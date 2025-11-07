DROP TABLE IF EXISTS animal_product;
DROP TABLE IF EXISTS animal;
DROP TABLE IF EXISTS product;

CREATE TABLE animal (animal_id VARCHAR(10) PRIMARY KEY,registration_number VARCHAR(20) NOT NULL);

CREATE TABLE product (product_id VARCHAR(10) PRIMARY KEY,product_name VARCHAR(50) NOT NULL);

CREATE TABLE animal_product (animal_id VARCHAR(10) REFERENCES animal(animal_id),
                             product_id VARCHAR(10) REFERENCES product(product_id));

INSERT INTO animal VALUES ('A1', 'REG-A1'),
                          ('A2', 'REG-A2'),
                          ('A3', 'REG-A3');

INSERT INTO product VALUES('P1', 'Product-P1'),
                          ('P2', 'Product-P2'),
                          ('P3', 'Product-P3');

INSERT INTO animal_product VALUES('A1', 'P1'),
                                 ('A2', 'P1'),
                                 ('A1', 'P2'),
                                 ('A3', 'P3');