CREATE TABLE cliente(
  id serial primary key,
  nome varchar(255) not null,
  cpf varchar(255) not null unique,
  telefone varchar(255) not null,
  email varchar(255) not null unique,
  data_nasc date not null,
  endereco varchar(255) not null
);