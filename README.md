# Temporary Mail

This is a simple example how implement a Temporary e-Mail Service API. In this case I used [Mail GW](https://mail.gw/en/) as temporary e-mail service and Spring Cloud OpenFeign to integrate with their API. 

### Reference Documentation

For further reference, please consider the following sections:

* [Mail GW API](https://docs.mail.gw/)
* [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)

### Guides

__DomainService__ - get all domains and by id

__AccountService__ - Create one account (temporary e-mail) and get info by id

__TokenService__ - Provide a token from one account (Without "Bearer " at begin, you must add it before use)

__MessageService__ - Get all messages from one account and by id

### Testing

Domains:

* http://127.0.0.1:8080/domain
* http://127.0.0.1:8080/domain/{id}

Use the ExampleControler.java as sample to implement the others endpoints


