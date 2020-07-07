--自定义函数1------------------------------------------------
create or replace function ftest1(num1 number,num2 number)--参数列表不能写长度
return number --函数必须写return，后面跟返回值类型
is
total number(10);--变量列表需要写长度
jia number(10);
jian varchar2(10);
cheng number(10);
chu number(10);
begin
  jia:=num1+num2;
  jian:=to_char(num1-num2);
  cheng:=num1*num2;
  chu:=num1/num2;
  total:=jia+to_number(jian)+cheng+chu;
  return total;--一定要return
end;
select ftest1(2,2) from dual;
drop function ftest1;
--自定义函数2
create or replace function ftest2(c varchar2)
return number
as
total number;
i number;
begin
  i:=1;
  total:=0;
  /*while循环
  while i<=to_number(c)
    loop
      total:=total+i;
      i:=i+1;
    end loop;
  */
  /*for循环
  for i in 1..to_number(c)
    loop
      total:=total+i;
    end loop;
  */
  loop
    exit when i>to_number(c);--这里记得打";"
    total:=total+i;
    i:=i+1;
  end loop;--这里记得打";"
  return total;
end;
select ftest2('100') from dual;
--自定义存储过程-----------------------------------------------
--查询：存储过程中select要配合into或游标来使用
create or replace procedure usp_emp_selectnamebyid
(vc2_in_eid in varchar2,
eename out varchar2)
is
begin
  select ename into eename from t_emp where eid=vc2_in_eid;
end;
--增加
create or replace procedure usp_emp_addemp
(vc2_in_eid in varchar2,
vc2_in_ename in varchar2,
dt_in_bdate in date,
ch_in_sex in char,
vc2_in_city in varchar2,
msg out varchar2)
is
n number(10);
begin
  insert into t_emp values(vc2_in_eid,vc2_in_ename,dt_in_bdate,ch_in_sex,vc2_in_city);
  if sql%found then
     commit;
     msg:='添加成功！';
  else
     msg:='添加失败！';
     end if;
end;
