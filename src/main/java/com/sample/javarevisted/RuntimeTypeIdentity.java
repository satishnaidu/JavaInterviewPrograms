package com.poc.javarevisted;

public class RuntimeTypeIdentity {

	public static void main(String[] args) {

		Rule simpleRule = new BusinessRule();
		if (simpleRule instanceof Rule) {
			System.out.println("System rule is instance of Rule");
		}

		if (simpleRule instanceof BusinessRule) {
			System.out.println("System rule is instance of BusinessRule");
		}
		if (simpleRule instanceof SystemRule) {
			System.out.println("System rule is instance of SystemRule");
		}
		// determining type of object in Java using getClass() method
		System.out.println("Checking type of object in Java using  getClass() ==>");

		if (simpleRule.getClass() == Rule.class) {
			System.out.println("System rule is instance of Rule");
		}

		if (simpleRule.getClass() == SystemRule.class) {
			System.out.println("System rule is instance of SystemRule");
		}

		// determining type of object in Java using isInstance() method
		// isInstance() is similar to instanceof operator and returns true even
		// if object belongs to sub class.
		System.out.println("Checking type of object in Java using  isInstance() ==>");

		if (Rule.class.isInstance(simpleRule)) {
			System.out.println("SystemRule is instance of Rule");
		}
	}
}

class Rule {
	public void process() {
		System.out.println("process method of Rule");
	}
}

class SystemRule extends Rule {

	@Override
	public void process() {
		System.out.println("process method of SystemRule class");
	}
}

class BusinessRule extends Rule {

	@Override
	public void process() {
		System.out.println("process method of Business Rule class");
	}
}
