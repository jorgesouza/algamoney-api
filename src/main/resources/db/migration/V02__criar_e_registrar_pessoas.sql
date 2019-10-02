CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	ativo TINYINT NOT NULL,
	logradouro VARCHAR(50),
	numero VARCHAR(5),
	complemento VARCHAR(30),
	bairro VARCHAR(20),
	cep VARCHAR(10),
	cidade VARCHAR(20),
	estado VARCHAR(2)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Jorge Souza', true, 'Rua Alexandre Benois', '17', '84A - Condomínio Fatto Morumbi', 'Vila Andrade', '05729-090', 'São Paulo', 'SP');

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES ('Patrícia Pedrosa', true, 'Rua Salvador de Sá', '40', 'A', 'Rosarinho', '52041-300', 'Recife', 'PE');