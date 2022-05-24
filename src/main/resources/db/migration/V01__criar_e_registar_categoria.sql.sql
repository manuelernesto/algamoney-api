CREATE TABLE category
(
    codigo bigint(20) primary key auto_increment,
    nome   varchar(50) not null
) ENGINE = InnoDB
  DEFAULT CHAR SET = utf8;

insert into category(nome)
values ('Lazer'),
       ('Alimentação'),
       ('Supermercado'),
       ('Farmácia'),
       ('Outros');