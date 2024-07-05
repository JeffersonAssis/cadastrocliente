ALTER TABLE cliente
ADD CONSTRAINT cep_endereco
FOREIGN KEY (endereco)
REFERENCES endereco(cep);