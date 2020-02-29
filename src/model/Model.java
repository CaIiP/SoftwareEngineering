package model;

public class Model {

	
	private  Admin a;
	private PTT ptt;
	private  Loader l;

 public Model(Admin admin, PTT pt) {
	 this.a = admin;
	 this.ptt = pt;
	 Loader l = new Loader();
	 l.load();
	 
 }
 }