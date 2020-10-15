# Compile and run the app

`./mvnw install && ./mvnw spring-boot:run -pl application`

or

`./mvnw install && java -jar application/target/application-1.0.0-SNAPSHOT.jar`

# Description of the architecture

The project consists of 4 modules `adapter`, `usecases`, `domain`, and
`application`.

## `domain` module

This module contains the domain entities. There are no dependencies to frameworks and/or libraries.

## `usecases` module

This module contains the business rules that are essential for our application
(Application business rules). The only dependency of this module is to `domain`.
In this module, gateways for the repositories are being defined. Each use case
defines the interface of the gateway that is required following the
[ISP](https://en.wikipedia.org/wiki/Interface_segregation_principle). These
gateways, operate on the domain entities defined in `domain`.

## `adapter` module

This module contains the implementation of the gateways defined in the
`usecases` module. This module depends on the framework that facilitates the
data access. In our example, we use JPA and Spring Data. The `Jpa*Repository`
classes are the actual implementation of the gateways defined in the `usecases`
module.

These repositories, use the Spring Data `JpaRepository` as dependencies.
The entities in this module, are JPA entities, so mappings to and from these and
the domain entities are needed.

## `application` module

This module contains all the details of the delivery mechanism that we use along
with the wiring of the app and the configurations. In our example, we use rest services
built with Spring Boot. Similarly, to the JPA entities of the
`adapter` module, the DTOs have mappers, to convert from and to the domain
entities.
