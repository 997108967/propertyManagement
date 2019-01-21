package serviceman;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ServicemanDAO;
import entity.Serviceman;

public class Troubleshooting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("username");
		ServicemanDAO dao = new ServicemanDAO();
		try {
			List<Serviceman> servicemans = dao.findByUsername(name);
			request.setAttribute("servicemans", servicemans);
			request.getRequestDispatcher("serviceman/troubleshooting.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
