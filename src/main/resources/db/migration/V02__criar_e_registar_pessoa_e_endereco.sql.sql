CREATE TABLE pessoa
(
    codigo bigint(20) primary key auto_increment,
    nome   varchar(50) not null,
    ativo  boolean     not null,
    logradouro varchar(50),
    numero varchar(30),
    complemento varchar(100),
    cep varchar(30),
    bairro varchar(50),
    cidade varchar(50),
    estado varchar(50)


) ENGINE = InnoDB
  DEFAULT CHAR SET = utf8;
