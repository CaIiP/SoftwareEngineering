package staff;

public class Initialiser {
	private String id;
	private String name;
	private String contact;
	private String education;
	private String spec;
	private String roleID;
	private String edLvl;
	private String department;
	
	//staff constructor
	public Initialiser(String a, String b, String d, String e, String f) {
		this.id = a;
		this.name = b;
		this.contact = d;
		this.education = e;
		this.spec = f;		
	}
	
	//requirements constructor
	public Initialiser(String rID, String ed, String dep)	{
		this.roleID = rID;
		this.edLvl = ed;
		this.department = dep;
	}
	
	//toString for Requirements toString
	public String getStaff()	{
		String s = String.format("%s %s %s %s %s \n", this.id, this.name,  this.contact, this.education, this.spec);
		return s;
	}
	
	public String getRequirements()	{
		String t = String.format("%s %s %s \n", this.roleID, this.edLvl,  this.department);
		return t;
	}

	//Getters
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
}

