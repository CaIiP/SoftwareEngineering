package view;

import java.util.Scanner;

import model.Requirements;
import model.Staff;

public class View {
	private Requirements r;
	private Staff s;

	public void run()	{
		mainMenu();
		Scanner s = new Scanner(System.in);
		String input = "";
		input = s.nextLine();
		if(input.equals("1"))	{
			pttView();	//call PTT Director view
		}
		if(input.equals("2"))	{
			//			adminView();	//call Administrator view
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
		System.out.println("PTT works");
	}

	public void adminView(Requirements r)	{
		System.out.println("For position " + r.getRole());
		System.out.println("The requirements are: Degree Level - " + r.getEdLvl() + " Specialistion - " + r.getDepartment());
		System.out.println("Candidates will be displayed individually. Please accept by pressing 1, or reject by pressing 2");
		//call Admin method selectStaff - under construction

	}

	public void cdView()	{
		System.out.println("CD works");
	}

}