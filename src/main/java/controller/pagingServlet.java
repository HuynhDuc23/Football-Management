package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.teamDao;

/**
 * Servlet implementation class pagingServlet
 */
@WebServlet("/pagingServlet")
public class pagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public pagingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String index = request.getParameter("index");
		if (index == null) {
			index = "1";
		}
		int indexNew = Integer.parseInt(index);
		teamDao dao = new teamDao();
		// count
		int paging = dao.CountAllTeam();
		teamDao team = new teamDao();

		ArrayList<model.team> pagingTeam = team.pagingGetAllTeam(indexNew);

		int endPage = paging / 3;
		if (paging % 3 != 0) {
			endPage++;
		}
		request.setAttribute("paging", endPage);
		request.setAttribute("pagingTeam", pagingTeam);
		request.setAttribute("tag", indexNew);
		request.getRequestDispatcher("homepaging.jsp").forward(request, response);
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
