package model;


import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Admin {



	// method to select staff for a role
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
			System.out.println(	"Here are the teaching positions that need to be filled, please review and assign appropriate candidates;");
			int count = 0;
			for (int i = 0; i < loader.getRequirementsList().size(); i++) {

				System.out.println("For position " + loader.toStringRequirements(i));
				if (count == 0) {
					bufferedWriter.write(loader.toStringRequirements(i));
				} else {
					bufferedWriter.write("\n" + loader.toStringRequirements(i));
				}
				staffCycle(loader, i, bufferedWriter);
				System.out.println("Job Confirmed:");
				System.out.println(loader.toStringAllocatedStaff(i));
				System.out.println("Training Confirmed:");
				System.out.println(loader.toStringAllocatedTraining(i));
				count++;
			}
			bufferedWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void staffCycle(Loader loader, int requirementsIndex, BufferedWriter bufferedWriter) throws IOException {
		int staffIndex;
		for (staffIndex = 0; staffIndex < loader.getStaffList().size(); staffIndex++) {
			System.out.println(
					"Candidates will be displayed individually. Please accept by pressing 1, or reject by pressing 2");
			Staff staff = loader.getStaff(staffIndex);
			Requirements requirements = loader.getRequirement(requirementsIndex);
			System.out.println(loader.toStringStaff(staffIndex));
			staffScanner(staffIndex, staff, requirements, bufferedWriter, loader);
		}
	}

	private void staffScanner(int staffIndex, Staff staff, Requirements requirements, BufferedWriter bufferedWriter, Loader loader) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		input = scanner.nextLine();
		switch (input) {
		case "1":
			requirements.addStaff(staff);
			System.out.println("YES");
			System.out.println("Does Candidate require training. Please accept by pressing 1, or reject by pressing 2");
			bufferedWriter.write(loader.toStringStaff(staffIndex));
			bufferedWriter.write("YES\n");
			training(staff, requirements, bufferedWriter);

			break;
		case "2":
			System.out.println("NO");
			break;
		default:
			System.out.println("You must select a value of either 1 or 2");
			staffScanner(staffIndex, staff, requirements, bufferedWriter, loader);
			break;
		}
	}

	private void training(Staff staff, Requirements requirements, BufferedWriter bufferedWriter) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		input = scanner.nextLine();
		switch (input) {
		case "1":
			requirements.addTraining(staff);
			System.out.println("Training Accepted");
			bufferedWriter.write("Training Accepted\n");
			break;
		case "2":
			System.out.println("Training Rejected");
			bufferedWriter.write("Training Rejected\n");
			break;
		default:
			System.out.println("You must select a value of either 1 or 2");
			training(staff, requirements, bufferedWriter);
			break;
		}
	}
}
