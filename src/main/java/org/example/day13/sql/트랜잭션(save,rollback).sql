use springweb2; -- 데이터베이스 선택
set SQL_SAFE_UPDATES = 0; -- mysql 워크벤치 에서 update 사용 설정

# 트랜잭션 : 여러 작업들을 하나의 묶음으로 간주하여 모두 성공하면 commit , 하나라도 실패하면 rollback
set autocommit = 0; -- mysql 워크벤치 에서 자동 commit 비활성화 설정 ( 학습용 )

# 1. 트랜잭션 시작 
start transaction;
# 2. 여러 작업 ( DML : INSERT/DELETE/UPDATE ) , DDL 불가능( ALTER,CREATE,DROP )
UPDATE trans SET money = money - 30000 where name = '신동엽' ; -- 출금
update trans SET money = money + 30000 where name = '서장훈' ; -- 입금
# 3. 되돌리기(취소)
ROLLBACK;
# 3. 완료
COMMIT;
# 4. 확인 : (1) 1 -> 2 -> 4(commit) -> 5 (2) 1->  2 -> 3(rollback) -> 5
select * from trans;

# [2] 
# 1. 트랜잭션 시작
start transaction; -- 트랜잭션 시작
# 2. 여러작업 1
update trans set money = money - 30000 where name = '신동엽'; -- 출금
# 3. 저장지점만들기
savepoint pointA; -- 저장지점 
# 4. 여러 작업2
update trans set money = money - 30000 where name = '서장훈'; -- 출금
# 5. 완료
commit;
# 6. 특정한 지점을 롤백
ROLLBACK TO pointA; -- 저장시점 까지 으로 롤백(이동)
# 7. 확인 : (1) 7-1-2-3-4-5-7 : 2/4(적용) (2)  7-1-2-3-4-6(특정롤백)-5-7 : 2번만 적용
select * from trans;

# DDL DML DCL(권한부여) TCL(트랜잭션)
# TCL( commit , rollback , savepoint )
# 1. JAVA SPRING( @Transactional  사용하되 ReutimeException으로 롤백한다. savepoint 지원하지 않는다. )
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
update trans set money = money - 10000 where name = '서장훈';
savepoint step3;


rollback to step1; commit; # (1) 까지 반영
rollback to step2; commit; # (1) (2) 까지 반영
rollback to step3; commit; # (1)(2)(3) 까지 반영

