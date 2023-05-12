-- https://school.programmers.co.kr/learn/courses/30/lessons/131697
-- 가장 비싼 상품 구하기
SELECT MAX(PRICE) AS MAX_PRICE
FROM PRODUCT;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131115
-- 가격이 제일 비싼 식품의 정보 출력하기
SELECT *
FROM FOOD_PRODUCT
ORDER BY PRICE DESC
    LIMIT 1;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59415
-- 최댓값 구하기
SELECT DATETIME AS '시간'
FROM ANIMAL_INS
ORDER BY DATETIME DESC
    LIMIT 1;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59038
-- 최솟값 구하기
SELECT DATETIME AS '시간'
FROM ANIMAL_INS
ORDER BY DATETIME
    LIMIT 1;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59406
-- 동물 수 구하기
SELECT COUNT(*) AS 'count'
FROM ANIMAL_INS

-- https://school.programmers.co.kr/learn/courses/30/lessons/59408
-- 중복 제거하기
SELECT COUNT(DISTINCT NAME) AS 'count'
FROM ANIMAL_INS;
