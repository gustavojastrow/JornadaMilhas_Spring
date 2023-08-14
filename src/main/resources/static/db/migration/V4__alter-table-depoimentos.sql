alter table depoimentos add ativo boolean not null;
update depoimentos set ativo = true