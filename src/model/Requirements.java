package model;

import java.util.ArrayList;

public class Requirements {
	private String roleID;
	private String role;
	private String edLvl;
	private String department;
	private ArrayList <Staff> allocatedStaff = new ArrayList<Staff>();
	private ArrayList <Staff> allocatedTraining = new ArrayList<Staff>();
	
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

	//associates staff with training  
	public void addTraining(Staff s)	{
		this.allocatedTraining.add(s);
		s.setRequirement(this);
	}
	
	//associates staff with training  
	public void remove(Staff s)	{
		this.allocatedTraining.remove(s);
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
	
	public ArrayList<Staff> getAllocatedTraining() {
		return allocatedTraining;
	}
	
	
	public ArrayList<Staff> getAllocatedStaff() {
		return allocatedStaff;
	}
	
	
//	//prints staff selected for job 
//	public String print()	{
//		String results = "";
//		for (Staff s : allocatedStaff)	{
//			results += s.getStaff();
//		}
//		return results;
//	}
//	
//	// prints staff seleced fpor training 
//	public String printTraining()	{
//		String results = "";
//		for (Staff s : allocatedTraining)	{
//			results += s.getStaff();
//		}
//		return results;
//	}
}
