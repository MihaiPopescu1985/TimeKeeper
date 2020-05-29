package timekeeper.model;


//create table Worker (ID int primary key auto_increment, FIRSTNAME varchar(20), LASTNAME varchar(20), DEPARTMENT varchar(20), TAGID varchar(50));

public class Worker {
	
	private int Id;
	private String FirstName;
	private String LastName;
	private String Department;
	private String TagId;
	
	public Worker() {};
	
	public Worker(int newId, String newFirstName, String newLastName, String newDepartment, String newTagId) {
		
		setId(newId);
		setFirstName(newFirstName);
		setLastName(newLastName);
		setDepartment(newDepartment);
		setTagId(newTagId);
	}
	
	public void setId(int newId) {
		Id = newId;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setFirstName(String newFirstName) {
		FirstName = newFirstName;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	public void setLastName(String newLastName) {
		LastName = newLastName;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public void setDepartment(String newDepartment) {
		Department = newDepartment;
	}
	
	public String getDepartment() {
		return Department;
	}
	
	public void setTagId(String newTagId) {
		TagId = newTagId;
	}
	
	public String getTagId() {
		return TagId;
	}
}
