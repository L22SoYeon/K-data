package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. JDBC����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC ����̹� �ε� ����");
		} //�ε��Ϸ��� Ŭ���� - import�� �ȵǱ� ������ �� ����� ��
		

		//2. �����ͺ��̽� ���� ����
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234"); //thin : express edition�� �⺻�� thin
			System.out.println("�����ͺ��̽� �ε� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����ͺ��̽� �ε� ����");
		}
		
		
		//3. Statement ��ü ����
		Statement st = null;
		try {
			st =con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //createStatement�� statement �������ִ� ���� 
		

		//4. SQL�� ���� - ���������� �ʴ� �̻� �ڵ� commit
		
		
		int result = 0;
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
			
			String sql = "insert into student values('" + s_id + "','" + s_name + "','" + s_sex + "')";
			System.out.println(sql);
			result = st.executeUpdate(sql);
			System.out.println(result);
			//st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//5. ��� ó��
		if(result == 0)
			System.out.println("����");
		else
			System.out.println("����");
		
		
		//6. �����ͺ��̽� ���� ���� ����
		try {
			st.close();
			System.out.println("����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���� ����");
		}
		try {
			con.close();
			System.out.println("����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���� ����");
		}
		
	}

}
