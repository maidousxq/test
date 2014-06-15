conn scott/tiger;

create table t_order
(order_id varchar2(3) primary key,
client_id varchar2(6),
createtime date,
status number
);

insert into t_order values('111','G00101',to_date('2004-7-1','yyyy-mm-dd'),1);

insert into t_order values('112','G00101',to_date('2004-6-1','yyyy-mm-dd'),2);

insert into t_order values('113','G00102',to_date('2004-5-30','yyyy-mm-dd'),2);

insert into t_order values('114','G00103',to_date('2004-7-1','yyyy-mm-dd'),2);

insert into t_order values('115','G00103',to_date('2004-7-1','yyyy-mm-dd'),3);

create table t_order_detail
(order_detail_id varchar2(5) primary key,
order_id varchar2(3),
product_id varchar2(3),
quantity number
);

insert into t_order_detail values('10001','111','001',11);

insert into t_order_detail values('10002','111','002',10);

insert into t_order_detail values('20001','114','001',5);

create or replace procedure up_detail
(
orderid in t_order_detail.order_id%type,
productid in t_order_detail.product_id%type,
qty in t_order_detail.quantity%type
)
as
  v_orderid t_order_detail.order_detail_id%type;
begin
  select max(trunc(order_detail_id,-4)+10001) into v_orderid from t_order_detail;
  insert into t_order_detail values((select decode(count(order_detail_id),0,v_orderid,max(order_detail_id)+1) from t_order_detail where order_id=orderid),orderid,productid,qty);
end up_detail;

commit;
