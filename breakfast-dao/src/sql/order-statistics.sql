

--订单统计
select co.id,
  group_concat(concat(og.goods_title,'*',og.quantity)) as title,
  co.price as price,
  co.is_impatient as impatient,
  co.create_time as create_time,
  co.address as address,
  co.add_name1 as addname1,
  co.add_name2 as addname2
from core_order co
left join core_order_goods og
on og.order_id = co.id
where co.create_time between [starttime] and current_time
group by co.id
order by co.create_time;