package org.headfirst.designpattern;

public abstract class Duck {

	protected FlyBehaviour flyBehaviour;
	protected QuackBehaviour quackBehaviour;
	
	public Duck() {

	}
	
	public abstract void display();
	
	public void performFly() {
		flyBehaviour.fly();
	}
	
	public void performQuack() {
		quackBehaviour.quack();
	}
	
	public void setQuackBehaviour(QuackBehaviour qb) {
		this.quackBehaviour = qb;
	}
	
	public void setFlyBehaviour(FlyBehaviour fb) {
		this.flyBehaviour = fb;
	}
	
	public void swim() {
		System.out.println("All Duck Swim");
	}
	
}
