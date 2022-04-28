SELECT day, time, round(avg(tip),2) avg_tip, round(avg(size),2) avg_size
FROM tips
GROUP BY day, time