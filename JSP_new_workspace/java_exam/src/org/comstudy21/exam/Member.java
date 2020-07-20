package org.comstudy21.exam;

public class Member {
	public String name;
	public int age;
	public String phone;

	public Member(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + age + ", " + phone + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member tmp = (Member) obj;
			if (this.name.equals(tmp.name) && this.age == tmp.age && this.phone.equals(tmp.phone)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		final int number = 13;
		int hashCode = 1;

		hashCode = number * hashCode + ((name == null) ? 0 : name.hashCode());
		hashCode = number * hashCode + age;
		hashCode = number * hashCode + ((phone == null) ? 0 : phone.hashCode());

		return hashCode;
	}
}