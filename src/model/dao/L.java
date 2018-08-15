package model.dao;

public class L {
	int id;
	String name;
	int total;
	int present;
	int percent;

	public L() {
		super();
	}

	public L(int id, String name, int total, int present, int percent) {
		super();
		this.id = id;
		this.name = name;
		this.total = total;
		this.present = present;
		this.percent = percent;
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
		return "{id:" + id + ", name:'" + name + "', total:" + total + ", present:" + present + ", percent:" + percent
				+ "}";
	}
}