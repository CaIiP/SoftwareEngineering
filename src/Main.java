
import model.*;
import Controller.*;
import java.io.IOException;
import view.View;

public class Main {

	public static void main(String[] args) throws IOException {
		Admin a = new Admin();
		PTT ptt = new PTT();
		View v = new View();
		Model m = new Model(a, ptt);
		Controller c = new Controller(m, v);
	}
}
