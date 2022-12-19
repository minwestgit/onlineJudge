select
  date(order_purchase_timestamp) purchase_date
  , count(case when order_estimated_delivery_date > order_delivered_customer_date then order_id end) success
  , count(case when order_estimated_delivery_date <= order_delivered_customer_date then order_id end) fail
from
  olist_orders_dataset
where order_purchase_timestamp >= '2017-01-01' AND order_purchase_timestamp < '2017-02-01'
group by purchase_date
order by purchase_date