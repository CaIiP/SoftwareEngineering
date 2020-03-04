package model;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Admin {

	// method to select staff for a job and write to file
	public void adminRun(Loader loader) {
		String route = "filename.txt";
		try {
			File file = new File(route);

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			loader.load();
			System.out.println(
					"Here are the teaching positions that need to be filled, please review and assign appropriate candidates:\n");
			int count = 0;
			// Cycle through requirements
			for (int i = 0; i < loader.getRequirementsList().size(); i++) {
				// prints job title and requirements
				System.out.print(loader.getRequirement(i).toStringJob());
				System.out.println(loader.getRequirement(i).toStringJobRequirments());
				if (count == 0) {
					// writes to text file
					// start of text file ( first requirement print conditions )
					bufferedWriter.write(loader.getRequirement(i).toStringJob());
					bufferedWriter.write(loader.getRequirement(i).toStringJobRequirments() + "Applicants: " + "\n");
				} else {
					// reest of text file print conditions
					bufferedWriter.write("------------------------------------------------------\n"
							+ loader.getRequirement(i).toStringJob());
					bufferedWriter.write(loader.getRequirement(i).toStringJobRequirments() + "Applicants: " + "\n");
				}
				// Initiates cycling through staff
				staffCycle(loader, i, bufferedWriter);
				// Summarises staff selected for each job
				System.out.println("------------------------------------------------------\nApplicants Confirmed:");
				if (loader.getRequirement(i).getAllocatedStaff().isEmpty()) {
					System.out.println("\nNo applicants selected for this Position\n");
					bufferedWriter.write("\nNo applicants selected for this Position\n");
					System.out.println("------------------------------------------------------\n");
				} else {
					System.out.println(loader.toStringAllocatedStaff(i));
					System.out.println(
							"------------------------------------------------------\nTraining Confirmed for the Following Applicants:");
					System.out.println(loader.toStringAllocatedTraining(i));
					System.out.println("------------------------------------------------------\n");
				}
				count++;
			}
			bufferedWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// method to cycle through staff
	private void staffCycle(Loader loader, int requirementsIndex, BufferedWriter bufferedWriter) throws IOException {
		int staffIndex;
		for (staffIndex = 0; staffIndex < loader.getStaffList().size(); staffIndex++) {
			System.out.println(
					"Please accept by pressing 1, or reject by pressing 2 (candidates displayed individually)");
			Staff staff = loader.getStaff(staffIndex); // get specific staff
			Requirements requirements = loader.getRequirement(requirementsIndex); // get specific requirement
			System.out.println(loader.toStringStaff(staffIndex));
			staffScanner(staffIndex, staff, requirements, bufferedWriter, loader);
		}
	}

	// method to add or reject staff to job using scanner input
	private void staffScanner(int staffIndex, Staff staff, Requirements requirements, BufferedWriter bufferedWriter,
			Loader loader) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		input = scanner.nextLine();
		switch (input) {
		case "1":
			requirements.addStaff(staff);
			bufferedWriter.write(loader.toStringStaff(staffIndex));
			System.out.println("Applicant Approved by Admin");
			bufferedWriter.write("Applicant Approved by Admin\n");
			System.out.println("Does Candidate require training? Please accept by pressing 1, or reject by pressing 2");

			training(staff, requirements, bufferedWriter);
			bufferedWriter.write("\n");

			break;
		case "2":
			System.out.println("Applicant Rejected by Admin");
			break;
		default:
			System.out.println("You must select a value of either 1 or 2");
			staffScanner(staffIndex, staff, requirements, bufferedWriter, loader);
			break;
		}
	}

	// method to add or reject training used in staff scanner
	private void training(Staff staff, Requirements requirements, BufferedWriter bufferedWriter) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		input = scanner.nextLine();
		switch (input) {
		case "1": // add staff to training array
			requirements.addTraining(staff);
			System.out.println("Training Approved by Admin");
			bufferedWriter.write("Training Approved by Admin\n");
			break;
		case "2": // reject staff
			System.out.println("Training Rejected by Admin");
			bufferedWriter.write("Training Rejected by Admin\n");
			break;
		default:
			System.out.println("You must select a value of either 1 or 2");
			training(staff, requirements, bufferedWriter);
			break;
		}
	}
}
