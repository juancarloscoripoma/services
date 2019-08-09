-- USE product;
-- date NOT NULL,
-- datetime DEFAULT NULL,
-- timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,

-- -------------- one to many -----------------------------------------------------------
drop table if exists product^

create table product
(
   id           bigint not null AUTO_INCREMENT,
   name 		    varchar(200),
   amount       decimal(10,2) NOT NULL,
   created_date date NOT NULL,
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8^