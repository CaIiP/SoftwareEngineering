package Controller;

import java.io.IOException;
import view.*;
import model.*;

public class Controller {

	private View view;
	private Model model;

	// initialise mvc
	public Controller(Model model, View view) throws IOException {
		this.model = model;
		this.view = view;
		view.run();
	}

}
