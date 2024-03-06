package admincontroller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import admindao.seasionDao;

/**
 * Servlet implementation class addSeasionServlet
 */
@WebServlet(urlPatterns = { "/addSeasionServlet", "/admin/addSeasionServlet" })
public class addSeasionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addSeasionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		if(start.length()>4 || end.length() >4)
		{
			start = "0";
			end = "0";
		}
		seasionDao dao = new seasionDao();
		dao.insertSeasion(Integer.parseInt(start), Integer.parseInt(end));
		request.getRequestDispatcher("seasionAddofDelete").forward(request, response);

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
