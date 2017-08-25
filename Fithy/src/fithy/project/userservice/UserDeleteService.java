package fithy.project.userservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fithy.project.dao.UserDAO;
import fithy.project.util.NextPage;
import fithy.project.util.Service;

public class UserDeleteService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("UserDeleteService()");

		// 1. ��û �Ķ���� ó��
		HttpSession session = request.getSession();

		String userId = (String) session.getAttribute("uId");
		
		// 2. DB ó��
		int result = UserDAO.getInstance().userDelete(userId);

		// 4. �̵��� ���� ������ ó��
		NextPage nextPage = new NextPage();

		// ȸ�� ���� ����
		if (result != 0) {
			nextPage.setPageName("./user/login.jsp");
			nextPage.setRedirect(true);
			return nextPage;
		}
		// ȸ�� ���� ����
		else {
			nextPage.setPageName("./error/error.jsp");
			nextPage.setRedirect(false);
			request.setAttribute("errorMessage", "ȸ��Ż�� ���� �ϼ̽��ϴ�.");
			return nextPage;
		}
	}

}
