package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class UserRegistration extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String idNumber = request.getParameter("id");
		String phoneNumber = request.getParameter("phoneNumber");
		String secretProtection = request.getParameter("secretProtection");
		if("teacher".equals(secretProtection)) {
			secretProtection = "你老师的姓名？";
		}else if("father".equals(secretProtection)){
			secretProtection = "你父亲的姓名？";
		}else if("deskmate".equals(secretProtection)){
			secretProtection = "你同桌的姓名？";
		}
		String secretProtectionValue = request.getParameter("secretProtectionValue");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress(address);
		user.setIdNumber(idNumber);
		user.setPhoneNumber(phoneNumber);
		user.setSecretProtection(secretProtection);
		user.setSecretProtectionValue(secretProtectionValue);
		UserDAO dao = new UserDAO();
		response.sendRedirect("registrationSuccess.jsp");
		try {
			dao.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("系统繁忙，稍后重试！");
		}
	}
	
}
