DROP TABLE IF EXISTS transfer;
CREATE TABLE transfer (
  id int PRIMARY KEY AUTO_INCREMENT,
  amount double,
  date datetime,
  company_id varchar(255),
  debitAccount varchar(255),
  creditAccount varchar(255)
);

DROP TABLE IF EXISTS company;
CREATE TABLE company (
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(255),
  cuit varchar(255),
  startDate date
);

ALTER TABLE transfer ADD FOREIGN KEY (company_id) REFERENCES company (id);
