package fithy.project.userservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fithy.project.dao.UserDAO;
import fithy.project.dto.User;
import fithy.project.util.NextPage;
import fithy.project.util.Service;

public class UserDetailService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("UserDetailService()");

		// 1. ��û �Ķ���� ó��
		String id = request.getParameter("userId");
		System.out.println("�˻�ȸ�� ID : " + id);

		// 2. DB ó��
		User user = UserDAO.getInstance().userSelectByName(id);

		// 3. DB ��� ó��
		request.setAttribute("detailUser", user);

		// 4. �̵��� ���� ������ ó��
		NextPage nextPage = new NextPage();

		nextPage.setPageName("./user/detail.jsp");
		nextPage.setRedirect(false);
		
		return nextPage;
	}

}
