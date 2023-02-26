SELECT CAR_ID, if(max(END_DATE) >= '2022-10-16', '대여중', '대여 가능') as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE <= '2022-10-16'
group by CAR_ID
order by CAR_ID desc