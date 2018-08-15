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

import model.dao.UserDAO;
import model.entity.User;

/**
 * Servlet implementation class Save
 */
@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Save() {
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
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		JSONObject jObj = null;
		String uname = "";
		String pwd = "";
		String uid = "";
		String page = "";
		HttpSession session = request.getSession();
		try {
			jObj = new JSONObject(sb.toString());
			uname = jObj.getString("uname");
			pwd = jObj.getString("pwd");
			uid = jObj.getString("uid");
			UserDAO udao = new UserDAO();
			User user = udao.findUserByUid(uid);
			String type=user.getType();
			if(type.equalsIgnoreCase("admin"))
				page="profileAdmin.jsp";
			else if(type.equalsIgnoreCase("faculty"))
				page="profileFaculty.jsp";
			else if(type.equalsIgnoreCase("student"))
				page="profileStudent.jsp";
			user.setUname(uname);
			user.setPwd(pwd);
			udao.modifyUser(user);
			jObj = new JSONObject("{\"alert\":'success',"
					+ "\"msg\":'Updated.',"
					+ "\"page\":" + page + "}");
		} catch (JSONException e) {
			e.printStackTrace();
			try {
				jObj = new JSONObject("{\"alert\":'danger',"
						+ "\"msg\":'Failed! Required fields can not be empty."
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