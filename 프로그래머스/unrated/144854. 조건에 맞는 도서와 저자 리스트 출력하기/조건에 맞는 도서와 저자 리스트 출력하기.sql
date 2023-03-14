SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK as b
JOIN AUTHOR as a ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE CATEGORY = '경제'
ORDER BY PUBLISHED_DATE;




























# SELECT BOOK.BOOK_ID, AUTHOR.AUTHOR_NAME, DATE_FORMAT(BOOK.PUBLISHED_DATE, '%Y-%m-%d')
# FROM BOOK
# JOIN AUTHOR ON BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID
# WHERE BOOK.CATEGORY = '경제'
# ORDER BY BOOK.PUBLISHED_DATE;