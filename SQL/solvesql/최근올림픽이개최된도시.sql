SELECT year, UPPER(SUBSTR(city, 0, 4)) city
FROM games
WHERE year >= 2000
ORDER BY year DESC