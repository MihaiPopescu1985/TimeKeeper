package timekeeper.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import timekeeper.model.Worker;
import timekeeper.services.DbHandler;


public class WorkersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private List<Worker> Workers;

    public WorkersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		retrieveWorkers();
		
		request.setAttribute("Workers", Workers);
		request.getRequestDispatcher("/Pages/Workers.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void retrieveWorkers() {
        DbHandler dbHandler = DbHandler.getInstance();
        if (!dbHandler.isConnected())
        	dbHandler.connect();
        
        Workers = dbHandler.getWorkers();
	}
	
	@Override
	public void init() {

	}

}
