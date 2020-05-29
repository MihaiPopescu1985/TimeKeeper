package timekeeper.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import timekeeper.model.Workday;
import timekeeper.services.DbHandler;


public class WorkdaysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Workday> Workdays;
	
	
    public WorkdaysServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		retrieveWorkdays();
		
		request.setAttribute("Workdays", Workdays);
		request.getRequestDispatcher("/Pages/Workdays.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/Pages/Workdays.jsp");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void retrieveWorkdays() {
        DbHandler dbHandler = DbHandler.getInstance();
        if (!dbHandler.isConnected())
        	dbHandler.connect();
        
        Workdays = dbHandler.getWorkdays();
	}
	
	@Override
	public void init() {

	}

}
