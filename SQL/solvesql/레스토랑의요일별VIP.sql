select total_bill, tip, sex, smoker, day, time, size
from (
  select *
  	, row_number() over(partition by day order by total_bill desc) as rank
  from tips
) a
where rank = 1
order by day desc