--Oracle数据库函数练习
--字符函数------------------------------------
select
--initcap('yes') --首字母大写
--lower('YES') --转换为全小写
--upper('yes') --转换为全大写
--ltrim('aaaaajavaaaaa','ja') --左裁剪
--rtrim('aaaaajavaaaaa','av') --右裁剪
--translate('jack','abcd','1234') --按字符翻译
--replace('java','j','lululu') --字符串替换
--instr('worldwide','d') --查找子串位置
--substr('abcdefghijk',3,5) --取子字符串
--concat('Hello','world') --连接字符串
from dual;
--数字函数------------------------------------
select
--abs(-30) --绝对值
--ceil(44.5) --向上取整
--floor(44.5) --向下取整
--sign(-30) --取符号
--power(2,4) --m的n次方
--mod(16,10) --取余
--round(44.55,1) --四舍五入
--trunc(44.55,1) --截断
--sqrt(16) --平方根
from dual;
--日期函数------------------------------------
select
--months_between(to_date('2020-7-6','yyyy-MM-dd'),to_date('2020-1-1','yyyy-MM-dd')) --两个日期之间的月份
--add_months(sysdate,1) --加上月份数后的新日期
--next_day(sysdate,'星期二') --返回日期后指定星期对应的新日期
--last_day(sysdate) --返回日期所在月份的最后一天
--round(sysdate,'year') --按指定的格式进行四舍五入
trunc(sysdate,'day') --按指定的格式进行截断
from dual;
--常用转换函数------------------------------------
select
--to_char(sysdate,'yyyy-MM-dd') --转化为字符串类型
--to_date('2020-7-6','yyyy-MM-dd') --转化为日期类型
--to_number('1234') --转化为数值类型
from dual;
--常用其它函数------------------------------------
select
--nvl(null,4) --如果第一个是null，返回第二个
--nvl2(3,1,2) --如果第一个是null，返回第二个，否则返回第三个
--decode(value,if1,then1,if2,then2,else) --value和后面if相比，都不等于就输出else
from dual;
--自定义函数------------------------------------
create or replace function 函数名(参数1 模式 参数类型,...)  
return 返回值类型  
as  
变量1 变量类型;  
变量2 变量类型;  
begin  
    函数体;  
end 函数名;  
