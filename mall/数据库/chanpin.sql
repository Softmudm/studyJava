???prompt PL/SQL Developer import file
prompt Created on 2020年9月16日 by Administrator
set feedback off
set define off
prompt Creating PRODUCT...
create table PRODUCT
(
  product_id    NUMBER(10) not null,
  product_name  VARCHAR2(255),
  product_price NUMBER(12,2),
  product_img   VARCHAR2(255),
  description   VARCHAR2(255)
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
comment on column PRODUCT.product_id
  is '产品id';
comment on column PRODUCT.product_name
  is '商品名称';
comment on column PRODUCT.product_price
  is '商品价格';
comment on column PRODUCT.product_img
  is '商品图片';
comment on column PRODUCT.description
  is '商品描述';
alter table PRODUCT
  add primary key (PRODUCT_ID)
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

prompt Disabling triggers for PRODUCT...
alter table PRODUCT disable all triggers;
prompt Loading PRODUCT...
insert into PRODUCT (product_id, product_name, product_price, product_img, description)
values (1, '菜一', 10, 'cai.jpg', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试');
insert into PRODUCT (product_id, product_name, product_price, product_img, description)
values (2, '菜二', 20, 'cai.jpg', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试');
insert into PRODUCT (product_id, product_name, product_price, product_img, description)
values (3, '菜三', 30, 'cai.jpg', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试');
insert into PRODUCT (product_id, product_name, product_price, product_img, description)
values (4, '菜四', 40, 'cai.jpg', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试');
insert into PRODUCT (product_id, product_name, product_price, product_img, description)
values (5, '菜五', 50, 'cai.jpg', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试');
insert into PRODUCT (product_id, product_name, product_price, product_img, description)
values (6, '菜六', 60, 'cai.jpg', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试');
insert into PRODUCT (product_id, product_name, product_price, product_img, description)
values (7, '菜七', 70, 'cai.jpg', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试');
insert into PRODUCT (product_id, product_name, product_price, product_img, description)
values (8, '菜八', 80, 'cai.jpg', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试');
insert into PRODUCT (product_id, product_name, product_price, product_img, description)
values (9, '菜九', 90, 'cai.jpg', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试');
insert into PRODUCT (product_id, product_name, product_price, product_img, description)
values (10, '菜十', 100, 'cai.jpg', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试');
commit;
prompt 10 records loaded
prompt Enabling triggers for PRODUCT...
alter table PRODUCT enable all triggers;
set feedback on
set define on
prompt Done.
