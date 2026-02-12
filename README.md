# Library — Система учёта книг

Библиотечная система учёта книг и пользователей, реализованная на Java. Проект содержит сущности «Книга» и «Человек», базовый CRUD для них и учёт выдач/возвратов книг.

---

## Технологии

* Java (Maven)
* Spring MVC
* JdbcTemplate
* PostgreSQL
* Thymeleaf

---

## Функциональные возможности

* CRUD для книг (создание, чтение, обновление, удаление)
* CRUD для пользователей/читателей
* Учёт выдач книг (регистрация того, кто и когда взял книгу)
* Валидация дат (например, проверка, что дата выдачи — не в будущем)

---

## Требования

* Java 17+
* Maven 3.6+
* Реляционная база данных (PostgreSQL / MySQL / H2 и т. п.)
* Apache Tomcat 11

---

## Запуск (локально)

1. Клонируйте репозиторий:

```bash
git clone https://github.com/Kirill-F1av3r/Library.git
cd Library
```

2. Сконфигурируйте доступ к базе данных. Создайте `src/main/resources/database.properties` с параметрами подключения, например:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/librarydb
spring.datasource.username=your_user
spring.datasource.password=your_password
```

3. Настройте Apache Tomcat и запустите

---

## Рекомендуемая схема БД


```sql
CREATE TABLE person (
  id SERIAL PRIMARY KEY,
  name VARCHAR(63) NOT NULL,
  birthday DATE,
  email VARCHAR(127) UNIQUE,
  phone VARCHAR(20) UNIQUE 
);

CREATE TABLE book (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  author VARCHAR(127),
  release_date DATE,
  count INT CHECK (count >= 0)
);

CREATE TABLE borrow_record (
  id SERIAL PRIMARY KEY,
  book_id INT REFERENCES book(id),
  person_id INT REFERENCES person(id),
  borrow_date DATE NOT NULL DEFAULT CURRENT_DATE,
  return_date DATE
);
```

---

## Как пользоваться

* Откройте веб-интерфейс (`http://localhost:8080/library/`) — в нём должны быть страницы для управления книгами и читателями.
* В разделе books: добавление/редактирование/удаление, просмотр деталей книги.
* В разделе people: добавление читателей и просмтор информации о читателях.
* В разделе borrow records: создание записей о заимствовании книг и просмотр уже существующих.

---

