package view;

import java.util.Scanner;

import model.Admin;
import model.Loader;
import model.Requirements;
import model.Staff;

public class View {
	private Staff s;
	private Admin a;
	private Requirements r;

	public void run()	{
		mainMenu();
		Loader l = new Loader();
		a = new Admin();
		Scanner s = new Scanner(System.in);
		String input = "";
		input = s.nextLine();
		if(input.equals("1"))	{
			pttView();	//call PTT Director view
		}
		if(input.equals("2"))	{

			a.adminRun(l);
			System.out.println(a.toString());//call Administrator view


		}
		if(input.equals("3"))	{
			cdView();	//call Class Director view
		}
	}

	public void mainMenu()	{
		System.out.println("Please select user profile using corresponding number:");
		System.out.println("1. PTT Director");
		System.out.println("2. Administrator");
		System.out.println("3. Class Director");
		System.out.println("Enter number here;");
	}

	public void pttView()	{
		System.out.println("Here is a list of submissions from the administrator which require approval; ");
		//Call a method which prints out Approval objects
		System.out.println("Press 1 to approve or 2 to decline");
		//Call a method with scanner which performs this functionality
		System.out.println("No more submissions remaining, please press enter to write to main document.");
		//Call a method which write to allInfo.
		System.out.println("Approvals have been added, please press enter to return to main menu");
		//Call method which returns to main menu
	}

	public void adminView(Requirements r)	{
		System.out.println("Here are the teaching positions that need to be filled, please review and assign appropriate candidates;");
		
	//	System.out.println("For position " + );
		System.out.println("The requirements are: Degree Level - " + r.getEdLvl() + " Specialistion - " + r.getDepartment());
		System.out.println("Candidates will be displayed individually. Please accept by pressing 1, or reject by pressing 2");
		//call Admin method selectStaff - under construction
		//a.selectStaff(s);
		System.out.println("here");
		System.out.println(a.toString());
	}

	public void cdView()	{
		System.out.println("Once teaching requirements have been confirmed, press 1 to upload file");
		//method that calls a scanner and a read function for the file containing teaching requirements
	}
	
	public void adminScanner()	{
		
	}
	

}
