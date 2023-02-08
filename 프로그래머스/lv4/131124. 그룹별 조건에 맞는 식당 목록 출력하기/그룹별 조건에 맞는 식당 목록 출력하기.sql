SELECT pro.MEMBER_NAME, review.REVIEW_TEXT, DATE_FORMAT(review.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
FROM MEMBER_PROFILE pro
JOIN REST_REVIEW review ON pro.MEMBER_ID = review.MEMBER_ID
WHERE pro.MEMBER_ID = (SELECT MEMBER_ID
                      FROM REST_REVIEW
                      GROUP BY MEMBER_ID
                      ORDER BY COUNT(*) DESC
                      LIMIT 1)
ORDER BY review.REVIEW_DATE, review.REVIEW_TEXT;