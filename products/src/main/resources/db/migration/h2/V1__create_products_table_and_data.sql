CREATE TABLE product (
  id UUID NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(1000),
  price DECIMAL(10,2) NOT NULL,
  available INTEGER NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);


INSERT INTO product (id, name, description, price, available, created_at, updated_at) 
VALUES 
  ('c59e7492-39b9-4b6a-a5a5-5dc73f1598a1', 'Apple iPhone 13 Pro Max', 'The ultimate iPhone for power users', 1099.99, true, '2022-04-08 10:00:00', '2022-04-08 10:00:00'),
  ('2b39a9f9-6b68-4d1f-bcf0-8a8fc449fe21', 'Samsung Galaxy S22 Ultra', 'A high-end Android smartphone', 1299.99, true, '2022-04-07 09:00:00', '2022-04-08 11:00:00'),
  ('e9c8b774-793a-4ea5-ae2d-447e8d215859', 'Dell XPS 13 Laptop', 'A premium ultraportable laptop', 1299.99, true, '2022-04-07 09:00:00', '2022-04-08 11:00:00'),
  ('2a26a026-2d2e-4c20-a2d7-077c0f076ec0', 'Logitech MX Master 3 Mouse', 'A high-performance wireless mouse', 99.99, true, '2022-04-07 09:00:00', '2022-04-08 11:00:00'),
  ('b49a9385-1d53-4a5a-87d4-aa5b6da384d6', 'Sony WH-1000XM4 Headphones', 'Premium noise-cancelling wireless headphones', 349.99, true, '2022-04-07 09:00:00', '2022-04-08 11:00:00'),
  ('33c7e641-2d9e-4c13-b0a6-0e749e264c91', 'Nintendo Switch Console', 'A versatile hybrid gaming console', 299.99, true, '2022-04-07 09:00:00', '2022-04-08 11:00:00'),
  ('7d01ef54-3d7a-4e3a-b7f1-441c2536d4d4', 'Amazon Echo (4th Generation)', 'Smart speaker with Alexa voice control', 99.99, true, '2022-04-07 09:00:00', '2022-04-08 11:00:00'),
  ('f6c32b77-22d9-4c1f-9912-2f12d1462011', 'Fitbit Charge 5 Fitness Tracker', 'A high-end fitness tracker with built-in GPS', 179.99, true, '2022-04-07 09:00:00', '2022-04-08 11:00:00');
