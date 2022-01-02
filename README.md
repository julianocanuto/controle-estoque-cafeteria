# :computer: Controle de estoque para cafeteria :coffee:

## :rotating_light: Situação:

Um cliente chegou na loja e comprou 5 cookies. O barista olhou o pedido e ficou desesperado, havia somente 2 cookies na loja.
Ele teve que explicar ao cliente o ocorrido e o cliente foi embora, essa situação não aconteceria se o pessoal do TI estivesse **controlado o estoque**.

## :mag_right: Sobre:

Você foi designado a resolver esse problema e precisa **estruturar todo sistema de estoque e produtos** para evitar acontecer novamente.

## :triangular_flag_on_post:	 Requisitos:

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
## :warning: Observações técnicas (Requisitos não funcionais):
- :construction: Validar todos os campos para ninguem quebrar a loja
- :white_check_mark: Login precisa ser criptografado a senha
- Documentar para entendimento do código. (comentar algumas coisas explicando)
- :construction: Tratar erros corretamente (404 para não encontrado), (200 | 202 para OK), etc

## :memo: Requisitos:
- :white_check_mark: Utilizar Spring Boot e Hibernate
- Validar as rotas utilizando JWT ou Oauth2
- :white_check_mark: Salvar em um banco de dados as informações

## :gem: Diferenciais:
- Upload de imagens (deixar somente PNG e JPG)

*Lembrando que os diferenciais são algo a mais, então só faça caso ja tenha conhecimento e esteja familiarizado.*

# :construction: Modelagem do sistema
## Diagrama de classes
![javaw_duTXnkqpwg](https://user-images.githubusercontent.com/17866411/147786179-71ff7ae6-8302-4c75-b8ee-f40ed57688c4.png)

## Arquitetura do sistema
![EXCEL_IeKAPdSDpM](https://user-images.githubusercontent.com/17866411/147827466-1600b17b-003f-441e-b22f-b8dd6e3cf451.png)

## Coleção do Postman
- https://www.postman.com/julianocanuto/workspace/controle-estoque-cafeteria/collection/18955527-7e121b86-5418-4e50-bcfd-a1d9e71e3ac6
# :books: Tarefas

- estruturar todo sistema de estoque e produtos
  - [ ] fazer um **novo objeto** que faça referência a esse ingrediente com a quantidade que é usado, nós chamamos de componente.
  - [ ] faça uma rota de controle manual para o dono da loja imputar os valores do estoque.
  - [ ] será necessario uma rota para CRUD dessas informações (informações da loja).
    - [ ] Componente
  - [ ] alterar as informações é restrito (...) precisa de um login para controlar
    - [ ] PUT
    - [ ] POST
    - [ ] DELETE
  - [ ] Precisamos de uma rota que retorne todos os produtos e o custo de cada um.
  - [ ] Documentar para entendimento do código. (comentar algumas coisas explicando)
  - [ ] Tratar erros corretamente (404 para não encontrado), (200 | 202 para OK), etc
  - [ ] Upload de imagens 
  - [ ] Restringir o upload de imagens aos seguintes formatos: PNG e JPG

# Notas de versão
## :tada: v1.0.0
- estruturar todo sistema de estoque e produtos
  - :white_check_mark: quantos ingredientes tem na loja
  - :white_check_mark: crie uma estrutura de ingrediente com nome, unidade de medida e preço unitario
  - :white_check_mark: ter um produto (...) com: nome, imagem, preço e os ingredientes
  - :white_check_mark: organize em **um objeto** para que o cliente consiga visualizar os ingredientes da loja e quanto tem de estoque atualmente.
  - :white_check_mark: faça uma rota de verificação para saber se o produto X pode ser vendido.
    - Consideração: Se o produto possui a quantidade desejada no estoque, logo, pode ser pedido.
  - :white_check_mark: será necessario uma rota para CRUD dessas informações (informações da loja).
    - :white_check_mark: CRUD Produto
    - :white_check_mark: CRUD Ingrediente
  - :white_check_mark: Validar todos os campos para ninguem quebrar a loja
  - :white_check_mark: Login precisa ser criptografado a senha
  - :white_check_mark: Tratar erros corretamente (404 para não encontrado), (200 | 202 para OK), etc
    - :white_check_mark: p/ CRUD User

# :book: Referências

1. https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
2. https://www.baeldung.com/spring-data-jpa-projections
3. https://www.baeldung.com/spring-request-param
4. https://www.restapitutorial.com/lessons/httpmethods.html
