package kdata.project.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.BoardDAO;
import kdata.project.dto.Comments;

public class CommentsDeleteService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CommentsDeleteService");
	
		String commentsNum = request.getParameter("commentsNum");
		System.out.println(commentsNum);
		
		int result = 0;
		result = BoardDAO.getInstance().deleteComments(Integer.parseInt(commentsNum));
		
		return null;
	}

}
