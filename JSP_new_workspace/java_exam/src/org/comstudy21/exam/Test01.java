package org.comstudy21.exam;

import java.util.Calendar;

public class Test01 {

	public static void main(String[] args) {
		int year = 1995;
		int age = 25;
		
		Calendar date = Calendar.getInstance();
		int postAge = date.getWeekYear() - year;
		System.out.println("계산한 나이 : "+ "만"+postAge + "세");
		System.out.println("현재 나이 : "+ "만"+age + "세");
	}

}
