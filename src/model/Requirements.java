package model;

import java.util.ArrayList;

public class Requirements {
	private String jobID;
	private String jobTitle;
	private String educationLevel;
	private String department;
	private ArrayList<Staff> allocatedStaff = new ArrayList<Staff>();
	private ArrayList<Staff> allocatedTraining = new ArrayList<Staff>();

	// constructor
	public Requirements(String rID, String r, String ed, String dep) {
		this.jobID = rID;
		this.jobTitle = r;
		this.educationLevel = ed;
		this.department = dep;
	}

	// associates staff object with requirements object
	public void addStaff(Staff s) {
		this.allocatedStaff.add(s);
		s.setRequirement(this);
	}

	public void removeStaff(Staff s) {
		this.allocatedStaff.remove(s);
		s.setRequirement(null);
	}

	// associates staff with training
	public void addTraining(Staff s) {
		this.allocatedTraining.add(s);
		s.setRequirement(this);
	}

	public void removeTraining(Staff s) {
		this.allocatedTraining.remove(s);
		s.setRequirement(null);
	}

	// toStrings
	public String toStringRequirements() {
		String t = String.format("%s %s %s %s \n", this.jobID, this.jobTitle, this.educationLevel, this.department);
		return t;
	}

	public String toStringJobRequirments() {
		String t = String.format("%s %s %s %s \n", "The Requirements are :", this.educationLevel, "in the area of",
				this.department);
		return t;
	}

	public String toStringJob() {
		String t = String.format("%s %s \n", "For the Position: ", this.jobTitle);
		return t;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getJobID() {
		return jobID;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public String getDepartment() {
		return department;
	}

	// getters
	public ArrayList<Staff> getAllocatedTraining() {
		return allocatedTraining;
	}

	public ArrayList<Staff> getAllocatedStaff() {
		return allocatedStaff;
	}

}
