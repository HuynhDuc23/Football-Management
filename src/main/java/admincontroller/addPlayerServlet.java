package admincontroller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import admindao.playerTeam;

/**
 * Servlet implementation class addPlayerServlet
 */
@WebServlet(urlPatterns = { "/addPlayerServlet", "/admin/addPlayerServlet" })
public class addPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addPlayerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String namePlayer = request.getParameter("name");
		String shirt = request.getParameter("shirt");
		String listID = request.getParameter("idTeamList");
		playerTeam dao = new playerTeam();
		dao.addPlayer(namePlayer, Integer.parseInt(shirt), Integer.parseInt(listID));
		response.sendRedirect("crudPlayerServlet");
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
