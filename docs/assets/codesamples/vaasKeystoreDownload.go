/*
 * Copyright 2021 Venafi, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package main

import (
	"archive/zip"
	"bytes"
	"crypto/rand"
	"encoding/base64"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"strings"

	"golang.org/x/crypto/nacl/box"
)

const (
	apiAddr    = "api.venafi.cloud"
	apiKey     = "e2238c25-0689-4379-9fb9-d558872f4cbc"         // ryan@tr1ck3r.xyz test account
	certId     = "82f2fbf0-2526-11ec-9552-c1b0d6cb25a3"         // existing certificate requested using CKG
	vaasPubKey = "ELk7oiUMXK4aoVP8VNSuQvXdVQI/xttKuwa5utnVfUY=" // key value returned by GET /v1/edgeencryptionkeys/{dekHash}
	keyPasswd  = "newPassw0rd!"
	rootFirst  = true
)

type keystoreRequest struct {
	ExportFormat                  string `json:"exportFormat"`
	EncryptedPrivateKeyPassphrase string `json:"encryptedPrivateKeyPassphrase"`
	EncryptedKeystorePassword     string `json:"encryptedKeystorePassphrase"`
	CertificateLabel              string `json:"certificateLabel"`
}

func main() {

	publicKeyBytes, _ := base64.StdEncoding.DecodeString(vaasPubKey)
	var publicKey [32]byte
	copy(publicKey[:], publicKeyBytes[:32])

	keyPasswdEncrypted, _ := box.SealAnonymous(nil, []byte(keyPasswd), &publicKey, rand.Reader)

	/* download the keystore (zip containing PEM files) and save to a file */
	url := fmt.Sprintf("https://%s/outagedetection/v1/certificates/%s/keystore", apiAddr, certId)
	reqKeystore := keystoreRequest{
		ExportFormat:                  "PEM",
		EncryptedPrivateKeyPassphrase: base64.StdEncoding.EncodeToString(keyPasswdEncrypted),
		EncryptedKeystorePassword:     "",
		CertificateLabel:              "",
	}
	body, err := json.Marshal(reqKeystore)
	req, err := http.NewRequest(http.MethodPost, url, bytes.NewBuffer(body))
	req.Header.Add("tppl-api-key", apiKey)
	req.Header.Add("Content-Type", "application/json")
	req.Header.Add("Accept", "application/octet-stream")

	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil {
		log.Fatal(err)
	}

	//log.Print(resp.Status)

	defer resp.Body.Close()
	bodyBytes, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		log.Fatal(err)
	}

	/* extract certificate, private key, and chain from zip */
	var certificate string
	var privateKey string
	var chain string

	zipReader, err := zip.NewReader(bytes.NewReader(bodyBytes), int64(len(bodyBytes)))
	if err != nil {
		log.Fatal(err)
	}

	for _, zipFile := range zipReader.File {
		if strings.HasSuffix(zipFile.Name, ".key") {

			f, err := zipFile.Open()
			if err != nil {
				log.Println(err)
				continue
			}
			defer f.Close()
			fileBytes, err := ioutil.ReadAll(f)

			privateKey = strings.TrimSpace(string(fileBytes))

		} else if strings.HasSuffix(zipFile.Name, "_root-first.pem") {

			f, err := zipFile.Open()
			if err != nil {
				log.Println(err)
				continue
			}
			defer f.Close()
			fileBytes, err := ioutil.ReadAll(f)

			certs := strings.Split(strings.TrimSpace(string(fileBytes)), "\n\n")

			for i := 0; i < len(certs); i++ {
				if i < len(certs)-1 {
					if chain == "" {
						chain = certs[i]
					} else {
						if rootFirst {
							chain = fmt.Sprintf("%s\n%s", chain, certs[i])
						} else {
							chain = fmt.Sprintf("%s\n%s", certs[i], chain)
						}
					}
				} else {
					certificate = certs[i]
				}
			}
		}
	}

	fmt.Printf("%s\n\n", certificate)
	fmt.Printf("%s\n\n", privateKey)
	fmt.Printf("%s\n\n", chain)
}
