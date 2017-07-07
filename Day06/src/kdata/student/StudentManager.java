package kdata.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManager {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Scanner sc = new Scanner(System.in);

	public StudentManager() {
		// 1. JDBC드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 데이터베이스 서버 연결

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "test", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ---------------------------------------------------add-----
	public void add(Student s) {
		String sql = "insert into student values(?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			pstmt.setString(1, s.getS_id());
			pstmt.setString(2, s.getS_name());
			pstmt.setString(3, s.getS_sex());
			int reuslt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void print() {
		String sql = "select * from student order by s_name";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("s_id") + "\t" + rs.getString("s_name") + "\t" + rs.getString("sex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void search() {
		String s_name;

		System.out.println("검색할 이름을 입력해 주세요 : ");
		s_name = sc.nextLine();
		
		String sql = "select * from student where s_name = '"+ s_name + "'";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next() == true) {
				System.out.println(rs.getString("s_id") + "\t" + rs.getString("s_name") + "\t" + rs.getString("sex"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}