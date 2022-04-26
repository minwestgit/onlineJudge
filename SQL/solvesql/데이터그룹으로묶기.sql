SELECT quartet
      , round(avg(x), 2) x_mean
      , round(variance(x), 2) x_var
      , round(avg(y), 2) y_mean
      , round(variance(y), 2) y_var
FROM points
GROUP BY quartet