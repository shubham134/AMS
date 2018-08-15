package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import model.dao.AdminDAO;
import model.dao.FacultyDAO;
import model.dao.StudentDAO;
import model.dao.UserDAO;
import model.entity.Admin;
import model.entity.Faculty;
import model.entity.Student;
import model.entity.User;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete() {
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
		JSONObject jObj = null;
		UserDAO udao = new UserDAO();
		User user = null;
		HttpSession session = request.getSession();
		String page = (String) session.getAttribute("page");
		String uid = (String) session.getAttribute("uid");
		try {
			user = udao.findUserByUid(uid);
			String type = user.getType();
			if (type.equalsIgnoreCase("admin")) {
				AdminDAO adao = new AdminDAO();
				Admin admin = adao.findAdminByUid(uid);
				adao.removeAdmin(admin.getId());
			} else if (type.equalsIgnoreCase("faculty")) {
				FacultyDAO fdao = new FacultyDAO();
				Faculty faculty = fdao.findFacultyByUid(uid);
				fdao.removeFaculty(faculty.getId());
			} else if (type.equalsIgnoreCase("student")) {
				StudentDAO sdao = new StudentDAO();
				Student student = sdao.findStudentByUid(uid);
				sdao.removeStudent(student.getId());
			}
			jObj = new JSONObject("{\"alert\":'success',"
					+ "\"msg\":'Deleted.',"
					+ "\"page\":" + page + "}");
		} catch (JSONException e) {
			e.printStackTrace();
			try {
				jObj = new JSONObject("{\"alert\":'danger',"
						+ "\"msg\":'Failed!',"
						+ "\"page\":'" + page + "'}");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jObj);
		out.flush();
	}
}