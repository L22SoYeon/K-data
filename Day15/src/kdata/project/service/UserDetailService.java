package kdata.project.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.UserDAO;
import kdata.project.dto.User;

public class UserDetailService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("2. UserDetailService");

		// 1. 요청 파라미터 처리
		String id = request.getParameter("id");

		// 2. DB 처리


		// 3. DB 결과 처리
		User user = UserDAO.getInstance().selectById(id);
		request.setAttribute("detail", user);

		// 4. 이동할 다음 페이지 처리
		NextPage nextPage = new NextPage();
		nextPage.setPageName("./user/detail.jsp");
		nextPage.setRedirect(false);

		return nextPage;
	}

}
