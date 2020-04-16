drop database if exists clouddb2020_3;
create database clouddb2020_3;
use clouddb2020_3;

CREATE TABLE tb_user (
  user_id int(4) primary key,
  username varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO clouddb2020_3.tb_user(user_id, username) VALUES ('9999', 'clouddb2020_3');