
<div align="center">
  
# :airplane: Milhas API 

![Spring](https://img.shields.io/badge/-Spring-000?&logo=Spring)
![MySQL](https://img.shields.io/badge/-MySQL-000?&logo=MySQL)
![Git](https://img.shields.io/badge/Git-000?&logo=Git)
![VSCode](https://img.shields.io/badge/VSCode-000?&logo=visualstudiocode)

</div>

<a href="https://www.alura.com.br/challenges/back-end-7/">
    <img src="https://www.alura.com.br/assets/img/challenges/logos/logo-challenges-back-end.1680020826.svg" alt="Aimeos logo" title="Alura Challenges" align="left" height="60px"/>
</a>

The goal is to provide information and resource related to possible travel destinations, showing photos, texts and also resources about testimonials from other travelers. In addition to integrating AI into your application.

-------------

<br/>

## :scroll: About

API in development to the [7th Back-end Challenge](https://www.alura.com.br/challenges/back-end-7/) of Alura.

### Used Technologies:
- Language: Java
- Framework: Spring Boot 
- Migration Tool: Flywaydb
- OpeanAI Integration
- Other libraries: Lombok
- Database: MySQL
- Code Editor: VS Code

## :dart: The Challenge

> In this 7th Backend challenge, we are going to develop an API that will be integrated with Frontend. Our challenge is to provide information and resources from the database related to possible travel destinations, displaying photos and eye-catching text that encourages the user to want to visit that destination.
>
> In addition, we will also provide resources on testimonials from other travelers and, finally, we will integrate AI into our application.

### Project steps

- **<font color="green">First Week</font>**
    - [x] **Testimonial CRUD** Create `/depoimentos` endpoint to perform CRUD operations. 
    - [x] **Random Testimonials**: Create `depoimentos-home` endpoint to show 3 random testimonials
    - [x] **CORS** Enable CORS request from any origin on the development phase.
          
- **<font color="green">Second Week</font>**
    - [x] **Destination CRUD** Create `/destinos` endpoint to perform CRUD operations.
    - [x] **Search Destination** by name.

- **Third and Fourth Week**
    - [x] **Update `destinos` endpoint** with the fields
        - id
        - Photo 1
        - Photo 2
        - Name
        - Meta (max 160 characters)
        - Description text (optional)
    - [x] `/destinos/{id}` endpoint should retrieve
        - Photo 1
        - Photo 2
        - Name
        - Meta
        - Description text
    - [x] **AI integration** to generate description about destination, in case of some destination has no description

## :rocket: Running locally

```bash
# clone the repository

MilhasAPI uses MySQL as the database. Create a MySQL database, named **milhasapi** and update the database configuration in `src/main/resources/application.properties` file:

```bash
spring.datasource.url=jdbc:mysql://[URL]:[PORT]/milhasapi
spring.datasource.username=[USERNAME]
spring.datasource.password=[PASSWORD]
```
MilhasAPI is integrated to ChatGPT to generate destination description. Create an API key on [openai platform](platform.openai.com) and export it as environmet variable.

```bash
export OPENAI_KEY=123
```
Run the project

```bash
mvn spring-boot:run
```

To use this API, you can make HTTP requests to the provided endpoints using tools like cURL or Postman. 


<!-- ------------


| :placard: Vitrine.Dev |     |
| -------------  | --- |
| :sparkles: Nome        | **Milhas API**
| :label: Tecnologias | Java Spring Boot, MySQL
| :rocket: URL         | https://github.com/ecureuill/milhasapi
| :fire: Desafio     | https://www.alura.com.br/challenges/back-end-7/

