
import model.*;
import Controller.*;
import java.io.IOException;
import view.View;

public class Main {

	public static void main(String[] args) throws IOException {
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(model, view);
	}
}
