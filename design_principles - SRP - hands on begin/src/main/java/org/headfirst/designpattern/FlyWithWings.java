package org.headfirst.designpattern;

public class FlyWithWings implements FlyBehaviour {

	@Override
	public void fly() {
		System.out.println("I'm flying with wings!!");
	}

}

class FlyWithRocket implements FlyBehaviour {

	@Override
	public void fly() {
		System.out.println("I am rocket pwered fly");
	}

}
