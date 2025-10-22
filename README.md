Game API 🎮
Este projeto é uma API RESTful desenvolvida como parte da atividade acadêmica "Review 1/2". A API permite o gerenciamento completo (CRUD) de Jogos (Games) e Jogadores (Players), implementando conceitos avançados como DTOs, validação de dados e perfis de ambiente para múltiplos bancos de dados.

✅ Features
CRUD Completo para Games: Gerenciamento total de jogos.

CRUD Completo para Players: Gerenciamento total de jogadores.

Relacionamento: Implementação de relacionamento @ManyToOne entre Player e seu Game favorito.

Padrão DTO: Utilização do padrão DTO (Data Transfer Object) e Mapper para garantir a segurança e o desacoplamento entre a API e a camada de dados.

Validação de Dados: As entradas da API são validadas usando o spring-boot-starter-validation para garantir a integridade dos dados.


Documentação com Swagger: A API é autodocumentada e pode ser testada de forma interativa através do Swagger UI. 



Perfis de Ambiente: Configuração profissional com perfis (dev e prod) para alternar facilmente entre o banco de dados H2 (para desenvolvimento) e MySQL (para produção). 

🛠️ Tecnologias Utilizadas
Java 24

Spring Boot 3.4.10

Spring Data JPA

Maven

H2 Database (Perfil dev)

MySQL (Perfil prod)

Springdoc OpenAPI (Swagger)

🚀 Configuração e Execução
Pré-requisitos
Java JDK 24 ou superior

Maven 3.x

MySQL Server (necessário apenas para rodar o perfil prod)

Configuração do Banco de Dados
O projeto está configurado para usar dois perfis de banco de dados:

dev (Padrão): Usa o banco de dados em memória H2. Nenhuma configuração adicional é necessária.

prod: Usa o MySQL. Para este perfil funcionar, você precisa:

Ter um servidor MySQL rodando.

Criar um banco de dados (ex: gameapi_db).

Atualizar o arquivo src/main/resources/application-prod.properties com seu usuário e senha:

Properties

spring.datasource.username=seu_usuario_mysql
spring.datasource.password=sua_senha_mysql
Executando a Aplicação
Ambiente de Desenvolvimento (H2): O perfil dev é ativado por padrão. Basta rodar a classe principal GameapiApplication.java pela sua IDE ou via Maven:

Bash

mvn spring-boot:run
Ambiente de Produção (MySQL): Para ativar o perfil de produção, você precisa passar um argumento na inicialização.

Via IDE (IntelliJ): Vá em "Edit Configurations..." e no campo "Active profiles", digite prod.

Via linha de comando:

Bash

mvn spring-boot:run -Dspring-boot.run.profiles=prod
📖 Uso e Documentação da API
Com a aplicação rodando, as seguintes URLs estarão disponíveis:

Swagger UI (Documentação e Testes):


http://localhost:8080/swagger-ui/index.html 

Console do Banco H2 (Apenas no perfil dev):


http://localhost:8080/h2/ 


JDBC URL: jdbc:h2:file:./data/bankdb 


User Name: teste 
Password: 1234 

👤 Autor
Ygor Vieira Pontes
