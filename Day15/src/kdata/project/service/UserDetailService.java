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

		// 1. ��û �Ķ���� ó��
		String id = request.getParameter("id");

		// 2. DB ó��


		// 3. DB ��� ó��
		User user = UserDAO.getInstance().selectById(id);
		request.setAttribute("detail", user);

		// 4. �̵��� ���� ������ ó��
		NextPage nextPage = new NextPage();
		nextPage.setPageName("./user/detail.jsp");
		nextPage.setRedirect(false);

		return nextPage;
	}

}
