
import model.*;
import Controller.*;
import java.io.IOException;
import view.View;

public class Main {

	public static void main(String[] args) throws IOException {
		Admin admin = new Admin();
		PTT ptt = new PTT();
		View view = new View();
		Model model = new Model(admin, ptt);
		Controller controller = new Controller(model, view);
	}
}
