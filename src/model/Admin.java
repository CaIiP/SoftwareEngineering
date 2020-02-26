package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	Staff staff;
	ArrayList<Staff> selectedStaff = new ArrayList<>();
	
	public Admin()	{
		
	}
	//method to select staff for a role
	public void selectStaff(Staff staff)	{
		System.out.println(staff.getStaff());
		Scanner s = new Scanner(System.in);
		String input = "";
		input = s.nextLine();
		if(input.equals("1"))	{
			this.selectedStaff.add(staff);
		}
		if(input.equals("2"))	{
			selectStaff(staff);
			
			
		}
	}
}
