package org.comstudy21.model;

public class Person {
	private String userName;
	private String userAddr;
	private int age;

	public Person() {
		userName = "";
		userAddr = "";
		age = 0;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "[" + userName + ", " + userAddr + ", " + age + "]";
	}

	public Person(String userName, String userAddr, int age) {
		this.userName = userName;
		this.userAddr = userAddr;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((userAddr == null) ? 0 : userAddr.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (userAddr == null) {
			if (other.userAddr != null)
				return false;
		} else if (!userAddr.equals(other.userAddr))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
