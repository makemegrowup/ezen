package ksh.member.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

public class Context {

	public BasicDataSource basicDataSource;
	// 커넥션 풀 정보 저장할 인스턴스 변수 선언
	public Context() { // 커넥션풀 초기화 작업 생성자
		basicDataSource = new BasicDataSource();
		// 커넥션 풀 정보 저장하는 인스턴스 변수 초기화
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		// JDBC 드라이버 연결
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		// JDBC 드라이버 사용하여 접속할 URL 설정
		basicDataSource.setUsername("scott");
		// DB계정 설정
		basicDataSource.setPassword("tiger");
		// 계정 비밀번호 입력
		basicDataSource.setInitialSize(4);
		// 커넥션 풀 커넥션 초기값 4개
		basicDataSource.setMaxIdle(1000);
		// 커넥션 풀 최대 커넥션 1000개
		basicDataSource.setMinIdle(5);
		// 커넥션 풀 최소 커넥션 유지 개수 5개
	}
}
