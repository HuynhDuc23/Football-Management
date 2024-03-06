package controller;

import java.io.IOException;
import java.nio.file.Path;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import dao.userDao;
import model.account;
import model.user;

/**
 * Servlet implementation class editProFile
 */
@MultipartConfig
//  HTTP chứa dữ liệu đa phần (multipart). Dữ liệu đa phần thường được sử dụng để gửi và nhận file từ client (browser) đến server và ngược lại.
@WebServlet("/editProFile")
public class editProFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editProFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullname = request.getParameter("fullname");
		String age = request.getParameter("age");
		user userSession = (user) request.getSession().getAttribute("user");
		account acc = (account) request.getSession().getAttribute("Account");
		Part part = (Part) request.getPart("file"); // Đối tượng Part từ phần nhập tập tin
		// Link Luu Duong Dan Anh sau khi gui ve servlet
		String fullPath = getServletContext().getRealPath(""); // Lấy đường dẫn thực tế của project
		String realPath = fullPath + "imgs\\user";
		String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
		String fileNameSave = "imgs/user" + "/" + fileName;
		
		userDao user =  new userDao();
		if(age.length() > 4)
		{
			age = "0";
		}
		// Check  tuoi hop le 
		int ageCheck = Integer.parseInt(age);
		if(ageCheck>=120 || ageCheck <0)
		{
			ageCheck = 0 ;
		}
	     String err="";
		if(ageCheck>=0&& ageCheck<=120)
		{
			if(userSession == null)
			{
				userSession = new user();
				user.inSertInformationUser(acc.getId(),fullname,Integer.parseInt(age),fileNameSave);
			}
			
			else 
			{
				// Check File 2 trường hơp : 1 là file tải lên hoặc không tải file
				
				if(fileName.equals(""))
				{
					// no add file
					user.editAccountFile(userSession.getId() , fullname , Integer.parseInt(age) , fileName);
				}
				else
				{
					
					// Ghi du lieu vao trên project
					part.write(realPath +"/"+ fileName ) ;
					
					
					user.editAccountFile(userSession.getId() , fullname , Integer.parseInt(age) , fileNameSave);
				}
			}
		}
		else {
			err = "Age entered incorrectly" ;
		}
		
		if(err.length()==0)
		{
			     HttpSession session  =  request.getSession();
			    session.removeAttribute("user");
			    user u =  user.getByIdUser(acc.getId()) ;
			    request.getSession().setAttribute("user",u);
			    response.sendRedirect("HomeServletHeader");
		}

}
}
