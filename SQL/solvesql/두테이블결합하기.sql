SELECT distinct R.athlete_id
FROM records R LEFT JOIN events E ON R.event_id = E.id
WHERE E.sport = 'Golf'