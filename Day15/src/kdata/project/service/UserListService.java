package kdata.project.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.UserDAO;
import kdata.project.dto.User;

public class UserListService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("2. UserListService");

		// 1. 요청 파라미터 처리

		// 2. DB 처리
		List<User> list = null;
		list = UserDAO.getInstance().selectAll();

		// 3. DB 결과 처리
		request.setAttribute("list", list);
		System.out.println(list.size());
		
		// 4. 이동할 다음 페이지 처리
		NextPage nextPage = new NextPage();
		nextPage.setPageName("./user/list.jsp");
		nextPage.setRedirect(false);

		return nextPage;

	}

}
