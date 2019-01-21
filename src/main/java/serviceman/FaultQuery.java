package serviceman;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServicemanDAO;
import entity.User;

public class FaultQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicemanDAO dao = new ServicemanDAO();
		try {
			List<User> users = dao.findFaultUser();
			request.setAttribute("users", users);
			request.getRequestDispatcher("serviceman/faultUser.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
