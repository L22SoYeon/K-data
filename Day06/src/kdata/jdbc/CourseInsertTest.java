package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CourseInsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// try, catch, finally - null���� �ƴ��� ���ϰ� finally�� close

		// 1. JDBC����̹� �ε�
		// 2. �����ͺ��̽� ���� ����]
		// 3. Statement ��ü ����
		// 4. SQL�� ���� - ���������� �ʴ� �̻� �ڵ� commit
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into course values(?, ?, ?, default)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC ����̹� �ε� ����");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("�����ͺ��̽� �ε� ����");

			pstmt = con.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);
			String s_id;
			String sj_id;
			int grade;

			System.out.println("�й��� �Է��� �ּ��� : ");
			s_id = sc.nextLine();
			System.out.println("������ �Է��� �ּ��� : ");
			sj_id = sc.nextLine();
			System.out.println("������ �Է��� �ּ��� : ");
			grade = sc.nextInt();

			pstmt.setString(1, s_id);
			pstmt.setString(2, sj_id);
			pstmt.setInt(3, grade);

			int reuslt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����ͺ��̽� �ε� ����");
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
