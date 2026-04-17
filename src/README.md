# Planejamento: Controle de Biblioteca Escolar

Este projeto visa organizar o empréstimo e devolução de livros de uma biblioteca escolar, garantindo a integridade do estoque.

### Tabelas (Entidades) Identificadas
* **Livro:** Armazena `título`, `autor` e `quantidadeDisponível`.
* **Aluno:** Armazena `nome` e `matrícula`.
* **Empréstimo:** Representa a posse temporária de um `Livro` por um `Aluno`.

### Regras de Negócio Implementadas
* **Validação de Cadastro:** Não permite livros com título vazio ou quantidades iniciais negativas.
* **Disponibilidade de Estoque:** Um empréstimo só pode ser realizado se a `quantidadeDisponível` for maior que zero.
* **Atualização de Saldo:** O sistema reduz a quantidade do livro no empréstimo e aumenta automaticamente na devolução.
* **Rastreabilidade:** Permite consultar quais alunos possuem livros em aberto no momento.