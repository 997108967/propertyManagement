package adm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class FuzzyQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String fuzzyQuery = request.getParameter("fuzzyQuery");
		
		UserDAO dao = new UserDAO();
		try {
			List<User> users = dao.fuzzyQueryByUsername(fuzzyQuery);
			request.setAttribute("users", users);
			request.getRequestDispatcher("adm/listUser.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
