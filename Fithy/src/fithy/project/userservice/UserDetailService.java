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

		// 1. 요청 파라미터 처리
		String id = request.getParameter("userId");
		System.out.println("검색회원 ID : " + id);

		// 2. DB 처리
		User user = UserDAO.getInstance().userSelectByName(id);

		// 3. DB 결과 처리
		request.setAttribute("detailUser", user);

		// 4. 이동할 다음 페이지 처리
		NextPage nextPage = new NextPage();

		nextPage.setPageName("./user/detail.jsp");
		nextPage.setRedirect(false);
		
		return nextPage;
	}

}
