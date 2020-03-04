package model;

public class Model {
	private Loader loader;

	public Model() {

		// load staff and requirements
		this.loader = new Loader();
		loader.load();

	}

}
