package org.comstudy21.exam;

import java.util.HashSet;

public class Test2 {
	public static void main(String[] args) {
		HashSet<Member> set = new HashSet<Member>();
		
		Member mem1 = new Member("손흥민",29,"11111-1111111");
		Member mem2 = new Member("손흥민",29,"11111-1111111");
		
		set.add(mem1);
		set.add(mem2);
		
		System.out.println("size : " + set.size());
		
		System.out.println("mem1 : " + mem1.hashCode());
		System.out.println("mem2 : " + mem2.hashCode());
		
		System.out.println("비교 : " + mem1.equals(mem2));
	}
}
