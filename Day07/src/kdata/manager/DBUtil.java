package kdata.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB 서버 연결 관리하는 클래스 connection 생성, 종료
 * 
 * @author cse
 */

public class DBUtil {
	private static final String CON_URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USER_NAME = "test";
	private static final String USER_PWD = "1234";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	static { // 클래스 로드 할 때 한번만 실행됨
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 데이터베이스 서버 연결하는 메소드
	 * 
	 * @return Connection 데이터 베이스 연결 정보 객체 반환
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CON_URL, USER_NAME, USER_PWD);
	}

	/**
	 * 데이터 베이스 연결시 사용한 자원 해제
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
