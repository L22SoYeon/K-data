package fithy.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fithy.project.dto.Facility;
import fithy.project.dto.User;
import fithy.project.util.DBUtil;

public class UserDAO {

	// 싱글턴 패턴 --------------------------------
	private static UserDAO dao = new UserDAO();

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		return dao;
	}
	// --------------------------------------------

	// 회원가입을 위한 insert 함수
	public int userInsert(String userId, String userPw, String userName, String userGender, String userDate,
			String userPhoneNum, String userAddress, String userFavoriteKind, String userJob) {
		System.out.println("UserDAO userInsert()");

		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;

		if (userIdCheck(userId) == 0)
			return 0;

		// String userCode = null;
		// User user = new User(userCode
		// ,userId,userPw,userName,userAddress,userPhoneNum);

		String sql = "insert into personal_user values('US'||lpad(user_code_seq.nextval,8,'0'),?,?,?,?,?,?,?,?,?)";

		try {
			pState = con.prepareStatement(sql);

			pState.setString(1, userId);
			pState.setString(2, userPw);
			pState.setString(3, userName);
			pState.setString(4, userGender);
			pState.setString(5, userDate);
			pState.setString(6, userPhoneNum);
			pState.setString(7, userAddress);
			pState.setString(8, userFavoriteKind);
			pState.setString(9, userJob);

			return pState.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;

		} finally {
			DBUtil.close(con, pState);
		}

	}

	// ID 중복 확인을 위한 함수
	public int userIdCheck(String userId) {
		System.out.println("UserDAO userIdCheck()");

		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;
		ResultSet rs = null;

		// String idCheck = "";

		String sql = "select * from personal_user where u_id = ?";

		try {
			pState = con.prepareStatement(sql);

			pState.setString(1, userId);

			rs = pState.executeQuery();

			// 사용불가능 - 중복
			if (rs.next()) {
				return 0;
			}

			/*
			 * while(rs.next()) { if(idCheck.equals(rs.getString("u_id"))) //
			 * 사용불가능 - 중복 return 0; }
			 */ else {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			DBUtil.close(con, pState, rs);
		}
	}

	// 모든 회원 정보를 추출해주는 함수
	public ArrayList<User> userSelectAll() {
		System.out.println("UserDAO selectAll()");

		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;
		ResultSet rs = null;

		ArrayList<User> userArray = new ArrayList<>();

		String sql = "select * from personal_user by id asc";

		try {
			pState = con.prepareStatement(sql);
			rs = pState.executeQuery();

			while (rs.next()) {
				userArray.add(new User(rs.getString("u_code"), rs.getString("u_id"), rs.getString("u_password"),
						rs.getString("u_name"), rs.getString("u_gender"), String.valueOf(rs.getInt("u_age")),
						rs.getString("u_phoneNum"), rs.getString("u_address"), rs.getString("u_fav_kind"),
						rs.getString("u_job")));
			}
			return userArray;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			DBUtil.close(con, pState, rs);
		}

	}

	// 상세정보(회원 개인 정보 select하는 함수)
	public User userSelectById(String selectId) {
		System.out.println("UserDAO userSelectById()");

		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;
		ResultSet rs = null;

		User user = null;

		String sql = "select * from personal_user where u_id = ?";

		try {
			pState = con.prepareStatement(sql);
			pState.setString(1, selectId);

			rs = pState.executeQuery();

			while (rs.next()) {
				user = new User(rs.getString("u_name"), rs.getString("u_gender"), rs.getString("u_age"),
						rs.getString("u_phoneNum"), rs.getString("u_address"), rs.getString("u_fav_kind"),
						rs.getString("u_job"));
			}
			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			DBUtil.close(con, pState, rs);
		}
	}

	// 회원 선호 종목
	public List<Facility> userFavorite(String uKind, String uAddress) {
		System.out.println("userFavorite()");

		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;
		ResultSet rs = null;
		
		List<Facility> list = new ArrayList<>();
		Facility facility = null;

		String sql = "select f_name, f_address from facility where f_address like '?%' and f_address in(select f_address from facility f where f.f_code in (select f_code from price p where p.k_code in(select k_code from kind k where k.k_name = '?')))";

		try {
			pState = con.prepareStatement(sql);
			pState.setString(1, uAddress);
			pState.setString(2, uKind);

			rs = pState.executeQuery();

			while (rs.next()) {
				facility = new Facility(rs.getString("f_name"), rs.getString("f_address"));
				
				list.add(facility);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			DBUtil.close(con, pState, rs);
		}
	}

	// 회원 추천 종목

	// 해당 아이디 비밀번호의 회원 정보 삭제하는 함수
	public int userDelete(String userId) {
		System.out.println("UserDAO userDelete()");

		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;

		String sql = "delete from personal_user where u_id = ?";

		try {
			pState = con.prepareStatement(sql);

			pState.setString(1, userId);

			return pState.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return 0;

		} finally {
			DBUtil.close(con, pState);
		}

	}

	// 로그인 함수
	public User userLogin(String userId, String userPw) {
		System.out.println("UserDAO userLogin()");

		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;
		ResultSet rs = null;
		User user = null;

		String sql = "select * from personal_user where u_id = ? and u_password = ?";

		try {
			pState = con.prepareStatement(sql);

			pState.setString(1, userId);
			pState.setString(2, userPw);

			rs = pState.executeQuery();

			if (rs.next()) {
				user = new User(rs.getString("u_code"), rs.getString("u_id"), rs.getString("u_name"),rs.getString("u_address"),rs.getString("u_fav_kind"));
			}
			DBUtil.close(con, pState, rs);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.close(con, pState, rs);
			return null;

		}

	}

}
