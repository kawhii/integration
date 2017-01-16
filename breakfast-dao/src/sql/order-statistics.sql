

--订单统计
select co.id as orderId,
co.ADD_CODE1 as unitCode,
co.ADD_CODE2 as floorCode,
 co.add_name1 as unitName,
  co.add_name2 as floorName,
  group_concat(concat(og.goods_title,'*',og.quantity)) as goodsInfo,
  co.price as totalPrice,
  co.is_impatient as isImpatient,
  co.create_time as createTime,
  co.address as address
from core_order co
left join core_order_goods og
on og.order_id = co.id
where co.create_time between [starttime] and current_time
group by co.id
order by co.create_time;


--销售统计
select cog.goods_id, sum(total_price) as total_price,
sum(cog.unit_price) as unit_price, sum(cog.quantity) as sales,
cog.goods_title, mg.stock, co.add_name1 as unit_name, co.add_code as unit_code
from core_order co left join core_order_goods cog on co.id = cog.order_id
left join mall_goods mg on mg.id = cog.goods_id
group by cog.goods_id, cog.unit_price, cog.goods_title