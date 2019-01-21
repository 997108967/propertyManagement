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
/**
 * 接单
 * @author soft01
 *
 */
public class Receipt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String phoneNumber = request.getParameter("phoneNumber");
		String fault = request.getParameter("fault");
		
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("username");
		
		System.out.println(username+":"+phoneNumber+":"+fault+":"+name);
		ServicemanDAO dao = new ServicemanDAO();
		UserDAO uDao = new UserDAO();
		try {
			dao.insertInfoByUsername(name, username, phoneNumber, fault);
			uDao.modifyMaintenanceStatus(username);
			response.sendRedirect("/propertyManagement/faultQuery");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
