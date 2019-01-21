package serviceman;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ServicemanDAO;
import entity.Serviceman;

public class ServicemanLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ServicemanDAO dao = new ServicemanDAO();
		try {
			Serviceman serviceman = dao.findUserInfo(username);
			if(serviceman!=null&&password.equals(serviceman.getPassword())) {
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					response.sendRedirect("serviceman/index.jsp");
			}else {
				request.setAttribute("login_fail","用户名或密码错误！");
				request.getRequestDispatcher("serviceman/login.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
