--1创建一张老师表，包含（老师编号、姓名、性别、薪资、身份证号、工作岗位、部门编号）；
--创建一张部门表，包含（部门编号、部门名称、部门描述）
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
--2为老师表的字段添加约束，老师编号（主键约束）、性别（检查约束，只能是男、女）、 
--身份证号码（唯一约束）、部门编号（外键约束，引用部门表的部门编号）
alter table teacher add constraint pk_teacher_teaid primary key (teaid);
alter table teacher add constraint ck_teacher_teasex check (teasex in('男','女'));
alter table teacher add constraint uq_teacher_teacardid unique (teacardid);
alter table department add constraint pk_department_dptid primary key (dptid);
alter table teacher add constraint fk_teacher_dptid foreign key (dptid) references department(dptid);
--3修改表结构，为老师表添加年龄列；删除部门表中的部门描述列
alter table teacher add (teaage number(3));
alter table department drop column dptdescript;
--4编写 SQL 语句 
--a.给部门表插入 3 条数据分别是：教学部、市场部、行政部 
--b.给老师表插入 6 条数据，分别属于教学部、市场部、行政部
insert into department values('d1','教学部');
insert into department values('d2','市场部');
insert into department values('d3','行政部');
insert into department values('d4',null);
commit;
insert into teacher values('t1','张飞','男',5000,'430211166412288739','教学','d2',45);
insert into teacher values('t2','赵云','女',20020,'430211166412288654','研发','d1',22);
insert into teacher values('t3','诸葛亮','男',60000,'430211166456288739','市场','d1',60);
insert into teacher values('t4','貂蝉','女',10000,'430211164455288739','教学','d3',36);
insert into teacher values('t5','关羽','男',30000,'430211166412288659','教学','d2',39);
insert into teacher values('t6','张三','男',8000,'430211166412778739','研发','d3',29);
commit;
--5编写 SQL 语句：查询老师姓名、薪资，要求去掉重复数据
select distinct teaname,teasalary from teacher;
--6查询薪资是[10000,60000）的女老师
select teaid,teaname,teasex,teaage,teasalary,teacardid,teajob,dptid from teacher 
where teasalary>=10000 and teasalary<60000 and teasex='女';
--7查询姓名为张三的老师编号、性别、薪资，查询出的各字段需要取别名
select teaid 老师编号,teasex 性别,teasalary 薪资 from teacher where teaname='张三';
--8查询姓张的老师信息
select * from teacher where teaname like '张%';
--9查询姓名中包含张的老师信息
select * from teacher where teaname like '%张%';
--10创建一张表，表结构与老师表一致；往新创建出的表插入数据，数据来源于老师表
create table teacher2 as select * from teacher;
--11查询老师表的所有数据，按薪资降序
select * from teacher order by teasalary desc;
--12修改老师表中张三的薪资为 50000，性别为女
update teacher set teasalary=50000,teasex='女' where teaname='张三';
--13查询部门表中部门名称为空的数据
select * from department where dptname is null;
--14查询老师表中性别不等于男，薪资小于 50000 的数据
select * from teacher where teasalary<5000 and teasex!='男';
--15查询工作岗位为教学和研发的老师数据
select * from teacher where teajob='教学'or teajob='研发';
--16删除老师中姓名为张三和李四的数据
delete from teacher where teaname='张三'or teaname='李四'；
--17删除老师表中所有的数据，要求用 delete、truncate 两个方式删除
delete from teacher;commit;
truncate table teacher;
--18删除老师表和部门表
drop table teacher,department;
--19查询姓陈，薪资大于 20000 的男老师
select * from teacher where teaname like '陈%'and teasalary>20000;
--20查询部门里面存在员工信息的部门
select * from department where dptid in
(select d.dptid from department d left join teacher t on d.dptid=t.dptid group by d.dptid having count(t.dptid)>0);
----------------------------------------------------------------------------------------------------------
--1学员表 （学员编号，学员姓名，学员班级编号，学员入学时间）
create table student
(
stuid varchar2(10),
stuname varchar2(20),
claid varchar2(10),
stuindate date
)
--2课程表 （课程编号，课程名称）
create table course
(
couid varchar2(10),
couname varchar2(50)
)
--3学员成绩表 （成绩编号，学员编号，课程编号，笔试成绩，机试成绩）
create table score
(
scoid varchar2(10),
stuid varchar2(10),
couid varchar2(10),
writescore number(5,2),
computerscore number(5,2)
)
--4班级表(班级编号，班级名称)
create table clazz
(
claid varchar2(10),
claname varchar2(20)
)
--4向各表插入数据
insert into student values('st1','甲','cl1',to_date('2008-11-22','yyyy-mm-dd'));
insert into student values('st2','乙','cl1',to_date('2012-8-30','yyyy-mm-dd'));
insert into student values('st3','丙','cl2',to_date('2019-6-6','yyyy-mm-dd'));
insert into student values('st4','丁','cl2',to_date('2018-4-13','yyyy-mm-dd'));
insert into student values('st5','戊','cl1',to_date('2018-5-3','yyyy-mm-dd'));
insert into student values('st6','己','cl2',to_date('2020-8-16','yyyy-mm-dd'));
insert into student values('st7','庚','cl2',to_date('2020-3-1','yyyy-mm-dd'));
insert into student values('st8','辛',null,to_date('2019-6-22','yyyy-mm-dd'));
commit
insert into course values('co1','java基础');
insert into course values('co2','数据库');
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
insert into clazz values('cl1','一班');
insert into clazz values('cl2','二班');
commit;
--5删除没有班级编号的学员信息
delete from student where claid is null;
commit;
--6删除没有参加考试的学员信息
delete from student where stuid not in(select distinct stuid from score);
commit;
--7将笔试成绩没有及格的学员机试成绩提高 5 分
update score set computerscore=computerscore+5 where writescore<60;
commit;
--8将任意一科总成绩（笔试和机试）没有及格的学员班级修改成另外一个班级
update student set claid=case claid 
                          when 'cl1'then 'cl2'
                            when 'cl2'then 'cl1'
                              else'' end 
    where stuid in
(select distinct stuid from score where writescore+computerscore<120);
commit;
--9查询笔试成绩最高的学员信息包含课程名称
select couname from course where couid=
(select couid from score where writescore=(select max(writescore) from score));
--10查询每个班的总成绩（笔试和机试）和平均成绩（笔试和机试）
select sum(s2.writescore+s2.computerscore) 总成绩,avg(s2.writescore+s2.computerscore) 平均成绩 
from student s1,score s2 where s1.stuid=s2.stuid group by s1.claid;
--11查询每门课程总成绩（笔试和机试）最高的学员信息
select s3.couid,s3.m,s2.stuid,s2.stuname,s2.claid,s2.stuindate from
score s1,student s2,(select couid,max(writescore+computerscore) m from score group by couid) s3
where (s1.writescore+s1.computerscore)=s3.m and s1.stuid=s2.stuid and s1.couid=s3.couid;
--12查询每个班的总成绩（笔试和机试）第一名的学员信息
select s3.claid,s3.m,s2.stuid,s2.stuname,s2.claid,s2.stuindate from
score s1,student s2,(select claid,max(writescore+computerscore) m from score s1,student s2 where s1.stuid=s2.stuid group by claid) s3
where (s1.writescore+s1.computerscore)=s3.m and s1.stuid=s2.stuid and s2.claid=s3.claid;