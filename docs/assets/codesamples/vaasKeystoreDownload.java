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
/*
 * This sample depends on
 * <ul>
 * <li>feign-gson v11.7 from https://github.com/OpenFeign/feign</li>
 * <li>lombok v1.18.20 from https://github.com/projectlombok/lombok</li>
 * <li>commons-lang3 v3.11 from https://commons.apache.org/proper/commons-lang</li>
 * <li>bcprov-jdk15on v1.67 from https://www.bouncycastle.org</li>
 * <li>tweetnacl-java v1.1.2 from https://github.com/InstantWebP2P/tweetnacl-java</li>
 * </ul>
 * 
 *  @author Marcos E. Albornoz Abud
 */
package com.venafi.java.examples;

import static java.lang.String.format;
import static java.time.Duration.ZERO;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.crypto.digests.Blake2bDigest;

import com.iwebpp.crypto.TweetNaclFast;

import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import lombok.Data;
import lombok.experimental.Accessors;

interface VaaS {

	@Headers({"tppl-api-key: {apiKey}", "Content-Type: application/json"})
	@RequestLine("POST  /outagedetection/v1/certificaterequests")
	CertificateRequestsResponse certificateRequest(CertificateRequestsPayload certificateRequestPayload, @Param("apiKey") String apiKey);
	
	@Headers("tppl-api-key: {apiKey}")
	@RequestLine("GET  /outagedetection/v1/certificaterequests/{id}")
	CertificateStatus certificateStatus(@Param("id") String id, @Param("apiKey") String apiKey);
	
	@Headers("tppl-api-key: {apiKey}")
	@RequestLine("GET /outagedetection/v1/certificates/{id}")
	CertificateDetails certificateDetails(@Param("id") String id, @Param("apiKey") String apiKey);

	@Headers({"tppl-api-key: {apiKey}"})
	@RequestLine("GET /v1/edgeencryptionkeys/{id}")
	EdgeEncryptionKey retrieveEdgeEncryptionKey(@Param("id") String id, @Param("apiKey") String apiKey);
	
	@Headers({"tppl-api-key: {apiKey}", "Content-Type: application/json"})
	@RequestLine("POST /outagedetection/v1/certificates/{id}/keystore")
	Response retrieveKeystore(@Param("id") String id, KeystoreRequest keystoreRequest, @Param("apiKey") String apiKey);
}
@Data
@Accessors(fluent = true)
class CertificateRequestsPayload {
	private String validityPeriod;
	private String applicationId;
	private String certificateIssuingTemplateId;
	private boolean isVaaSGenerated;
	private CsrAttributes csrAttributes;
	private String applicationServerTypeId;
}

@Data
@Accessors(fluent = true)
class CsrAttributes {
	private String commonName;
	private String organization;
	private String[] organizationalUnits;
	private String locality;
	private String state;
	private String country;
	private SubjectAlternativeNamesByType subjectAlternativeNamesByType;
}

@Accessors(fluent = true)
@Data
class SubjectAlternativeNamesByType {
	private String[] dnsNames;
}

@Accessors(fluent = true)
@Data
class CertificateRequestsResponse {
	private List<CertificateRequestsResponseData> certificateRequests;
}

@Accessors(fluent = true)
@Data
class CertificateRequestsResponseData {
	private String id;
}


@Accessors(fluent = true)
@Data
class CertificateStatus {
	private String id;
	private String status;
	private List<String> certificateIds;
}


@Accessors(fluent = true)
@Data
class CertificateDetails {
	private String dekHash;
}

@Accessors(fluent = true)
@Data
class EdgeEncryptionKey {
	private String key;
}

@Accessors(fluent = true)
@Data
class KeystoreRequest {
	private String exportFormat;
	private String encryptedPrivateKeyPassphrase;
	private String encryptedKeystorePassphrase;
	private String certificateLabel;
}

public class RequestRetrieveCert {
	private static final String apiAddr = "https://api.venafi.cloud";
	//You need to set an API_KEY env variable to use it or replace this value
	//for the API Key value directly
	private static final String apiKey = System.getenv("API_KEY");
	private static final String appId = "5e8db070-217f-11ec-9134-5b0a4dd5f8a8";
	private static final String citId  = "0ea75d70-2181-11ec-bb0a-411653d7d9bc";
	private static final String appServTypeId = "784938d1-ef0d-11eb-9461-7bb533ba575b";
	private static final String keyPassword = "mykeypassword";
	
	//Creating the feing client to VaaS
	private static VaaS vaas = Feign.builder()
			.encoder(new GsonEncoder())
			.decoder(new GsonDecoder())
			.target(VaaS.class, apiAddr);

	
	public static void main(String[] args) {
		
		//Creating the payload to request a certificate
		String cn = String.format("t%d-%s.venafi.example.com", System.currentTimeMillis(),
				RandomStringUtils.randomAlphabetic(4)).toLowerCase();
		CertificateRequestsPayload certificateRequestPayload = new CertificateRequestsPayload()
				.isVaaSGenerated(true)
				.applicationId(appId)
				.certificateIssuingTemplateId(citId)
				.applicationServerTypeId(appServTypeId)
				.validityPeriod("P7D")
				.csrAttributes(new CsrAttributes()
						.commonName(cn)
						.organization("Venafi, Inc.")
						.organizationalUnits(new String[] {"Product Management"})
						.locality("SLC")
						.state("Utah")
						.country("US")
						.subjectAlternativeNamesByType(new SubjectAlternativeNamesByType()
								.dnsNames(new String[] {cn})
								)
						);
		
		//requesting a certificate
		System.out.println("Requesting a certificate...");
		CertificateRequestsResponse certificateRequestsResponse = vaas.certificateRequest(certificateRequestPayload, apiKey);
		
		//getting the certificate request id from the response
		String pickupId = certificateRequestsResponse.certificateRequests().get(0).id();
		
		//retrieving the certId
		String certId = getCertificateIdFromPickupId(pickupId);
		
		System.out.println("Retrieving the keystore for the certificate...");
		//Getting the cert details to get the dekhash in order to retrieve the encryption key
		CertificateDetails certificateDetails = vaas.certificateDetails(certId, apiKey);
		
		//Getting the edge encryption key
		EdgeEncryptionKey edgeEncryptionKey = vaas.retrieveEdgeEncryptionKey(certificateDetails.dekHash(), apiKey);
		
		//decoding the serverPublicKey
		byte[] serverPublicKey = Base64.getDecoder().decode(edgeEncryptionKey.key());
		
		//getting the keypassword encoded
		String encodedMessage = getEncodedMessage(serverPublicKey, keyPassword);
		
		//preparing the keystorerequest to get the keystore
		KeystoreRequest keystoreRequest = new KeystoreRequest()
				  .exportFormat("PEM")
				  .encryptedPrivateKeyPassphrase(encodedMessage)
				  .encryptedKeystorePassphrase("")
				  .certificateLabel("");

		//getting the kestore from vaas
		Response response = vaas.retrieveKeystore(certId, keystoreRequest, apiKey);
		
		//Printing the keystore
		System.out.println("Printing the keystore data...");
		printKeystore(response);
	}

	private static String getCertificateIdFromPickupId(String requestPickupId) {
		CertificateStatus certificateStatus = null;
		
		Duration timeout = Duration.of(1, MINUTES);
		Instant startTime = Instant.now();
		while (true) {

			certificateStatus = vaas.certificateStatus(requestPickupId, apiKey);
			if ("ISSUED".equals(certificateStatus.status())) {
				break;
			} else if ("FAILED".equals(certificateStatus.status())) {
				throw new RuntimeException( format("Failed to retrieve certificate with Request ID: %s", requestPickupId));
			}

			// Status either REQUESTED or PENDING
			if (ZERO.equals(timeout)) {
				throw new RuntimeException(format("Issuance is pending. You may try retrieving the "
						+ "certificate later using Request ID: %s", requestPickupId));
			}

			if (Instant.now().isAfter(startTime.plus(timeout))) {
				throw new RuntimeException(format("Operation timed out. You may try retrieving the "
						+ "certificate later using Request ID: %s", requestPickupId));
			}

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				throw new RuntimeException(format("Error attempting to retry", e));
			}
		}

		if(certificateStatus == null) {
			throw new RuntimeException( format("Was not able to retrieve Certificate Status, requestId: %s", requestPickupId));
		}

		return certificateStatus.certificateIds().get(0);
	}
	
	private static String getEncodedMessage(byte[] serverPublicKey, String keyPassword) {
		String encodedMessage = null;

		try {
		byte[] cipherText = cryptoBoxSeal(serverPublicKey, keyPassword.getBytes());
		encodedMessage = Base64.getEncoder().encodeToString(cipherText);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return encodedMessage;
	}
	
	/**
	 * Encrypt in  a sealed box
	 *
	 * @param receiverPubKey receiver public key
	 * @param clearText clear text
	 * @return encrypted message
	 * @throws GeneralSecurityException 
	 */
	private static byte[] cryptoBoxSeal(byte[] receiverPubKey, byte[] clearText) throws GeneralSecurityException {

		// create ephemeral keypair for sender
		TweetNaclFast.Box.KeyPair ephkeypair = TweetNaclFast.Box.keyPair();
		// create nonce
		byte[] nonce = cryptoBoxSealNonce(ephkeypair.getPublicKey(), receiverPubKey);
		TweetNaclFast.Box box = new TweetNaclFast.Box(receiverPubKey, ephkeypair.getSecretKey());
		byte[] ciphertext = box.box(clearText, nonce);
		if (ciphertext == null) 
			throw new GeneralSecurityException("Could not create the crypto box");

		byte[] sealedbox = null;
		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
			byteArrayOutputStream.write(ephkeypair.getPublicKey());
			byteArrayOutputStream.write(ciphertext);
			sealedbox = byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			throw new GeneralSecurityException("Could not create the sealed crypto box", e);
		}
		return sealedbox;
	}

	/**
	 *  hash the combination of senderpk + mypk into nonce using blake2b hash
	 * @param senderpk the senders public key
	 * @param mypk my own public key
	 * @return the nonce computed using Blake2b generic hash
	 */
	private static byte[] cryptoBoxSealNonce(byte[] senderpk, byte[] mypk){
		
		int CRYPTO_BOX_NONCEBYTES = 24;
		final Blake2bDigest blake2b = new Blake2bDigest( CRYPTO_BOX_NONCEBYTES*8 ); 
		blake2b.update(senderpk, 0, senderpk.length);
		blake2b.update(mypk, 0, mypk.length);
		byte[] nonce = new byte[CRYPTO_BOX_NONCEBYTES];
		blake2b.doFinal(nonce, 0);
		if (nonce == null || nonce.length!=CRYPTO_BOX_NONCEBYTES) throw new IllegalArgumentException("Blake2b hashing failed");
		return nonce;
	}
	
	private static void printKeystore(Response response) {
    	String certificateAsPem = null;
    	String privateKey = null;
    	String chainOfTrust = null;

    	try (ZipInputStream zis = new ZipInputStream(response.body().asInputStream())) {

    		ZipEntry zipEntry;
    		while ((zipEntry = zis.getNextEntry())!= null) {
    			String fileName = zipEntry.getName();
    			if(fileName.endsWith(".key")) {
    				privateKey = new String(zis.readAllBytes());
    			} else {
    				if(fileName.endsWith("_root-last.pem")) {
    					String certificateAsPemCollection = new String(zis.readAllBytes());
    					
    					int endOfCertificate = certificateAsPemCollection.indexOf("\n\n");
    					if (endOfCertificate>0) {
    						certificateAsPem = certificateAsPemCollection.substring(0,endOfCertificate);
    						chainOfTrust = certificateAsPemCollection.substring(endOfCertificate+2, certificateAsPemCollection.length()).trim();
    					} else
    						certificateAsPem = certificateAsPemCollection;
    				}
    			}
    		}
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    	
    	System.out.println("--Certificate--\n"+certificateAsPem+"\n");
    	System.out.println("--Chain of trust--\n"+chainOfTrust+"\n");
    	System.out.println("--Private Key--\n"+privateKey+"\n");
    }
}
