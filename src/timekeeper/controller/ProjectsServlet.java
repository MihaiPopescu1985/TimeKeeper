package timekeeper.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import timekeeper.model.Project;
import timekeeper.services.DbHandler;


public class ProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private List<Project> Projects;

    public ProjectsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		retrieveProjects();
		
		request.setAttribute("Projects", Projects);
		request.getRequestDispatcher("Pages/Projects.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/Pages/Projects.jsp");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void retrieveProjects() {
        DbHandler dbHandler = DbHandler.getInstance();
        if (!dbHandler.isConnected())
        	dbHandler.connect();
        
        Projects = dbHandler.getProjects();
	}
	
	@Override
	public void init() {

	}

}
