select
  date(min(order_purchase_timestamp)) first_order_date,
  date(max(order_purchase_timestamp)) last_order_date
from
  olist_orders_dataset