package kdata.project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.service.NextPage;
import kdata.project.service.UserService;

/**
 * Servlet implementation class Controller
 */
@WebServlet(value = "*.kdata", initParams = {
		@WebInitParam(name = "url", value = "/kdata/project/util/url.properties") })

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// <URL, ServiceClassName>
	private Map<String, UserService> map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		/*
		 * config.getInitParameter("url");
		 * System.out.println(config.getInitParameter("url"));
		 */

		Properties prop = new Properties();

		try {
			prop.load(getClass().getResourceAsStream(config.getInitParameter("url")));
			// System.out.println(prop);

			Iterator<Object> it = prop.keySet().iterator();
			UserService service=null;
			
			while (it.hasNext()) {
				// System.out.println(prop.get(it.next()));
				String key = (String) it.next();

				try {
					// 클래스 로딩
					Class clazz = Class.forName(prop.getProperty(key));
					// 객체 생성
					service = (UserService) clazz.newInstance();
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				map.put(key, service);

			}
			System.out.println(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.init(config);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String url = request.getRequestURI();
		int cmdIdx = url.lastIndexOf("/") + 1;
		String cmd = url.substring(cmdIdx);

		System.out.println(cmd);
		System.out.println(map.get(cmd));

		
		UserService service = map.get(cmd); 
		NextPage nextPage = null;

		nextPage = service.execute(request, response);

		if (nextPage == null) {
			System.out.println("null을 반환하지마!!!!!!");
		} else {
			if (nextPage.isRedirect()) {
				response.sendRedirect(nextPage.getPageName());
			} else {
				request.getRequestDispatcher(nextPage.getPageName()).forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	
}
