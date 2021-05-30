drop database if exists clouddb2020_4;
create database clouddb2020_4;
use clouddb2020_4;

CREATE TABLE tb_user (
  user_id int(4) primary key,
  username varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO clouddb2020_4.tb_user(user_id, username) VALUES ('9999', 'clouddb2020_4');