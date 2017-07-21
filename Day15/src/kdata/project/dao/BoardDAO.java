package kdata.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kdata.project.dto.Comments;
import kdata.project.util.DBUtil;

public class BoardDAO {
	// ΩÃ±€≈œ ∆–≈œ---------------------------------
	private static BoardDAO dao = new BoardDAO();

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		return dao;
	}
	// --------------------------------------------

	// ¥Ò±€ æ≤±‚
	public int insertComments(Comments comments) {
		System.out.println("insertComments()");

		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "insert into comments values(comments_seq.NEXTVAL, ?, ?, default, ?)";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, comments.getId());
			pstmt.setString(2, comments.getContent());
			pstmt.setInt(3, comments.getNum());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	// ¥Ò±€ ∏ÆΩ∫∆Æ
	public List<Comments> selectComments(int num) {
		System.out.println("selectComments()");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comments> list = new ArrayList<>();
		int result = 0;

		String sql = "select * from Comments where num=?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Comments comments = new Comments();

				comments.setCommentNum(rs.getInt("comment_Num"));
				comments.setId(rs.getString("id"));
				comments.setContent(rs.getString("content"));

				list.add(comments);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con, rs);
		}
		return list;
	}

	// ¥Ò±€ ªË¡¶
	public int deleteComments(int commentsNum) {
		System.out.println("deleteComments");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "delete comments where comment_num=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, commentsNum);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
		
	}
}
