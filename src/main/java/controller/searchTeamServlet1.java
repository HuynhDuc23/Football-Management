package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.teamDao;
import model.team;

/**
 * Servlet implementation class searchTeamServlet1
 */
@WebServlet("/searchTeamServlet1")
public class searchTeamServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchTeamServlet1() {
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
		String search = (String) request.getSession().getAttribute("search");

		teamDao dao = new teamDao();
		int count = 0;
		int endPage = 0;
		if (search != null) {
			if (dao.countTeamSearch(search) > 0) {
				count = dao.countTeamSearch(search);
				ArrayList<team> arr = dao.getAllTeamPaging(search, Integer.parseInt(index));
				endPage = count / 3;
				if (count % 3 != 0) {
					endPage++;
				}

				request.setAttribute("tag", (Integer.parseInt(index)));
				request.setAttribute("paging", endPage);
				request.setAttribute("pagingTeam", arr);
				request.getRequestDispatcher("homepaging2.jsp").forward(request, response);
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
