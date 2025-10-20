USE springweb2;

DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    dept_id INT,
    salary INT,
    hire_date DATE,
    email VARCHAR(100)
);
-- 부서 테이블 생성
DROP TABLE IF EXISTS department;
CREATE TABLE department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

-- 샘플 데이터
INSERT INTO department VALUES
(1, '개발팀'),
(2, '기획팀'),
(3, '디자인팀');

INSERT INTO employee (name, dept_id, salary, hire_date, email) VALUES
('유재석', 1, 5000, '2023-01-10', 'yu@test.com'),
('강호동', 2, 4000, '2024-02-12', 'kang@test.com'),
('신동엽', 1, 7000, '2022-06-05', 'shin@test.com'),
('이수근', 2, 5500, '2025-03-22', 'lee@test.com'),
('하하', 3, 3500, '2025-04-10', 'haha@test.com'),
('정형돈', 1, 6200, '2023-07-11', 'don@test.com'),
('박명수', 2, 4800, '2023-09-02', 'park@test.com'),
('노홍철', 3, 3700, '2024-05-14', 'noh@test.com'),
('김종국', 1, 8000, '2022-11-01', 'kim@test.com'),
('양세형', 2, 4300, '2024-06-21', 'yang@test.com'),
('이광수', 3, 3900, '2023-12-12', 'kwang@test.com'),
('조세호', 1, 5100, '2023-03-18', 'cho@test.com'),
('김용만', 2, 4600, '2022-09-23', 'yong@test.com'),
('정준하', 3, 3600, '2024-04-04', 'jun@test.com'),
('김태호', 1, 9000, '2021-10-15', 'taeho@test.com'),
('서장훈', 2, 5800, '2024-08-25', 'seo@test.com'),
('전현무', 3, 4000, '2022-12-01', 'jeon@test.com'),
('김구라', 1, 7500, '2023-11-05', 'gura@test.com'),
('유병재', 2, 4200, '2025-01-20', 'yoo@test.com'),
('김민아', 3, 3800, '2024-10-08', 'mina@test.com');


# 인덱스이란 : 데이터를 빠르게 검색하기 위한 색인
# primary key는 기본적인 인덱스를 갖는다. < 테이블1개당 pk1개 권장 >
# 관계형 데이터베이스 구조상 특정한 데이터를 찾을때 검색기준(인덱스)를 미리 지정하면 빠르다.

# [1] primary key 기본적인 인덱스를 갖는다.
select * from employee where id = 1;
# [2] 인덱스 목록 조회
# show index from 테이블명;
show index from employee;
# [3] 단일 컬럼 인덱스 생성
# create index 인덱스명 on 테이블명( 필드명 );
create index idx_name on employee( name ); # 확인 : 3 -> 2
# [4] 쿼리 성능 조회 : select 문 앞에 explain analyze
explain analyze select * from employee where name = '유재석';
# [5] 인덱스 삭제
# drop index 인덱스명 on 테이블명;
drop index idx_name on employee;	# 확인 : 5 -> 2 -> 4 , 3 -> 4
# [6] 복합 인덱스 생성
# create index 인덱스명 on 테이블명( 필드명1 , 필드명2 )
create index idx_salary on employee( dept_id , salary );
# 주의할점 : 첫번째 인덱스에 대해서는 단일 사용 가능하다. 두번째 인덱스부터는 단일 사용 불가능.
explain analyze select * from employee where dept_id = 1;					-- 첫번째 인덱스 가능
explain analyze select * from employee where salary = 7000; 				-- 두번째 인덱스 불가능
explain analyze select * from employee where dept_id = 1 and salary = 7000; -- 같이 인덱스 가능

# [7] JOIN
# JOIN : PK - FK 가 아니더라도 조인 가능하다
# FK 에 인덱스 추가
create index idx_dept on employee( dept_id );
# FK 에 인덱스 추가 후 JOIN 하면 조인 속도가 증가한다. *
select * from employee e inner join department d on e.dept_id = d.dept_id;

# [8] 문자열 검색 : 자연어 NLP(사람이 사용하는 언어 / 변환속도 줄이기 ) VS 기계어(컴퓨터 2진수)
# type이 text, longtext, char , varchar 가능하다.
create fulltext index idx_name_full on employee(name);
select * from employee where MATCH(name) AGAINST( '유재석' ); -- name = '유재석'use springweb2; -- 테이터베이스 선택
                                                                          set SQL_SAFE_UPDATES = 0; -- mysql 워크벤치 에서 update 사용 설정

                                                                          # 트랜잭션 : 여러 작업들을 하나의 묶음으로 간주하여 모두 성공하면 commit , 하나라도 실패이면 rollback
                                                                          set autocommit = 0; -- mysql 워크벤치 에서 자동 commit 비활성화 설정 ( 학습용 )

                                                                          # 1. 트랜잭션 시작
                                                                          start transaction;
                                                                          # 2. 여러 작업 ( DML가능:INSERT/UPDATE/DELETE ) , DDL불가능( ALTER,CREATE,DROP )
                                                                          UPDATE trans SET money = money - 30000 where name = '신동엽'; -- 출금
                                                                          UPDATE trans SET money = money + 30000 where name = '서장훈'; -- 입금
                                                                          # 3. 되돌리기(취소)
                                                                          ROLLBACK;
                                                                          # 4. 완료
                                                                          COMMIT ;
                                                                          # 5. 확인   : (1) 1 -> 2 -> 4(commit) -> 5  (2) 1-> 2 -> 3(rollback) -> 5
                                                                          select * from trans;

                                                                          # [2]
                                                                          # 1. 트랜잭션 시작
                                                                          start transaction;
                                                                          # 2. 여러 작업1
                                                                          update trans set money = money - 30000 where name = '신동엽'; -- 출금
                                                                          # 3. 저장 지점 만들기
                                                                          savepoint pointA; -- 저장지점 저장
                                                                          # 4. 여러 작업2
                                                                          update trans set money = money - 30000 where name = '서장훈'; -- 출금
                                                                          # 5. 완료
                                                                          commit;
                                                                          # 6. 특정한 지점으로 롤백
                                                                          rollback to pointA; -- 저장지점 까지 으로 롤백(이동)
                                                                          # 7. 확인 : (1) 7-1-2-3-4-5-7 : 2/4 적용 (2) 7-1-2-3-4-6(특정롤백)-5-7 : 2번만 적용
                                                                          select * from trans;

                                                                          # TCL( commit , rollback , savepoint )
                                                                          # 1. JAVA SPRING( @Transactional 사용하되 RuntimeException으로 롤백한다. savepoint 지원하지 않는다 )
                                                                          # 2. JAVA JDBC(DAO) 모두 지원

                                                                          # [3]
                                                                          start transaction;
                                                                          # 1.
                                                                          update trans set money = money - 10000 where name = '유재석';
                                                                          savepoint step1;
                                                                          # 2.
                                                                          update trans set money = money - 10000 where name = '서장훈';
                                                                          savepoint step2;
                                                                          # 3.
                                                                          update trans set money = money - 10000 where name = '강호동';
                                                                          savepoint step3;

                                                                          rollback to step1; commit;# (1) 까지 반영
                                                                          rollback to step2; commit;# (1)(2) 까지 반영
                                                                          rollback to step3; commit;# (1)(2)(3) 까지 반영