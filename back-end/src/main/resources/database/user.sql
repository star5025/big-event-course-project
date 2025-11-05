create table big_event.user
(
    id          int auto_increment
        primary key,
    username    varchar(255) not null,
    password    varchar(255) not null,
    nickname    varchar(255) null,
    email       varchar(255) null,
    user_pic    text         null,
    create_time datetime     null,
    update_time datetime     null,
    constraint id_UNIQUE
        unique (id),
    constraint username_UNIQUE
        unique (username)
)
    comment '用户信息表';

