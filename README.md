<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>PessoaContatoAPI - README</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      line-height: 1.6;
      margin: 20px;
    }
    h1, h2, h3 {
      color: #333;
    }
    code {
      background-color: #f4f4f4;
      padding: 5px;
      font-size: 0.9em;
    }
    pre {
      background-color: #f4f4f4;
      padding: 10px;
      overflow-x: auto;
    }
    .section {
      margin-bottom: 20px;
    }
    .download-btn {
      display: inline-block;
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      text-align: center;
      text-decoration: none;
      font-size: 16px;
      cursor: pointer;
      border-radius: 5px;
      margin-top: 20px;
    }
    .download-btn:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>

  <h1>📋 PessoaContatoAPI</h1>

  <div class="section">
    <h2>🚀 Requisitos</h2>
    <ul>
      <li>Java 21</li>
      <li>MySQL 8.0</li>
    </ul>
  </div>

  <div class="section">
    <h2>⚙️ Dependências</h2>
    <ul>
      <li>spring-boot-starter-data-jpa</li>
      <li>spring-boot-starter-thymeleaf</li>
      <li>spring-boot-starter-web</li>
      <li>spring-boot-devtools</li>
      <li>springdoc-openapi-starter-webmvc-ui 2.2.0</li>
      <li>jackson-databind</li>
      <li>spring-boot-configuration-processor</li>
      <li>spring-boot-starter-test</li>
    </ul>
  </div>

  <div class="section">
    <h2>🔧 Configuração</h2>
    <p>O banco de dados é configurado automaticamente pelo Spring Boot, sendo criado caso não exista nenhum. Certifique-se de ter o MySQL 8.0 instalado e que as credenciais no arquivo <code>application.properties</code> estão corretas.</p>
  </div>

  <div class="section">
    <h2>🚀 Como Executar</h2>
    <ol>
      <li><strong>Certifique-se de ter o Java 21 e o MySQL 8.0 instalados.</strong></li>
      <li><strong>Clone o repositório:</strong></li>
      <pre><code>git clone https://github.com/seu-usuario/PessoaContatoAPI.git<br>cd PessoaContatoAPI</code></pre>
      <li><strong>Compile o projeto e execute a aplicação:</strong></li>
      <pre><code>mvn spring-boot:run</code></pre>
      <li><strong>Acesse a API:</strong></li>
      <p>Após iniciar a aplicação, você pode acessar os endpoints diretamente ou através do Swagger UI:</p>
      <p><a href="http://localhost:8081/swagger-ui/index.html" target="_blank">Swagger UI - http://localhost:8081/swagger-ui/index.html</a></p>
    </ol>
  </div>

  <div class="section">
    <h2>📄 Documentação da API</h2>
    <p>Acesse o Swagger UI para explorar todos os endpoints e detalhes da API.</p>
  </div>

  <div class="section">
    <a href="README.md" download class="download-btn">Baixar README.md</a>
  </div>

</body>
</html>
