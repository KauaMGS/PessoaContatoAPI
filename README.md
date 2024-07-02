# 📋 PessoaContatoAPI

API Rest para gerenciar um sistema de cadastro de Pessoas e seus respectivos contatos.

## 🚀 Requisitos

- Java 21
- MySQL 8.0

## ⚙️ Dependências

- spring-boot-starter-data-jpa
- spring-boot-starter-thymeleaf
- spring-boot-starter-web
- spring-boot-devtools
- springdoc-openapi-starter-webmvc-ui 2.2.0
- jackson-databind
- spring-boot-configuration-processor 
- spring-boot-starter-test 

## 🔧 Configuração

O banco de dados é configurado automaticamente pelo Spring Boot. Certifique-se de ter o MySQL 8.0 instalado e que as credenciais no arquivo `application.properties` estão corretas.

## 🚀 Como Executar

1. Certifique-se de ter o Java 21 e o MySQL 8.0 instalados.

2. Clone o repositório:
 
   ```bash
   git clone https://github.com/seu-usuario/PessoaContatoAPI.git
   cd PessoaContatoAPI

4. Compile o projeto e execute a aplicação:

  mvn spring-boot:run

5. Acesse a API: Após iniciar a aplicação, você pode acessar os endpoints diretamente ou através do Swagger UI
   
## 📄 Documentação da API

Acesse o Swagger UI para explorar todos os endpoints e detalhes da API: http://localhost:8081/swagger-ui/index.html
