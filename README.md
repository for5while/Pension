* 스프링 시큐리티

문제: 서버 구동 시 security-context 스키마의 네임 스페이스를 읽지 못하였고 servlet-context가 정상적으로 로딩되지 못하였음
문제 원인/해결: pom.xml에서 Spring security의 Maven 의존 객체가 Spring framework 다음으로 로딩되도록 순서 변경 후 Maven Update로 해결

문제: 로그인을 시도하면 계속 error 파라미터만 받아냄
문제 원인/해결: Handler를 추가해서 Exception 로그 확인 후 MySQL 작업 환경/버전이 달라 DB에 접근하지 못하였던 것을 확인하고 MySQL 다운그레이드로 해결
