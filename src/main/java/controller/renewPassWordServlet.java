package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.accountDao;
import model.account;
import util.encode;

/**
 * Servlet implementation class renewPassWordServlet
 */
@WebServlet("/renewPassWordServlet")
public class renewPassWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public renewPassWordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailSession = (String) request.getSession().getAttribute("email");
		System.out.println(emailSession);
		String newPassword = request.getParameter("newPassword");
		System.out.println(newPassword);
		String re_newPassword = request.getParameter("re-newPassword");
		System.out.println(re_newPassword);
		String resetPass = "";
		System.out.println(resetPass);
		String Mess = "";
		if (emailSession != null) {
			try {
				if (newPassword.equals(re_newPassword) && newPassword.length() > 6) {
					resetPass = encode.encodeData(newPassword);
				
					accountDao acc = new accountDao();
					acc.updateAccountNewChange(emailSession, resetPass);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} else {
					Mess = "Passwords do not match, please try again";
					int LengthMess = Mess.length();
					request.setAttribute("newPassword", newPassword);
					request.setAttribute("re_newPassword", re_newPassword);
					request.setAttribute("Mess", Mess);
					request.setAttribute("LengthMess", LengthMess);
					request.getRequestDispatcher("renewPassWord.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("sms.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
