???prompt PL/SQL Developer import file
prompt Created on 2020年9月16日 by Administrator
set feedback off
set define off
prompt Creating ORDER_DETAIL...
create table ORDER_DETAIL
(
  detail_id  NUMBER(10) not null,
  product_id NUMBER(10),
  amount     NUMBER(10),
  order_id   VARCHAR2(20)
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
comment on column ORDER_DETAIL.detail_id
  is '详情id';
comment on column ORDER_DETAIL.product_id
  is '商品id';
comment on column ORDER_DETAIL.amount
  is '商品数量';
comment on column ORDER_DETAIL.order_id
  is '所属订单id';
alter table ORDER_DETAIL
  add primary key (DETAIL_ID)
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

prompt Creating TORDER...
create table TORDER
(
  order_id     VARCHAR2(20) not null,
  user_id      NUMBER(10),
  order_adress VARCHAR2(255),
  status       VARCHAR2(255)
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
comment on column TORDER.order_id
  is '订单id';
comment on column TORDER.user_id
  is '用户id';
comment on column TORDER.order_adress
  is '送货地址';
comment on column TORDER.status
  is '订单状态';
alter table TORDER
  add primary key (ORDER_ID)
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

prompt Disabling triggers for ORDER_DETAIL...
alter table ORDER_DETAIL disable all triggers;
prompt Disabling triggers for TORDER...
alter table TORDER disable all triggers;
prompt Loading ORDER_DETAIL...
insert into ORDER_DETAIL (detail_id, product_id, amount, order_id)
values (5, 7, 1, 'GL20200916000009');
insert into ORDER_DETAIL (detail_id, product_id, amount, order_id)
values (6, 3, 3, 'GL20200916000010');
insert into ORDER_DETAIL (detail_id, product_id, amount, order_id)
values (1, 3, 2, 'GL20200916000005');
insert into ORDER_DETAIL (detail_id, product_id, amount, order_id)
values (2, 8, 1, 'GL20200916000005');
insert into ORDER_DETAIL (detail_id, product_id, amount, order_id)
values (3, 3, 1, 'GL20200916000007');
insert into ORDER_DETAIL (detail_id, product_id, amount, order_id)
values (4, 7, 1, 'GL20200916000008');
commit;
prompt 6 records loaded
prompt Loading TORDER...
insert into TORDER (order_id, user_id, order_adress, status)
values ('GL20200916000009', null, null, '已支付');
insert into TORDER (order_id, user_id, order_adress, status)
values ('GL20200916000010', 1, '深圳市', '待支付');
insert into TORDER (order_id, user_id, order_adress, status)
values ('GL20200916000005', 1, '深圳市', '待支付');
insert into TORDER (order_id, user_id, order_adress, status)
values ('GL20200916000007', 1, '深圳市', '待支付');
insert into TORDER (order_id, user_id, order_adress, status)
values ('GL20200916000008', 1, '深圳市', '待支付');
commit;
prompt 5 records loaded
prompt Enabling triggers for ORDER_DETAIL...
alter table ORDER_DETAIL enable all triggers;
prompt Enabling triggers for TORDER...
alter table TORDER enable all triggers;
set feedback on
set define on
prompt Done.
