package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.accountDao;
import dao.userDao;
import model.account;
import util.encode;
import util.regex;

/**
 * Servlet implementation class validateFormServlet
 */
@WebServlet("/validateFormServlet")
public class validateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public validateFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("login")) {
			String url = "";
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String passwordCookies = password;
			password = encode.encodeData(password);
			String remember_me = request.getParameter("remember_me");
			accountDao dao = new accountDao();
			account acc = dao.loginAccount(email, password);
			if (acc != null) {
				HttpSession session = request.getSession();
				session.setAttribute("Account", acc);
				// save account 
				userDao userdao = new userDao();
				session.setAttribute("user", userdao.getByIdAccount(acc.getId()));
				// check cookie save
				if (remember_me != null) {
					// create cookie
					Cookie emailCookie = new Cookie("emailC", email);
					Cookie passwordCookie = new Cookie("passCookie", passwordCookies);
					// set time cookie
					emailCookie.setMaxAge(60 * 24);
					passwordCookie.setMaxAge(60 * 24);
					// reponse cookie in browse
					response.addCookie(emailCookie);
					response.addCookie(passwordCookie);

				}
				if (acc.getRole() == 1) {
					String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
							+ request.getContextPath();
					System.out.println(url1);
					url1 = url1 + ("/admin/home.jsp");
					response.sendRedirect(url1);
				} else {
					response.sendRedirect("session.jsp");
				}
			} else {
				url = "No data found";
				// account isempty
				int lengthUrl = url.length();
				request.setAttribute("lengthUrl", lengthUrl);
				request.setAttribute("Mess", url);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} else if (action.equals("register")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String re_password = request.getParameter("re-password");
			String mess = "";
			int checkLengthPass = 6;
			if (!password.equals(re_password) || password.length() < checkLengthPass) {
				mess += "Password Does Not Match Or Length Is Less Than 6";
			} else {
				accountDao dao = new accountDao();
				account acc = dao.checkEmailAndPass(email, password);
				if (acc != null) 
				{
					mess += "This account already exists!";
				} else {
					if (regex.checkEmailRegex(email)) {
						ArrayList<account> t = (ArrayList<account>) dao.getAllAccount(email);
						if (t.size() <= 0) {
							password = encode.encodeData(password);
							dao.signUp(email, password);
						} else {
							mess += "Account has been used";
						}

					}

				}
				if (mess.length() != 0) {
					int lengthUrl = mess.length();
					request.setAttribute("lengthUrl", lengthUrl);
					request.setAttribute("Mess", mess);
					request.setAttribute("email", email);
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}

				else {
					response.sendRedirect("login.jsp");
				}

			}
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
