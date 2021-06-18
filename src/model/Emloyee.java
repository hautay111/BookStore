package model;

public class Emloyee {
	private int Id;
	private String NameEmp;
	private String Usr;
	private String Pwd;
	private String Active;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNameEmp() {
		return NameEmp;
	}
	public void setNameEmp(String nameEmp) {
		NameEmp = nameEmp;
	}
	public String getUsr() {
		return Usr;
	}
	public void setUsr(String usr) {
		Usr = usr;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	public Emloyee(int id, String nameEmp, String usr, String pwd, String active) {
		super();
		Id = id;
		NameEmp = nameEmp;
		Usr = usr;
		Pwd = pwd;
		Active = active;
	}
	public Emloyee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
