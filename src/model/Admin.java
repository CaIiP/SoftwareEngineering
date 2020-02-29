package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	

	private Loader l;


	public Admin()	{

	}
	//method to select staff for a role



	public void adminRun(Loader l)	{
		
		l.load();
		System.out.println("Here are the teaching positions that need to be filled, please review and assign appropriate candidates;");
		for(int i=0; i<l.getReqList().size(); i++) {

			System.out.println("For position " +l.toStringReqs(i) );
			//	System.out.println("The requirements are: Degree Level - " + r.getEdLvl() + " Specialistion - " + r.getDepartment());
			//System.out.println("Candidates will be displayed individually. Please accept by pressing 1, or reject by pressing 2");
			//call Admin method selectStaff - under construction
			staffCycle(l, i);
			System.out.println("Job Confirmed:");
			System.out.println(l.print(i));
			System.out.println("Training Confirmed:");
			System.out.println(l.printTraining(i));
			//System.out.println(l.getRequirement(i).print());
			System.out.println("Made it");
		}
	}
	private void staffCycle(Loader l, int reqindex) {
		int i;
		for(i = 0; i<l.getStaffList().size(); i++)	{
			System.out.println("Candidates will be displayed individually. Please accept by pressing 1, or reject by pressing 2");
			Staff  st = l.getStaff(i);
			Requirements r = l.getRequirement(reqindex);
			System.out.println(l.toStringStaff1(i));
			staffScanner(i, st, r);
		}
	}

	private void staffScanner(int i, Staff st, Requirements r) {
		Scanner s = new Scanner(System.in); 
		String input = "";
		input = s.nextLine();
		switch (input) {
		case "1":
			r.addStaff(st);
			System.out.println("YES");
			System.out.println("Does Candidate reqiure training. Please accept by pressing 1, or reject by pressing 2");
			training(st, r);
			break;
		case "2":
			System.out.println("NO");
			break;
		default:
			System.out.println("You must select a value of either 1 or 2");
			staffScanner(i, st, r);
			break;
		}
	} 
	
	
	
	private void training(Staff st, Requirements r) {
		Scanner s = new Scanner(System.in); 
		String input = "";
		input = s.nextLine();
		switch (input) {
		case "1":
			r.addTraining(st);
			System.out.println("Training Accepted");
			break;
		case "2":
			System.out.println("Training Rejected");
			break;
		default:
			System.out.println("You must select a value of either 1 or 2");
			training(st, r);
			break;
		}
	}

	
}

