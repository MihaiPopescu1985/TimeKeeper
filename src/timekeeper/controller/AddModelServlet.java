package timekeeper.controller;

import java.io.IOException;
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
/*
		System.out.println(request.getParameter("DeviceDescription"));
		Map<String, String[]> map = request.getParameterMap();
		System.out.println(map.get("DeviceDescription")[0]);
*/		
		String model = request.getParameter("model");
		
		if (model.contentEquals("device")) {
			Device device = ParseModels.getDevice(request.getParameterMap());
			dbService.addDevice(device);
		}
		else if (model.contentEquals("project")) {
			Project project = ParseModels.getProject(request.getParameterMap());
			dbService.addProject(project);
		}
		else if (model.contentEquals("workday")) {
			Workday workday = ParseModels.getWorkday(request.getParameterMap());
			dbService.addWorkday(workday);
		}
		else if (model.contentEquals("worker")) {
			Worker worker = ParseModels.getWorker(request.getParameterMap());
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
