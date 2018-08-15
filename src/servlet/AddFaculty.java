package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import model.dao.FacultyDAO;
import model.entity.Faculty;

/**
 * Servlet implementation class AddFaculty
 */
@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFaculty() {
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
		String send = "";
		try {
			System.out.println(sb.toString());
			jObj = new JSONObject(sb.toString());
			FacultyDAO sdao = new FacultyDAO();
			Faculty faculty = new Faculty();
			faculty.setId(Integer.parseInt(jObj.getString("id")));
			faculty.setName(jObj.getString("name"));
			faculty.setCode(jObj.getString("code"));
			sdao.addFaculty(faculty);
			send = "{\"alert\":'success'," + "\"msg\":'Added successfully.'}";
			jObj = new JSONObject(send);
		} catch (JSONException e) {
			e.printStackTrace();
			try {
				jObj = new JSONObject("{\"alert\":'danger'," + "\"msg\":'Required fields can not be empty'}");
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
