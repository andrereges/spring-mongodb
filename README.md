# Spring Boot - MongoDB
Project built to implement CRUD with reference using mongodb database

Technologies used:

- Spring Boot with java 11
- RabbitMQ
- MongoDB
- Lombok

Use **docker-compose.yml** to run containers and to do locally tests:

- **MongoDB Server:** Run docker mongodb container

In root project run command:

- docker-compose up -d

In browser set urls:

- **product:** http://localhost:8080/api/v1/products
- **category:** http://localhost:8080/api/v1/categories

**Note:** Used postman to api requests and Robot 3T client to manager mongodb
<p>https://www.postman.com/</p>
<p>https://robomongo.org/download</p>