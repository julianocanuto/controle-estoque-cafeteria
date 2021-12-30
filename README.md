# Controle de estoque para cafeteria

## Situação:

Um cliente chegou na loja e comprou 5 cookies. O barista olhou o pedido e ficou desesperado, havia somente 2 cookies na loja.
Ele teve que explicar ao cliente o ocorrido e o cliente foi embora, essa situação não aconteceria se o pessoal do TI estivesse **controlado o estoque**.

## Sobre:

Você foi designado a resolver esse problema e precisa **estruturar todo sistema de estoque e produtos** para evitar acontecer novamente.

## Requisitos:

O estoque nada mais é que controlar **quantos ingredientes tem na loja**, além de cookie em uma cafeteria tem outros ingredientes como café em pó, leite, entre outros.
Para organizar melhor crie uma estrutura de **ingrediente com nome, unidade de medida e preço unitario**.

Antes de ter um estoque você precisa **ter um produto** com algumas coisas basicas que o cliente precisa saber como: **nome, imagem, preço e os ingredientes** que esse produto tem. 
Porém temos um problema aqui, **o ingrediente é só uma referencia ao que foi usado ele não tem quantidade**, então você precisa **fazer um novo objeto que faça referência a esse ingrediente com a quantidade que é usado, nós chamamos de componente.**

Agora você já tem as informações basicas para controlar o estoque, **organize em um objeto para que o cliente consiga visualizar os ingredientes da loja e quanto tem de estoque atualmente.**

> (...) organize em um objeto para que o cliente consiga visualizar os ingredientes da loja e quanto tem de estoque atualmente.

Ufa, tudo pronto, mas ainda o problema não foi resolvido, você só esta controlando quanto tem, **faça uma rota de verificação para saber se o produto X pode ser vendido.** 

> (...) faça uma rota de verificação para saber se o produto X pode ser vendido.

Como você não tem acesso ao PDV **faça uma rota de controle manual para o dono da loja imputar os valores do estoque.**

> (...) faça uma rota de controle manual para o dono da loja imputar os valores do estoque.

O dono é quem cadastra todas as informações da loja, inclusive o upload da imagem, então **será necessario uma rota para CRUD dessas informações.**
Além disso **alterar as informações é restrito** então essas **rotas especificas precisa de um login para controlar**.

> (...) cadastra todas as informações da loja (...) será necessario uma rota para CRUD dessas informações.

Situação resolvida, agora o cliente pediu novas alterações, como sempre. **Ele precisa de um relatório para saber o custo dos produtos**, você tem essas informações de quanto custa o ingrediente e de quanto vai no produto.
**Precisamos de uma rota que retorne todos os produtos e o custo de cada um.**

> (...) precisa de um relatório para saber o custo dos produtos
> (...) Precisamos de uma rota que retorne todos os produtos e o custo de cada um.
## Observações técnicas (Requisitos não funcionais):
- Validar todos os campos para ninguem quebrar a loja
- Login precisa ser criptografado a senha
- Documentar para entendimento do código. (comentar algumas coisas explicando)
- Tratar erros corretamente (404 para não encontrado), (200 | 202 para OK), etc

## Requisitos:
- Utilizar Spring Boot e Hibernate
- Validar as rotas utilizando JWT ou Oauth2
- Salvar em um banco de dados as informações

## Diferenciais:
- Upload de imagens (deixar somente PNG e JPG)

*Lembrando que os diferenciais são algo a mais, então só faça caso ja tenha conhecimento e esteja familiarizado.*

# Modelagem do sistema
## Diagrama de classes
![javaw_SKR3vfNsaN](https://user-images.githubusercontent.com/17866411/147617016-7c4ba44e-1b72-4c63-a7e6-638faafd7a88.png)


# Tarefas

- estruturar todo sistema de estoque e produtos
  - [x] quantos ingredientes tem na loja
  - [x] crie uma estrutura de ingrediente com nome, unidade de medida e preço unitario
  - [x] ter um produto (...) com: nome, imagem, preço e os ingredientes
  - [ ] fazer um **novo objeto** que faça referência a esse ingrediente com a quantidade que é usado, nós chamamos de componente. *(Caminho provável: novo DTO)*
  - [ ] organize em **um objeto** para que o cliente consiga visualizar os ingredientes da loja e quanto tem de estoque atualmente.*(Caminho provável: novo DTO)*
  - [ ] faça uma rota de verificação para saber se o produto X pode ser vendido.
    - Consideração: Se o produto possui a quantidade desejada no estoque, logo, pode ser pedido.
  - [ ] faça uma rota de controle manual para o dono da loja imputar os valores do estoque.
  - [ ] será necessario uma rota para CRUD dessas informações (informações da loja).
    - [x] CRUD Produto
    - [x] CRUD Ingrediente
    - [ ] Componente
  - [ ] alterar as informações é restrito (...) precisa de um login para controlar
    - [ ] PUT
    - [ ] POST
    - [ ] DELETE
  - [ ] relatório para saber o custo dos produtos
  - [ ] Precisamos de uma rota que retorne todos os produtos e o custo de cada um.
  - [x] Validar todos os campos para ninguem quebrar a loja
  - [x] Login precisa ser criptografado a senha
  - [ ] Documentar para entendimento do código. (comentar algumas coisas explicando)
  - [ ] Tratar erros corretamente (404 para não encontrado), (200 | 202 para OK), etc
  - [ ] Upload de imagens 
  - [ ] Restringir o upload de imagens aos seguintes formatos: PNG e JPG

# Referências

1. https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
2. https://www.baeldung.com/spring-data-jpa-projections
3. https://www.baeldung.com/spring-request-param