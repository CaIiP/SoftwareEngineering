package staff;

import java.io.File;
import java.util.Scanner;

public class Staff1 {
	private Scanner x;
	
	public void openFile()	{
		try {
			x = new Scanner(new File("PermanentInfo.txt"));
		}
		catch(Exception e)	{
			System.out.println("File not found");
		}
	}

	public void readFile()	{
		String fullLine = new String();
		String[] splitLine = fullLine.split(" ");
		while(x.hasNext())	{
			String a = splitLine[0];
			String b = splitLine[1];
			String c = splitLine[2];
			String d = splitLine[3];
			String e = splitLine[4];
			String f = splitLine[5];
			
//			String[] splitLine = fullLine.split(",");
//			this.id = Integer.parseInt(splitLine[0]);
//			this.name = splitLine[1];
//			this.contact = splitLine[2];
//			this.education = splitLine[3];
//			this.spec = splitLine[4];
			
			System.out.printf("%s %s %s %s %s %s\n", a, b, c, d, e, f);
		}
	}
	
	public void closeFile()	{
		x.close();
	}

}
