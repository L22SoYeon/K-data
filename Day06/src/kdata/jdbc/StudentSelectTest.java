package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentSelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC ����̹� �ε� ����");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("�����ͺ��̽� �ε� ����");

			String sql = "select * from student";
			pstmt = con.prepareStatement(sql);

			// 4.
			rs = pstmt.executeQuery();

			// 5.
			while (rs.next() == true) {
				System.out.println(rs.getString("s_id") + "\t" + rs.getString("s_name") + "\t" + rs.getString("sex"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����ͺ��̽� �ε� ����");
		} finally {
			if(rs!=null)
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