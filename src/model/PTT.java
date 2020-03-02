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
	private Loader l;

	public static void readFile(String file) throws FileNotFoundException, IOException {
		String read;
		FileReader f = new FileReader(file);
		BufferedReader b = new BufferedReader(f);
		int count = 0;
		BufferedWriter bw = null;
		FileWriter fw = null;
		File files = new File(file);
		if (!files.exists()) {
			files.createNewFile();
		}
		fw = new FileWriter(files.getAbsoluteFile(), true);
		bw = new BufferedWriter(fw);
		bw.write("\nPTT Director Decision:\n");
		int decision = 0;
		while ((read = b.readLine()) != null) {

			if ("Training Accepted".equals(read) || "Training Rejected".equals(read)) {
				if (decision != 1) {
					System.out.println(read);
					bw.write(read + "\n");
				}
			} else {
				System.out.println(read);
				bw.write(read + "\n");
			}

			if ("YES".equals(read)) {
				System.out.println("Press 1 to approve or 2 to decline");
				Scanner s = new Scanner(System.in);
				String input = "";
				input = s.nextLine();
				switch (input) {
				case "1":
					System.out.println("Accepted by PTT Director");
					bw.write("\nAccepted by PTT Director\n");
					decision = 0;
					break;
				case "2":
					System.out.println("Not Accepted by PTT Director");
					bw.write("\nNot Accepted by PTT Director\n");
					decision = 1;
					break;
				default:
					System.out.println("You must select a value of either 1 or 2");
					// staffScanner(i, st, r,bw,l);
					break;
				}
			}

			if ("Training Accepted".equals(read)) {
				if (decision != 1) {
					System.out.println("Press 1 to approve or 2 to decline training");
					Scanner s = new Scanner(System.in);
					String input = "";
					input = s.nextLine();
					switch (input) {
					case "1":
						System.out.println("Training Accepted by PTT Director");
						bw.write("\nTraining Accepted by PTT Director\n");
						break;
					case "2":
						System.out.println("Not Accepted Training by PTT Director");
						bw.write("\nNot Accepted Training by PTT Director\n");
						break;
					default:
						System.out.println("You must select a value of either 1 or 2");
						// staffScanner(i, st, r,bw,l);
						break;
					}
				} else {
					System.out.println("Not Accepted Training by PTT because the candidate was not accepted");
					bw.write("\nNot Accepted Training by PTT because the candidate was not accepted\n");
				}
			}
			count++;
		}
		bw.close();
		b.close();
	}

	public void runPTT() throws IOException {
		readFile("filename.txt");
	}

}

