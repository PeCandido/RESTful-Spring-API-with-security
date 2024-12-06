create table consertos(
    id                      bigint       not null auto_increment,
    entrada                 varchar(100) not null,
    saida                   varchar(100) not null,
    marca                   varchar(100) not null,
    modelo                  varchar(100) not null,
    ano                     int          not null,
    nome                    varchar(100) not null,
    experiencia             int          not null,

    primary key (id)
)