package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInsertTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. JDBC����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC ����̹� �ε� ����");
		} // �ε��Ϸ��� Ŭ���� - import�� �ȵǱ� ������ �� ����� ��

		// 2. �����ͺ��̽� ���� ����
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
			System.out.println("�����ͺ��̽� �ε� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����ͺ��̽� �ε� ����");
		}

		// 3.Statement ��ü ����
		String sql = "insert into student values(?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4. SQL�� ���� - ���������� �ʴ� �̻� �ڵ� commit
		try {
			Scanner sc = new Scanner(System.in);
			String s_id; 
			String s_name; 
			String s_sex;
			
			System.out.println("�й��� �Է��� �ּ��� : ");
			s_id =sc.nextLine(); 
			System.out.println("�̸��� �Է��� �ּ��� : ");
			s_name =sc.nextLine();
			System.out.println("������ �Է��� �ּ��� : ");
			s_sex =sc.nextLine();
			
			pstmt.setString(1, s_id);
			pstmt.setString(2, s_name);
			pstmt.setString(3, s_sex);
			int reuslt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//pstmt.executeQuery();
		

	
	}

}
