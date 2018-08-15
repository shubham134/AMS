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

import model.dao.AdminDAO;
import model.entity.Admin;

/**
 * Servlet implementation class AddAdmin
 */
@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAdmin() {
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
			jObj = new JSONObject(sb.toString());
			AdminDAO sdao = new AdminDAO();
			Admin admin = new Admin();
			admin.setId(Integer.parseInt(jObj.getString("id")));
			admin.setName(jObj.getString("name"));
			sdao.addAdmin(admin);
			send = "{\"alert\":'success'," + "\"msg\":'Added successfully.'}";
			jObj = new JSONObject(send);
		} catch (JSONException e) {
			e.printStackTrace();
			try {
				send = "{\"alert\":'danger'," + "\"msg\":'Required fields can not be empty.'}";
				jObj = new JSONObject(send);
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
