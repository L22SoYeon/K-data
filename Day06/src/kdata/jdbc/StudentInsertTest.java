package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. JDBC드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		} //로딩하려는 클래스 - import가 안되기 때문에 다 써줘야 함
		

		//2. 데이터베이스 서버 연결
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234"); //thin : express edition은 기본이 thin
			System.out.println("데이터베이스 로드 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("데이터베이스 로드 실패");
		}
		
		
		//3. Statement 객체 생성
		Statement st = null;
		try {
			st =con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //createStatement가 statement 생성해주는 역할 
		

		//4. SQL문 전송 - 설정해주지 않는 이상 자동 commit
		
		
		int result = 0;
		try {
			Scanner sc = new Scanner(System.in);
			String s_id; 
			String s_name; 
			String s_sex;
			
			System.out.println("학번을 입력해 주세요 : ");
			s_id =sc.nextLine(); 
			System.out.println("이름을 입력해 주세요 : ");
			s_name =sc.nextLine();
			System.out.println("성별을 입력해 주세요 : ");
			s_sex =sc.nextLine();
			
			String sql = "insert into student values('" + s_id + "','" + s_name + "','" + s_sex + "')";
			System.out.println(sql);
			result = st.executeUpdate(sql);
			System.out.println(result);
			//st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//5. 결과 처리
		if(result == 0)
			System.out.println("실패");
		else
			System.out.println("성공");
		
		
		//6. 데이터베이스 서버 연결 해제
		try {
			st.close();
			System.out.println("해제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("해제 실패");
		}
		try {
			con.close();
			System.out.println("해제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("해제 실패");
		}
		
	}

}
