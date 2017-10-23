# Prefer Header for HTTP

[rfc7240](https://tools.ietf.org/html/rfc7240)

If a request with a [validator](https://tools.ietf.org/html/rfc7232#section-2) has a [prefer wait preference](https://tools.ietf.org/html/rfc7240#section-4.3), then
the cache will delay the response up to the wait time OR until it can generate a response which would not result in a 304.

## Additions

   o  Preference: only-when-modified

   o  Description: Indicates that the client prefers the server only send the response when it is modified (different) than indicated on any cache validators. 

   o  Reference: [this specification]

   o  Notes: The server can wait indefinitely before returning the response, for it to change
