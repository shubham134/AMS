package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.entity.Admin;
import model.entity.Student;
import model.entity.User;

public class StudentDAO extends MySession {
	UserDAO udao=new UserDAO();
	public List<Student> getAllStudents() {
		Session session=getSession();
		Criteria criteria=session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	public List<Integer> getAllIds() {
		Session session=getSession();
		Query query=session.createQuery("select s.id from Student s");
		List<Integer> ids=query.list();
		session.close();
		return ids;
	}
	public void addStudent(Student student) {
		student.setUid(udao.generateUid(student.getId(), student.getName(), "Student"));
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.persist(student);
		tran.commit();
		session.close();
	}
	public void modifyStudent(Student student) {
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.update(student);
		tran.commit();
		session.close();
	}
	public void removeStudent(int id) {
		Student student=findStudentById(id);
		User user=udao.findUserByUid(student.getUid());
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.delete(student);
		session.delete(user);
		tran.commit();
		session.close();
	}
	public Student findStudentById(int id) {
		Session session=getSession();
		Student student=(Student) session.get(Student.class, id);
		session.close();
		return student;
	}
	public Student findStudentByUid(String uid) {
		Session session=getSession();
		Query query=session.createQuery("select s from Student s where s.uid=:uid");
		query.setParameter("uid", uid);
		List<Student> students = query.list();
		Student student=null;
		if(students.size()==1)
			student=students.get(0);
		session.close();
		return student;
	}
	public static void main(String[] args) {

	}

}
