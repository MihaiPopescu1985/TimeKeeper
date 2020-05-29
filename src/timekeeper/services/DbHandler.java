package timekeeper.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import timekeeper.model.*;

public class DbHandler implements DbService {
	
	private static DbHandler instance;
	private static Connection DbConnection;
	private static boolean Connected;
	
	private static final String PATH = "jdbc:mysql://localhost:3306/eccel";
	private static final String USER = "root";
	private static final String PASSWORD = "eccelC1";
	
	private DbHandler() {};
	
	public static synchronized DbHandler getInstance() {
		
		if (instance == null) {
			instance = new DbHandler();
		}
		return instance;
	}
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DbConnection = DriverManager.getConnection(PATH, USER, PASSWORD);
			if (DbConnection.isValid(5)) {
				System.out.println("Connection to database established.");
				Connected = true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error connecting to database.");
			Connected = false;
		}
	}
	
	public void closeConnection() {
		try {
			DbConnection.close();
		} catch (SQLException e) {
			System.out.println("Error closing connection to database.");
			Connected = false;
		}
	}
	
	public boolean isConnected() {
		return Connected;
	}

	private void executeUpdate(String command) {
		System.out.println("Executing command " + command);
		try {
			Statement statement = DbConnection.createStatement();
			statement.executeUpdate(command);
		} catch (SQLException e) {
			System.out.println("Error executing command: " + command);
			System.out.println(e.getMessage());
			Connected = false;
		}
	}
	
	private ResultSet executeQuery(String command) {
		System.out.println("Executing command " + command);
		ResultSet result = null;
		try {
			Statement statement = DbConnection.createStatement();
			result = statement.executeQuery(command);
		} catch (SQLException e) {
			System.out.println("Error executing command: " + command);
			System.out.println(e.getMessage());
			Connected = false;
		}
		return result;
	}
	
	@Override
	public void addDevice(Device newDevice) {
		String insertDevice = "INSERT INTO Device VALUES ("
				+ newDevice.getId() + ", \'" + newDevice.getDeviceDescription()
				+ "\', \'" + newDevice.getDeviceIp() + "\', " + newDevice.getProjectId() 
				+ ");";
		executeUpdate(insertDevice);
	}

	@Override
	public void addProject(Project newProject) {
		String insertProject = "INSERT INTO Project VALUES ("
				+ newProject.getId() + ", \'" + newProject.getRoNumber() + "\', \'"
				+ newProject.getGeNumber() + "\', \'" + newProject.getDescription() + "\', \'"
				+ newProject.getDeviceIp() 
				+ "\');";
		executeUpdate(insertProject);
	}
	
	@Override
	public void addWorkday(Workday newWorkday) {
		String insertWorkday = "INSERT INTO Workday VALUES ("
				+ newWorkday.getId() + ", " + newWorkday.getWorker() + ", "
				+ newWorkday.getProject() + ", \'" + newWorkday.getStartHour() + "\', ";
		if (newWorkday.getStopHour() == null) {
			insertWorkday += "null);";
		}
		else {
			insertWorkday += "\'" + newWorkday.getStopHour() + "\');";
		}
		executeUpdate(insertWorkday);
	}
	
	@Override
	public void addWorker(Worker newWorker) {
		String insertWorker = "INSERT INTO Worker VALUES ("
				+ newWorker.getId() + ", \'" + newWorker.getFirstName() + "\', \'"
				+ newWorker.getLastName() + "\', \'" + newWorker.getDepartment() + "\', \'"
				+ newWorker.getTagId()
				+ "\');";
		executeUpdate(insertWorker);
	}

	@Override
	public void deleteDevice(Device newDevice) {
		String delete = "DELETE FROM Device WHERE ID = " + newDevice.getId() + ";";
		executeUpdate(delete);
	}

	@Override
	public void deleteProject(Project newProject) {
		String delete = "DELETE FROM Project WHERE ID = " + newProject.getId() + ";";
		executeUpdate(delete);
	}
	
	@Override
	public void deleteWorkday(Workday newWorkday) {
		String delete = "DELETE FROM Workday WHERE ID = " + newWorkday.getId() + ";";
		executeUpdate(delete);
	}

	@Override
	public void deleteWorker(Worker newWorker) {
		String delete = "DELETE FROM Worker WHERE ID = " + newWorker.getId() + ";";
		executeUpdate(delete);
	}

	@Override
	public void updateDevice(Device newDevice) {
		String update = "UPDATE Device SET "
				+ "DEVICEDESCRIPTION = \'" + newDevice.getDeviceDescription() 
				+ "\' DEVICEIP = \'" + newDevice.getDeviceIp()
				+ "\' PROJECTID = " + newDevice.getDeviceIp()
				+ " WHERE ID = " + newDevice.getId()
				+ ";";
		
		executeUpdate(update);
	}

	@Override
	public void updateProject(Project newProject) {
		String update = "UPDATE Project SET "
				+ " RONUMBER = \'" + newProject.getRoNumber()
				+ "\' GENUMBER = \'" + newProject.getGeNumber()
				+ "\' DESCRIPTION = \'" + newProject.getDescription()
				+ "\' DEVICEIP = \'" + newProject.getDeviceIp()
				+ "\';";
		executeUpdate(update);
	}
	
	@Override
	public void updateWorkday(Workday newWorkday) {
		String update = "UPDATE Workday SET "
				+ " WORKER = " + newWorkday.getWorker()
				+ ", PROJECT = " + newWorkday.getProject()
				+ ", STARTHOUR = \'" + newWorkday.getStartHour()
				+ "\', STOPHOUR = \'" + newWorkday.getStopHour()
				+ "\' WHERE ID = " + newWorkday.getId() + ";";
		executeUpdate(update);
	}
	
	@Override
	public void updateWorker(Worker newWorker) {
		String update = "UPDATE Worker SET "
				+ " FIRSTNAME = \'" + newWorker.getFirstName()
				+ "\' LASTNAME = \'" + newWorker.getLastName()
				+ "\' DEPARTMENT = \'" + newWorker.getDepartment()
				+ "\' TAGID = \'" + newWorker.getTagId()
				+ "\';";
		executeUpdate(update);
	}
	
	@Override
	public List<Device> getDevices() {
		String getDevices = "SELECT * FROM Device;";
		ResultSet query = executeQuery(getDevices);
		
		ArrayList<Device> devices = new ArrayList<Device>();
		try {
			while (query.next()) {
				devices.add(new Device(
						query.getInt(1), query.getString(2), query.getString(3), query.getInt(4)
						));
			}
		} catch (SQLException e) {
			System.out.println("Error processing devices.");
			Connected = false;
		}
		return devices;
	}

	@Override
	public List<Project> getProjects() {
		String getProjects = "SELECT * FROM Project;";
		ResultSet query = executeQuery(getProjects);
		
		ArrayList<Project> projects = new ArrayList<Project>();
		try {
			while (query.next()) {
				projects.add(new Project(
						query.getInt(1), query.getString(2)
						, query.getString(3), query.getString(4)
						, query.getString(5)
						));
			}
		} catch (SQLException e) {
			System.out.println("Error processing projects.");
			Connected = false;
		}
		return projects;
	}

	@Override
	public List<Workday> getWorkdays() {
		String getWorkdays = "SELECT * FROM Workday;";
		ResultSet query = executeQuery(getWorkdays);
		
		ArrayList<Workday> workdays = new ArrayList<Workday>();
		try {
			while (query.next()) {
				workdays.add(new Workday(
						query.getInt(1), query.getInt(2), query.getInt(3)
						, query.getObject(4, LocalDateTime.class)
						, query.getObject(5, LocalDateTime.class)
						));
			} 
		} catch (SQLException e) {
			System.out.println("Error processing workdays.");
			Connected = false;
		}
		return workdays;
	}
	
	@Override
	public List<Worker> getWorkers() {
		String getWorkers = "SELECT * FROM Worker;";
		ResultSet query = executeQuery(getWorkers);
		
		ArrayList<Worker> workers = new ArrayList<Worker>();
		try {
			while (query.next()) {
				workers.add(new Worker(
						query.getInt(1), query.getString(2)
						, query.getString(3), query.getString(4)
						, query.getString(5)
						));
			}
		} catch (SQLException e) {
			System.out.println("Error processing workers.");
			Connected = false;
		}
		return workers;
	}
	
	public int getProjectFromDevice(String deviceIp) {
		String getDeviceCommand = "SELECT * FROM Device WHERE DEVICEIP = \'" + deviceIp + "\';";
		ResultSet result = executeQuery(getDeviceCommand);
		int projectId = -1;
		try {
			result.next();
			projectId = result.getInt(4);
		} catch (SQLException e1) {
			System.out.println("Error retrieving project ID." + e1.getMessage());
		}
		return projectId;
	}
	
	public int getWorkerByTag(String tag) {
		String command = "SELECT * FROM Worker WHERE TAGID = \'" + tag + "\';";
		ResultSet result = executeQuery(command);
		
		int workerId = -1;
		try {
			result.next();
			workerId = result.getInt(1);
		} catch (SQLException e) {
			System.out.println("Error retrieving worker." + e.getMessage());
		}
		return workerId;
	}
	
	
}
