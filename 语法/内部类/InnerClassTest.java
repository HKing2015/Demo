package com.tests;

public class InnerClassTest {
	private static Integer num;
	
	public InnerClassTest() {};
	public InnerClassTest(Integer num) {
		this.num = num;
	}
	
	public void show(Fuck fuck) {
		String str = "you";
		fuck.fuckAll(str);
	}
	
	public static void main(String[] args) {
		Fuck hehe = new Fuck("everyone") {
			public void fuckAll(String opposite) {
				System.out.println(getName() + "fuck" + opposite);
			}
		};
		
		InnerClassTest inner = new InnerClassTest();
		inner.show(hehe);
	}
}


abstract class Fuck {
	private String name;
	
	public Fuck() {};
	public Fuck(String name) {
		this.name = name;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void fuckAll(String opposite) {};
}