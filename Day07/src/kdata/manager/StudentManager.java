package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
	// 학생 정보 추가
	public int insert(Student s) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result;
		try {
			// 2.
			con = DBUtil.getConnection();

			// 3. 4.
			String sql = "insert into student values(?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, s.getsId());
			pstmt.setString(2, s.getsName());
			pstmt.setString(3, s.getSex());

			// 5.
			result = pstmt.executeUpdate();
		} finally {
			// 6.
			DBUtil.close(pstmt, con);

		}
		return result;
	}

	// 학생 리스트 출력
	public List<Student> selectAll() throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Student> list = new ArrayList<>();
		try {

			con = DBUtil.getConnection();
			String sql = "select * from student";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Student s = new Student(rs.getString("s_id"), rs.getString("s_name"), rs.getString("sex"));

				// System.out.println(s.toString());
				list.add(s);
			}

		} finally {

			DBUtil.close(pstmt, con, rs);

		}
		return list;

	}

	// 학생 정보 검색
	public Student selectByName(String sName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student s = null;

		List<Student> list = new ArrayList<>();
		try {

			con = DBUtil.getConnection();
			String sql = "select * from student where s_name ='" + sName + "'";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				s = new Student(rs.getString("s_id"), rs.getString("s_name"), rs.getString("sex"));

				list.add(s);

			}
			DBUtil.close(pstmt, con, rs);
			return s;
		} catch (SQLException e) {
			DBUtil.close(pstmt, con, rs);
			return null;
		}

	}

}
