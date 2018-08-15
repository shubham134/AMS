package model.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entity.Attendance;
import model.entity.Student;
import model.entity.Subject;

public class AttendanceDAO extends MySession {
	public void updateAttendance(int id, String code, String status) {
		Attendance attendance = new Attendance(id, code, status);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		attendance.setDate(sdf.format(new Date()));
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		session.persist(attendance);
		tran.commit();
		session.close();
	}

	public List<Student> getStudentListForAttendance(String branch, String section) {
		Session session = getSession();
		Query query = session.createQuery("select s from Student s where s.branch=:branch and s.section=:section");
		query.setParameter("branch", branch);
		query.setParameter("section", section);
		List<Student> students = query.list();
		return students;
	}

	public List<L> showAttendance(String code, String branch, String section) {
		Session session = getSession();
		Query query1 = session.createQuery("select s from Student s where s.branch=:branch and s.section=:section");
		query1.setParameter("branch", branch);
		query1.setParameter("section", section);
		Query query2 = session.createQuery("select a from Attendance a where a.code=:code");
		query2.setParameter("code", code);
		List<Student> students = query1.list();
		List<Attendance> attendanceList = query2.list();
		// code
		List<L> list = new ArrayList<L>();
		for (Student student : students) {
			int present = 0;
			int total = 0;
			L l = new L();
			l.setId(student.getId());
			l.setName(student.getName());
			for (Attendance attendance : attendanceList) {
				if (attendance.getId() == l.getId()) {
					total++;
					if (attendance.getStatus().equalsIgnoreCase("P"))
						present++;
				}
			}
			l.setPresent(present);
			l.setTotal(total);
			l.setPercent(present, total);
			list.add(l);
		}
		return list;
	}

	public List<L2> showAttendanceOfStudent(int id) {
		Session session = getSession();
		Query query1 = session.createQuery("select s from Subject s");
		Query query2 = session.createQuery("select a from Attendance a where a.id=:id");
		query2.setParameter("id", id);
		List<Subject> subjects = query1.list();
		List<Attendance> attendanceList = query2.list();
		// code
		List<L2> list = new ArrayList<L2>();
		for (Subject subject : subjects) {
			int present = 0;
			int total = 0;
			L2 l2 = new L2();
			l2.setCode(subject.getCode());
			for (Attendance attendance : attendanceList) {
				if (attendance.getCode().equalsIgnoreCase(l2.getCode())) {
					total++;
					if (attendance.getStatus().equalsIgnoreCase("P"))
						present++;
				}
			}
			if (total != 0) {
				l2.setName(subject.getName());
				l2.setPresent(present);
				l2.setTotal(total);
				l2.setPercent(present, total);
				list.add(l2);
			}
		}
		return list;
	}

	/*
	 * public List<L> showAttendance(String code, String branch, String section) {
	 * String queryString = ""; queryString += "select s.id as id, s.name as name ";
	 * queryString += "from Student s, Attendance a "; queryString +=
	 * "inner join s.id sd "; queryString += "inner join a.id ad "; queryString +=
	 * "where sd = ad "; queryString += "and a.code =:code "; queryString +=
	 * "and s.branch =:branch "; queryString += "and s.section =:section";
	 * //queryString += "group by s.id "; Session session = getSession(); Query
	 * query = session.createQuery(queryString); query.setParameter("code", code);
	 * query.setParameter("branch", branch); query.setParameter("section", section);
	 * return query.list(); }
	 */

	public static void main(String[] args) {
		AttendanceDAO adao = new AttendanceDAO();
		System.out.println(adao.showAttendanceOfStudent(1514310200));
	}

}