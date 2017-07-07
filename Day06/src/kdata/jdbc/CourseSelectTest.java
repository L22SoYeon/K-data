package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseSelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("데이터베이스 로드 성공");

			String sql = "select s.s_id, s.s_name, sj.sj_name, c.grade from student s, subject sj, course c WHERE s.s_id = c.s_id AND c.sj_id = sj.sj_id";
			pstmt = con.prepareStatement(sql);

			// 4.
			rs = pstmt.executeQuery();

			// 5.
			while (rs.next() == true) {
				System.out.println(rs.getString("s_id") + "\t" + rs.getString("s_name") + "\t" + rs.getString("sj_name")
						+ "\t" + rs.getInt("grade"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("데이터베이스 로드 실패");
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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