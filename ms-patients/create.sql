create table tb_patient (id bigint not null auto_increment, birth_date varchar(255) not null, email varchar(255) not null, height double precision, name varchar(100) not null, phone varchar(255) not null, weight double precision, primary key (id)) engine=InnoDB;
