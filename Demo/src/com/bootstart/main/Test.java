package com.bootstart.main;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo f = new Foo();
		f.setI(50);
		System.out.println(f.getI());
		compare(f);
		System.out.println(f.getI());
	}
	
	static void compare(Foo f) {
		f.setI(100);
		System.out.println("From Compare1 : "+ f.getI());
		f = new Foo();
		f.setI(300);
		System.out.println("From Compare2 : "+ f.getI());
	}

}

class Foo{
	int i;
	public void setI(int i) {
		this.i= i;
	}
	public int getI() {
		// TODO Auto-generated method stub
		return i;
	}
}
