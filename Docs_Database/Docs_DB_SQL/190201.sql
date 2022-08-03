SELECT DEPTNO, ENAME, SAL, COMM,
       ROW_NUMBER() OVER(PARTITION BY DEPTNO
                         ORDER BY SAL DESC) RK1,
       RANK() OVER(PARTITION BY DEPTNO
                   ORDER BY SAL DESC) RK2,
       DENSE_RANK() OVER(PARTITION BY DEPTNO
                         ORDER BY SAL DESC) DK3,
       DENSE_RANK() OVER(ORDER BY COMM DESC NULLS LAST) RK4
FROM EMP;       

SELECT RANK(2500) WITHIN GROUP(ORDER BY SAL DESC) RK1,
       DENSE_RANK(3000) WITHIN GROUP(ORDER BY SAL DESC) RK2
FROM EMP;

-- �Ϲ� �׷� �Լ� : AVG
SELECT MGR, ENAME, HIREDATE, SAL,
       AVG(SAL) OVER(PARTITION BY MGR ORDER BY HIREDATE 
                     ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING) AS C_MAVG
FROM EMP;        

--> Lock Test
-- [SESSION 1]
CREATE TABLE LOCK_TEST
            (EMPNO CHAR(5) PRIMARY KEY,
             ENAME VARCHAR2(50),
             JOB VARCHAR2(20));

INSERT INTO LOCK_TEST
            VALUES('9999', 'KIMTH', 'SALESMAN');

-- [SESSION 2]
INSERT INTO LOCK_TEST
            VALUES('9999', 'KIMTH', 'SALESMAN');

-- [SESSION 1]
COMMIT;

-- [SESSION 2] �������� ���� -> ������ �ߺ�

--> Dead Lock Test ��������
-- [SESSION 1]
UPDATE EMP SET SAL = SAL * 1.1 WHERE EMPNO = 7788;

-- [SESSION 2]
UPDATE EMP SET SAL = SAL * 1.1 WHERE EMPNO = 7934;

-- [SESSION 1]
UPDATE EMP SET SAL = SAL * 1.1 WHERE EMPNO = 7934;
--> Waiting

-- [SESSION 2]
UPDATE EMP SET SAL = SAL * 1.1 WHERE EMPNO = 7788;
--> Dead Lock Waiting

-- [SESSION 1]
ROLLBACK;

-- DeadLock ��Ȳ�� �ý����� �ŷڼ��� ����߸��� ����̳� ������ DB ��ü������ �ذ���� ������ ���� ����
-- ö�� ���� �Ǵ� �ܼ�Ʈ Ƽ�� ��... ��κ��� �����ڴ� �� �� ��ũ��...

-- �ε��� �ɷ��ִ� �͸� ����
SELECT * 
FROM USER_INDEXES 
WHERE TABLE_NAME = 'EMP';

-- �ε����� � Į���� �޷��ִ���
SELECT * 
FROM USER_IND_COLUMNS
WHERE TABLE_NAME = 'EMP';







