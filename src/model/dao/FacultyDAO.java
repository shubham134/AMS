package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entity.Admin;
import model.entity.Faculty;
import model.entity.User;

public class FacultyDAO extends MySession {
	UserDAO udao=new UserDAO();
	public List<Faculty> getAllFaculties() {
		Session session=getSession();
		Criteria criteria=session.createCriteria(Faculty.class);
		List<Faculty> faculties = criteria.list();
		session.close();
		return faculties;
	}
	public List<Integer> getAllIds() {
		Session session=getSession();
		Query query=session.createQuery("select f.id from Faculty f");
		List<Integer> ids=query.list();
		session.close();
		return ids;
	}
	public void addFaculty(Faculty faculty) {
		faculty.setUid(udao.generateUid(faculty.getId(), faculty.getName(), "Faculty"));
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.persist(faculty);
		tran.commit();
		session.close();
	}
	public void modifyFaculty(Faculty faculty) {
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.update(faculty);
		tran.commit();
		session.close();
	}
	public void removeFaculty(int id) {
		Faculty faculty=findFacultyById(id);
		User user=udao.findUserByUid(faculty.getUid());
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.delete(faculty);
		session.delete(user);
		tran.commit();
		session.close();
	}
	public Faculty findFacultyById(int id) {
		Session session=getSession();
		Faculty faculty=(Faculty) session.get(Faculty.class, id);
		session.close();
		return faculty;
	}
	public Faculty findFacultyByUid(String uid) {
		Session session=getSession();
		Query query=session.createQuery("select f from Faculty f where f.uid=:uid");
		query.setParameter("uid", uid);
		List<Faculty> faculties = query.list();
		Faculty faculty=null;
		if(faculties.size()==1)
			faculty=faculties.get(0);
		session.close();
		return faculty;
	}
	public static void main(String[] args) {

	}

}