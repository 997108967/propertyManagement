package serviceman;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServicemanDAO;
import entity.Serviceman;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		Serviceman serviceman = new Serviceman();
		serviceman.setName(username);
		serviceman.setPassword(password);
		serviceman.setPhone(phone);
		
		ServicemanDAO dao = new ServicemanDAO();
		try {
			dao.insertUserInfo(serviceman);
			response.sendRedirect("serviceman/login.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
