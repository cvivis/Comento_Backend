# 통계 API 구축 SQL 작성 ( Group by, union, substr, case when then 구문 사용 ) 접속일자와 회원 아이디가 있는 TEMP 테이블이라는 기준. (예시)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cdc87706-36ca-47d1-ab0a-24d90d267519/Untitled.png)

1. 월별접속자수  - 접속기록을 월별로 카운트. 
    
    ```sql
    SELECT MONTH(DT) as m, count(ID) FROM TEMP GROUP BY m  
    ```
    
2. 일자별접속자수 - 접속기록을 일별로 카운트.
    
    ```sql
    SELECT DATE(DT) as date, count(ID) FROM TEMP GROUP BY date
    ```
    
3. 평균 하루 로그인 수 - 월별접속자수 / 총일수 
    
    ```sql
    SELECT DATE(DT) AS date ,AVG(ID) as avg FROM TEMP GROUP BY date
    ```
    
4. 휴일을제외한로그인  수- (전체 날짜의 테이블(TEMP)) - 휴일 날짜 테이블 (HOLIDAY)
    
    → 휴일을 제외한  일자별 로그인 수 
    
    ```sql
    CREATE TABLE NOHOLIDAY AS SELECT *FROM TEMP;
    DELETE FROM NOHOLIDAY WHERE TEMP.DT = HOLIDAT.DT; 
    SELECT DATE(DT) AS date, count(ID) FROM NOHOLIDAY GROUP BY date;
    ```
    
5. 부서별월별로그인수 - 부서별(department) 접속기록을 월별로 카운트
    
    ```sql
    SELECT DATE(DT) as date,department, count(ID) FROM TEMP GROUP BY date
    , GROUP BY department
    ```
