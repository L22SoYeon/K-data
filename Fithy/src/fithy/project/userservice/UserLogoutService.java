package fithy.project.userservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fithy.project.util.NextPage;
import fithy.project.util.Service;

public class UserLogoutService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("UserLogoutService execute()");
		HttpSession session = request.getSession();
		// 1. ��û �Ķ���� ó��
		String userId = (String) session.getAttribute("uId");
		System.out.println(userId);
		// 2. DB ó��
		// int result = UserDAO.getInstance().userLogin(userId, userPw);

		// 4. �̵��� ���������� ó��
		NextPage nextPage = new NextPage();

		// ------------------------------------�α׾ƿ� ���
		// ����
		if (userId != null) {
			session.invalidate();
			nextPage.setPageName("./index.jsp");
			nextPage.setRedirect(true);
			return nextPage;
		} // ����
		else {
			nextPage.setPageName("./errors/error.jsp");
			nextPage.setRedirect(false);
			return nextPage;
		}
	}

}
