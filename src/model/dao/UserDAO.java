package model.dao;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entity.Admin;
import model.entity.User;

public class UserDAO extends MySession {
	private String trim(String name) {
		String str="";
		int index=0;
		while(index<name.length()) {
			if(name.charAt(index)!=' ') {
				str+=name.charAt(index);
				index++;
			}
			else
				break;
		}
		return str;
	}
	private String generateUname(int id,String name) {
		String s=id+"";
		String uname=trim(name).toLowerCase()+s.substring(s.length()-3, s.length());
		return uname;
	}
	private String generatePwd(int length) throws NoSuchAlgorithmException {
		String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "@", "#", "$", "!"};
		Random random = SecureRandom.getInstanceStrong();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
		    int indexRandom = random.nextInt( symbols.length );
		    sb.append( symbols[indexRandom] );
		}
		String pwd = sb.toString();
		return pwd;
	}
	public User findUserByUid(String uid) {
		Session session=getSession();
		User user = (User) session.get(User.class, uid);
		session.close();
		return user;
	}
	public void modifyUser(User user) {
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.update(user);
		tran.commit();
		session.close();
	}
	public String generateUid(int id,String name,String type) {
		String uname=generateUname(id, name);
		String pwd="";
		String uid="";
		try {
			pwd = generatePwd(10);
			uid = generatePwd(15);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//set user
		User user=new User();
		user.setUid(uid);
		user.setUname(uname);
		user.setPwd(pwd);
		user.setType(type);
		//add user
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.persist(user);
		tran.commit();
		session.close();
		return uid;
	}
	public User findUserByLogin(String uname,String pwd) {
		Session session=getSession();
		Query query=session.createQuery("select u from User u where u.uname=:uname and u.pwd=:pwd");
		query.setParameter("uname", uname);
		query.setParameter("pwd", pwd);
		List<User> users=query.list();
		User user=null;
		if(users.size()==1)
			user = users.get(0);
		return user;
	}
}
