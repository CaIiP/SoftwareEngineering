package staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Staff {
	private String id;
	private String name;
	private String contact;
	private String education;
	private String spec;
	
	
	public Staff(String a, String b, String d, String e, String f) {
		this.id = a;
		this.name = b;
		this.contact = d;
		this.education = e;
		this.spec = f;		
	}
	
//	public Staff()	{
//		String fullLine = null;
//		  String[] splitLine = fullLine.split(",");
//		  this.id = Integer.parseInt(splitLine[0]);
//		  this.name = splitLine[1];
//		  this.contact = splitLine[2];
//		  this.education = splitLine[3];
//		  this.spec = splitLine[4];
//	}

	@SuppressWarnings("null")
	public void loadStaff() {
		ArrayList<String> lines = null;
		try (BufferedReader br = new BufferedReader(new FileReader("PermanentInfo.txt")))	{
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}
		}catch (IOException e)	{
			e.printStackTrace();
		}
			
	}
	
	public String getStaff()	{
		String s = String.format("%s %s %s %s %s \n", this.id, this.name,  this.contact, this.education, this.spec);
		return s;
	}

	
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
	
//	
//	public static void  main(String args[]) {
//		
//		Staff s = new Staff();
//		s.loadStaff();
//		System.out.println(s.getName());
//		System.out.println(s.getContact());
//	}
}