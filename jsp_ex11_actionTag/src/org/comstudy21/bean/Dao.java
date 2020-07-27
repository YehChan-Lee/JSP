package org.comstudy21.bean;

import java.util.ArrayList;

public class Dao {
	ArrayList<Bean> list = new ArrayList<>();
	
	public void insertMember(Bean b){
		String name = b.getName();
		String age = b.getAge();
		String height = b.getHeight();
		Bean p = new Bean();
		p.setName(name);
		p.setAge(age);
		p.setHeight(height);
		list.add(p);
	}
	public ArrayList<Bean> showMember(){
		return list;
	}
}
