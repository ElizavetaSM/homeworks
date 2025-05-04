-- Создание таблицы "Покупатели"
CREATE TABLE IF NOT EXISTS Users (
    id SERIAL PRIMARY KEY,
    name_surname VARCHAR);

    COMMENT ON table Users is 'Таблица с покупателями';

-- Создание таблицы "Заказы"
CREATE TABLE IF NOT EXISTS Orders (
    id SERIAL PRIMARY KEY,
    user_id LONG REFERENCES User(id),
    order_date DATE,
    quantity INTEGER NOT NULL,
    discount NUMERIC

    COMMENT ON table Orders is 'Таблица с заказами';


-- Заполнение таблицы "Покупатели" данными
INSERT INTO Users (id, name_surname) VALUES
(1,'Иван Т.'),
(2,'Петр. П.'),
(3,'Анна Р.'),
(4,'Светлана Г.'),
(5,'Николай П.')


-- Заполнение таблицы "Заказы" данными
INSERT INTO Orders (id,  user_id, order_date, quantity, discount) VALUES
(01, 1, '22.02.2025', 2, 0)
(02, 2, '22.02.2025', 3, 0),
(03, 3, '22.02.2025', 1, 1),
(04, 4, '22.02.2025', 2, 2),
(05, 5, '22.02.2025', 2, 0)


