package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.AttendanceDAO;
import model.entity.Attendance;
import model.entity.Student;

/**
 * Servlet implementation class AddAttendanceForm
 */
@WebServlet("/AddAttendanceForm")
public class AddAttendanceForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAttendanceForm() {
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
		String branch = request.getParameter("branch");
		String section = request.getParameter("section");
		String code = request.getParameter("code");
		AttendanceDAO adao = new AttendanceDAO();
		List<Student> students = adao.getStudentListForAttendance(branch, section);
		HttpSession session = request.getSession();
		List<Attendance> studentsList = new ArrayList<>();
		for (Student student : students) {
			Attendance attendance=new Attendance(student.getId(), code, "P", student.getName());
			studentsList.add(attendance);
		}
		session.setAttribute("studentsList", studentsList);
		session.setAttribute("branch", branch);
		session.setAttribute("section", section);
		response.sendRedirect("addAttendance.jsp");
	}
}