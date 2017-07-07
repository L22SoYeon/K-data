package kdata.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB ���� ���� �����ϴ� Ŭ���� connection ����, ����
 * 
 * @author cse
 */

public class DBUtil {
	private static final String CON_URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USER_NAME = "test";
	private static final String USER_PWD = "1234";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	static { // Ŭ���� �ε� �� �� �ѹ��� �����
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����ͺ��̽� ���� �����ϴ� �޼ҵ�
	 * 
	 * @return Connection ������ ���̽� ���� ���� ��ü ��ȯ
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CON_URL, USER_NAME, USER_PWD);
	}

	/**
	 * ������ ���̽� ����� ����� �ڿ� ����
	 * 
	 * @param
	 * @return
	 */

	public static void close(PreparedStatement pstmt, Connection con) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		if (con != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

	public static void close(PreparedStatement pstmt, Connection con, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		if (con != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

}
