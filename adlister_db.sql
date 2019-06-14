use adlister_db;

Use adlister_db;
drop table if exists users;

create table users (
                      id int unsigned not null auto_increment,
                      username varchar(255) not null,
                      email varchar(255) not null,
                      password varchar(255) not null,
                      primary key (id)
);

create table ads (
                      id int unsigned not null auto_increment,
                      user_id int unsigned not null,
                      title varchar(255) not null,
                      description TEXT not null,
                      primary key (id)
);

