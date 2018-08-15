package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.AttendanceDAO;
import model.entity.Attendance;

/**
 * Servlet implementation class AddAttendance
 */
@WebServlet("/AddAttendance")
public class AddAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAttendance() {
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
		HttpSession session = request.getSession();
		List<Attendance> studentsList = (List<Attendance>) session.getAttribute("studentsList");
		AttendanceDAO adao=new AttendanceDAO();
		for(Attendance attendance: studentsList)
		{
			attendance.setStatus(request.getParameter("status"+attendance.getId()));
			System.out.println("SaveAttendance:"+attendance.getId()+"\t"+ attendance.getCode()+"\t"+attendance.getStatus());
			adao.updateAttendance(attendance.getId(), attendance.getCode(), attendance.getStatus());
		}
		response.sendRedirect("addFormAttendance.jsp");
	}

}
