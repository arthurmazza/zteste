# zteste

Utilizar o arquivo xyinc.sql para criação/inserção do Banco de Dados.

<b>Ferramentas Utilizadas:</b>

IDE Eclipse Neon2, 
Java 1.7, 
Tomcat 8.039 e 
MAVEN 3

<b>Frameworks utilizados:</b>

Spring MVC Rest, 
Spring Data (JPA / Hibernate) com MySQL e 
Jackson

<b>Serviço para cadastrar POIs:</b>

http://localhost:8080/xyinc/place/create

Foi utilizado o aplicativo POSTMAN para realizar o teste.

POST http://localhost:8080/xyinc/place/create

HEADERS Content-Type application/json

Body: {	"name":"XYInc",	"x":-2,	"y":55 }

Resposta: {"id":8,"name":"XYInc","x":12.0,"y":55.0}

<b>Serviço para listar todos os POIs cadastrados:</b>

http://localhost:8080/xyinc/place/findAll

Resposta: [{"id":1,"name":"Lanchonete","x":27.0,"y":12.0},{"id":2,"name":"Posto","x":31.0,"y":18.0},{"id":3,"name":"Joalheria","x":15.0,"y":12.0},{"id":4,"name":"Floricultura","x":19.0,"y":21.0},{"id":5,"name":"Pub","x":12.0,"y":8.0},{"id":6,"name":"Supermercado","x":23.0,"y":6.0},{"id":7,"name":"Churrascaria","x":28.0,"y":2.0}]

<b>Serviço para listar todos os POIs por proximidade:</b>

http://localhost:8080/xyinc/place/findNearbyPlaces/{x}/{y}/{dMax}

Exemplo: http://localhost:8080/xyinc/place/findNearbyPlaces/20/10/10

Resposta: [{"id":1,"name":"Lanchonete","x":27.0,"y":12.0},{"id":3,"name":"Joalheria","x":15.0,"y":12.0},{"id":5,"name":"Pub","x":12.0,"y":8.0},{"id":6,"name":"Supermercado","x":23.0,"y":6.0}]
