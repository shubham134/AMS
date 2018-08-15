package model.dao;

public class L2 {
	String code;
	String name;
	int total;
	int present;
	int percent;

	public L2() {
		super();
	}

	public L2(String code, String name, int total, int present, int percent) {
		super();
		this.code = code;
		this.name = name;
		this.total = total;
		this.present = present;
		this.percent = percent;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPresent() {
		return present;
	}

	public void setPresent(int present) {
		this.present = present;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int present, int total) {
		try {
			this.percent = (present * 100) / total;
		} catch (ArithmeticException e) {
			this.percent = 0;
		}
	}

	@Override
	public String toString() {
		return "{code:'" + code + "',name:'" + name + "', total:" + total + ", present:" + present + ", percent:"
				+ percent + "}";
	}
}