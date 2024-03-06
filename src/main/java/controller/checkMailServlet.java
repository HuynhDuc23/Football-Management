package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.accountDao;
import model.account;
import util.SendEmail;

/**
 * Servlet implementation class checkMailServlet
 */
@WebServlet("/checkMailServlet")
public class checkMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkMailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		accountDao accD = new accountDao();
		account acc = accD.checkEmail(email);
		String url = "";
		if (acc != null) {
			String otp = SendEmail.send(email);
			System.out.println(otp);
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("otp", otp);

			request.getRequestDispatcher("sms.jsp").forward(request, response);

		} else {
			url = "Email error, please re-enter";
			int lengthUrl = url.length();
			request.setAttribute("email", email);
			request.setAttribute("Mess", url);
			request.setAttribute("lengthUrl", lengthUrl);
			request.getRequestDispatcher("mail.jsp").forward(request, response);
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
