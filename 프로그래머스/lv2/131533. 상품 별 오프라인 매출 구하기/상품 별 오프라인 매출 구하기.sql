SELECT PRODUCT_CODE, PRICE * SUM(SALES_AMOUNT) as SALES
FROM PRODUCT as p
JOIN OFFLINE_SALE as o
ON p.PRODUCT_ID = o.PRODUCT_ID
GROUP BY p.PRODUCT_ID
ORDER BY SALES DESC, PRODUCT_CODE;













# SELECT p.PRODUCT_CODE, SUM(p.PRICE * o.SALES_AMOUNT) as SALES
# FROM PRODUCT p
# JOIN OFFLINE_SALE o ON p.PRODUCT_ID = o.PRODUCT_ID
# GROUP BY p.PRODUCT_CODE
# ORDER BY SALES DESC, p.PRODUCT_CODE;