???prompt PL/SQL Developer import file
prompt Created on 2020年9月16日 by Administrator
set feedback off
set define off
prompt Creating T_USER...
create table T_USER
(
  user_id   NUMBER(10) not null,
  account   VARCHAR2(255) not null,
  password  VARCHAR2(255) not null,
  user_name VARCHAR2(255),
  address   VARCHAR2(255)
)
tablespace ZHILINGSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column T_USER.user_id
  is '用户id';
comment on column T_USER.account
  is '账号';
comment on column T_USER.password
  is '密码';
comment on column T_USER.user_name
  is '用户名';
comment on column T_USER.address
  is '地址';
alter table T_USER
  add primary key (USER_ID)
  using index 
  tablespace ZHILINGSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for T_USER...
alter table T_USER disable all triggers;
prompt Loading T_USER...
insert into T_USER (user_id, account, password, user_name, address)
values (1, 'wx', '202cb962ac59075b964b07152d234b70', '王鑫', '深圳市');
commit;
prompt 1 records loaded
prompt Enabling triggers for T_USER...
alter table T_USER enable all triggers;
set feedback on
set define on
prompt Done.
