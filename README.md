# livro-api-springboot


---

## 🔄 Funcionalidades

- ✅ **POST /livros** – Cadastrar livro
- ✅ **GET /livros** – Listar todos os livros
- ✅ **PUT /livros/{id}** – Atualizar livro por ID
- ✅ **DELETE /livros/{id}** – Deletar livro por ID

---

## 🧪 Testes

A classe `LivroControllerTest` realiza testes completos para cada operação da API usando **MockMvc**, validando:

- Status HTTP corretos (`200 OK`, `204 No Content`);
- JSON de resposta esperado;
- Funcionalidade de atualização e exclusão.

---

## 🛠 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/joaomauro0/livro-api-springboot
