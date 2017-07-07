package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CourseInsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// try, catch, finally - null인지 아닌지 비교하고 finally에 close

		// 1. JDBC드라이버 로드
		// 2. 데이터베이스 서버 연결]
		// 3. Statement 객체 생성
		// 4. SQL문 전송 - 설정해주지 않는 이상 자동 commit
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into course values(?, ?, ?, default)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("데이터베이스 로드 성공");

			pstmt = con.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);
			String s_id;
			String sj_id;
			int grade;

			System.out.println("학번을 입력해 주세요 : ");
			s_id = sc.nextLine();
			System.out.println("과목을 입력해 주세요 : ");
			sj_id = sc.nextLine();
			System.out.println("점수를 입력해 주세요 : ");
			grade = sc.nextInt();

			pstmt.setString(1, s_id);
			pstmt.setString(2, sj_id);
			pstmt.setInt(3, grade);

			int reuslt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("데이터베이스 로드 실패");
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

	}

}
