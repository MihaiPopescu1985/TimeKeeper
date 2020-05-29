package timekeeper.services;

import java.util.List;

import timekeeper.model.*;

/*
 * Mysql 
 * database: eccel
 * credentials : root eccelC1
 */
public interface DbService {
	
	public void addDevice(Device newDevice);
	public void addProject(Project newProject);
	public void addWorkday(Workday newWorkday);
	public void addWorker(Worker newWorker);
	public void deleteDevice(Device newDevice);
	public void deleteProject(Project newProject);
	public void deleteWorkday(Workday newWorkday);
	public void deleteWorker(Worker newWorker);
	public void updateDevice(Device newDevice);
	public void updateProject(Project newProject);
	public void updateWorkday(Workday newWorkday);
	public void updateWorker(Worker newWorker);
	public List<Device> getDevices();
	public List<Project> getProjects();
	public List<Workday> getWorkdays();
	public List<Worker> getWorkers();
	
}
