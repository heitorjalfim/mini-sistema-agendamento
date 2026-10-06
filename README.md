# Mini Sistema de Agendamento

API REST para gestão e controlo de agendamentos desenvolvida com Spring Boot, PostgreSQL e Flyway.

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
  - Spring Web
  - Spring Data JPA
  - Validation
- **PostgreSQL**
- **Flyway Migration**
- **Lombok**

> [!NOTE]
> 🛠️ **Projeto em desenvolvimento ativo!** 
> As funcionalidades estão a ser construídas e atualizadas frequentemente.
> 
## 📌 Funcionalidades

- [x] Agendamento de reuniões/compromissos.
- [x] Validação de intervalos de datas (data inicial < data final).
- [x] Validação de conflitos de horário por utilizador.
- [x] Alteração de estado de agendamentos (agendado, cancelado, concluído).
- [x] Triggers automáticas no PostgreSQL para auditoria.
