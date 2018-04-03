# Spring Demo Application

Simple experiment keeping Spring at the perimeter of an Java app.

## Common Commands

Run the application tests.

``` bash
mvn clean test
```

Run OWASP dependency check.

``` bash
mvn org.owasp:dependency-check-maven:check
```

Package the application for distribution.

``` bash
mvn clean package
```

Run the packaged application.

``` bash
java -jar src/api/target/spring-demo-api-0.0.1-SNAPSHOT.jar
```

Start database and application.

``` bash
foreman start -f Procfile.development
```

## Setup

### Environment

``` bash
gem install foreman
```

### Postgresql

``` bash
brew install postgresql
```

``` bash
pg_ctl init -D vendor/postgresql
```

``` bash
psql -p 5432 -h localhost -d postgres
```

Create project user and database.

``` sql
CREATE USER springdemo;
CREATE DATABASE spring_demo OWNER springdemo;
```

Connect to the project database.

``` bash
psql --dbname=spring_demo
```

## Built With

* [Java SE 9.0.1](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Spring Boot 1.5.2](https://projects.spring.io/spring-boot/)
* [PostgreSQL](https://www.postgresql.org)
* [Foreman](https://github.com/ddollar/foreman)
* [OWASP Dependency-Check](https://www.owasp.org/index.php/OWASP_Dependency_Check)

## License

This project is licensed under the MIT License - see the LICENSE.md file for details