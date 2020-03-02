package Controller;
import java.io.IOException;
import view.*;
import model.*;



public class Controller {
	
	private View view;
	private Admin admin;
	private PTT ptt;
	private Model model;
	
	
	
	public Controller(Model model, View view ) throws IOException {
		this.model= model;
		model = new Model(admin, ptt);
		this.view = view;
		view = new View();
		view.run();
	}
	
}
