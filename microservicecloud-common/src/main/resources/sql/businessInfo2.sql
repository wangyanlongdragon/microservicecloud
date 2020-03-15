DROP DATABASE IF EXISTS cloudDB02;
CREATE DATABASE cloudDB02 CHARACTER SET UTF8;
DROP DATABASE IF EXISTS cloudDB02;
CREATE DATABASE cloudDB02 CHARACTER SET UTF8;
USE cloudDB02;
CREATE TABLE t_business
(
  business_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  sys_no VARCHAR(60),
  cust_no VARCHAR(60),
  db_source   VARCHAR(60)
);
 
INSERT INTO t_business(sys_no,cust_no,db_source) VALUES('01','001',DATABASE());
INSERT INTO t_business(sys_no,cust_no,db_source) VALUES('02','002',DATABASE());
INSERT INTO t_business(sys_no,cust_no,db_source) VALUES('03','003',DATABASE());
INSERT INTO t_business(sys_no,cust_no,db_source) VALUES('04','004',DATABASE());
INSERT INTO t_business(sys_no,cust_no,db_source) VALUES('05','005',DATABASE());

 
SELECT * FROM t_business;
 
 
 

