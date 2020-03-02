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

	// toString for Staff toString
	public String toStringStaff() {
		String s = String.format("%s %s %s %s %s \n", this.id, this.name, this.contact, this.education, this.specification);
		return s;
	}


	public void setRequirement(Requirements requirements) {
		this.requirements = requirements;
	}

}
