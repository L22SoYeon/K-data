package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CourseManager {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int result = 0;

	// ---------- 수강 신청
	public int courseInsert(Course c) {
		con = DBUtil.getConnection();

		String sql = "insert into course values(?,?,0, default)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, c.getsId());
			pstmt.setString(2, c.getSjId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		return result;
	}

	// ---------- 수강 취소
	public int courseDelete(Course c) {
		con = DBUtil.getConnection();

		String sql = "delete course where s_id='" + c.getsId() + "'and sj_id='" + c.getSjId() + "'";

		try {
			pstmt = con.prepareStatement(sql);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		return result;
	}

	// ---------- 수강 신청 목록
	public List<Course> courseList() {
		con = DBUtil.getConnection();

		List<Course> list = new ArrayList<>();

		String sql = "SELECT s.s_id, s.s_name, sj.sj_name, c.grade, c_day " + "FROM student s, subject sj, course c"
				+ " WHERE s.s_id = c.s_id AND c.sj_id = sj.sj_id";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Course c = new Course(rs.getString("s_id"), rs.getString("s_name"), rs.getString("sj_name"),
						rs.getInt("grade"), rs.getDate("c_day"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con, rs);
		}
		return list;
	}

	// ---------- 성적 입력
	public int courseScoreInsert(Course c) {
		con = DBUtil.getConnection();

		String sql = "update course set grade = ? where trim(s_id) = ? and trim(sj_id) = ?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, c.getGrade());
			pstmt.setString(2, c.getsId());
			pstmt.setString(3, c.getSjId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.close(pstmt, con);
		}
		return result;
	}

	// ---------- 과목 평균
	public Map<String, Integer> courseAverage() {
		con = DBUtil.getConnection();

		Map<String, Integer> map = new HashMap<>();

		String sql = "SELECT sj.sj_name, AVG(grade)" + " FROM course c, subject sj" + " WHERE sj.sj_id = c.sj_id"
				+ " GROUP BY sj.sj_name";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				map.put(rs.getString("sj_name"), rs.getInt("AVG(grade)"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con, rs);
		}
		return map;
	}
}
