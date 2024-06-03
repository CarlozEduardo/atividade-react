-- DROP DATABASE loja; 
CREATE DATABASE loja;
USE loja;

CREATE TABLE Cliente (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45),
email VARCHAR(45),
senha VARCHAR(45),
cpf VARCHAR(45)
);

CREATE TABLE Produto (
id VARCHAR(55) PRIMARY KEY,
nome VARCHAR(45),
preco DOUBLE
);

CREATE TABLE Venda (
id INT PRIMARY KEY AUTO_INCREMENT,
dtVenda DATETIME,
precoTotal DOUBLE,
fkCliente INT,
CONSTRAINT fkVendaCliente FOREIGN KEY (fkCliente)
REFERENCES Cliente(id)
);

CREATE TABLE Registro (
id INT AUTO_INCREMENT,
fkVenda INT,
fkProduto VARCHAR(55),
CONSTRAINT PK PRIMARY KEY (id, fkVenda, fkProduto),
CONSTRAINT fkRegistroVenda FOREIGN KEY (fkVenda) REFERENCES Venda(id),
CONSTRAINT fkRegistroProduto FOREIGN KEY (fkProduto) REFERENCES Produto(id)
);

SELECT * FROM Cliente;
SELECT * FROM Produto;
