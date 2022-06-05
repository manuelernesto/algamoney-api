CREATE TABLE launch
(
    id          bigint(20) primary key auto_increment,
    description varchar(50)    not null,
    due_date    date           not null,
    payday      date,
    amount      decimal(10, 2) not null,
    observation varchar(100),
    type        varchar(20)    not null,
    category_id bigint         not null,
    person_id   bigint         not null,

    foreign key (category_id) references category (id),
    foreign key (person_id) references person (id)

) ENGINE = InnoDB
  DEFAULT CHAR SET = utf8;

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 'REVENUE', 1, 2);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'EXPENSE', 2, 2);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Top Club', '2017-06-10', null, 120, null, 'REVENUE', 3, 3);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 'REVENUE', 3, 4);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('DMAE', '2017-06-10', null, 200.30, null, 'EXPENSE', 3, 5);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'REVENUE', 4, 6);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'EXPENSE', 4, 4);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Despachante', '2017-06-10', null, 123.64, 'Multas', 'EXPENSE', 3, 6);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Bahamas', '2017-06-10', null, 500, null, 'REVENUE', 1, 6);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 'REVENUE', 5, 6);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Café', '2017-06-10', null, 8.32, null, 'EXPENSE', 1, 5);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 'EXPENSE', 5, 4);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Instrumentos', '2017-06-10', null, 1040.32, null, 'EXPENSE', 4, 3);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Café', '2017-04-10', '2017-04-10', 4.32, null, 'EXPENSE', 4, 2);

INSERT INTO launch (description, due_date, payday, amount, observation, type, category_id, person_id)
values ('Lanche', '2017-06-10', null, 10.20, null, 'EXPENSE', 4, 2);