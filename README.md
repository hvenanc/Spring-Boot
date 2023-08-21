# Spring Boot
Formação Spring Boot Alura - Curso 1/3

Spring Boot

Para criarmos um projeto devemos acessar o seguinte link:

[Spring Initializr](https://start.spring.io/)

Anotações:

@RestController

Essa anotação indica o controlodar é do tipo REST.

@RequestMapping

Essa anotação permite a criação de uma rota, a partir do "/nome-da-rota"

@GetMapping

Indica que o método recebe requisições do tipo GET.

@PostMapping

Indica que o método recebe requisições do tipo POST, que enviam dados para API.

@DelleteMapping

Indica que método remove dados do servidor.

@PutMapping

Atualiza dados existentes no servidor.

@RequestBody

Recebe os dados do corpo da requisição que são enviados através uma requisição POST.

@PathParameter

Recuperam valores passados na url.


### Bibliotecas

#### JPA
#### Flyway
#### Spring Validation

### Padrões de Projeto

#### DTO

Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão de projetos bastante usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.