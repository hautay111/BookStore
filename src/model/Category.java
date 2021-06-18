package model;

public class Category {
	private int Id;
	private String NameCate;
	private String Active;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNameCate() {
		return NameCate;
	}
	public void setNameCate(String nameCate) {
		NameCate = nameCate;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	public Category(int id, String nameCate, String active) {
		super();
		Id = id;
		NameCate = nameCate;
		Active = active;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
