package serviceman;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ServicemanDAO;
import dao.UserDAO;

public class MaintenanceCompleted extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("username");
		String username = request.getParameter("username");
		
		ServicemanDAO dao = new ServicemanDAO();
		UserDAO uDao = new UserDAO();
		
		try {
			dao.maintenanceCompleted(name);
			uDao.maintenanceCompleted(username);
			
			response.sendRedirect("/propertyManagement/troubleshooting");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
