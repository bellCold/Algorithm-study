SELECT hour(DATETIME), COUNT(*)
FROM ANIMAL_OUTS
WHERE hour(DATETIME) between 9 and 20
GROUP BY hour(DATETIME)
ORDER BY hour(DATETIME);