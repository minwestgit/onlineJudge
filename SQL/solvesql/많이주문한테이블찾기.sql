select
  *
from
  tips
where
  total_bill > (
    select
      avg(total_bill)
    from
      tips
  )