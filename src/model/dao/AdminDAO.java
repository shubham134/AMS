package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entity.Admin;
import model.entity.User;

public class AdminDAO extends MySession {
	UserDAO udao = new UserDAO();

	public List<Admin> getAllAdmins() {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Admin.class);
		List<Admin> admins = criteria.list();
		session.close();
		return admins;
	}

	public List<Integer> getAllIds() {
		Session session = getSession();
		Query query = session.createQuery("select a.id from Admin a");
		List<Integer> ids = query.list();
		session.close();
		return ids;
	}

	public void addAdmin(Admin admin) {
		admin.setUid(udao.generateUid(admin.getId(), admin.getName(), "Admin"));
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		session.persist(admin);
		tran.commit();
		session.close();
	}

	public void modifyAdmin(Admin admin) {
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		session.update(admin);
		tran.commit();
		session.close();
	}

	public void removeAdmin(int id) {
		Admin admin = findAdminById(id);
		User user = udao.findUserByUid(admin.getUid());
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		session.delete(admin);
		session.delete(user);
		tran.commit();
		session.close();
	}

	public Admin findAdminById(int id) {
		Session session = getSession();
		Admin admin = (Admin) session.get(Admin.class, id);
		session.close();
		return admin;
	}

	public Admin findAdminByUid(String uid) {
		Session session = getSession();
		Query query = session.createQuery("select a from Admin a where a.uid=:uid");
		query.setParameter("uid", uid);
		List<Admin> admins = query.list();
		Admin admin = null;
		if (admins.size() == 1)
			admin = admins.get(0);
		session.close();
		return admin;
	}

	public int createFirstAdmin() {
		int status = 0;
		Session session = getSession();
		AdminDAO adao = new AdminDAO();
		Admin admin = adao.findAdminById(1111);
		if (admin == null) {
			admin = new Admin();
			admin.setId(1111);
			admin.setName("admin");
			adao.addAdmin(admin);
			admin = adao.findAdminById(1111);
			String uid = admin.getUid();
			UserDAO udao = new UserDAO();
			User user = udao.findUserByUid(uid);
			user.setPwd("111");
			udao.modifyUser(user);
			return 1;
		}
		return status;
	}

	public static void main(String[] args) {
		AdminDAO adao = new AdminDAO();
		Admin admin = new Admin(123, "Shubham Chaurasia");
		adao.addAdmin(admin);
	}

}
