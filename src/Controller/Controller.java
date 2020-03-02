package Controller;
import java.io.IOException;
import view.*;
import model.*;



public class Controller {
	
	private View v;
	private Admin a;
	private PTT ptt;
	private Model m;
	
	
	
	public Controller(Model model, View view ) throws IOException {
		this.m= model;
		m = new Model(a, ptt);
		this.v = view;
		v = new View();
		v.run();
	}
	
}
