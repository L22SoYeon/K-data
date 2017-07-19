package kdata.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kdata.project.dto.User;
import kdata.project.util.DBUtil;

public class UserDAO {

	// �̱��� ����---------------------------------
	private static UserDAO dao = new UserDAO();

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		return dao;
	}
	// --------------------------------------------

	// �ߺ�üũ
	public int idcheck(String id) {
		System.out.println("3. UserDAO idcheck()");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from users where id=?";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			// ���Ұ��� - �ߺ�
			if (rs.next()) {
				return 0;
			}
			// ��밡��
			else {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtil.close(pstmt, con, rs);
		}
	}

	// ȸ������
	public int insert(User user) {
		System.out.println("3. UserDAO insert()");

		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "insert into users values(?, ?, ?, ?, default)";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getProfile());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		return result;

	}

	// ȸ������Ʈ
	public List<User> selectAll() {
		System.out.println("3. UserDAO selectAll()");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<>();
		int result = 0;

		String sql = "select * from users order by id";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setProfile(rs.getString("profile"));
				user.setRegDate(rs.getDate("reg_date"));

				list.add(user);
			}

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con, rs);
		}
		return list;
	}

	// ȸ��������
	public User selectById(String id) {
		System.out.println("3. UserDAO selectById()");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		User user = new User();

		String sql = "select * from users where id=?";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setProfile(rs.getString("profile"));
				user.setRegDate(rs.getDate("reg_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con, rs);
		}
		return user;
	}

	// �α���
	public void login() {

	}

	// ȸ������ ����
	public void deleteById() {

	}

}
