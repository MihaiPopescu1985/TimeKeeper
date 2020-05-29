package timekeeper.services;

import java.time.LocalDateTime;
import java.util.Map;

import timekeeper.model.*;

public class ParseModels implements ParseModel {
	
	public static Device getDevice(Map<String, String[]> parameter) {
		
		int id = 0;
		String deviceDescription = parameter.get("DeviceDescription")[0];
		String deviceIp = parameter.get("DeviceIp")[0];
		
		int projectId = Integer.parseInt(parameter.get("ProjectId")[0]);
		
		Device device = new Device(
				id, deviceDescription, deviceIp, projectId);
		return device;
	}
	
	public static Project getProject(Map<String, String[]> parameter) {
		
		int id = 0;
		String roNumber = parameter.get("RoNumber")[0];
		String geNumber = parameter.get("GeNumber")[0];
		String description = parameter.get("Description")[0];
		String deviceIp = parameter.get("DeviceIp")[0];
		
		Project project = new Project(
				id, roNumber, geNumber, description, deviceIp);
		return project;
	}
	
	public static Workday getWorkday(Map<String, String[]> parameter) {
		
		int id = 0;
		int worker = Integer.parseInt(parameter.get("Worker")[0]);
		int project = Integer.parseInt(parameter.get("Project")[0]);
		LocalDateTime startHour = LocalDateTime.parse(parameter.get("StartHour")[0]);
		LocalDateTime stopHour = LocalDateTime.parse(parameter.get("StopHour")[0]);
		
		Workday workday = new Workday(
				id, worker, project, startHour, stopHour);
		return workday;
	}
	
	public static Worker getWorker(Map<String, String[]> parameter) {
		
		int id = 0;
		String firstName = parameter.get("FirstName")[0];
		String lastName = parameter.get("LastName")[0];
		String department = parameter.get("Department")[0];
		String tagId = parameter.get("TagId")[0];
		
		Worker worker = new Worker(
				id, firstName, lastName, department, tagId);
		return worker;
	}
}
