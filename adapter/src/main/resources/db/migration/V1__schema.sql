CREATE TABLE product (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL UNIQUE,
    price DECIMAL(10,4) NOT NULL CHECK (price > 0)
);

INSERT INTO product (id,name,price) VALUES
('1ede3e63-b4ad-45a3-a799-5dff81754e90','Relógio de ouro','5797.03'),
('67b96843-b709-479e-b7c6-67b96c252698','Bracelete de prata','2411.75'),
('f9347934-5bb1-4606-bacc-7962da200b87','Carteira de couro','6548.70'),
('8a610f92-babe-4f40-b916-ffc7f55c0a26','Caneta de luxo','7577.50'),
('d3fcdd78-a49e-414c-b00e-c350361e1652','Aliança de ouro','8828.66'),
('6bf41428-ee23-451f-b441-f6e9a0a927f4','Anel de prata','5188.60'),
('5b66110d-1fc6-42d4-9a3b-da8c9fe8aa53','Perfume de luxo','1019.39'),
('864fdae1-139a-4ddc-b091-81ee23df2a19','Relógio de prata','5097.55'),
('56f02307-b2f5-4400-85db-d250b6c6a442','Anel de bronze','2703.31'),
('0b710e07-bfa5-4b57-8cde-76cce5b15dc1','Colar de cobre','526.79'),
('40d9d552-04c7-484d-b08b-1e5a75ad59be','Pulseira de prata','1578.00'),
('2a0d48f2-35c3-4a11-93f4-bf6f4f9275d6','Cinto de couro','1306.94'),
('920bf5bc-d805-462c-85ac-c48f666bcc1c','Colar de lata','218.90'),
('f757b7e3-2b8c-4045-9d3c-da840afdb791','Brinco de ouro','6014.94'),
('c9511100-4280-44ea-aa59-26ea6b2b99e9','Canivete suiço','5979.05');
