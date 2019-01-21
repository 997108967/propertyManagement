package adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdmLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if("admin".equals(username)) {
			if("1234".equals(password)) {
				response.sendRedirect("adm/index.jsp");
			}else {
				request.setAttribute("login_fail", "密码错误");
				request.getRequestDispatcher("adm/login.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("login_fail", "用户名不存在");
			request.getRequestDispatcher("adm/login.jsp").forward(request, response);
		}
		
	}

}
