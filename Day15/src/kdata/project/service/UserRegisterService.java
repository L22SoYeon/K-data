package kdata.project.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kdata.project.dao.UserDAO;
import kdata.project.dto.User;

public class UserRegisterService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("2. UserRegisterService");

		String path = request.getServletContext().getRealPath("profile");
		System.out.println(path);

		try {
			MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 10, "UTF-8",
					new DefaultFileRenamePolicy());
			// 1. 요청 파라미터
			String id = multi.getParameter("id");
			String pw = multi.getParameter("pw");
			String name = multi.getParameter("name");

			String fileSystemName = multi.getFilesystemName("file");
			// String originalFileName = multi.getOriginalFileName("file");

			System.out.println(fileSystemName);// db에 넣어야할 것
			// System.out.println(originalFileName);

			// 2. DB처리
			int result = 0;
			UserDAO.getInstance().insert(new User(id, pw, name, fileSystemName, null));

			// 3. DB 결과 처리

			// 4. 이동할 다음 페이지 처리
			NextPage nextPage = new NextPage();
			// 회원가입 성공
			if (result != 0) {
				System.out.println("회원가입 성공");
				nextPage.setPageName("./user/login.jsp");
				nextPage.setRedirect(true);
				return nextPage;
			} // 회원가입 실패
			else {
				request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
				nextPage.setPageName("./errors/error.jsp");
				nextPage.setRedirect(false);
				return nextPage;
			}

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}
