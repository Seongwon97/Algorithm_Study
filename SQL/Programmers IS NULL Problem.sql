-- https://school.programmers.co.kr/learn/courses/30/lessons/131114
-- 경기도에 위치한 식품창고 목록 출력하기
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IFNULL(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE "경기도%";

-- https://school.programmers.co.kr/learn/courses/30/lessons/59039
-- 이름이 없는 동물의 아이디
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59407
-- 이름이 있는 동물의 아이디
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59410
-- NULL 처리하기
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131528
-- 나이 정보가 없는 회원 수 구하기
SELECT COUNT(USER_ID) AS USERS
FROM USER_INFO
WHERE AGE IS NULL
