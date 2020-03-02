package model;

public class Staff {
	private String id;
	private String name;
	private String contact;
	private String education;
	private String spec;
	private Requirements req;
	private int reqID;

	// staff constructor
	public Staff(String a, String b, String d, String e, String f, Requirements r) {
		this.id = a;
		this.name = b;
		this.contact = d;
		this.education = e;
		this.spec = f;
		this.req = r;

	}

	// toString for Staff toString
	public String getStaff() {
		String s = String.format("%s %s %s %s %s \n", this.id, this.name, this.contact, this.education, this.spec);
		return s;
	}

	// Getters
	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getContact() {
		return contact;
	}

	public String getEducation() {
		return education;
	}

	public String getSpec() {
		return spec;
	}

	public int getReqID() {
		return reqID;
	}

	public void setReqID(int reqID) {
		this.reqID = reqID;
	}

	public void setRequirement(Requirements requirements) {
		this.req = requirements;
	}

}
