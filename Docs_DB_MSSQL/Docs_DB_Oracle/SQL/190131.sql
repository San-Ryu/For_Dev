--> CROSS JOIN
SELECT EMP.ename, DEPT.dname
FROM EMP CROSS JOIN DEPT;

--> NATURAL JOIN 1

SELECT * FROM EMP, DEPT, LOCATIONS
WHERE EMP.DEPTNO = DEPT.DEPTNO
AND DEPT.LOC_CODE = LOCATIONS.LOC_CODE
AND DEPT.LOC_CODE != 'A1'
GROUP BY DEPT.LOC_CODE
HAVING COUNT(*) >= 3 
ORDER BY COUNT(*) desc;

SELECT ENAME, JOB
FROM emp
UNION ALL
SELECT NAME, TITLE
FROM EMP_HISTORY;

SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM LOCATIONS;
SELECT * FROM SALGRADE;

SELECT LOCATIONS.LOC_CODE, LOCATIONS.CITY, EMP.ENAME
FROM EMP, DEPT, LOCATIONS
WHERE EMP.deptno = DEPT.deptno
AND DEPT.loc_code = LOCATIONS.loc_code;

--> JOIN 실습인데, 해당 계층 구조 한번 살펴볼 것
SELECT EMP1.ENAME, EMP2.ENAME
FROM EMP EMP1, EMP EMP2
WHERE EMP1.MGR = EMP2.EMPNO
ORDER BY EMP2.ENAME;

SELECT EMP.ENAME, EMP.SAL, DEPT.LOC_CODE
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
AND EMP.SAL >= 3000;

SELECT ename
from emp
where empno in (select mgr
                from emp);
                
select ename
from emp a
where exists (select 1 
             from emp 
             where a.empno = mgr);

select ename
from emp
where empno not in (select mgr 
                    from emp
                    where mgr is not null);

select a.job, count(*)
from emp a
group by a.job
having count(*) = (select max(count(*)) 
                   from emp b
                   group by b.job);







