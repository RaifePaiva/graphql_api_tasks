# GraphQL com Springboot

Este projeto tem como objetivo demonstrar a utilização do GraphQL com Springboot. O exemplo utilizado é um CRUD de simulando um pequeno sistema de de gerenciamento de tarefas.

## Tecnologias utilizadas

- Java 17
- Springboot 3.1.5
- GraphQL
- Lombok
- H2 Database
- Maven
- Jpa

## Como executar

Para executar o projeto, basta executar o comando abaixo na pasta raiz do projeto (caso tenha o maven instalado): <br>

OBS.: Caso haja algum problema para executar usando o comando abaixo, o mesmo pode ser executado através da IDE de sua preferência.

```shell script
mvn spring-boot:run
```

## Como testar

Para testar o projeto, basta acessar o endereço abaixo no seu navegador:

```shell script
http://localhost:8080/graphiql
```

## Banco de dados
O banco de dados utilizado é o H2 Database, que é um banco de dados em memória. Para acessar o banco de dados, basta acessar o endereço abaixo no seu navegador:

```shell script
http://localhost:8080/h2-console
```
**Nota:** O banco de dados é criado automaticamente ao executar o projeto, e nesta mesma base dados algum dados foram criados para simular usuarios.
<br><br>**Nota:** Caso deseje alterar o banco de dados, basta alterar as configurações no arquivo application.properties. E caso necessite inserir mais dados, basta alterar o arquivo data.sql.

## Exemplos de requisições

Para acessar todos as possiveis rotas desta api, basta navegar pela interface gráfica fornecida pelo link de acesso acima. <br>
e caso deseje obter mais informações sobre como utilizar o GraphQL, basta acessar o link abaixo:

```shell script
https://graphql.org/learn/
```

### Criar uma tarefa

```shell script
mutation {
  createTask(task: {title: "Tarefa 1", description: "Descrição da tarefa 1", userId: 1}) {
    id
    title
    description
    status
    user {
      name
      email
    }
  }
}
```

### Listar todas as tarefas

```shell script
query {
  getAllTasks {
    id
    title
    description
    status
    user {
      name
      email
    }
  }
}
```

