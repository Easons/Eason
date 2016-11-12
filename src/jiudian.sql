drop table manager;
create table manager(
  mid number primary key,
  mname varchar2(10) not null,
  mpassword varchar2(10) not null
);


--ɾ��ԭ�����ڵ�����
drop sequence manager_seq;
--��������
create sequence manager_seq start with 1 increment by 1;
--��������
insert into manager values(manager_seq.nextval,'����','111111');


--ɾ��ԭ����emp��
drop table emp;

create table emp(
  empno number(4) primary key,
  epassword varchar2(10) not null,
  ename varchar2(10) not null,
  esex varchar2(8) constraint emp_ck_sex check(esex in('��','Ů')),
  age number(3) constraint empl_ck_age check(age between 18 and 60),
  sal number(7,2)
);
drop sequence emp_seq;
--��������
create sequence emp_seq start with 100 minvalue 100 increment by 1;

--��������
insert into emp values(emp_seq.nextval,'666666','jack','��',25,2500);
insert into emp values(emp_seq.nextval,'666666','rose','Ů',25,2500);
insert into emp values(emp_seq.nextval,'666666','����','Ů',25,2500);
insert into emp values(emp_seq.nextval,'666666','����','��',18,2500);
insert into emp values(emp_seq.nextval,'666666','����','��',18,2500);
insert into emp values(emp_seq.nextval,'666666','ɵ��','��',18,2500);


--������Ϣ��
drop table room ;
create table room(
  rmno number(4) primary key,
  rmtype varchar2(10)  constraint room_ck_rmtype check(rmtype in('���˼�','˫�˼�','���Է�')),
  rmprice number(5,2) not null,
  vprice number(5,2) not null,
  rmbuff varchar2(10) check(rmbuff in('����','����')),
  rmbook varchar2(18) check(rmbook in('��Ԥ��','����Ԥ��')),
  rydate  varchar2(20)
);
drop sequence room_seq;
--��������
create sequence room_seq start with 100 minvalue 100 increment by 1;
--��������
insert into room values(room_seq.nextval,'���˼�',35,32,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���˼�',35,32,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���˼�',40,35,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���˼�',42,36,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���˼�',35,32,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���˼�',35,32,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���˼�',40,35,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���˼�',42,36,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���˼�',40,35,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���˼�',40,35,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'˫�˼�',60,47,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'˫�˼�',60,47,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'˫�˼�',60,45,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'˫�˼�',62,47,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'˫�˼�',65,48,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'˫�˼�',60,47,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'˫�˼�',60,47,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'˫�˼�',60,45,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'˫�˼�',62,47,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'˫�˼�',65,48,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,41,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,43,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',58,42,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,40,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,42,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,40,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,41,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,42,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,43,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,45,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,44,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,44,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,43,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,42,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,41,'����','����Ԥ��',null);
insert into room values(room_seq.nextval,'���Է�',55,41,'����','����Ԥ��',null);


drop table menus;
--������
 create table menus(
   mno number(5)not null,
   mname varchar2(10) not null,
   mfee number(4) not null,
   mvfee number(4) not null
 );
drop sequence menus_seq;
--��������
create sequence menus_seq start with 1000 minvalue 1000 increment by 1;
insert into menus values(menus_seq.nextval,'��������',15,10);
insert into menus values(menus_seq.nextval,'��������',15,10);
insert into menus values(menus_seq.nextval,'����ţ��',15,10);
insert into menus values(menus_seq.nextval,'������',15,10);
insert into menus values(menus_seq.nextval,'��������',15,10);







drop table client;
--�ͻ���
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
--��������
create sequence client_seq start with 0 minvalue 0 increment by 1;


--ɾ��ԭ��
drop table vip; 
--vip��
create table vip(
 id number,
 vno number(5) primary key,
 vname varchar2(10) not null,
 vcard varchar2(20) not null,
 rmno references room(rmno),
 tel number(15) not null,
 --��Ǯ
 vfee number(5,2),
 --����
 --vmfee number(5,2),
 --�ܵķ���
 --vallfee number(5,2),
 vdate varchar2(20)
);
--ɾ������
drop sequence vip_seq ;
--��������
create sequence vip_seq start with 0 minvalue 0 increment by 1;
--���ӻ�Ա
insert into vip values(vip_seq.nextval,101,'����','431202199611300017',null,13787019873,0,'��');
insert into vip values(vip_seq.nextval,102,'tt','431202199611311111',null,13787011111,0,'��');
insert into vip values(vip_seq.nextval,103,'pp','431202199611322222',null,13787184252,0,'��');

drop table history;
--��ʷ��¼��
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

--ɾ������
drop sequence his_seq;
--��������
create sequence his_seq start with 0 minvalue 0 increment by 1;










