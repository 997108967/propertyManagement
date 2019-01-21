package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class UserLogin extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO dao = new UserDAO();
		boolean login = false;
		try {
			User user = dao.find(username);
		
			if(user==null) {
			}else {
				String pwd = user.getPassword();
				if(password.equals(pwd)) {
					login = true;
				}
			}
			if(login) {
				//登录成功，跳转用户模块
				HttpSession session = request.getSession();
				session.setAttribute("username",username);
				response.sendRedirect("userModule.jsp");
			}else {
				//登录失败，转发登录页面提示用户
				request.setAttribute("login_fail", "用户名和密码输入有误，请重新输入!");
				request.getRequestDispatcher("userLogin.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
	}
	
}
