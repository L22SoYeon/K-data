package fithy.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fithy.project.dto.Reservation;
import fithy.project.util.DBUtil;

public class ReservationDAO {
	private static ReservationDAO dao = new ReservationDAO();

	private ReservationDAO() {
	}

	public static ReservationDAO getInstance() {
		return dao;
	}

	public ArrayList<String> reservationCheck(String fcName, Date reDate, String kindCode) {
		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;
		ResultSet rs = null;
		
		ArrayList<String> reArray = new ArrayList<>();

		String findFcCode = findFcCode(fcName);

		if (findFcCode.equals("")) {
			return null;
		} // ������ �� -1 ��ȯ
		String sql = "select request_time from reservation where f_code = '"+findFcCode+"' and request_date = '"+reDate+"' and k_code='"+kindCode+"'";
		
		try {
			pState = con.prepareStatement(sql);
			
			rs = pState.executeQuery();
			
			while(rs.next()) {
				reArray.add(rs.getString("request_time"));
			}
			
			return reArray;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String findFcCode(String fcName) {// ���� Ȯ���� �ϱ� ���� �ü� �̸��� �°� �ü� �ڵ带 ��ȯ�ϴ� �Լ�
		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;
		ResultSet rs = null;
		String fcCode = "";

		String sql = "select f_code from facility where f_name = ?";

		try {
			pState = con.prepareStatement(sql);

			pState.setString(1, fcName);

			rs = pState.executeQuery();

			if (rs.next()) {
				fcCode = rs.getString("f_code");
			}

			DBUtil.close(con, pState, rs);
			return fcCode;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.close(con, pState, rs);
			return "";
		}
	}

	public ArrayList<Reservation> reservationSelect() {// ��� �ü� �̸��� ����ϱ� ���� �Լ�
		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;
		ResultSet rs = null;
		ArrayList<Reservation> fNameArray = new ArrayList<>();

		String sql = "select f_code,f_name from facility order by f_name";

		try {
			pState = con.prepareStatement(sql);

			rs = pState.executeQuery();

			while (rs.next()) {
				fNameArray.add(new Reservation(rs.getString("f_code"), rs.getString("f_name")));
			}

			DBUtil.close(con, pState, rs);
			return fNameArray;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.close(con, pState, rs);
			return null;
		}

	}

	public ArrayList<Reservation> reservationCityList(String cityName) {// �������� ����Ʈ ����ֱ�
		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;
		ResultSet rs = null;

		ArrayList<Reservation> cityArray = new ArrayList<>();

		String sql = "select f_code, f_name from facility where f_address like '%" + cityName + "%' order by f_name";

		try {
			pState = con.prepareStatement(sql);

			rs = pState.executeQuery();

			while (rs.next()) {
				cityArray.add(new Reservation(rs.getString("f_code"), rs.getString("f_name")));
			}
			DBUtil.close(con, pState, rs);
			return cityArray;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.close(con, pState, rs);
			return null;
		}
	}

	public int reservationInsert(String usCode, String kindCode, String fcName, Date date, String time) {// ���� �߰��ϴ� �Լ�
		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;
		int result = 0;
		String fcCode = findFcCode(fcName);
		System.out.println(usCode+","+ kindCode+","+date+","+time+","+fcCode);
		String sql = "insert into reservation values('RE'||lpad(r_code_seq.nextval,8,'0'),?,default,?,?,?,?)";

		try {
			pState = con.prepareStatement(sql);

			pState.setString(1, usCode);
			pState.setString(2, kindCode);
			pState.setString(3, fcCode);	
			pState.setDate(4, date);
			pState.setString(5, time);

			result = pState.executeUpdate();

			DBUtil.close(con, pState);
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.close(con, pState);
			return 0;
		}
	}

	public int reservationDelete(Date deleteDate, String deleteTime, String deleteFcName, String deleteKindCode) {// ����
																													// ����ϴ�
																													// �Լ�
		Connection con = null;
		con = DBUtil.getConnect();

		PreparedStatement pState = null;

		String findFcCode = findFcCode(deleteFcName);

		if (findFcCode.equals("")) {// ������ �� -1��ȯ �Լ� ����
			return -1;
		}

		String sql = "delete reservation where request_date = ? and request_time = ? and f_code = ? and k_code = ?";

		try {
			pState = con.prepareStatement(sql);

			pState.setDate(1, deleteDate);
			pState.setString(2, deleteTime);
			pState.setString(3, findFcCode);
			pState.setString(4, deleteKindCode);

			int result = pState.executeUpdate();

			DBUtil.close(con, pState);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.close(con, pState);
			return -1;
		}
	}
}
