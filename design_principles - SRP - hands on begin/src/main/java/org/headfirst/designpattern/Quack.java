package org.headfirst.designpattern;

class Quack implements QuackBehaviour {
	
	@Override
	public void quack() {
		System.out.println("<<Quack>>");
	}
}

class MuteQuack implements QuackBehaviour {
	public void quack() {
	System.out.println("<< Silence >>");
	}
}


class Squeak implements QuackBehaviour {
	public void quack() {
	System.out.println("<<Squeak>>");
	}
}