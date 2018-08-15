package model.entity;

import javax.persistence.*;

@Entity
@Table(name="subject")	
public class Subject {
	@Id
	@Column
	private String code;
	@Column(nullable=false)
	private String name;
	public Subject() {
		super();
	}
	public Subject(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "{code:'" + code + "', name:'" + name + "'}";
	}
	
}