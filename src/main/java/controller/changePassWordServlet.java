package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changePassWordServlet
 */
@WebServlet("/changePassWordServlet")
public class changePassWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public changePassWordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String o1 = request.getParameter("o1");
		String o2 = request.getParameter("o2");
		String o3 = request.getParameter("o3");
		String o4 = request.getParameter("o4");
		String o5 = request.getParameter("o5");
		String o6 = request.getParameter("o6");
		String otpReset = o1 + o2 + o3 + o4 + o5 + o6;
		String otpSession = (String) request.getSession().getAttribute("otp");
		
		String url = "";
		if (otpSession != null) {
			if (otpReset.equals(otpSession)) {
				request.getSession().removeAttribute("otp");
				response.sendRedirect("renewPassWord.jsp");
			} else {
				url = "Incorrect authentication code, please re-enter";
				int legnthUrl = url.length();

				request.setAttribute("Mess", url);
				request.setAttribute("legnthUrl", legnthUrl);
				request.getRequestDispatcher("sms.jsp").forward(request, response);
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
