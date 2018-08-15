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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        JSONObject jObj=null;
        User user=null;
		String userType=null;
		String userUid=null;
		String send=null;
        String page=null;
        HttpSession session=request.getSession();
        try {
			jObj=new JSONObject(sb.toString());
			String uname=jObj.getString("uname");
			String pwd=jObj.getString("pwd");
			UserDAO udao=new UserDAO();
			if(!uname.equals("")||!pwd.equals(""))
				user=udao.findUserByLogin(uname,pwd);
			if(user!=null) {
				userType=user.getType();
				userUid=user.getUid();
				System.out.println("Login successful:"+userType+":"+userUid);
				if(userType.equalsIgnoreCase("admin"))
					page="homeAdmin.jsp";
				else if(userType.equalsIgnoreCase("faculty"))
					page="homeFaculty.jsp";
				else if(userType.equalsIgnoreCase("student"))
					page="homeStudent.jsp";
				send="{\"alert\":'success',"
						+ "\"msg\":'Login successful.',"
						+ "\"page\":'"+page+"'}";
				jObj=new JSONObject(send);
			}
			else {
				System.out.println("Invalid login");
				send="{\"alert\":'danger',"
						+ "\"msg\":'Invalid username and password.'}";
				jObj=new JSONObject(send);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			try {
				jObj = new JSONObject("{\"alert\":'danger',"
						+ "\"msg\":'Required fields can not be empty'}");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
        session.setAttribute("userType", userType);
		session.setAttribute("userUid", userUid);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    out.print(jObj);
	    out.flush();
	}
}