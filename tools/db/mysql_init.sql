use simpleservicedb;

create table if not exists tbl_users(
id varchar(255),
name varchar(255),
primary key (id)
);

select * from tbl_users;

