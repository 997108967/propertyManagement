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

public class BalanceInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		System.out.println(username);
		UserDAO dao = new UserDAO();
		try {
			User user = dao.find(username);
//			String WaterRates = user.getWaterRates();
//			String powerRates = user.getPowerRates();
//			String burnerCost = user.getBurnerCost();
//			String propertyFee = user.getPropertyFee();
			request.setAttribute("user", user);
			request.getRequestDispatcher("balanceInquiry.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
