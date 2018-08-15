package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {
	@Id
	@Column
	private int id;
	@Column(nullable=false,updatable=true)
	private String name;
	@Column(nullable=false,updatable=false)
	private String code;
	@Column
	private String uid;
	
	public Faculty() {
		super();
	}
	public Faculty(int id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "{id:" + id + ", name:'" + name + "', code:'" + code + "', uid:'" + uid + "'}";
	}
	
}
