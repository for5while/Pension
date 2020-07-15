## 🔧 겪었던 문제들과 해결 방법
#### Spring Security

> 문제 1. 서버 구동 시 security-context 스키마의 네임 스페이스를 읽지 못하였고, servlet-context가 정상적으로 로딩되지 못하였음<br>
> 해결 1. pom.xml에서 Spring security의 Maven 의존 객체가 Spring framework 다음으로 로딩되도록 순서 변경 후 Maven Update<br>
> 
> 문제 2. 로그인을 시도하면 지속해서 Failur URL로 이동함<br>
> 해결 2. Handler를 추가해서 Exception 로그 확인 후 MySQL 버전이 달라 DB에 접근하지 못하였던 것을 확인 후 MySQL 다운그레이드<br>
> 

#### Reservation System

> 문제 1. 서비스단에서 반복문 작업 중 DB 쿼리문의 행이 1개 이상 나오지않아 NullPointerException 발생<br>
> 해결 1. DAO를 리턴 받는 자료형을 프로미티브 타입에서 Wrapper 클래스 타입으로 변경하여 NULL 후행 처리<br>
