package model;

public class Staff {
	private String id;
	private String name;
	private String contact;
	private String education;
	private String specification;
	private Requirements requirements;

	// staff constructor
	public Staff(String a, String b, String d, String e, String f, Requirements r) {
		this.id = a;
		this.name = b;
		this.contact = d;
		this.education = e;
		this.specification = f;
		this.requirements = r;

	}

	// toString for Staff
	public String toStringStaff() {
		String s1 = String.format("\n%-20s %-20s \n", "Name:", this.name);
		String s2 = String.format("%-21s %-20s  \n", "Applicant ID:", this.id);
		String s3 = String.format("%-20s %-20s  \n", "Contact Info:", this.contact);
		String s4 = String.format("%-20s %-20s  \n", "Education Level:", this.education);
		String s5 = String.format("%-20s %-20s  \n", "Degree Subject:", this.specification);
		String s = s1 + s2 + s3 + s4 + s5;
		return s;
	}

	// set requirements: used in Allocated Staff and Allocated training arrays
	public void setRequirement(Requirements requirements) {
		this.requirements = requirements;
	}

}
