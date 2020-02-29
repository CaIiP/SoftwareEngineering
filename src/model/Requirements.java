package model;

import java.util.ArrayList;

public class Requirements {
	private String roleID;
	private String role;
	private String edLvl;
	private String department;
	private ArrayList <Staff> allocatedStaff = new ArrayList<Staff>();
	
	
	public Requirements(String rID, String r, String ed, String dep)	{
		this.roleID = rID;
		this.role = r;
		this.edLvl = ed;
		this.department = dep;
	}
	
	//associates staff object with requirements object
	public void addStaff(Staff s)	{
		this.allocatedStaff.add(s);
		s.setRequirement(this);
	}
	
	//removes staff object from associated requirements object
	public void removeStaff(Staff s)	{
		this.allocatedStaff.remove(s);
		s.setRequirement(null);
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
	
	public ArrayList<Staff> getAllocatedStaff() {
		return allocatedStaff;
	}
	
	public String print()	{
		String results = "";
		for (Staff s : allocatedStaff)	{
			results += s.getStaff();
		}
		return results;
	}
}
