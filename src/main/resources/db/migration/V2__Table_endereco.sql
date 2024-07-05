CREATE TABLE endereco(
  cep varchar(255) primary key,
  logradouro varchar(255) not null,
  localidade varchar(255) not null,
  bairro varchar(255) not null,
  uf varchar(255) not null
);