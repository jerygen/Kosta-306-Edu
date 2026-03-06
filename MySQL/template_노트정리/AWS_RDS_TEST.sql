select @@time_zone, now();

use AWS_RDS_DB;
CREATE TABLE test (
	id int AUTO_INCREMENT,
	content varchar(255) DEFAULT NULL,
	reg_date datetime default now(),
	PRIMARY KEY (id)
);
insert into test(content) values ('RDS세팅성공');
select * from test;