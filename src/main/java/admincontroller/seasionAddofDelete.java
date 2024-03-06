package admincontroller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import admindao.seasionDao;
import model.session;

/**
 * Servlet implementation class seasionAddofDelete
 */
@WebServlet(urlPatterns = { "/seasionAddofDelete", "/admin/seasionAddofDelete" })
public class seasionAddofDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public seasionAddofDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		seasionDao SeasionDao = new seasionDao();
		ArrayList<session> Seasion = SeasionDao.getAllSeasion();
		request.setAttribute("Seasion", Seasion);

		request.getRequestDispatcher("crudSeasion.jsp").forward(request, response);
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
