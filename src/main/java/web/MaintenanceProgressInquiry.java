package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class MaintenanceProgressInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		UserDAO dao = new UserDAO();
		try {
			User user = dao.find(username);
			request.setAttribute("user", user);
			request.getRequestDispatcher("maintenanceProgressInquiry.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
