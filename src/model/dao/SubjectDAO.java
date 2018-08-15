package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entity.Student;
import model.entity.Subject;

public class SubjectDAO extends MySession {
	public List<Subject> getAllSubjects() {
		Session session=getSession();
		Criteria criteria=session.createCriteria(Subject.class);
		List<Subject> subjects=criteria.list();
		session.close();
		return subjects;
	}
	public List<String> getAllCodes() {
		Session session=getSession();
		Query query=session.createQuery("select s.id from Subject s");
		List<String> codes=query.list();
		session.close();
		return codes;
	}
	public void addSubject(Subject subject) {
		subject.setCode(subject.getCode().toUpperCase());
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.persist(subject);
		tran.commit();
		session.close();
	}
	public void modifySubject(Subject subject) {
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.update(subject);
		tran.commit();
		session.close();
	}
	public void removeSubject(int code) {
		Subject subject=findSubjectByCode(code);
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.delete(subject);
		tran.commit();
		session.close();
	}
	public Subject findSubjectByCode(int code) {
		Session session=getSession();
		Subject subject=(Subject) session.get(Subject.class, code);
		session.close();
		return subject;
	}
	public static void main(String[] args) {
		/*SubjectDAO d=new SubjectDAO();
		System.out.println(d.getAllSubjects());*/
	}
}
