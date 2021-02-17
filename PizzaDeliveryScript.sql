CREATE DATABASE pizzeria;
USE pizzeria;

CREATE TABLE ingredient(
id_ingredient INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
name_ingredient VARCHAR(70) NOT NULL,
stock_quantity FLOAT,
measure_unit ENUM('kilos', 'litros')
);

CREATE TABLE product(
id_product INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
product_line ENUM('acompañamiento', 'bebestible','pizza'),
name_product VARCHAR(100),
size VARCHAR(50),
measure_unit VARCHAR(50),
price FLOAT,
stock_quantity FLOAT,
availability BIT
);

CREATE TABLE pizzas_recipe(
id_pizza INT,
id_ingredient INT,
quantity FLOAT,
FOREIGN KEY(id_pizza) REFERENCES product(id_product),
FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient)
);

CREATE TABLE address(
id_address INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
name_address VARCHAR(50) NOT NULL,
street VARCHAR(220) NOT NULL,
number VARCHAR(10) NOT NULL,
apartment VARCHAR(10),
comment VARCHAR(300)
);

CREATE TABLE customer(
id_customer INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
name_customer VARCHAR(120),
lastname_customer VARCHAR(120),
id_address INT,
email VARCHAR(50),
phone INT,
FOREIGN KEY(id_address) REFERENCES address(id_address)
);

CREATE TABLE purchase_order(
id_order INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
id_customer INT,
order_date DATE,
total_price float,
status ENUM('pagada', 'enviada', 'recibida'),
FOREIGN KEY (id_customer) REFERENCES customer(id_customer)
);

CREATE TABLE order_detail(
id_order INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
id_product INT,
FOREIGN KEY(id_product) REFERENCES product(id_product)
);

INSERT INTO pizzeria.ingredient(name_ingredient, stock_quantity, measure_unit) VALUES
('Salsa de tomate', 40, 'litros'),
('Albahaca', 350, 'kilos'),
('Tomate', 50000, 'kilos'),
('Queso', 60000, 'kilos'),
('Jamón Serrano', 1000, 'kilos'),
('Aceituna', 6000, 'kilos'),
('Cebolla',8000, 'kilos'),
('Pepperoni',5000, 'kilos'),
('Pollo',5000, 'kilos'),
('Tocino',5000, 'kilos'),
('Champiñón',5000, 'kilos'),
('Pimentón',5000, 'kilos'),
('Choclo',5000, 'kilos'),
('Pulled pork',5000, 'kilos'),
('Salchicha italiana',5000, 'kilos'),
('Ajo',5000, 'kilos'),
('Sal',5000, 'kilos');

INSERT INTO product(product_line, name_product, size, measure_unit, price, stock_quantity, availability) VALUES
('pizza', 'Double Pepperoni', 'familiar', null, '11790', null, 0),
('pizza', 'Double Pepperoni', 'mediana', null, '8690', null, 0),
('pizza', 'BBQ Pork', 'familiar', null, '11790', null, 0),
('pizza', 'BBQ Pork', 'mediana', null, '8690', null, 0),
('pizza', 'Mix Especial', 'familiar', null, '11790', null, 0),
('pizza', 'Mix Especial', 'mediana', null, '8690', null, 0),
('pizza', 'Classic', 'familiar', null, '11790', null, 0),
('pizza', 'Classic', 'mediana', null, '8690', null, 0),
('pizza', 'Chicken BBQ', 'familiar', null, '11790', null, 0),
('pizza', 'Chicken BBQ', 'mediana', null, '8690', null, 0),
('pizza', 'Full Veggie', 'familiar', null, '12590', null, 0),
('pizza', 'Full Veggie', 'mediana', null, '9690', null, 0),
('pizza', 'Rústica', 'familiar', null, '12590', null, 0),
('pizza', 'Rústica', 'mediana', null, '9690', null, 0),
('pizza', 'De la Casa', 'familiar', null, '12590', null, 0),
('pizza', 'De la Casa', 'mediana', null, '9690', null, 0),
('pizza', 'Barbacoa', 'familiar', null, '12590', null, 0),
('pizza', 'Barbacoa', 'mediana', null, '9690', null, 0),
('pizza', 'Pulled Pork', 'familiar', null, '12590', null, 0),
('pizza', 'Pulled Pork', 'mediana', null, '9690', null, 0),
('pizza', 'Jamón Serrano Rúcula', 'familiar', null, '12590', null, 0),
('pizza', 'Jamón Serrano Rúcula', 'mediana', null, '9690', null, 0),
('pizza', 'Gran Vegana', 'familiar', null, '11790', null, 0),
('pizza', 'Gran Vegana', 'mediana', null, '8690', null, 0),
('bebestible', 'Coca-Cola', '0.35', 'litros', 1190, 200, 1),
('bebestible', 'Coca-Cola', '1.5', 'litros', 1190, 120, 1),
('bebestible', 'Coca-Cola', '2.5', 'litrso', 2590, 150, 1),
('bebestible', 'Coca-Cola Zero', '0.35', 'litros', 1190, 200, 1),
('bebestible', 'Coca-Cola Zero', '1.5', 'litros', 1190, 120, 1),
('bebestible', 'Coca-Cola Zero', '2.5', 'litros', 2590, 150, 1),
('bebestible', 'Fanta', '0.35', 'litros', 1190, 200, 1),
('bebestible', 'Fanta', '1.5', 'litros', 1190, 120, 1),
('bebestible', 'Fanta', '2.5', 'litros', 2590, 150, 1),
('bebestible', 'Sprite', '0.35', 'litros', 1190, 200, 1),
('bebestible', 'Sprite', '1.5', 'litros', 1190, 120, 1),
('bebestible', 'Sprite', '2.5', 'litros', 2590, 150, 1),
('bebestible', 'Sprite Light', '0.35', 'litros', 1190, 200, 1),
('bebestible', 'Sprite Light', '1.5', 'litros', 1190, 120, 1),
('bebestible', 'Sprite Light', '2.5', 'litros', 2590, 150, 1),
('acompañamiento', 'Cheesesticks', '0.6', 'kilos', 2990, null, 1),
('acompañamiento', 'Palitos de ajo', '0.6', 'kilos', 2990, null, 1),
('acompañamiento', 'Salsa BBQ', '0.2', 'litros', 490, 120, 1),
('acompañamiento', 'Honey Mustard', '0.2', 'litros', 490, 80, 1),
('acompañamiento', 'Sweet Chili', '0.2', 'litros', 490, 150, 1)
;

INSERT INTO pizzas_recipe(id_pizza, id_ingredient, quantity) VALUES
('', '','')
;




