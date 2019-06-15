use adlister_db;

create table if not exists users (
                      id int unsigned not null auto_increment,
                      username varchar(255) not null,
                      email varchar(255) not null,
                      password varchar(255) not null,
                      primary key (id)
);

create table if not exists ads (
                      id int unsigned not null auto_increment,
                      user_id int unsigned not null,
                      title varchar(255) not null,
                      description TEXT not null,
                      primary key (id)
);


insert into users (username, email, password)
values ('bob-joe-johnson', 'bob@joejohnson.com', 'pass');

