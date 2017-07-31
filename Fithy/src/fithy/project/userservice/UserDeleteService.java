package fithy.project.userservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fithy.project.dao.UserDAO;
import fithy.project.util.NextPage;
import fithy.project.util.Service;

public class UserDeleteService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("UserDeleteService()");

		// 1. 요청 파라미터 처리
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		// 2. DB 처리
		int result = UserDAO.getInstance().userDelete(userId, userPw);

		// 4. 이동할 다음 페이지 처리
		NextPage nextPage = new NextPage();

		// 회원 삭제 성공
		if (result != 0) {
			nextPage.setPageName("./user/login.jsp");
			nextPage.setRedirect(true);
			return nextPage;
		}
		// 회원 삭제 실패
		else {
			nextPage.setPageName("./error/error.jsp");
			nextPage.setRedirect(false);
			request.setAttribute("errorMessage", "회원탈퇴에 실패 하셨습니다.");
			return nextPage;
		}
	}

}
