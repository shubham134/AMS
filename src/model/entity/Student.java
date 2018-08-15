package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column
	private int id;
	@Column(nullable=false,updatable=true)
	private String name;
	@Column(nullable=false,updatable=false)
	private String branch;
	@Column(nullable=false,updatable=false)
	private String section;
	@Column
	private String uid;
	//@Column
	//private byte[] photo;
	public Student() {
		super();
	}
	public Student(int id, String name, String branch, String section) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.section = section;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	/*public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	*/
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "{id:" + id + ", name:'" + name + "', branch:'" + branch + "', section:'" + section + "', uid:'" + uid
				+ "'}";
	}
	
}
