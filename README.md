Projeto - API-REST - Digital Bank 
________________________________________________________________________________________________________________________________
API Rest de um banco, com CRUD de clientes e contas.
Para clientes é possível: Criar um novo, listar, deletar e atualizar.
Para contas é possível: Criar a conta no momento de cadastro do cliente, listar, atualizar o tipo da conta e deletar.
_____________________________________________________________________________________________________________________________
Pré-requisitos
Java 11 | Spring Boot | Maven  
Banco de Dados MySql  
Docker   
Postman
________________________________________________________________________________________________________________________________
Configuração da banco de Dados MySql com Docker
Utilizamos o Docker para executar o MySQL

Acesse a pasta docker e execute o comando:

docker-compose up

Se não quiser utilizar o Docker você precisa ter o MySQL instalado no seu computador e precisará criar um banco de dados com o nome db. Atualize o usuário e senha no arquivo application.properties para os dados do seu banco de dados

spring.datasource.username=root   
spring.datasource.password=root


Utilizar o postman com as requisições:  
Para cadastrar um NOVO CLIENTE:
>POST: http://localhost:8080/cliente/novoCliente

{
"cliente":
        {
    "nome": "Joao"
        }
}

Para LISTAR CLIENTE:
>GET: http://localhost:8080/cliente/listar/{id}

Para DELETAR CLIENTE:
>DEL: http://localhost:8080/cliente/deletar/{id}

Para ATUALIZAR CLIENTE:
>PUT: http://localhost:8080/cliente/atualizar/{id}

{
"nome": "NomeAtualizado"
}