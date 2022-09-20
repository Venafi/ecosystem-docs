# Components of an API search

When you search for a certificate, the format of the JSON body has the following
parts: 

* **Expression**: Designates an `operands` parameter with the certificate field,
  operator, and value or values for searching.

* **Join Expression**: Allows filtering with a NOT or AND logical operator.

* **Ordering**: (Optional) Sorts the result by one or more certificate field
  names.

* **Paging**: (Optional) Dictates the size of the data set to return.

For example: 
```json
{
  "expression": {
  "operands": {[+]}
  },
  "joinexpression":{+}
  "ordering": {[+]},
  "paging": {+}
}
```
