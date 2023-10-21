-- https://school.programmers.co.kr/learn/courses/30/lessons/59047
-- 이름에 el이 들어가는 동물 찾기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog'
AND NAME LIKE '%el%'
ORDER BY NAME;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59414
-- DATETIME에서 DATE로 형 변환
SELECT ANIMAL_ID, NAME, date_format(DATETIME, '%Y-%m-%d') AS '날짜'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59043
-- 있었는데요 없었습니다
SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS AS I
JOIN ANIMAL_OUTS AS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.DATETIME > O.DATETIME
ORDER BY I.DATETIME;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59411
-- 오랜 기간 보호한 동물(2)
SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS AS I
JOIN ANIMAL_OUTS AS O
ON I.ANIMAL_ID = O.ANIMAL_ID
ORDER BY (O.DATETIME - I.DATETIME) DESC
LIMIT 2;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59045
-- 보호소에서 중성화한 동물
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS AS I
JOIN ANIMAL_OUTS AS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.SEX_UPON_INTAKE != O.SEX_UPON_OUTCOME
ORDER BY I.ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/132204
-- 취소되지 않은 진료 예약 조회하기
SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, D.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM APPOINTMENT AS A
LEFT JOIN DOCTOR AS D
ON A.MDDR_ID = D.DR_ID
LEFT JOIN PATIENT AS P
ON A.PT_NO = P.PT_NO
WHERE A.MCDP_CD = 'CS'
AND A.APNT_YMD LIKE '2022-04-13%'
AND A.APNT_CNCL_YN = 'N'
ORDER BY A.APNT_YMD;

-- https://school.programmers.co.kr/learn/courses/30/lessons/62284
-- 우유와 요거트가 담긴 장바구니
SELECT C1.CART_ID
FROM CART_PRODUCTS AS C1
JOIN CART_PRODUCTS AS C2
ON C1.CART_ID = C2.CART_ID
WHERE C1.NAME = 'Yogurt'
AND C2.NAME = 'Milk'
ORDER BY C1.CART_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/151141
-- 자동차 대여 기록 별 대여 금액 구하기
SELECT HISTORY_ID, ROUND(SUM(C.DAILY_FEE * (DATEDIFF(END_DATE, START_DATE) + 1) * (1 - IFNULL(DISCOUNT_RATE, 0)/100)), 0) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS R
LEFT JOIN CAR_RENTAL_COMPANY_CAR AS C
ON C.CAR_ID = R.CAR_ID
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS D
ON C.CAR_TYPE = D.CAR_TYPE
AND D.DURATION_TYPE = (
    CASE
    WHEN DATEDIFF(R.END_DATE, R.START_DATE) + 1 BETWEEN 7 AND 29 THEN "7일 이상"
    WHEN DATEDIFF(R.END_DATE, R.START_DATE) + 1 BETWEEN 30 AND 89 THEN "30일 이상"
    WHEN DATEDIFF(R.END_DATE, R.START_DATE) + 1 >= 90 THEN "90일 이상"
    ELSE "" END
)
WHERE C.CAR_TYPE="트럭"
GROUP BY HISTORY_ID
ORDER BY FEE DESC, R.HISTORY_ID DESC