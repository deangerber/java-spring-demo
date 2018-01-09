# Spring Demo Application

Run the application tests.

``` bash
mvn clean test
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