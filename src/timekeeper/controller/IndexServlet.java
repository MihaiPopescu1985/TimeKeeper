package timekeeper.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import timekeeper.services.DbHandler;
import timekeeper.services.SocketClient;


public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			
		response.sendRedirect(request.getContextPath() + "/Pages/Index.jsp");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	@Override
	public void init() {
		DbHandler dbHandler = DbHandler.getInstance();
		if (!dbHandler.isConnected())
			dbHandler.connect();
		new Thread(SocketClient.getInstance()).start();
	}
}
