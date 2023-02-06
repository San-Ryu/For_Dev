[MSSQL] Oracle의 NVL 기능을 MSSQL에서 써보자!

-- ISNULL(field_name, '원하는 문자, 또는 숫자')
​
WHERE A.PLANT = @PLANT
AND ISNULL(A.CUSTOMER, '') = CASE WHEN LEN(@CUSTOMER) = 0
THEN ISNULL(A.CUSTOMER, '')
ELSE @CUSTOMER
END
-- -> 여기서 @CUSTOMER 값은 NULL일 수도 있고 아닐 수도 있음.