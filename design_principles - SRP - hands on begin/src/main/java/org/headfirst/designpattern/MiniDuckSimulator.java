package org.headfirst.designpattern;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		Duck d = new MallardDuck();
		d.performFly();
		d.display();
		d.performQuack();
		d.swim();
		System.out.println();
		d = new DuffyDuck();
		d.performFly();
		d.setFlyBehaviour(new FlyWithRocket());
		d.performFly();
		d.display();
		d.performQuack();
		d.swim();
	}

}
