package com.sample.hackerrank.cons;

public class Animal {
	private boolean herbival;
	private String speak;

	public Animal(boolean h, String s) {
		this.herbival = h;
		this.speak = s;
	}

	public void makeSound() {
		System.out.println(herbival+" makes sound "+speak);
	}
	
	public static void main(String[] args) {
		Animal a = new Dog(true,"Dog");
		a.makeSound();
		Animal b = new Dear(false,"Duck");
		b.makeSound();
	}
}
