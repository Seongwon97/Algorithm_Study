-- https://school.programmers.co.kr/learn/courses/30/lessons/133026
-- 성분으로 구분한 아이스크림 총 주문량
SELECT INGREDIENT_TYPE, SUM(f.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF AS f
         JOIN ICECREAM_INFO AS i
              ON f.FLAVOR = i.FLAVOR
GROUP BY i.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER;

-- https://school.programmers.co.kr/learn/courses/30/lessons/157340
-- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
SELECT CAR_ID,
       (CASE WHEN CAR_ID IN (
           SELECT CAR_ID
           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
           WHERE '2022-10-16' BETWEEN DATE_FORMAT(START_DATE, '%Y-%m-%d') AND DATE_FORMAT(END_DATE, '%Y-%m-%d'))
                 THEN '대여중'
             ELSE '대여 가능'
           END) AS 'AVAILABILITY'
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131116
-- 식품분류별 가장 비싼 식품의 정보 조회하기
SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN
      (SELECT CATEGORY, MAX(PRICE)
       FROM FOOD_PRODUCT
       GROUP BY CATEGORY)
  AND CATEGORY IN ("과자", "국", "김치", "식용유")
ORDER BY MAX_PRICE DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/144856
-- 저자 별 카테고리 별 매출액 집계하기
SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(BS.SALES * B.PRICE) AS TOTAL_SALES
FROM BOOK AS B
         JOIN AUTHOR AS A
              ON B.AUTHOR_ID = A.AUTHOR_ID
         JOIN BOOK_SALES AS BS
              ON B.BOOK_ID = BS.BOOK_ID
WHERE DATE_FORMAT(BS.SALES_DATE, "%Y-%m") = "2022-01"
GROUP BY AUTHOR_ID, CATEGORY
ORDER BY A.AUTHOR_ID, B.CATEGORY DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/151137
-- 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%가죽시트%' OR OPTIONS LIKE '%열선시트%' OR OPTIONS LIKE '%통풍시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE;

-- https://school.programmers.co.kr/learn/courses/30/lessons/132202
-- 진료과별 총 예약 횟수 출력하기
SELECT MCDP_CD AS '진료과 코드', COUNT(MCDP_CD) AS '5월예약건수'
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, "%Y-%m") = '2022-05'
GROUP BY MCDP_CD
ORDER BY COUNT(MCDP_CD), MCDP_CD;

-- https://school.programmers.co.kr/learn/courses/30/lessons/151139
-- 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE (DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10')
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
    ) AND (DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10')
GROUP BY MONTH, CAR_ID
HAVING RECORDS > 0
ORDER BY MONTH, CAR_ID DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131123
-- 즐겨찾기가 가장 많은 식당 정보 출력하기
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN (
    SELECT FOOD_TYPE, MAX(FAVORITES)
    FROM REST_INFO
    GROUP BY FOOD_TYPE)
ORDER BY FOOD_TYPE DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/164668
-- 조건에 맞는 사용자와 총 거래금액 조회하기
SELECT USER_ID, NICKNAME, SUM(PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD AS B
         JOIN USED_GOODS_USER AS U
              ON B.WRITER_ID = U.USER_ID
WHERE B.STATUS = 'DONE'
GROUP BY B.WRITER_ID
HAVING SUM(PRICE) >= 700000
ORDER BY TOTAL_SALES;

-- https://school.programmers.co.kr/learn/courses/30/lessons/144855
-- 카테고리 별 도서 판매량 집계하기
SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM BOOK AS B
         JOIN BOOK_SALES AS S
              ON B.BOOK_ID = S.BOOK_ID
WHERE SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY CATEGORY
ORDER BY CATEGORY;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59040
-- 고양이와 개는 몇 마리 있을까
SELECT ANIMAL_TYPE, COUNT(*) AS 'count'
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59041
-- 동명 동물 수 찾기
SELECT NAME, COUNT(ANIMAL_ID) AS 'COUNT'
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING COUNT(ANIMAL_ID) >= 2
ORDER BY NAME;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59412
-- 입양 시각 구하기(1)
SELECT HOUR(DATETIME) AS 'HOUR', COUNT(ANIMAL_ID) AS 'COUNT'
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) BETWEEN 9 AND 19
GROUP BY HOUR(DATETIME)
ORDER BY HOUR;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59413
-- 입양 시각 구하기(2)
SET @HOUR = -1;
SELECT (@HOUR := @HOUR +1) AS HOUR,
    (SELECT COUNT(HOUR(DATETIME))
    FROM ANIMAL_OUTS
    WHERE HOUR(DATETIME)=@HOUR) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR < 23;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131530
-- 가격대 별 상품 개수 구하기
SELECT (
           CASE WHEN PRICE < 10000 THEN 0
                ELSE TRUNCATE(PRICE, -4)
               END) AS PRICE_GROUP, COUNT(PRODUCT_ID) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP

-- https://school.programmers.co.kr/learn/courses/30/lessons/131532
-- 년, 월, 성별 별 상품 구매 회원 수 구하기
SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, GENDER, COUNT(DISTINCT U.USER_ID) AS USERS
FROM USER_INFO AS U
    JOIN ONLINE_SALE AS O
ON U.USER_ID = O.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER
ORDER BY YEAR, MONTH, GENDER;
