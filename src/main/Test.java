package main;

import staff.Staff;
import requirements.Requirements;

public class Test {

	public static void main(String[] args) {
		Requirements requirements = new Requirements();
		requirements.loadStaff();
		System.out.println(requirements.toString());
	}
}
