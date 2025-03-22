-- Создание таблицы "Покупатели"
CREATE TABLE IF NOT EXISTS Users (
    id SERIAL PRIMARY KEY,
    name_surname VARCHAR);

-- Создание таблицы "Заказы"
CREATE TABLE IF NOT EXISTS Orders (
    id SERIAL PRIMARY KEY,
    user_id LONG REFERENCES User(id),
    order_date DATE,
    quantity INTEGER NOT NULL,
    discount NUMERIC,
