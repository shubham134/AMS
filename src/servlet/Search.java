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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
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
		String id = "";
		String page = "";
		HttpSession session = request.getSession();
		try {
			jObj = new JSONObject(sb.toString());
			id = jObj.getString("id");
			page = (String) session.getAttribute("page");
			jObj = new JSONObject("{\"alert\":'success',"
					+ "\"msg\":'Fetching details...',"
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
		session.setAttribute("id", id);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jObj);
		out.flush();
	}
}