# Dans Multi Pro Test

## Installation

this project using java 11 and maven, to install all dependencies use

```bash
mvn dependency:resolve
```

## Usage
to run the project use

```bash
mvn spring-boot:run

```

## API
there are 4 API(s) within the project
1. POST: /authenticate -> use to create JWT token that will valid for 30 minutes, for this purpose use this as request body. Used by other endpoints to authorize the request
```json
{
"username": "test",
"password": "test"
}
```
2. POST: /login -> use to login with stored value in DB, in this case the DB using H2 in-memory DB and value are seeded from data.sql file, use this as body request for valid login, put JWT from previous endpoint in the Bearer Authorization
```json
{
"username": "abcd",
"password": "testPassword"
}
```
3. GET: /jobs
getting all jobs from http://dev3.dansmultipro.co.id/api/recruitment/position.json
4. /jobs/{id} getting respective job with parameters from http://dev3.dansmultipro.co.id/api/recruitment/positions/{id}
