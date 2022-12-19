SELECT A.name
FROM records R
  JOIN teams T ON T.id = R.team_id
  JOIN athletes A ON A.id = R.athlete_id
  JOIN games G ON G.id = R.game_id
WHERE
  G.year >= 2000 AND R.medal IS NOT NULL
GROUP BY R.athlete_id두
HAVING COUNT(distinct T.team) > 1