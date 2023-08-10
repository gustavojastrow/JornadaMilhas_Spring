CREATE TABLE destinos(
    id BIGINT not null auto_increment,
    foto VARCHAR(100) NOT NULL,
    nome VARCHAR(100) NOT NULL UNIQUE,
    preco FLOAT(100) NOT NULL

    Primary key(id)
)