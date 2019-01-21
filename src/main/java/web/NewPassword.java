package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		String password = request.getParameter("password");
		UserDAO dao = new UserDAO();
		try {
			dao.changePassword(username, password);
			response.sendRedirect("userLogin.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}

}
