package kdata.project.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kdata.project.dao.BoardDAO;

import kdata.project.dto.Comments;

public class CommentsWriteService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CommentsWriteService()");

		// 1. 요청 파라미터
		String id = request.getParameter("id");
		String comments = request.getParameter("comments");
		String num = request.getParameter("num");

		// 2. DB처리
		int result = 0;
		result = BoardDAO.getInstance().insertComments(new Comments(id, comments, Integer.parseInt(num)));

		System.out.println(result);

		List<Comments> list = BoardDAO.getInstance().selectComments(Integer.parseInt(num));
		// System.out.println("After : " + list.size());
		// System.out.println(list);
		System.out.println("JSON-------------------------");
		JSONArray array = new JSONArray();

		for (Comments com : list) {
			JSONObject obj = new JSONObject();
			obj.put("commentNum", com.getCommentNum());
			obj.put("id", com.getId());
			obj.put("content", com.getContent());
			obj.put("writeDate", String.valueOf(com.getWriteDate()));
			array.add(obj);
		}

		System.out.println(array);

		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(array);

		// 3. DB 결과 처리

		// 4. 이동할 다음 페이지 처리
		/*NextPage nextPage = new NextPage();

		nextPage.setPageName("./user/login.jsp");
		nextPage.setRedirect(true);
		return nextPage;*/
		return null;
	}

}
