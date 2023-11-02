create table user
(
    id                  int auto_increment
        primary key,
    username            varchar(50)      null,
    password            varchar(255)     null,
    address             varchar(50)      null,
    code                varchar(20)      null,
    identification_card varchar(18)      null,
    birthday            datetime         null,
    sex                 char             null,
    enter_time          datetime         null,
    finish_time         datetime         null,
    create_time         datetime         null,
    create_by           int              null,
    update_time         datetime         null,
    update_by           int              null,
    del_flag            char default '0' null,
    constraint user_pk
        unique (code)
);

