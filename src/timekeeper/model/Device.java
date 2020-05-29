package timekeeper.model;


//create table Device (ID int primary key auto_increment, DEVICEDESCRIPTION varchar(100), DEVICEIP varchar(15), PROJECTID int); 

/**
 * 
 * @author MPopescu
 * 
 */

public class Device {
	
	private int Id;
	private String DeviceDescription;
	private String DeviceIp;
	private int ProjectId;
	
	public Device() {};
	
	public Device(int newId, String newDeviceDescription, String newDeviceIp, int newProjectId) {
		setId(newId);
		setDeviceDescription(newDeviceDescription);
		setDeviceIp(newDeviceIp);
		setProjectId(newProjectId);
	}
	
	public void setId(int newId) {
		Id = newId;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setDeviceDescription(String newDeviceDescription) {
		DeviceDescription = newDeviceDescription;
	}
	
	public String getDeviceDescription() {
		return DeviceDescription;
	}
	
	public void setDeviceIp(String newDeviceIp) {
		DeviceIp = newDeviceIp;
	}
	
	public String getDeviceIp() {
		return DeviceIp;
	}
	
	public void setProjectId(int newProjectId) {
		ProjectId = newProjectId;
	}
	
	public int getProjectId() {
		return ProjectId;
	}
}
