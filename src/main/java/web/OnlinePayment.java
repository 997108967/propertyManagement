package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

public class OnlinePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		String payType = request.getParameter("payType");
		System.out.println(payType+"1111111111111111");
		String money = request.getParameter("money");
		System.out.println(username+":"+payType+":"+money);
		UserDAO dao = new UserDAO();
		try {
			dao.onlinePayment(username,payType,money);
			response.sendRedirect("balanceInquiry");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
