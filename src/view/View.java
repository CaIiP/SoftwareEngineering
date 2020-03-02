package view;

import java.io.IOException;
import java.util.Scanner;

import model.Admin;
import model.Loader;
import model.Requirements;
import model.Staff;
import model.PTT;

public class View {

	private Admin admin;
	

	public void run() throws IOException {
		mainMenu();
		Loader loader = new Loader();
		PTT ptt = new PTT();

		admin = new Admin();
		Scanner scanner = new Scanner(System.in);
		String input = "";
		input = scanner.nextLine();
		if (input.equals("1")) {
			pttView(ptt); // call PTT Director view
		}
		if (input.equals("2")) {
			admin.adminRun(loader);
		}
	}

	public void mainMenu() {
		System.out.println("Please select user profile using corresponding number:");
		System.out.println("1. PTT Director");
		System.out.println("2. Administrator");
		System.out.println("Enter number here;");
	}

	public void pttView(PTT ptt) throws IOException {
		System.out.println("Here is a list of submissions from the administrator which require approval: ");
		ptt.runPTT();


		System.out.println("No more submissions remaining");
	}

}
