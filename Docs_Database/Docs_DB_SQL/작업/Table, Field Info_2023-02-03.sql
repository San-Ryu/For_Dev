[MSSQL] 테이블 및 필드 존재 여부 확인

--테이블 존재 확인
SELECT * 
FROM sysobjects
WHERE NAME = [테이블명]
​
--있을 경우 테이블 정보 출력
--없을 경우 Empty
​
--필드 존재 확인
SELECT *
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = [테이블명]
AND COLUMN_NAME = [필드명]
​
--있을 경우 필드 정보 출력
--없을 경우 Empty