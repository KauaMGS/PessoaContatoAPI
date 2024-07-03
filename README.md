<!DOCTYPE html>
<html lang="pt-BR">
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
	<p>Recomenda-se o uso de Docker com a image:mysql:latest rodando na porta 3306</p>
	<p>Caso for fazer o banco manualmente crie nos seguintes parâmetros:</p>
	<p>Banco de dados: mysql</p>
	<p>Nome do banco: dbapi</p>
	<p>Username: root</p>
	<p>Password: 123456</p>
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
    <h2>📝 Licença</h2>
    <p>Este projeto está licenciado sob a MIT License</p>
  </div>

</body>
</html>
