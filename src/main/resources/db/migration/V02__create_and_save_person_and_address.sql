CREATE TABLE people
(
    id bigint(20) primary key auto_increment,
    name   varchar(50) not null,
    active  boolean     not null,
    publicPlace varchar(50),
    number varchar(30),
    complement varchar(100),
    cep varchar(30),
    district varchar(50),
    city varchar(50),
    state varchar(50)


) ENGINE = InnoDB
  DEFAULT CHAR SET = utf8;
