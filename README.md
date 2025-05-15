#API de Livros com melhorias pós-feedback técnico

Este é um projeto de uma API REST para cadastro, consulta, atualização e exclusão de livros utilizando **Java 17**, **Spring Boot**, **Spring Data JPA**, **Lombok** e **H2 Database**.

O código foi originalmente desenvolvido para um processo seletivo e, com base no feedback técnico recebido de um recrutador, foi **refatorado e aprimorado** para seguir boas práticas.

---

## 🔧 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- H2 Database (em memória)  
- Lombok  
- JUnit 5 + Mockito  

---

## 🛠 Melhorias aplicadas com base no feedback

| Item                    | Situação Antes                   | Refatorado                             |
|-------------------------|----------------------------------|-----------------------------------------|
| Injeção de dependência  | `@Autowired` no Controller       | Injeção via construtor                  |
| Uso de DTO              | Ausente                          | Implementado com `LivroDTO`            |
| `getById`               | Não implementado                 | Adicionado com tratamento de exceção   |
| Tratamento de erros     | Inexistente                      | `RecursoNaoEncontradoException` + handler global |
| Lombok                  | Não utilizado                    | Usado em `Livro` para reduzir boilerplate |
| Testes                  | Apenas controller testado        | Testes de serviço com Mockito           |
| Estrutura de pacotes    | Fora do padrão                   | Organizado conforme boas práticas       |

---

## 🚀 Endpoints

- `POST /livros` - Cadastra um novo livro  
- `GET /livros` - Lista todos os livros  
- `GET /livros/{id}` - Busca um livro por ID  
- `PUT /livros/{id}` - Atualiza um livro existente  
- `DELETE /livros/{id}` - Remove um livro  

Todos os endpoints utilizam `LivroDTO` como contrato de entrada e saída.

---

## ✅ Testes Automatizados

Foram implementados testes unitários para a camada de serviço usando Mockito, validando:

- Cadastro de livro  
- Listagem  
- Busca por ID (com e sem sucesso)  
- Deleção  

---

## 🧠 Lições aprendidas

- Importância do uso de DTOs para não expor a entidade diretamente  
- Como estruturar tratamento global de exceções com `@RestControllerAdvice`  
- Melhor entendimento do ciclo de vida das dependências no Spring  
- Validação através de testes unitários com Mockito  

---

## 📁 Como executar o projeto localmente

1. Clone o repositório:
```bash
git clone https://github.com/joaomauro0/livro-api-springboot.git
