package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

public class Repair extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String repairContent = request.getParameter("repairContent");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		UserDAO dao = new UserDAO();
		try {
			dao.updateFault(username, repairContent);
			response.sendRedirect("mpi");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
}
