alter table destinos drop column foto;
alter table destinos ADD (
    url_1 varchar(255) not null,
    url_2 varchar(255) not null,
    meta varchar(100) not null,
    texto varchar(300)
);