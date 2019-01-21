package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

public class SecretProtection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		String securityQuestion = request.getParameter("securityQuestion");
		String answer = request.getParameter("answer");
		UserDAO dao = new UserDAO();
		try {
			String databaseAnswer = dao.findTheSecretAnswer(username, securityQuestion);
			if(answer.equals(databaseAnswer)) {
				response.sendRedirect("newPassword.jsp");
			}else {
				request.setAttribute("confidentialInsuranceError", "您输入的密保答案有误！");
				request.getRequestDispatcher("secretProtection.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
