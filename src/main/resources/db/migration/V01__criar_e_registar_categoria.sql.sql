CREATE TABLE category
(
    id bigint(20) primary key auto_increment,
    name   varchar(50) not null
) ENGINE = InnoDB
  DEFAULT CHAR SET = utf8;

insert into category(name)
values ('Lazer'),
       ('Alimentação'),
       ('Supermercado'),
       ('Farmácia'),
       ('Outros');