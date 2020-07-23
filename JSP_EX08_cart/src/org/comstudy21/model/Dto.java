package org.comstudy21.model;

public class Dto {
	int no;
	String name = null;
	String company = null;
	int year;
	
	public Dto() {}

	public Dto(int no, String name, String company, int year) {
		this.no = no;
		this.name = name;
		this.company = company;
		this.year = year;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "[" + no + ", " + name + ", " + company + ", " + year + "]";
	}
	
	
}
