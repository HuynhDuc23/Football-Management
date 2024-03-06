package controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.commentDao;
import model.commentModel;
import model.user;

/**
 * Servlet implementation class commentServlet
 */
@WebServlet("/commentServlet")
public class commentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public commentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user userID = (user) request.getSession().getAttribute("user");
		
		int id = userID.getId();
		String id_match = (String) request.getParameter("id_match");
		String comment = (String) request.getParameter("comment");
		String url = request.getParameter("url");

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		commentDao dao = new commentDao();
		dao.addCommentByUserId(id, Integer.parseInt(id_match), sqlDate, comment);
		System.out.println(url);

		String saveUrl = url;
		request.setAttribute("saveUrl", saveUrl);
		response.sendRedirect(url);
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
