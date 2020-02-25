package requirements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import staff.Initialiser;

public class Loader {
	private ArrayList<Initialiser> staffList;
	private ArrayList<Initialiser> reqList;
	private int numOfStaff;
	private int numOfReqs;

	//constructor 
	public Loader() {
		this.staffList = new ArrayList<Initialiser>();
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
				this.staffList.add(new Initialiser(staffInfo[0], staffInfo[1], staffInfo[2], staffInfo[3], staffInfo[4]));
			}
		}catch (IOException e)	{
			e.printStackTrace();
		}
	}

	public void loadRequirements()	{
		try {
			BufferedReader br = new BufferedReader(new FileReader("PermanentInfo.txt"));
			String read = null;
			//			read = br.readLine();
			//			this.headerNames = read.split(", ");
			while ((read = br.readLine()) != null)	{
				this.numOfReqs++;
				String[] reqInfo = read.split(", ");
				this.reqList.add(new Initialiser(reqInfo[0], reqInfo[1], reqInfo[2]));
			}
		}catch (IOException e)	{
			e.printStackTrace();
		}
	}

	//toString for staffList array
	public String toString()	{
		String results = "";
		for (Initialiser s : staffList)	{
			results += s.getStaff();
		}
		return results;
	}

	//getters
	public ArrayList<Initialiser> getStaffList() {
		return staffList;
	}

	public ArrayList<Initialiser> getReqList() {
		return reqList;
	}

}

