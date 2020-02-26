package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Loader {
	private ArrayList<Staff> staffList;
	private ArrayList<Requirements> reqList;
	private int numOfStaff;
	private int numOfReqs;

	//constructor 
	public Loader() {
		this.staffList = new ArrayList<Staff>();
		this.reqList = new ArrayList<Requirements>();
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

	public void loadRequirements()	{
		try {
			BufferedReader br = new BufferedReader(new FileReader("Requirements.txt"));
			String read = null;
			//			read = br.readLine();
			//			this.headerNames = read.split(", ");
			while ((read = br.readLine()) != null)	{
				this.numOfReqs++;
				String[] reqInfo = read.split(", ");
				this.reqList.add(new Requirements(reqInfo[0], reqInfo[1], reqInfo[2], reqInfo[3]));
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
		for (Requirements r : reqList)	{
			results += r.getRequirements();
		}
		
		return results;
	}

	//getters
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public ArrayList<Requirements> getReqList() {
		return reqList;
	}

}

