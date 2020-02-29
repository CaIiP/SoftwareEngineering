package main;

import model.*;
import Controller.*;
import view.View;

public class Test {

	public static void main(String[] args) {
		//Loader l = new Loader();
		//l.loadRequirements();
		//System.out.println(l.toStringReqs(1));

		//		View v = new View();
		//		v.run();
		Admin a = new Admin();
		;
		PTT ptt = new PTT();
	
		View v = new View();
		Model m = new Model(a, ptt);
		Controller c = new Controller(m, v);



		//	View view = new View();


	}
}
