package model.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column
	private String uid;
	@Column
	private String pwd;
	@Column
	private String uname;
	@Column
	private String type;
	public User() {
		super();
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", type=" + type + "]";
	}
	
}
