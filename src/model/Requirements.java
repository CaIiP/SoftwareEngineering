package model;

public class Requirements {
	private String roleID;
	private String role;
	private String edLvl;
	private String department;
	
	
	public Requirements(String rID, String r, String ed, String dep)	{
		this.roleID = rID;
		this.role = r;
		this.edLvl = ed;
		this.department = dep;
	}
	
	public String getRequirements()	{
		String t = String.format("%s %s %s %s \n", this.roleID, this.role, this.edLvl,  this.department);
		return t;
	}
	
	public String getRoleID() {
		return roleID;
	}
	
	public String getRole() {
		return role;
	}

	public String getEdLvl() {
		return edLvl;
	}

	public String getDepartment() {
		return department;
	}
	
}
