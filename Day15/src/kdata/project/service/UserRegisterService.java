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
			// 1. ��û �Ķ����
			String id = multi.getParameter("id");
			String pw = multi.getParameter("pw");
			String name = multi.getParameter("name");

			String fileSystemName = multi.getFilesystemName("file");
			// String originalFileName = multi.getOriginalFileName("file");

			System.out.println(fileSystemName);// db�� �־���� ��
			// System.out.println(originalFileName);

			// 2. DBó��
			int result = 0;
			UserDAO.getInstance().insert(new User(id, pw, name, fileSystemName, null));

			// 3. DB ��� ó��

			// 4. �̵��� ���� ������ ó��
			NextPage nextPage = new NextPage();
			// ȸ������ ����
			if (result != 0) {
				System.out.println("ȸ������ ����");
				nextPage.setPageName("./user/login.jsp");
				nextPage.setRedirect(true);
				return nextPage;
			} // ȸ������ ����
			else {
				request.setAttribute("errorMsg", "ȸ�����Կ� �����߽��ϴ�.");
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
