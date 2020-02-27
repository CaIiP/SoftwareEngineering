package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Loader	{ 
	private ArrayList<Staff> staffList;
	private ArrayList<Requirements> reqList;
	private Requirements r;
	//	private int numOfStaff;
	private int numOfReqs;
	private String[] i;

	//constructor 
	public Loader() {
		this.staffList = new ArrayList<Staff>();
		this.reqList = new ArrayList<Requirements>();
	}

	//scanner option
	//	public void loadInfo()	{
	//		Scanner scanner = new Scanner(System.in);
	//		List<String> lines;
	//		try	{
	//			lines = Files.readAllLines(Paths.get("PermanentInfo.txt"));
	//			int index = 0;
	//			while(index < lines.size()) {
	//				do {
	//					//System.out.println(lines.get(index));
	//					index++;
	//				}
	//				while(index < lines.size() && lines.get(index).startsWith("[Staff]"));	{
	//					if(lines.get(index).startsWith("[Requirements]"))	{
	//						System.out.println("Saw requirements");
	//						break;
	//					}
	//					System.out.println("Made it");
	//				}
	//				while(index < lines.size() && lines.get(index).startsWith("[Requirements]"));	{
	//					if(lines.get(index).startsWith("[END]"))	{
	//						System.out.println("Saw END");
	//						break;
	//					}
	//					System.out.println("Made it to r");
	//				}
	//			} 
	//		}
	//		catch (IOException e)	{
	//			e.printStackTrace();
	//		}
	//	}


	//reads from text file, creates staff objects, and loads into an array
	//	public void loadStaff()	{
	//		try {
	//			BufferedReader br = new BufferedReader(new FileReader("PermanentInfo.txt"));
	//			String read = br.readLine();
	//			String section = br.readLine();
	//			int numOfStaff = 0;
	//			//			for(int numOfStaff = 0; this.staffList.size() == numOfStaff; numOfStaff++)	{
	//			while(section != null)	{
	//				while ((read = br.readLine()) !=null){
	//					if(section.contentEquals("[Staff]"))	{
	//						if(this.staffList.size() < 10)	{
	//							String[] staffInfo = read.split(", ");
	//							this.staffList.add(new Staff(staffInfo[0], staffInfo[1], staffInfo[2], staffInfo[3], staffInfo[4]));
	//							numOfStaff = this.staffList.size() + 1;
	//							System.out.println("Loaded staff");
	//							System.out.println(numOfStaff);
	//							System.out.println(this.staffList.size());
	//						}
	//					}
	//				}
	//			}
	//		}
	//		catch (IOException e)	{
	//			e.printStackTrace();
	//		}
	//	}

	//	public void loadReq()	{
	//		try {
	//			BufferedReader br = new BufferedReader(new FileReader("PermanentInfo.txt"));
	//			String read = br.readLine();
	//			String section = br.readLine();
	//			int numOfReqs = 0;
	//			//			for(int numOfStaff = 0; this.staffList.size() == numOfStaff; numOfStaff++)	{
	//			while(section != null)	{
	//				while ((read = br.readLine()) !=null){
	//					if(section.contentEquals("[Requirements]"))	{
	//						if(this.reqList.size() < 4)	{
	//							String[] reqInfo = read.split(", ");
	//							this.reqList.add(new Requirements(reqInfo[0], reqInfo[1], reqInfo[2], reqInfo[3]));
	//							numOfReqs = this.reqList.size() + 1;
	//							System.out.println("Loaded reqs");
	////							System.out.println(numOfStaff);
	//							System.out.println(this.reqList.size());
	//						}
	//					}
	//				}
	//			}
	//		}
	//		catch (IOException e)	{
	//			e.printStackTrace();
	//		}
	//	}

	//	public void loadRequirements()	{
	//		try {
	//			BufferedReader br = new BufferedReader(new FileReader("Requirements.txt"));
	//			String read = null;
	//			//			read = br.readLine();
	//			//			this.headerNames = read.split(", ");
	//			while ((read = br.readLine()) != null)	{
	//				
	//				String[] reqInfo = read.split(", ");
	//				this.reqList.add(new Requirements(reqInfo[0], reqInfo[1], reqInfo[2], reqInfo[3]));
	//			}
	//		}catch (IOException e)	{
	//			e.printStackTrace();
	//		}
	//	}

	public void load()	{
		try {
			BufferedReader br = new BufferedReader(new FileReader("allinfo.csv"));
			String read = null;
			while ((read = br.readLine()) != null)	{
				String[] info = read.split(",");
				System.out.println(Arrays.toString(info));
//				this.staffList.add(new Staff(info[0], info[1], info[2], info[3], info[4]));
//				this.reqList.add(new Requirements(info[5], info[6], info[7], info[8]));
			}
		}
		catch (IOException e)	{
			e.printStackTrace();
		}
	}



	//toString for staffList array
//	public String toString()	{
//		String results = "";
//		for (Staff s : staffList)	{
//			results += s.getStaff();
//		}
//		for (Requirements r : reqList)	{
//			results += r.getRequirements();
//		}
//
//		return results;
//	}

	//getters
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public ArrayList<Requirements> getReqList() {
		return reqList;
	}

}

