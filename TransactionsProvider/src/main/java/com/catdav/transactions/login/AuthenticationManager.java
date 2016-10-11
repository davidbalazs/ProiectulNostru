package com.catdav.transactions.login;

public interface AuthenticationManager {
  void login();
}
/**
 login flow:
 ------------------------------------------
 1)
 GET https://www.wunderlist.com/oauth/authorize?client_id=44b12461b9b1b61b95b3&redirect_uri=http://localhost/&state=abcabc
 te redirecteaza la http://localhost/?state=abcabc&code=382b921cde968eef981d

 ce poate merge rau:
 daca nu e bun client-id sau redirect-uri sau state-ul:
 iti da response cu 400 bad request
 ------------------------------------------
 2)
 POST https://www.wunderlist.com/oauth/access_token
 cu body-ul urmator:
 {
 "client_id": "44b12461b9b1b61b95b3",
 "client_secret":"968407529360c576d6d00247091c36ca7e915cdefc81164cd376711003f7",
 "code":"382b921cde968eef981d"
 }

 (code-ul este valoarea "code" din url-ul cu care te redirecteaza la pasul 1 inapoi la localhost)

 si iti vine response body:
 {
 "access_token": "0a4971f217798935c0bd3604a28e2f348eab4c40707a7a5ef5e5cd366f3d"
 }

 ce poate merge rau:
 daca nu e bun client-id sau client-secret sau code:
 iti da response cu 400 bad request
 ------------------------------------------
 3) te-ai logat cu succes!
 ca sa iti iei listele:
 GET a.wunderlist.com/api/v1/lists
 cu headerele:
 X-Access-Token   -    0a4971f217798935c0bd3604a28e2f348eab4c40707a7a5ef5e5cd366f3d
 X-Client-ID      -    44b12461b9b1b61b95b3

 si primesti response body
 [
 {
 "id": 133679023,
 "title": "inbox",
 "owner_type": "user",
 "owner_id": 12019105,
 "list_type": "inbox",
 "public": false,
 "revision": 37,
 "created_at": "2014-10-15T06:21:19.467Z",
 "type": "list"
 },
 {
 "id": 133679079,
 "title": "Shopping",
 "owner_type": "user",
 "owner_id": 12019105,
 "list_type": "list",
 "public": false,
 "revision": 3289,
 "created_at": "2014-10-15T06:22:04.933Z",
 "type": "list"
 },]


 posibil raspuns pentru request gresit:
 daca nu pui headerele x-access-token si x-client-id pe request:
 403 FORBIDDEN
 {
 "error": {
 "type": "server_error",
 "translation_key": "api_error_unknown",
 "message": "An unknown server error occurred",
 "authentication": [
 "missing"
 ]
 }
 }
