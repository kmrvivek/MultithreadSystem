package org.headfirst.designpattern;

public class MallardDuck extends Duck {

	public MallardDuck() {
		flyBehaviour = new FlyWithWings();
		quackBehaviour = new Quack();	
	}
	
	@Override
	public void display() {
		System.out.println("I'm mallard duck. Beautiful duck");
	}

}

class DuffyDuck extends Duck {

	public DuffyDuck() {
		flyBehaviour = new FlyNoWay();
		quackBehaviour = new Squeak();	
	}
	
	@Override
	public void display() {
		System.out.println("I'm Duffy duck. Beautiful duck");
	}

}
