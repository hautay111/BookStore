package model;

public class Author {
	private int Id;
	private String NameAuthor;
	private String phone;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNameAuthor() {
		return NameAuthor;
	}
	public void setNameAuthor(String nameAuthor) {
		NameAuthor = nameAuthor;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Author(int id, String nameAuthor, String phone) {
		super();
		Id = id;
		NameAuthor = nameAuthor;
		this.phone = phone;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
