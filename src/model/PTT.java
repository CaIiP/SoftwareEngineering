package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;

public class PTT {


	public static void readFile(String file) throws FileNotFoundException, IOException {// loading file to be approved by admin
		String read;
		FileReader fileReader = new FileReader(file);
		BufferedReader b = new BufferedReader(fileReader);
		int count = 0;
		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;
		File files = new File(file);
		if (!files.exists()) {
			files.createNewFile();
		}
		fileWriter = new FileWriter(files.getAbsoluteFile(), true);
		bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("\nPTT Director Decision:\n");//Director decisions
		int decision = 0;
		while ((read = b.readLine()) != null) {// when txt file is not empty run

			if ("Training Accepted".equals(read) || "Training Rejected".equals(read)) {// training accepted or rejected by admin for staff
				if (decision != 1) {
					System.out.println(read);
					bufferedWriter.write(read + "\n");
				}
			} else {
				System.out.println(read);
				bufferedWriter.write(read + "\n");
			}

			if ("YES".equals(read)) {// accepted by admin ask director to approve or reject
				System.out.println("Press 1 to approve or 2 to decline");
				Scanner scanner = new Scanner(System.in);
				String input = "";
				input = scanner.nextLine();
				switch (input) {
				case "1"://accepted by director
					System.out.println("Accepted by PTT Director");
					bufferedWriter.write("\nAccepted by PTT Director\n");
					decision = 0;
					break;
				case "2"://rejected by director
					System.out.println("Not Accepted by PTT Director");
					bufferedWriter.write("\nNot Accepted by PTT Director\n");
					decision = 1;
					break;
				default:
					System.out.println("You must select a value of either 1 or 2");
					
					break;
				}
			}

			if ("Training Accepted".equals(read)) {// if staff accepted by training by admin ask director to approve or reject training
				if (decision != 1) {//if director has approved candidate for job and they are accepted by admin for training. ask director to approve or reject it.
					System.out.println("Press 1 to approve or 2 to decline training");
					Scanner scanner = new Scanner(System.in);
					String input = "";
					input = scanner.nextLine();
					switch (input) {
					case "1":
						System.out.println("Training Accepted by PTT Director");// if director accepted training
						bufferedWriter.write("\nTraining Accepted by PTT Director\n");
						break;
					case "2":
						System.out.println("Not Accepted Training by PTT Director");// if director rejected training
						bufferedWriter.write("\nNot Accepted Training by PTT Director\n");
						break;
					default:
						System.out.println("You must select a value of either 1 or 2");
						// staffScanner(i, st, r,bw,l);
						break;
					}
				} else {// if director rejects staff.
					System.out.println("Not Accepted Training by PTT because the candidate was not accepted");
					bufferedWriter.write("\nNot Accepted Training by PTT because the candidate was not accepted\n");
				}
			}
			count++;
		}
		bufferedWriter.close();
		b.close();
	}

	public void runPTT() throws IOException {
		readFile("filename.txt");
	}

}

