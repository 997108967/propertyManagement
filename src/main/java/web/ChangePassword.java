package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		UserDAO dao = new UserDAO();
		try {
			User user = dao.find(username);
			String password = user.getPassword();
			if(password.equals(oldPassword)) {
				dao.changePassword(username, newPassword);
				response.sendRedirect("userLogin.jsp");
			}else {
				request.setAttribute("passwordError", "您输入的密码有误！");
				request.getRequestDispatcher("changePassword.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
