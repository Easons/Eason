drop table manager;
create table manager(
  mid number primary key,
  mname varchar2(10) not null,
  mpassword varchar2(10) not null
);


--删除原来存在的序列
drop sequence manager_seq;
--创建序列
create sequence manager_seq start with 1 increment by 1;
--插入数据
insert into manager values(manager_seq.nextval,'庞攀','111111');


--删除原来的emp表
drop table emp;

create table emp(
  empno number(4) primary key,
  epassword varchar2(10) not null,
  ename varchar2(10) not null,
  esex varchar2(8) constraint emp_ck_sex check(esex in('男','女')),
  age number(3) constraint empl_ck_age check(age between 18 and 60),
  sal number(7,2)
);
drop sequence emp_seq;
--创建序列
create sequence emp_seq start with 100 minvalue 100 increment by 1;

--增加数据
insert into emp values(emp_seq.nextval,'666666','jack','男',25,2500);
insert into emp values(emp_seq.nextval,'666666','rose','女',25,2500);
insert into emp values(emp_seq.nextval,'666666','张三','女',25,2500);
insert into emp values(emp_seq.nextval,'666666','李四','男',18,2500);
insert into emp values(emp_seq.nextval,'666666','王五','男',18,2500);
insert into emp values(emp_seq.nextval,'666666','傻逼','男',18,2500);


--房间信息表
drop table room ;
create table room(
  rmno number(4) primary key,
  rmtype varchar2(10)  constraint room_ck_rmtype check(rmtype in('单人间','双人间','电脑房')),
  rmprice number(5,2) not null,
  vprice number(5,2) not null,
  rmbuff varchar2(10) check(rmbuff in('有人','无人')),
  rmbook varchar2(18) check(rmbook in('已预订','无人预订')),
  rydate  varchar2(20)
);
drop sequence room_seq;
--创建序列
create sequence room_seq start with 100 minvalue 100 increment by 1;
--加入数据
insert into room values(room_seq.nextval,'单人间',35,32,'无人','无人预订',null);
insert into room values(room_seq.nextval,'单人间',35,32,'无人','无人预订',null);
insert into room values(room_seq.nextval,'单人间',40,35,'无人','无人预订',null);
insert into room values(room_seq.nextval,'单人间',42,36,'无人','无人预订',null);
insert into room values(room_seq.nextval,'单人间',35,32,'无人','无人预订',null);
insert into room values(room_seq.nextval,'单人间',35,32,'无人','无人预订',null);
insert into room values(room_seq.nextval,'单人间',40,35,'无人','无人预订',null);
insert into room values(room_seq.nextval,'单人间',42,36,'无人','无人预订',null);
insert into room values(room_seq.nextval,'单人间',40,35,'无人','无人预订',null);
insert into room values(room_seq.nextval,'单人间',40,35,'无人','无人预订',null);
insert into room values(room_seq.nextval,'双人间',60,47,'无人','无人预订',null);
insert into room values(room_seq.nextval,'双人间',60,47,'无人','无人预订',null);
insert into room values(room_seq.nextval,'双人间',60,45,'无人','无人预订',null);
insert into room values(room_seq.nextval,'双人间',62,47,'无人','无人预订',null);
insert into room values(room_seq.nextval,'双人间',65,48,'无人','无人预订',null);
insert into room values(room_seq.nextval,'双人间',60,47,'无人','无人预订',null);
insert into room values(room_seq.nextval,'双人间',60,47,'无人','无人预订',null);
insert into room values(room_seq.nextval,'双人间',60,45,'无人','无人预订',null);
insert into room values(room_seq.nextval,'双人间',62,47,'无人','无人预订',null);
insert into room values(room_seq.nextval,'双人间',65,48,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,41,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,43,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',58,42,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,40,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,42,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,40,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,41,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,42,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,43,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,45,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,44,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,44,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,43,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,42,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,41,'无人','无人预订',null);
insert into room values(room_seq.nextval,'电脑房',55,41,'无人','无人预订',null);


drop table menus;
--餐饮表
 create table menus(
   mno number(5)not null,
   mname varchar2(10) not null,
   mfee number(4) not null,
   mvfee number(4) not null
 );
drop sequence menus_seq;
--创建序列
create sequence menus_seq start with 1000 minvalue 1000 increment by 1;
insert into menus values(menus_seq.nextval,'辣椒炒肉',15,10);
insert into menus values(menus_seq.nextval,'土豆烧肉',15,10);
insert into menus values(menus_seq.nextval,'铁板牛肉',15,10);
insert into menus values(menus_seq.nextval,'红烧肉',15,10);
insert into menus values(menus_seq.nextval,'茄子烧肉',15,10);







drop table client;
--客户表
create table client(
  cid number primary key,
  cname varchar2(10) not null,
  ccard varchar2(20) not null,
  rtel number(15) not null,
  rmno references room(rmno),
  cding number(5,2) not null,
  cfee number(5,2),
 -- cmfee number(5,2),
  --callfee number(5,2),
  cdate varchar2(30)
  --cedate varchar2(30)
);
drop sequence client_seq;
--创建序列
create sequence client_seq start with 0 minvalue 0 increment by 1;


--删除原表
drop table vip; 
--vip表
create table vip(
 id number,
 vno number(5) primary key,
 vname varchar2(10) not null,
 vcard varchar2(20) not null,
 rmno references room(rmno),
 tel number(15) not null,
 --饭钱
 vfee number(5,2),
 --房费
 --vmfee number(5,2),
 --总的费用
 --vallfee number(5,2),
 vdate varchar2(20)
);
--删除序列
drop sequence vip_seq ;
--创建序列
create sequence vip_seq start with 0 minvalue 0 increment by 1;
--增加会员
insert into vip values(vip_seq.nextval,101,'庞攀','431202199611300017',null,13787019873,0,'空');
insert into vip values(vip_seq.nextval,102,'tt','431202199611311111',null,13787011111,0,'空');
insert into vip values(vip_seq.nextval,103,'pp','431202199611322222',null,13787184252,0,'空');

drop table history;
--历史记录表
create table history(
  id number primary key,
  hname varchar2(10),
  hcard varchar2(20),
  htel number(11),
  hrmno number(5),
  htype varchar2(10),
  hydate varchar2(20),
  hyedate varchar2(20),
  hdate varchar2(30),
  hedate varchar2(30),
  hallfee number(5,2),
  hshijian varchar2(10)
);

--删除序列
drop sequence his_seq;
--创建序列
create sequence his_seq start with 0 minvalue 0 increment by 1;










