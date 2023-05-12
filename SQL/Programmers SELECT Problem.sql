-- https://school.programmers.co.kr/learn/courses/30/lessons/59034
-- 모든 레코드 조회하기
SELECT *
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/132201
-- 12세 이하인 여자 환자 목록 출력하기
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE AGE <= 12
  AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME

-- https://school.programmers.co.kr/learn/courses/30/lessons/132203
-- 흉부외과 또는 일반외과 의사 목록 출력하기
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD,'%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME;


-- https://school.programmers.co.kr/learn/courses/30/lessons/133024
-- 인기있는 아이스크림
SELECT FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID;


-- https://school.programmers.co.kr/learn/courses/30/lessons/144853
-- 조건에 맞는 도서 리스트 출력하기
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, "%Y-%m-%d") AS PUBLISHED_DATE
FROM BOOK
WHERE CATEGORY = '인문'
          AND YEAR(PUBLISHED_DATE) = '2021';

-- https://school.programmers.co.kr/learn/courses/30/lessons/151136
-- 평균 일일 대여 요금 구하기
SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV'

-- https://school.programmers.co.kr/learn/courses/30/lessons/131535
-- 조건에 맞는 회원수 구하기
SELECT COUNT(USER_ID) AS USERS
FROM USER_INFO
WHERE YEAR(JOINED) = '2021'
  AND AGE BETWEEN 20 AND 29

-- https://school.programmers.co.kr/learn/courses/30/lessons/59405
-- 상위 n개 레코드
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
    LIMIT 1;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59404
-- 여러 기준으로 정렬하기
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME, DATETIME DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59403
-- 동물의 아이디와 이름
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59037
-- 어린 동물 찾기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION <> 'Aged'
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59036
-- 아픈 동물 찾기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'sick'
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59035
-- 역순 정렬하기
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131536
-- 재구매가 일어난 상품과 회원 리스트 구하기
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING count(*) >= 2
ORDER BY USER_ID, PRODUCT_ID DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131120
-- 3월에 태어난 여성 회원 목록 출력하기
SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, "%Y-%m-%d") AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE GENDER = 'W' AND
    MONTH(DATE_OF_BIRTH) = '3' AND
    TLNO IS NOT NULL
ORDER BY MEMBER_ID;원

-- https://school.programmers.co.kr/learn/courses/30/lessons/131112
-- 강원도에 위치한 생산공장 목록 출력하기
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원도%'
ORDER BY FACTORY_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/133025
-- 과일로 만든 아이스크림 고르기
SELECT a.FLAVOR
FROM FIRST_HALF AS a
         LEFT JOIN ICECREAM_INFO AS b
                   ON a.FLAVOR = b.FLAVOR
WHERE TOTAL_ORDER > 3000
  AND INGREDIENT_TYPE = 'fruit_based'
ORDER BY TOTAL_ORDER DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/164673
-- 조건에 부합하는 중고거래 댓글 조회하기
SELECT a.TITLE, a.BOARD_ID, b.REPLY_ID, b.WRITER_ID, b.CONTENTS, DATE_FORMAT(b.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
FROM USED_GOODS_BOARD as a
         JOIN USED_GOODS_REPLY as b
              ON a.BOARD_ID = b.BOARD_ID
    # WHERE YEAR(a.CREATED_DATE) = '2022'
    # AND MONTH(a.CREATED_DATE) = '10'
WHERE DATE_FORMAT(a.CREATED_DATE, '%Y-%m') = '2022-10'
ORDER BY b.CREATED_DATE, a.TITLE;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131118
-- 서울에 위치한 식당 목록 출력하기
SELECT A.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(AVG(REVIEW_SCORE), 2)AS SCORE
FROM REST_INFO as A
         JOIN REST_REVIEW as B
              ON A.REST_ID = B.REST_ID
GROUP BY A.REST_ID
HAVING A.ADDRESS LIKE '서울%'
ORDER BY SCORE DESC, FAVORITES DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131537
-- 오프라인/온라인 판매 데이터 통합하기
(SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
 FROM ONLINE_SALE
 WHERE SALES_DATE LIKE '2022-03%'
 UNION
 SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
 FROM OFFLINE_SALE
 WHERE DATE_FORMAT(SALES_DATE, "%Y-%m") = '2022-03')
    ORDER BY SALES_DATE, PRODUCT_ID, USER_ID
