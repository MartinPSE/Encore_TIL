package servlet.model;

public class Member {
	String id;
	String Password;
	String name;
	String address;
	public Member(String id, String password) {
		super();
		this.id = id;
		Password = password;
		
	}
	public Member(String id, String password, String name, String address) {
		super();
		this.id = id;
		Password = password;
		this.name = name;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", Password=" + Password + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
	
	

}
