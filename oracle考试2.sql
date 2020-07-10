--1����һ����ʦ����������ʦ��š��������Ա�н�ʡ����֤�š�������λ�����ű�ţ���
--����һ�Ų��ű����������ű�š��������ơ�����������
create table teacher
(
teaid varchar2(10),
teaname varchar2(20),
teasex varchar2(5),
teasalary number(10,2),
teacardid varchar2(20),
teajob varchar2(100),
dptid varchar2(10)
)
create table department
(
dptid varchar2(10),
dptname varchar2(20),
dptdescript varchar2(1000)
)
--2Ϊ��ʦ����ֶ����Լ������ʦ��ţ�����Լ�������Ա𣨼��Լ����ֻ�����С�Ů���� 
--���֤���루ΨһԼ���������ű�ţ����Լ�������ò��ű�Ĳ��ű�ţ�
alter table teacher add constraint pk_teacher_teaid primary key (teaid);
alter table teacher add constraint ck_teacher_teasex check (teasex in('��','Ů'));
alter table teacher add constraint uq_teacher_teacardid unique (teacardid);
alter table department add constraint pk_department_dptid primary key (dptid);
alter table teacher add constraint fk_teacher_dptid foreign key (dptid) references department(dptid);
--3�޸ı�ṹ��Ϊ��ʦ����������У�ɾ�����ű��еĲ���������
alter table teacher add (teaage number(3));
alter table department drop column dptdescript;
--4��д SQL ��� 
--a.�����ű���� 3 �����ݷֱ��ǣ���ѧ�����г����������� 
--b.����ʦ����� 6 �����ݣ��ֱ����ڽ�ѧ�����г�����������
insert into department values('d1','��ѧ��');
insert into department values('d2','�г���');
insert into department values('d3','������');
insert into department values('d4',null);
commit;
insert into teacher values('t1','�ŷ�','��',5000,'430211166412288739','��ѧ','d2',45);
insert into teacher values('t2','����','Ů',20020,'430211166412288654','�з�','d1',22);
insert into teacher values('t3','�����','��',60000,'430211166456288739','�г�','d1',60);
insert into teacher values('t4','����','Ů',10000,'430211164455288739','��ѧ','d3',36);
insert into teacher values('t5','����','��',30000,'430211166412288659','��ѧ','d2',39);
insert into teacher values('t6','����','��',8000,'430211166412778739','�з�','d3',29);
commit;
--5��д SQL ��䣺��ѯ��ʦ������н�ʣ�Ҫ��ȥ���ظ�����
select distinct teaname,teasalary from teacher;
--6��ѯн����[10000,60000����Ů��ʦ
select teaid,teaname,teasex,teaage,teasalary,teacardid,teajob,dptid from teacher 
where teasalary>=10000 and teasalary<60000 and teasex='Ů';
--7��ѯ����Ϊ��������ʦ��š��Ա�н�ʣ���ѯ���ĸ��ֶ���Ҫȡ����
select teaid ��ʦ���,teasex �Ա�,teasalary н�� from teacher where teaname='����';
--8��ѯ���ŵ���ʦ��Ϣ
select * from teacher where teaname like '��%';
--9��ѯ�����а����ŵ���ʦ��Ϣ
select * from teacher where teaname like '%��%';
--10����һ�ű���ṹ����ʦ��һ�£����´������ı�������ݣ�������Դ����ʦ��
create table teacher2 as select * from teacher;
--11��ѯ��ʦ����������ݣ���н�ʽ���
select * from teacher order by teasalary desc;
--12�޸���ʦ����������н��Ϊ 50000���Ա�ΪŮ
update teacher set teasalary=50000,teasex='Ů' where teaname='����';
--13��ѯ���ű��в�������Ϊ�յ�����
select * from department where dptname is null;
--14��ѯ��ʦ�����Ա𲻵����У�н��С�� 50000 ������
select * from teacher where teasalary<5000 and teasex!='��';
--15��ѯ������λΪ��ѧ���з�����ʦ����
select * from teacher where teajob='��ѧ'or teajob='�з�';
--16ɾ����ʦ������Ϊ���������ĵ�����
delete from teacher where teaname='����'or teaname='����'��
--17ɾ����ʦ�������е����ݣ�Ҫ���� delete��truncate ������ʽɾ��
delete from teacher;commit;
truncate table teacher;
--18ɾ����ʦ��Ͳ��ű�
drop table teacher,department;
--19��ѯ�ճ£�н�ʴ��� 20000 ������ʦ
select * from teacher where teaname like '��%'and teasalary>20000;
--20��ѯ�����������Ա����Ϣ�Ĳ���
select * from department where dptid in
(select d.dptid from department d left join teacher t on d.dptid=t.dptid group by d.dptid having count(t.dptid)>0);
----------------------------------------------------------------------------------------------------------
--1ѧԱ�� ��ѧԱ��ţ�ѧԱ������ѧԱ�༶��ţ�ѧԱ��ѧʱ�䣩
create table student
(
stuid varchar2(10),
stuname varchar2(20),
claid varchar2(10),
stuindate date
)
--2�γ̱� ���γ̱�ţ��γ����ƣ�
create table course
(
couid varchar2(10),
couname varchar2(50)
)
--3ѧԱ�ɼ��� ���ɼ���ţ�ѧԱ��ţ��γ̱�ţ����Գɼ������Գɼ���
create table score
(
scoid varchar2(10),
stuid varchar2(10),
couid varchar2(10),
writescore number(5,2),
computerscore number(5,2)
)
--4�༶��(�༶��ţ��༶����)
create table clazz
(
claid varchar2(10),
claname varchar2(20)
)
--4������������
insert into student values('st1','��','cl1',to_date('2008-11-22','yyyy-mm-dd'));
insert into student values('st2','��','cl1',to_date('2012-8-30','yyyy-mm-dd'));
insert into student values('st3','��','cl2',to_date('2019-6-6','yyyy-mm-dd'));
insert into student values('st4','��','cl2',to_date('2018-4-13','yyyy-mm-dd'));
insert into student values('st5','��','cl1',to_date('2018-5-3','yyyy-mm-dd'));
insert into student values('st6','��','cl2',to_date('2020-8-16','yyyy-mm-dd'));
insert into student values('st7','��','cl2',to_date('2020-3-1','yyyy-mm-dd'));
insert into student values('st8','��',null,to_date('2019-6-22','yyyy-mm-dd'));
commit
insert into course values('co1','java����');
insert into course values('co2','���ݿ�');
commit
insert into score values('sc1','st1','co1',88,80);
insert into score values('sc2','st1','co2',75,90);
insert into score values('sc3','st2','co1',56,65);
insert into score values('sc4','st2','co2',70,80);
insert into score values('sc5','st3','co1',60,60);
insert into score values('sc6','st3','co2',55,55);
insert into score values('sc7','st4','co1',70,50);
insert into score values('sc8','st4','co2',11,21);
insert into score values('sc9','st5','co1',34,68);
insert into score values('sc10','st5','co2',63,24);
insert into score values('sc11','st7','co1',66,87);
insert into score values('sc12','st7','co2',74,77);
commit
insert into clazz values('cl1','һ��');
insert into clazz values('cl2','����');
commit;
--5ɾ��û�а༶��ŵ�ѧԱ��Ϣ
delete from student where claid is null;
commit;
--6ɾ��û�вμӿ��Ե�ѧԱ��Ϣ
delete from student where stuid not in(select distinct stuid from score);
commit;
--7�����Գɼ�û�м����ѧԱ���Գɼ���� 5 ��
update score set computerscore=computerscore+5 where writescore<60;
commit;
--8������һ���ܳɼ������Ժͻ��ԣ�û�м����ѧԱ�༶�޸ĳ�����һ���༶
update student set claid=case claid 
                          when 'cl1'then 'cl2'
                            when 'cl2'then 'cl1'
                              else'' end 
    where stuid in
(select distinct stuid from score where writescore+computerscore<120);
commit;
--9��ѯ���Գɼ���ߵ�ѧԱ��Ϣ�����γ�����
select couname from course where couid=
(select couid from score where writescore=(select max(writescore) from score));
--10��ѯÿ������ܳɼ������Ժͻ��ԣ���ƽ���ɼ������Ժͻ��ԣ�
select sum(s2.writescore+s2.computerscore) �ܳɼ�,avg(s2.writescore+s2.computerscore) ƽ���ɼ� 
from student s1,score s2 where s1.stuid=s2.stuid group by s1.claid;
--11��ѯÿ�ſγ��ܳɼ������Ժͻ��ԣ���ߵ�ѧԱ��Ϣ
select s3.couid,s3.m,s2.stuid,s2.stuname,s2.claid,s2.stuindate from
score s1,student s2,(select couid,max(writescore+computerscore) m from score group by couid) s3
where (s1.writescore+s1.computerscore)=s3.m and s1.stuid=s2.stuid and s1.couid=s3.couid;
--12��ѯÿ������ܳɼ������Ժͻ��ԣ���һ����ѧԱ��Ϣ
select s3.claid,s3.m,s2.stuid,s2.stuname,s2.claid,s2.stuindate from
score s1,student s2,(select claid,max(writescore+computerscore) m from score s1,student s2 where s1.stuid=s2.stuid group by claid) s3
where (s1.writescore+s1.computerscore)=s3.m and s1.stuid=s2.stuid and s2.claid=s3.claid;