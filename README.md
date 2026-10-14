# Sistema de Agendamento

API REST para gestão e controle de agendamentos desenvolvida com Spring Boot, PostgreSQL e Flyway.

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **PostgreSQL**
- **Flyway Migration**
- **Lombok**

## 📌 Funcionalidades

- [x] **Criação de Agendamentos:** Registro de novos compromissos com validação de dados via DTOs.
- [x] **Validação de Intervalos de Datas:** Garantia de que a data inicial seja anterior à data final.
- [x] **Validação de Conflitos de Horário:** Impedimento de sobreposição de horários.
- [x] **Atualização de Dados:** Alteração das informações de um agendamento existente.
- [x] **Gestão de Status:** Transição de estados dos agendamentos (`AGENDADO`, `CANCELADO`, `CONCLUIDO`).
- [x] **Consulta por ID:** Busca detalhada de um agendamento específico.
- [x] **Documentação Interativa:** Interface visual Swagger UI para testes da API REST.

---

## 🛣️ Endpoints da API

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/agendamentos` | Cria um novo agendamento |
| `GET` | `/agendamentos/{id}` | Busca um agendamento pelo ID |
| `PUT` | `/agendamentos/{id}` | Atualiza os dados de um agendamento |
| `PUT` | `/agendamentos/{id}/cancelar` | Altera o status do agendamento para `CANCELADO` |
| `PUT` | `/agendamentos/{id}/concluir` | Altera o status do agendamento para `CONCLUIDO` |
