# BibliotecaPublica

Sistema de gerenciamento de uma biblioteca pública, com interface gráfica desktop, feito em Java com banco de dados MySQL. É um trabalho em grupo da disciplina de Análise e Projeto de Software (UFSJ).

## Equipe

- Felipe Girardi
- Gabriel Vaz Bernardini
- Miguel de Assis
- Nicolas Teles
- Ramon Caique de Paula

## Funcionalidades

### Clientes

- Cadastro e login
- Reserva e devolução de livros
- Avaliação de livros
- Consulta e edição do próprio perfil

### Funcionários

- Login e cadastro de funcionários
- Cadastro de livros
- Consulta de clientes e alteração do estado do cliente (ativo ou banido)
- Alteração de cargo de funcionários (administrador)

### Regras

- O prazo do empréstimo é de 1 mês a partir da reserva.
- Cliente com o estado "banido" não consegue reservar livros.

## Tecnologias

- Java 22
- Maven
- Java Swing (interface gráfica)
- MySQL, com acesso via JDBC (mysql-connector-j 9.1.0)

## Organização do código

O projeto é dividido em camadas, cada uma em um pacote de `src/main/java`:

| Pacote | Responsabilidade |
|---|---|
| `Modelo` | Entidades: `Cliente`, `Funcionario`, `Livro`, `Emprestimo` e `Session` |
| `Visao` | Telas em Swing |
| `Controle` | Regras da aplicação e ligação entre telas e dados |
| `Persistencia` |
