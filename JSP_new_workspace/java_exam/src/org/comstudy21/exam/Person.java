package org.comstudy21.exam;

public class Person {
	String 예금주;
	String 계좌번호;
	int 잔액;
	public Person() {
		예금주 = null;
		계좌번호 = null;
		잔액 = 0;
	}
	
	public Person(String 예금주, String 계좌번호, int 잔액) {
		this.예금주 = 예금주;
		this.계좌번호 = 계좌번호;
		this.잔액 = 잔액;
	}

	@Override
	public String toString() {
		return "예금주:" + 예금주 + ", 계좌번호:" + 계좌번호 + ", 잔액:" + 잔액 + "원";
	}
	public String 입금(int money){
		잔액 += money;
		return "남은 잔액 : " + 잔액;
	}
	public String 출금(int money){
		if(잔액<money){
			return "잔액이 부족합니다";
		}else{
			return "남은 잔액 : " + 잔액;
		}
	}
	public static void main(String[] args) {
		Person p = new Person("자바맨", "123-456",10000);
		
		System.out.println(p.입금(15000));
		System.out.println(p.출금(30000));
	}
}
