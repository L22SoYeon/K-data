package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int result = 0;

	// ---------- 학생 정보 추가
	public int insert(Student s) {
		con = DBUtil.getConnection();

		String sql = "insert into student values(?, ?, ?)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, s.getsId());
			pstmt.setString(2, s.getsName());
			pstmt.setString(3, s.getSex());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		return result;
	}

	// ---------- 학생 정보 출력
	public List<Student> selectAll() {
		con = DBUtil.getConnection();
		
		List<Student> list = new ArrayList<>();

		String sql = "select * from student";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Student s = new Student(rs.getString("s_id"), rs.getString("s_name"), rs.getString("sex"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		return list;
	}

	// ---------- 학생 정보 검색
	public Student selectByName(String sName) {
		con = DBUtil.getConnection();
		
		List<Student> list = new ArrayList<>();
		Student s = null;

		String sql = "select * from student where s_name ='" + sName + "'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				s = new Student(rs.getString("s_id"), rs.getString("s_name"), rs.getString("sex"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con, rs);
		}
		return s;
	}

}
