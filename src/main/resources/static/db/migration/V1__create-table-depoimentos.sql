CREATE TABLE depoimentos(

    id bigint not NULL auto_increment,
    foto varchar(100) not null,
    depoimento varchar(150) not null unique,
    autor varchar(100) not null unique,

    primary key(id)
);