--Oracle���ݿ⺯����ϰ
--�ַ�����------------------------------------
select
--initcap('yes') --����ĸ��д
--lower('YES') --ת��ΪȫСд
--upper('yes') --ת��Ϊȫ��д
--ltrim('aaaaajavaaaaa','ja') --��ü�
--rtrim('aaaaajavaaaaa','av') --�Ҳü�
--translate('jack','abcd','1234') --���ַ�����
--replace('java','j','lululu') --�ַ����滻
--instr('worldwide','d') --�����Ӵ�λ��
--substr('abcdefghijk',3,5) --ȡ���ַ���
--concat('Hello','world') --�����ַ���
from dual;
--���ֺ���------------------------------------
select
--abs(-30) --����ֵ
--ceil(44.5) --����ȡ��
--floor(44.5) --����ȡ��
--sign(-30) --ȡ����
--power(2,4) --m��n�η�
--mod(16,10) --ȡ��
--round(44.55,1) --��������
--trunc(44.55,1) --�ض�
--sqrt(16) --ƽ����
from dual;
--���ں���------------------------------------
select
--months_between(to_date('2020-7-6','yyyy-MM-dd'),to_date('2020-1-1','yyyy-MM-dd')) --��������֮����·�
--add_months(sysdate,1) --�����·������������
--next_day(sysdate,'���ڶ�') --�������ں�ָ�����ڶ�Ӧ��������
--last_day(sysdate) --�������������·ݵ����һ��
--round(sysdate,'year') --��ָ���ĸ�ʽ������������
trunc(sysdate,'day') --��ָ���ĸ�ʽ���нض�
from dual;
--����ת������------------------------------------
select
--to_char(sysdate,'yyyy-MM-dd') --ת��Ϊ�ַ�������
--to_date('2020-7-6','yyyy-MM-dd') --ת��Ϊ��������
--to_number('1234') --ת��Ϊ��ֵ����
from dual;
--������������------------------------------------
select
--nvl(null,4) --�����һ����null�����صڶ���
--nvl2(3,1,2) --�����һ����null�����صڶ��������򷵻ص�����
--decode(value,if1,then1,if2,then2,else) --value�ͺ���if��ȣ��������ھ����else
from dual;
--�Զ��庯��------------------------------------
create or replace function ������(����1 ģʽ ��������,...)  
return ����ֵ����  
as  
����1 ��������;  
����2 ��������;  
begin  
    ������;  
end ������;  
