-- 1. Чтение всех товаров
SELECT * FROM Goods;

-- 2. Чтение всех покупателей
SELECT * FROM Users;

-- 3. Чтение всех заказов
SELECT * FROM Orders;

-- 4. Изменение данных товара
UPDATE Goods SET price = 99.99 WHERE id = 1;

-- 5. Изменение данных покупателя
UPDATE Users SET name_surname = 'Анна C.' WHERE id = 2;

-- 6. Изменение данных заказа
UPDATE Orders SET order_date = '23.03.2025' WHERE id = 02;

-- 7. Удаление товара
DELETE FROM Goods WHERE id = 5;

-- 8. Удаление покупателя
DELETE FROM Users WHERE id = 1;

-- 9. Удаление заказа
DELETE FROM Orders WHERE id = 1;