# API de Gerenciamento de Pacientes

## Descrição

Esta aplicação consiste em uma API REST desenvolvida em **Java com Spring Boot** para gerenciamento de pacientes.

A API permite realizar operações de cadastro, consulta, atualização e exclusão de pacientes (CRUD), utilizando arquitetura em camadas, DTOs para comunicação, persistência com JPA/Hibernate e banco de dados H2.

---

# Tecnologias utilizadas

- Java 17
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- JUnit 5
- Mockito
- Postman

## Instalação e Execução

### Pré-requisitos

Antes de executar a aplicação, certifique-se de possuir instalado:

- Java JDK 17 ou superior
- Maven 3.9 ou superior
- Git

## Testes

Os testes podem ser executados utilizando o aplicativo Postman:
- GET (Listar Pacientes): http://localhost:8080/api/v1/pacientes
- POST (Cadastrar PAcientes: http://localhost:8080/api/v1/pacientes
- JSON (mudar os dados se preciso): 
{
    "nome": "José Silva",
    "cpf": "12345678911",
    "telefone": "81999998888",
    "email": "jose@email.com",
    "dataNascimento": "1995-05-10",
    "numeroCartaoSus": "987654322"
}
- DELETE (Detelat Paciente por ID): http://localhost:8080/api/v1/pacientes/2
Mudar o ID pro ID que deseja excluir.
- PUT (Alterar Paciente por ID): http://localhost:8080/api/v1/pacientes/1
Mudar o dado que deseja alterar: 
{
    "nome": "Maria da Silva Souza",
    "cpf": "12345678900",
    "telefone": "81999999999",
    "email": "maria@email.com",
    "dataNascimento": "1990-05-10",
    "numeroCartaoSus": "987654321"
}
GET (Buscar PAciente por ID): http://localhost:8080/api/v1/pacientes/3