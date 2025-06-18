# 📝 Blogging Platform API

RESTful API para uma plataforma de blog pessoal, construída com **Spring Boot** e **PostgreSQL**.

> Projeto baseado no desafio da [roadmap.sh](https://roadmap.sh/projects/blogging-platform-api)

---

## 📌 Descrição

Esta API permite a criação, leitura, atualização, exclusão e filtragem de posts de blog. A proposta é entender os fundamentos das APIs RESTful, boas práticas, métodos HTTP e manipulação de banco de dados relacional.

---

## 🚀 Funcionalidades

- ✅ Criar um novo post de blog
- ✅ Listar todos os posts
- ✅ Buscar post por ID
- ✅ Atualizar post existente
- ✅ Deletar post
- ✅ Filtrar posts por termo (buscando por título, conteúdo ou categoria)

---

## 🔧 Tecnologias utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Bean Validation (Jakarta)**
- **Lombok (opcional)**

---

## 📂 Estrutura de Pacotes

```text
com.liamfer.BloggingPlatform
├── Controller         // Controladores REST (PostController)
├── Models             // Modelos JPA (PostModel)
├── Repository         // Interface de acesso ao banco (PostRepository)
├── Service            // Camada de serviço (PostService)


---

## 📬 Endpoints da API

### ➕ Criar Post

```http
POST /posts
Content-Type: application/json

{
  "title": "Meu primeiro post",
  "content": "Este é o conteúdo do post.",
  "category": "Tecnologia",
  "tags": ["Java", "Spring"]
}
```

📎 Resposta: `201 Created` com o post criado.

---

### 🔁 Atualizar Post

```http
PUT /posts/{id}
Content-Type: application/json

{
  "title": "Título Atualizado",
  "content": "Conteúdo atualizado.",
  "category": "Tecnologia",
  "tags": ["Atualizado"]
}
```

📎 Resposta: `200 OK` ou `404 Not Found`

---

### 🗑️ Deletar Post

```http
DELETE /posts/{id}
```

📎 Resposta: `204 No Content` ou `404 Not Found`

---

### 📄 Obter Post por ID

```http
GET /posts/{id}
```

📎 Resposta: `200 OK` ou `404 Not Found`

---

### 📚 Listar Todos os Posts

```http
GET /posts
```

📎 Resposta: `200 OK`

---

### 🔍 Filtrar por termo

```http
GET /posts?term=java
```

📎 Retorna todos os posts onde o termo aparece no **título**, **conteúdo** ou **categoria**.

---

## 📦 Exemplo de Resposta

```json
{
  "id": 1,
  "title": "Meu Primeiro Post",
  "content": "Conteúdo aqui...",
  "category": "Tecnologia",
  "tags": ["Java", "Spring"],
  "createdAt": "2025-06-01T12:00:00Z",
  "updatedAt": "2025-06-01T12:00:00Z"
}
```

---

## 📘 Como rodar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/BloggingPlatformAPI.git
cd BloggingPlatformAPI
```

2. Configure o banco de dados PostgreSQL no `application.properties`.

3. Rode o projeto:

```bash
./mvnw spring-boot:run
```

---

## ✅ Aprendizados

✔️ Boas práticas de design REST
✔️ Validação de entrada com Jakarta Validation
✔️ Manipulação de dados com JPA e PostgreSQL
✔️ Tratamento de erros HTTP com status apropriados

---

## 🌐 Link do desafio

🔗 [https://roadmap.sh/projects/blogging-platform-api](https://roadmap.sh/projects/blogging-platform-api)

---

