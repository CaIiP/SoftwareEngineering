package view;

import java.io.IOException;
import java.util.Scanner;

import model.Admin;
import model.Loader;
import model.Requirements;
import model.Staff;
import model.PTT;

public class View {
	private Staff s;
	private Admin a;
	private Requirements r;
	private PTT p;

	public void run() throws IOException {
		mainMenu();
		Loader l = new Loader();
		PTT p = new PTT();

		a = new Admin();
		Scanner s = new Scanner(System.in);
		String input = "";
		input = s.nextLine();
		if (input.equals("1")) {
			pttView(p); // call PTT Director view
		}
		if (input.equals("2")) {
			a.adminRun(l);
		}
	}

	public void mainMenu() {
		System.out.println("Please select user profile using corresponding number:");
		System.out.println("1. PTT Director");
		System.out.println("2. Administrator");
		System.out.println("Enter number here;");
	}

	public void pttView(PTT p) throws IOException {
		System.out.println("Here is a list of submissions from the administrator which require approval; ");
		p.runPTT();

		// Call a method with scanner which performs this functionality
		System.out.println("No more submissions remaining, please press enter to write to main document.");
		// Call a method which write to allInfo.
		System.out.println("Approvals have been added, please press enter to return to main menu");
		// Call method which returns to main menu
	}

	public void adminView(Requirements r) {
		System.out.println(
				"Here are the teaching positions that need to be filled, please review and assign appropriate candidates;");
		System.out.println(
				"The requirements are: Degree Level - " + r.getEdLvl() + " Specialistion - " + r.getDepartment());
		System.out.println(
				"Candidates will be displayed individually. Please accept by pressing 1, or reject by pressing 2");
		System.out.println("here");
		System.out.println(a.toString());
	}
}
