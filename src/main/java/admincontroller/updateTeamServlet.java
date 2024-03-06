package admincontroller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import admindao.teamDao;

/**
 * Servlet implementation class updateTeamServlet
 */
@WebServlet(urlPatterns = { "/updateTeamServlet", "/admin/updateTeamServlet" })
public class updateTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateTeamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String logo = request.getParameter("logo");
		String namearena = request.getParameter("namearena");
		String imgarena = request.getParameter("imgarena");
		String description = request.getParameter("description");
		teamDao dao = new teamDao();
		dao.updateTeamById(Integer.parseInt(id), name, namearena, logo, imgarena, description);
		response.sendRedirect("crudTeamServlet");
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
