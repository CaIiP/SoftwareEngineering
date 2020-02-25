package requirements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import staff.Staff;

public class Requirements {
	private ArrayList<Staff> staffList;
	private int numOfStaff;
	
	//constructor 
	public Requirements() {
		this.staffList = new ArrayList<Staff>();
	}
	
	//reads from text file, creates staff objects, and loads into an array
	public void loadStaff()	{
		try {
			BufferedReader br = new BufferedReader(new FileReader("PermanentInfo.txt"));
			String read = null;
//			read = br.readLine();
//			this.headerNames = read.split(", ");
			while ((read = br.readLine()) != null)	{
				this.numOfStaff++;
				String[] staffInfo = read.split(", ");
				this.staffList.add(new Staff(staffInfo[0], staffInfo[1], staffInfo[2], staffInfo[3], staffInfo[4]));
			}
		}catch (IOException e)	{
			e.printStackTrace();
		}
	}
	
	//toString for staffList array
	public String toString()	{
		String results = "";
		for (Staff s : staffList)	{
			results += s.getStaff();
		}
		return results;
	}
	
	//getters
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}
	
}
