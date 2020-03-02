package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Loader {
	private ArrayList<Staff> staffList;
	private ArrayList<Requirements> reqList;
	private Requirements r;
	private Staff s;

	// private int numOfStaff;
	private int numOfReqs;
	private String[] i;

	// constructor
	public Loader() {
		this.staffList = new ArrayList<Staff>();
		this.reqList = new ArrayList<Requirements>();
	}

	public boolean estaEnArray(int numero, String[] info) {
		return Arrays.asList(info).contains(numero);
	}

	public void load() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("allinfo.csv"));
			String read = null;
			while ((read = br.readLine()) != null) {
				String[] info = read.split(",");
				int size = info.length;
				this.staffList.add(new Staff(info[0], info[1], info[2], info[3], info[4], null));
				if (size > 6) {
					this.reqList.add(new Requirements((info[6]), info[7], info[8], info[9]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// toString for staffList array
	public String toStringStaff() {
		String results = "";
		for (Staff s : staffList) {
			results += s.getStaff();
		}
		return results;
	}

	public Staff getStaff(int index) {
		s = staffList.get(index);
		return s;
	}

	public Requirements getRequirement(int index) {
		r = reqList.get(index);
		return r;
	}

	public String print(int index) {
		String results = "";
		r = reqList.get(index);
		for (Staff s : r.getAllocatedStaff()) {
			results += s.getStaff();
		}
		return results;
	}

	public String printTraining(int index) {
		String results = "";
		r = reqList.get(index);
		for (Staff s : r.getAllocatedTraining()) {
			results += s.getStaff();
		}
		return results;
	}

	public String toStringStaff1(int index) {
		String results = "";
		s = staffList.get(index);
		results = s.getStaff();
		return results;
	}

	public String toStringReqs() {
		String results = "";
		for (Requirements r : reqList) {
			results += r.getRequirements();
		}
		return results;
	}

	public String toStringReqs(int index) {
		String results = "";
		r = reqList.get(index);
		results = r.getRequirements();

		return results;
	}

	// getters
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public ArrayList<Requirements> getReqList() {
		return reqList;
	}
}
