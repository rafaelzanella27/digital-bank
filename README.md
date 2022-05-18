##Projeto
###API-REST - Digital Bank 
API Rest de um banco, com CRUD de clientes e contas.
Para clientes é possível: Criar um novo, listar, deletar e atualizar.
Para contas é possível: Criar a conta no momento de cadastro do cliente, listar, atualizar o tipo da conta e deletar.

###Pré-requisitos
Java 11 | Spring Boot | Maven  
Banco de Dados MySql  
Docker   
Postman

###Configuração da banco de Dados MySql com Docker
Utilizamos o Docker para executar o MySQL

Acesse a pasta docker e execute o comando:

docker-compose up

Se não quiser utilizar o Docker você precisa ter o MySQL instalado no seu computador e precisará criar um banco de dados com o nome db. Atualize o usuário e senha no arquivo application.properties para os dados do seu banco de dados

spring.datasource.username=root   
spring.datasource.password=root
