package model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int entry;
	@Column
	private Date date;
	@Column
	private int id;
	@Column
	private String code;
	@Column
	private String status;
	@Transient
	private String name;
	@Transient
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public Attendance() {
		super();
	}

	public Attendance(int id, String code, String status) {
		super();
		this.id = id;
		this.code = code;
		this.status = status;
	}
	
	public Attendance(int id, String code, String status, String name) {
		super();
		this.id = id;
		this.code = code;
		this.status = status;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEntry() {
		return entry;
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

	public void setEntry(int entry) {
		this.entry = entry;
	}

	public String getDate() {
		return sdf.format(date);
	}

	public void setDate(String date) {
		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "{entry:" + entry + ", date:'" + date + "', id:" + id + ", code:'" + code + "', status:'" + status
				+ "', name:'" + name + "'}";
	}

}
