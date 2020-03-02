package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Admin {

	private Loader l;

	// method to select staff for a role
	public void adminRun(Loader l) {
		String route = "filename.txt";
		try {
			File file = new File(route);

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			l.load();
			System.out.println(
					"Here are the teaching positions that need to be filled, please review and assign appropriate candidates;");
			int count = 0;
			for (int i = 0; i < l.getReqList().size(); i++) {

				System.out.println("For position " + l.toStringReqs(i));
				if (count == 0) {
					bw.write(l.toStringReqs(i));
				} else {
					bw.write("\n" + l.toStringReqs(i));
				}
				staffCycle(l, i, bw);
				System.out.println("Job Confirmed:");
				System.out.println(l.print(i));
				System.out.println("Training Confirmed:");
				System.out.println(l.printTraining(i));
				count++;
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void staffCycle(Loader l, int reqindex, BufferedWriter bw) throws IOException {
		int i;
		for (i = 0; i < l.getStaffList().size(); i++) {
			System.out.println(
					"Candidates will be displayed individually. Please accept by pressing 1, or reject by pressing 2");
			Staff st = l.getStaff(i);
			Requirements r = l.getRequirement(reqindex);
			System.out.println(l.toStringStaff(i));
			staffScanner(i, st, r, bw, l);
		}
	}

	private void staffScanner(int i, Staff st, Requirements r, BufferedWriter bw, Loader l) throws IOException {
		Scanner s = new Scanner(System.in);
		String input = "";
		input = s.nextLine();
		switch (input) {
		case "1":
			r.addStaff(st);
			System.out.println("YES");
			System.out.println("Does Candidate require training. Please accept by pressing 1, or reject by pressing 2");
			bw.write(l.toStringStaff(i));
			bw.write("YES\n");
			training(st, r, bw);

			break;
		case "2":
			System.out.println("NO");
			break;
		default:
			System.out.println("You must select a value of either 1 or 2");
			staffScanner(i, st, r, bw, l);
			break;
		}
	}

	private void training(Staff st, Requirements r, BufferedWriter bw) throws IOException {
		Scanner s = new Scanner(System.in);
		String input = "";
		input = s.nextLine();
		switch (input) {
		case "1":
			r.addTraining(st);
			System.out.println("Training Accepted");
			bw.write("Training Accepted\n");
			break;
		case "2":
			System.out.println("Training Rejected");
			bw.write("Training Rejected\n");
			break;
		default:
			System.out.println("You must select a value of either 1 or 2");
			training(st, r, bw);
			break;
		}
	}
}
