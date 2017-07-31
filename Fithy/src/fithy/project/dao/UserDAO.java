package fithy.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fithy.project.dto.User;
import fithy.project.util.DBUtil;

public class UserDAO {

	// ΩÃ±€≈œ ∆–≈œ------------------------------------
	private static UserDAO dao = new UserDAO();

	private UserDAO() {

	}

	public static UserDAO getInstance() {
		return dao;
	}
	// -----------------------------------------------

	// UserRegister----------------------------------
	public int userInsert(String userId, String userPw, String userName, String userGender, int userAge,
			String userPhoneNum, String userAddress, String userFavoriteKind) {
		System.out.println("UserDAO userInsert()");

		Connection con = null;
		PreparedStatement pState = null;

		con = DBUtil.getConnet();

		String sql = "insert into personal_user values('US'||lpad(user_code_seq.nextval, 8, '0'), ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pState = con.prepareStatement(sql);

			pState.setString(1, userId);
			pState.setString(2, userPw);
			pState.setString(3, userName);
			pState.setString(4, userGender);
			pState.setInt(5, userAge);
			pState.setString(6, userPhoneNum);
			pState.setString(7, userAddress);
			pState.setString(8, userFavoriteKind);

			return pState.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtil.close(con, pState);
		}
	}

	// UserIdCheck ----------------------------------
	public int userIdCheck(String userId) {
		System.out.println("UserDAO userIdCheck()");

		Connection con = null;
		PreparedStatement pState = null;
		ResultSet rs = null;

		con = DBUtil.getConnet();

		String sql = "select * from personal_user where u_id = ?";

		try {
			pState = con.prepareStatement(sql);

			pState.setString(1, userId);

			rs = pState.executeQuery();

			if (rs.next()) {
				return 0;
			}

			else {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtil.close(con, pState, rs);
		}
	}

	// UserDelete -----------------------------------
	public int userDelete(String userId, String userPw) {
		System.out.println("UserDAO userDelete()");

		Connection con = null;
		PreparedStatement pState = null;

		con = DBUtil.getConnet();

		String sql = "delete from personal_user where u_id = ? and u_password = ?";

		try {
			pState = con.prepareStatement(sql);

			pState.setString(1, userId);
			pState.setString(2, userPw);

			return pState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtil.close(con, pState);
		}
	}

	// UserDetail------------------------------------
	public User  userSelectByName(String selectId){
		System.out.println("UserDAO userSelectByName()");
		
		Connection con = null;
		PreparedStatement pState = null;
		ResultSet rs = null;
		User user = null;

		con = DBUtil.getConnet();
		
		String sql = "select * from personal_user where u_id = ?";
		
		try {
			pState = con.prepareStatement(sql);
			
			pState.setString(1, selectId);
			
			rs = pState.executeQuery();
			
			while(rs.next()){
				user = new User(rs.getString("u_code"), rs.getString("u_id"), rs.getString("u_password"), rs.getString("u_name"), rs.getString("u_gender"), String.valueOf(rs.getInt("u_age")), rs.getString("u_phoneNum"), rs.getString("u_address"), rs.getString("u_fav_kind"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			DBUtil.close(con, pState, rs);
		}	
	}
	
	// UserList -------------------------------------
	public ArrayList<User>  userSelectAll(String selectId){
		System.out.println("UserDAO userSelectAll()");
		
		Connection con = null;
		PreparedStatement pState = null;
		ResultSet rs = null;
		ArrayList<User> userArray = new ArrayList<>();

		con = DBUtil.getConnet();
		
		String sql = "select * from personal_user by id asc";
		
		try {
			pState = con.prepareStatement(sql);
			
			rs = pState.executeQuery();
			
			while(rs.next()){
				userArray.add(new User(rs.getString("u_code"), rs.getString("u_id"), rs.getString("u_password"), rs.getString("u_name"), rs.getString("u_gender"), String.valueOf(rs.getInt("u_age")), rs.getString("u_phoneNum"), rs.getString("u_address"), rs.getString("u_fav_kind")));
			}
			return userArray;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			DBUtil.close(con, pState, rs);
		}	
	}
	
	// UserLogin ------------------------------------
	public User userLogin(String userId, String userPw) {
		System.out.println("UserDAO userLogin()");

		Connection con = null;
		PreparedStatement pState = null;
		ResultSet rs = null;
		User user = null;

		con = DBUtil.getConnet();

		String sql = "select u_id, u_password, u_code, u_name from personal_user where u_id and u_password = ?";

		try {
			pState = con.prepareStatement(sql);

			pState.setString(1, userId);
			pState.setString(2, userPw);

			rs = pState.executeQuery();

			if (rs.next()) {
				user = new User(rs.getString("u_code"), rs.getString("u_id"), rs.getString("u_name"));
			}
			DBUtil.close(con, pState, rs);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
