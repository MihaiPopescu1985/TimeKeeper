package timekeeper.model;


//create table Project (ID int primary key auto_increment, RONUMBER varchar(20), GENUMBER varchar(20), DESCRIPTION varchar(100), DEVICEIP varchar(15));

public class Project {
	
	private int Id;
	private String RoNumber;
	private String GeNumber;
	private String Description;
	private String DeviceIp;
	
	public Project() {};
	
	public Project(int newId, String newRoNumber, String newGeNumber, String newDescription, String newDeviceIp) {
		setId(newId);
		setRoNumber(newRoNumber);
		setGeNumber(newGeNumber);
		setDescription(newDescription);
		setDeviceIp(newDeviceIp);
	}
	
	public void setId(int newId) {
		Id = newId;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setRoNumber(String newRoNumber) {
		RoNumber = newRoNumber;
	}
	
	public String getRoNumber() {
		return RoNumber;
	}
	
	public void setGeNumber(String newGeNumber) {
		GeNumber = newGeNumber;
	}
	
	public String getGeNumber() {
		return GeNumber;
	}
	
	public void setDescription(String newDescription) {
		Description = newDescription;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDeviceIp(String newDeviceIp) {
		DeviceIp = newDeviceIp;
	}
	
	public String getDeviceIp() {
		return DeviceIp;
	}

}
