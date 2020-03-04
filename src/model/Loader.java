package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Loader {

	private ArrayList<Staff> staffList;
	private ArrayList<Requirements> requirmentsList;
	private Requirements requirements;
	private Staff staff;

	// constructor
	public Loader() {
		this.staffList = new ArrayList<Staff>();
		this.requirmentsList = new ArrayList<Requirements>();
	}

	// method to load staff and requirements form csv file into staflist array and
	// requirementsList array
	public void load() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("allinfo.csv"));
			String read = null;
			while ((read = bufferedReader.readLine()) != null) {
				String[] info = read.split(",");
				int size = info.length;
				this.staffList.add(new Staff(info[0], info[1], info[2], info[3], info[4], null));
				if (size > 6) {
					this.requirmentsList.add(new Requirements((info[6]), info[7], info[8], info[9]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// toStrings
	public String toStringAllocatedStaff(int index) {
		String results = "";
		requirements = requirmentsList.get(index);
		for (Staff s : requirements.getAllocatedStaff()) {
			results += s.toStringStaff();
		}
		return results;
	}

	public String toStringAllocatedTraining(int index) {
		String results = "";
		requirements = requirmentsList.get(index);
		for (Staff s : requirements.getAllocatedTraining()) {
			results += s.toStringStaff();
		}
		return results;
	}

	public String toStringStaff(int index) {
		String results = "";
		staff = staffList.get(index);
		results = staff.toStringStaff();
		return results;
	}

	public String toStringRequirements(int index) {
		String results = "";
		requirements = requirmentsList.get(index);
		results = requirements.toStringRequirements();

		return results;
	}

	// getters
	public Staff getStaff(int index) {
		staff = staffList.get(index);
		return staff;
	}

	public Requirements getRequirement(int index) {
		requirements = requirmentsList.get(index);
		return requirements;
	}

	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public ArrayList<Requirements> getRequirementsList() {
		return requirmentsList;
	}
}
