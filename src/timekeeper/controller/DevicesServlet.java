package timekeeper.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import timekeeper.model.Device;
import timekeeper.services.DbHandler;


public class DevicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Device> Devices;
	
    public DevicesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		retrieveDevices();
		
		request.setAttribute("Devices", Devices);
		request.getRequestDispatcher("/Pages/Devices.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/Pages/Devices.jsp");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void retrieveDevices() {
        DbHandler dbHandler = DbHandler.getInstance();
        if (!dbHandler.isConnected())
        	dbHandler.connect();
        
        Devices = dbHandler.getDevices();
	}
	
	@Override
	public void init() {

	}

}
