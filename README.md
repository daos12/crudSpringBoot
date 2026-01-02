````markdown
# CRUD Completo com Spring Boot

Este projeto consiste em uma **API RESTful CRUD (Create, Read, Update, Delete)** desenvolvida com **Spring Boot**, utilizando **arquitetura em camadas** e banco de dados **H2 em memória**.  
O objetivo é demonstrar, de forma didática e organizada, a construção de uma aplicação backend em Java, seguindo boas práticas do ecossistema Spring.

O sistema permite **cadastrar, consultar, atualizar e remover usuários**, utilizando requisições HTTP padrão, podendo ser testado por ferramentas como o **Postman**.

---

## 📌 Funcionalidades

- Cadastro de usuário  
- Consulta de usuário por e-mail  
- Atualização de usuário por ID  
- Exclusão de usuário por e-mail  
- Persistência de dados com JPA  
- Console web do banco H2 para inspeção dos dados  

---

## 🏗️ Arquitetura do Projeto

O projeto utiliza uma **arquitetura de camadas simples**, separando responsabilidades:


controller      → Camada de entrada (API REST)
business        → Camada de regras de negócio (Service)
infrastructure  → Persistência e acesso a dados
 ├─ entitys
 └─ repository
````

---

## 🔧 Tecnologias Utilizadas

* **Java 21 (JDK 21)**
* **Spring Boot**
* **Spring Data JPA**
* **H2 Database**
* **Lombok**
* **Maven**

---

## ⚙️ Configurações do Banco de Dados (H2)

```properties
spring.application.name=crudSpring

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.datasource.url=jdbc:h2:mem:usuarios
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=senac
spring.datasource.password=

server.port=8081
```

### Acesso ao console H2

```
http://localhost:8081/h2-console
```

---

## ▶️ Como Executar o Projeto

1. Acesse o **Spring Initializr**
   [https://start.spring.io/](https://start.spring.io/)

2. Gere o projeto com as seguintes configurações:

   * Project: Maven
   * Language: Java
   * Java: 21
   * Dependências:

     * Spring Web
     * Spring Data JPA
     * H2 Database
     * Lombok

3. Importe o projeto na IDE (IntelliJ, Eclipse ou VS Code)

4. Aguarde o download das dependências

5. Execute a aplicação

---

## 🔁 Endpoints da API

### ➕ Criar usuário

**POST** `/usuario`

```json
{
  "nome": "Diego Silva",
  "email": "diego@email.com"
}
```

---

### 🔍 Buscar usuário por e-mail

**GET** `/usuario?email=diego@email.com`

---

### ✏️ Atualizar usuário por ID

**PUT** `/usuario?id=1`

```json
{
  "nome": "Diego Atualizado",
  "email": "diego.novo@email.com"
}
```

---

### ❌ Deletar usuário por e-mail

**DELETE** `/usuario?email=diego@email.com`

---

## 🧪 Testes com Postman

O projeto foi desenvolvido para ser testado utilizando o **Postman**, permitindo o envio de requisições HTTP e a validação das respostas da API.

Download do Postman:
[https://www.postman.com/downloads/](https://www.postman.com/downloads/)

---

## 📚 Objetivo Educacional

Este projeto é indicado para:

* Estudantes de **Java e Spring Boot**
* Cursos técnicos e profissionalizantes
* Introdução ao desenvolvimento de **APIs REST**
* Prática de **CRUD com Spring Data JPA**
* Demonstração de arquitetura em camadas

---

## 📄 Licença

Projeto de uso **educacional e demonstrativo**, podendo ser livremente adaptado e expandido.

---

```
```


