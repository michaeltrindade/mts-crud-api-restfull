API RESTful Java MongoDB
### Como executar a aplicação
Certifique-se de ter o Spring Tool Suite instalado , assim como o Git.
```
git clone https://github.com/michaeltrindade/Java-MongoDB

### Importando o projeto no STS
No STS aberto, importe o projeto como projeto Maven, File --> Import --> Maven --> Projeto Maven Existente
```
No Eclipse/STS, .
Acesse http://localhost:8080/api/clientes
Utilize o usuário "user" e a senha que é impressa no terminal do STS ao executar a aplicação para autenticar.

### APIs endpoints
GET http://localhost:8080/api/pessoas [lista todos os pessoas]  
GET http://localhost:8080/api/pessoas/{id} [lista um pessoas por ID]  
POST http://localhost:8080/api/pessoas [cadastra um novo pessoas]  
PUT http://localhost:8080/api/pessoas/{id} [atualiza os dados de um pessoas]  
DELETE http://localhost:8080/api/pessoas/{id} [remove um pessoas por ID]  


