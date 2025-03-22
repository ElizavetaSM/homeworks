-- Создание таблицы "Товары"
CREATE TABLE IF NOT EXISTS Goods (
    id SERIAL PRIMARY KEY,
    description VARCHAR,
    price NUMERIC,
    quantity INTEGER);

COMMENT ON table goods is 'Таблица с продуктами';

-- Создание таблицы "Покупатели"
CREATE TABLE IF NOT EXISTS Users (
    id SERIAL PRIMARY KEY,
    name_surname VARCHAR);

    COMMENT ON table users is 'Таблица с покупателями';

-- Создание таблицы "Заказы"
CREATE TABLE IF NOT EXISTS Orders (
    id SERIAL PRIMARY KEY,
    user_id LONG REFERENCES User(id),
    order_date DATE,
    quantity INTEGER NOT NULL,
    discount NUMERIC,
    good_id LONG REFERENCES Goods(id));

    COMMENT ON table Orders is 'Таблица с заказами';

-- Заполнение таблицы "Товары" данными
INSERT INTO Goods (id, description, price, quantity) VALUES
(1, 'Хлеб', 89.9, 100),
(2, 'Молоко', 70, 200),
(3, 'Масло', 199.9, 150),
(4, 'Лук', 47, 50),
(5, 'Йогурт', 65, 120),
(6, 'Торт', 780, 100),
(7, 'Сыр', 170, 250),
(8, 'Чай', 98.7, 130),
(9, 'Шоколад', 150, 180),
(10, 'Мороженое', 250, 80)

-- Заполнение таблицы "Покупатели" данными
INSERT INTO Users (id, name_surname) VALUES
(1,'Иван Т.'),
(2,'Петр. П.'),
(3,'Анна Р.'),
(4,'Светлана Г.'),
(5,'Николай П.'),
(6,'Анастасия М.'),
(7,'Роман Е.'),
(8,'Кирилл. П.'),
(9,'Диана А.'),
(10,'Виктор. П.')

-- Заполнение таблицы "Заказы" данными
INSERT INTO Orders (id,  user_id, order_date, quantity, discount, good_id) VALUES
(01, 1, '22.02.2025', 2, 0, 5),
(02, 2, '22.02.2025', 3, 0, 4),
(03, 3, '22.02.2025', 1, 1, 1),
(04, 6, '22.02.2025', 2, 2, 6),
(05, 5, '22.02.2025', 2, 0, 2),
(06, 7, '22.02.2025', 8, 0, 3),
(07, 4, '22.02.2025', 1, 0, 9),
(08, 9, '22.02.2025', 2, 0, 7),
(09, 8, '22.02.2025', 4, 2, 10),
(010, 10, '22.02.2025', 2, 0 ,9)

