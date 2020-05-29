package timekeeper.model;

import java.time.LocalDateTime;


//create table Workday (ID int primary key auto_increment, WORKER int, PROJECT int, STARTHOUR datetime, STOPHOUR datetime);

public class Workday {
	
	private int Id;
	private int Worker;
	private int Project;
	private LocalDateTime StartHour;
	private LocalDateTime StopHour;
	
	public Workday() {};
	
	public Workday(int newId, int newWorker, int newProject, LocalDateTime newStartHour, LocalDateTime newStopHour) {
		setId(newId);
		setWorker(newWorker);
		setProject(newProject);
		setStartHour(newStartHour);
		setStopHour(newStopHour);
	}
	
	public void setId(int newId) {
		Id = newId;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setWorker(int newWorker) {
		Worker = newWorker;
	}
	
	public int getWorker() {
		return Worker;
	}
	
	public void setProject(int newProject) {
		Project = newProject;
	}
	
	public int getProject() {
		return Project;
	}
	
	public void setStartHour(LocalDateTime newStartHour) {
		StartHour = newStartHour;
	}
	
	public LocalDateTime getStartHour() {
		return StartHour;
	}
	
	public void setStopHour(LocalDateTime newStopHour) {
		StopHour = newStopHour;
	}
	
	public LocalDateTime getStopHour() {
		return StopHour;
	}
}
