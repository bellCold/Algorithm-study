SELECT outs.ANIMAL_ID, outs.ANIMAL_TYPE, outs.NAME
FROM ANIMAL_OUTS outs
JOIN ANIMAL_INS ins ON outs.ANIMAL_ID = ins.ANIMAL_ID
WHERE ins.SEX_UPON_INTAKE != outs.SEX_UPON_OUTCOME
ORDER BY ANIMAL_ID;