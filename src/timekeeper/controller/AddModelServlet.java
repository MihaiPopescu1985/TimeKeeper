package timekeeper.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import timekeeper.model.*;
import timekeeper.services.DbHandler;
import timekeeper.services.DbService;
import timekeeper.services.ParseModels;


public class AddModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DbService dbService;

    public AddModelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String model = (String) request.getParameter("model");
		
		if (model.contentEquals("device")) {
			Device device = new Device(
					0
					, request.getParameter("DeviceDescription")
					, request.getParameter("DeviceIp")
					, Integer.valueOf(request.getParameter("ProjectId")));
		}
		else if (model.contentEquals("project")) {
			Project project = new Project(
					0
					, request.getParameter("RoNumber")
					, request.getParameter("GeNumber")
					, request.getParameter("Description")
					, request.getParameter("DeviceIp"));
			dbService.addProject(project);
		}
		else if (model.contentEquals("workday")) {
			Workday workday = new Workday(
					0
					, Integer.valueOf(request.getParameter("WorkerId").toString())
					, Integer.valueOf(request.getParameter("ProjectId").toString())
					, LocalDateTime.parse(request.getParameter("StartHour").toString())
					, LocalDateTime.parse(request.getParameter("StopHour").toString()));
			dbService.addWorkday(workday);
		}
		else if (model.contentEquals("worker")) {
			Worker worker = new Worker(
					0
					, request.getParameter("FirstName")
					, request.getParameter("LastName")
					, request.getParameter("TagId")
					, request.getParameter("Department"));
			dbService.addWorker(worker);
		}
		response.sendRedirect("/TimeKeeper");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	@Override
	public void init() {
		 dbService = DbHandler.getInstance();
	}

}
