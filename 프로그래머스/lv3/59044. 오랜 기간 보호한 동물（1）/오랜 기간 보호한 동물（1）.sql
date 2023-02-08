SELECT ins.NAME, ins.DATETIME
FROM ANIMAL_INS ins
LEFT JOIN ANIMAL_OUTS outs ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE outs.ANIMAL_ID is null
ORDER BY ins.DATETIME
LIMIT 3;