[MSSQL] 테이블명, 컬럼명 검색

--테이블명 검색
SELECT *
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_NAME = '테이블명'

--컬럼명 검색
SELECT * 
FROM information_schema.COLUMNS
WHERE COLUMN_NAME = '컬럼명'

​--PK 검색
SELECT * 
FROM information_schema.KEY_COLUMN_USAGE