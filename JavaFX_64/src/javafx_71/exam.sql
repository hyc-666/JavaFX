create table exam_result(
id int,
name varchar(40),
chinese decimal(3,1),
math decimal(3,1),
english decimal(3,1)
);

insert into exam_result(ind,name,chinese,math,english) value(1,'唐三藏',90,60,50),
(2,'孙悟空',88,77,66),
(3,'孙权',70,65,69);

insert into exam_result(ind,name,chinese,math,english) value(4,'曹操',85.6,63,59),
(5,'刘备',81,75,66),
(6,'猪八戒',91,74,63);