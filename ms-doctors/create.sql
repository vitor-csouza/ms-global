create table tb_doctor (id bigint not null auto_increment, crm varchar(255) not null, email varchar(255) not null, name varchar(100) not null, phone varchar(255) not null, specialty varchar(255) not null, primary key (id)) engine=InnoDB;