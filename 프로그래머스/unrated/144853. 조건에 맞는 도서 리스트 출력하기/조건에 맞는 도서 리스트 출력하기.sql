SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') 
  FROM BOOK
 WHERE CATEGORY = '인문' AND YEAR(PUBLISHED_DATE) = '2021'
ORDER BY BOOK_ID;