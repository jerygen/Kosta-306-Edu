
-- 데이터베이스 접속
USE MYTEST;

SELECT * FROM emp; -- 사원정보
SELECT * FROM dept; -- 부서정보
SELECT * FROM salgrade; -- 급여등급


-- 1. SMITH 에 대한  정보 검색(ename, emp.deptno, loc .)
select ename, emp.deptno, loc
from emp join dept on emp.deptno = dept.deptno
where ename = 'smith';

/* 2. NEW YORK에 근무하는 사원의 이름과 급여를 출력 - 서브쿼리로도 가능하다.
 먼저 dept테이블에서 NEW YORK의 부서번호를 구한다. 그 구한 부서번호를 부서번호로 사용하고 있는 사원의 정보를 검색한다.
*/
select ename, sal
from emp join dept using(deptno) 
where loc = 'new york';

-- 3. ACCOUNTING 부서 소속 사원의 이름과 입사일 출력 - 서브쿼리 가능
select ename, hiredate, dname
from emp join dept using(deptno)
where dname = 'accounting';

-- 4. 직급이 MANAGER인 사원의 이름, 부서명 출력
select ename, dname, job
from emp join dept using(deptno)
where job = 'manager';

-- 5. 사원의 급여가 몇 등급인지를 검색
-- between A and B
select ename, sal, grade
from emp join salgrade 
on sal between losal and hisal;

-- 6. 사원 테이블의 부서 번호로 부서 테이블을 참조해서 부서명, 급여 등급도 검색
select ename, deptno, dname, grade
from emp join dept using(deptno) 
join salgrade on sal between losal and hisal;

SELECT * FROM emp;
SELECT * FROM dept; -- 부서정보
SELECT * FROM salgrade; -- 급여등급


-- 7. SMITH의 메니저(mgr) 이름(ename) 검색
 -- 'SMITH의 관리자는 ~ 입니다.'  - CONCAT함수 이용
select concat(e1.ename, '의 관리자는 ', e2.ename, '입니다.') 매니저이름검색
from emp e1 join emp e2 on e1.mgr = e2.empno
where e1.ename = 'smith';

-- 8. 관리자가 KING인 사원들의 이름과 직급(job) 검색
select e1.ename, e1.job, e2.ename
from emp e1 join emp e2 on e1.MGR = e2.empno
where e2.ename = 'king';  

-- 9. SMITH 와 동일한 부서번호(DEPTNO)에서 근무하는 사원의 이름 출력
-- 단, SMITH 데이터 출력 불가
select e2.ename, e2.deptno
from emp e1 join emp e2 on e1.deptno = e2.deptno
where e1.ename = 'smith' and e2.ename not in ('smith') ;

-- 10. SMITH 와 동일한 근무지(LOC)에서 근무하는 사원의 이름 출력
-- 단, SMITH 데이터  출력 불가
-- 내가 푼 답은 문제의 의도와 조금 다름. 먼저 각 사원들의 근무지를 알아야 하고 그 이후 smith의 근무지와 다른 사원들의 근무지를 비교하는 순으로 가야 함
select e1.ename, e2.ename, loc
from emp e1 join emp e2 using(deptno) 
join dept on e2.deptno = dept.deptno
where e1.ename = 'smith' and  e2.ename != 'smith'; -- self join 에서 using은 사용하지 않는다.
-- ---- 강사님 답 --------
select d1.ename, d1.loc, d2.ename, d2.loc
from 
(select * from emp join dept using(deptno)) d1 
join 
(select * from emp join dept using(deptno)) d2 on d1.loc = d2.loc
where d1.ename = 'smith' and d2.ename != 'smith';

-- 11, 사원명, 해당 하는 메니저명 검색
-- 반드시 모든 사원들(CEO포함) 정보 검색
-- CEO인 경우 메니저 정보 null
select e1.ename 사원명, e2.ename 매니저명
from emp e1 left outer join emp e2 on e1.mgr = e2.empno;



  
  
  
  







