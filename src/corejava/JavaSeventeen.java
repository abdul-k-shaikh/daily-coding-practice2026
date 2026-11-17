package corejava;

import module.Employee;

public class JavaSeventeen {
	
	/*
	 * java 17 feature-> record
	 * Why records?
	 * 
	 * Answer:
	 * 
	 * Records are immutable data carrier classes that reduce boilerplate code by
	 * automatically generating constructor, accessors, equals, hashCode and
	 * toString methods.
	 * 
	 * Used in REST APIs.
	 */
	public static void main(String[] args) {
		Employeee emp = new Employeee(1, "Abdul");
		System.out.println(emp.id());
		System.out.println(emp.name());
	}

	public record Employeee(int id, String name) {

	}
}
