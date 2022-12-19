select *
from tips
where day in
(select day from tips group by day having sum(total_bill) >= 1500)