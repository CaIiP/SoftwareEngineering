package staff;

public class Staff {
	private int id;
	private String name;
	private int dob;
	private String contact;
	private String education;
	private String spec;
	
	public Staff(int a, String b, int c, String d, String e, String f) {
		this.id = a;
		this.name = b;
		this.dob = c;
		this.contact = d;
		this.education = e;
		this.spec = f;		
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getDob() {
		return dob;
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
}
