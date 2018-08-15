package model.dao;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;

import model.entity.Admin;
import model.entity.Attendance;
import model.entity.Faculty;
import model.entity.Student;
import model.entity.Subject;
import model.entity.User;

public class MySession {
	public Session getSession() {
		AnnotationConfiguration con = new AnnotationConfiguration();
		con.addAnnotatedClass(Admin.class);
		con.addAnnotatedClass(Faculty.class);
		con.addAnnotatedClass(Student.class);
		con.addAnnotatedClass(User.class);
		con.addAnnotatedClass(Attendance.class);
		con.addAnnotatedClass(Subject.class);
		con.configure("hibernate.cfg.xml");
		return con.buildSessionFactory().openSession();
	}
}
