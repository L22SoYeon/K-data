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

		// 1. ��û �Ķ���� ó��

		// 2. DB ó��
		List<User> list = null;
		list = UserDAO.getInstance().selectAll();

		// 3. DB ��� ó��
		request.setAttribute("list", list);
		System.out.println(list.size());
		
		// 4. �̵��� ���� ������ ó��
		NextPage nextPage = new NextPage();
		nextPage.setPageName("./user/list.jsp");
		nextPage.setRedirect(false);

		return nextPage;

	}

}
