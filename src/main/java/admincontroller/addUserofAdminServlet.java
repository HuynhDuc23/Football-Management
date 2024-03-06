package admincontroller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.accountDao;
import model.account;
import util.encode;
import util.regex;

/**
 * Servlet implementation class addUserofAdminServlet
 */
@WebServlet(urlPatterns = { "/addUserofAdminServlet", "/admin/addUserofAdminServlet" })
public class addUserofAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addUserofAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String role = request.getParameter("role");
		
		

		String checkError = "";
		String defaultPass = "abcabc";
		String defaultPassMax = "abcabcabcabc";
		int lengthDefaultMax = defaultPassMax.length();
		int lengthDefault = defaultPass.length();
		accountDao accountDao = new accountDao();
		account acc = accountDao.checkEmailAndPass(mail, pass);
		boolean checkAcc = false;
		String checkErrorEmail = "";
		String checkErrorkPass = "";
		String checkErrorRole = "";
		if (acc != null) {
			checkError += "Not Login Sucessfully";
		} else {
			if (regex.checkEmailRegex(mail)) {
				if (pass.length() >= lengthDefault && pass.length() <= lengthDefaultMax) {
					pass = encode.encodeData(pass);
					if (Integer.parseInt(role) == 0 || Integer.parseInt(role) == 1) {
						checkAcc = true;
					} else {
						checkErrorRole += "ErrorRole";
					}
				} else {
					checkErrorkPass += "ErrorPass";
				}
			} else {
				checkErrorEmail += "ErrorEmail";
			}
		}
		String susess = "";
		int lengthsuess = 0;
		if (checkAcc == true) {
			int lengthSucess = 0;
			admindao.accountDao accAdmin = new admindao.accountDao();
			accAdmin.InsertAccInAdmin(mail, pass, Integer.parseInt(role));
			request.setAttribute("lengthSucess", lengthSucess);
			request.getRequestDispatcher("adminaccountServlet").forward(request, response);
		} else {
			String susess1 = "error!";
			if (susess1.length() > 0) {
				lengthsuess = susess1.length();
				susess = susess1;
			}
			request.setAttribute("sucess", susess);
			request.setAttribute("lengthsuess", lengthsuess);
			request.setAttribute("checkErrorEmail", checkErrorEmail);
			request.setAttribute("checkErrorkPass", checkErrorkPass);
			request.setAttribute("checkErrorRole", checkErrorRole);

			request.getRequestDispatcher("adminaccountServlet").forward(request, response);
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
