package by.htp.payments.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.payments.web.command.BasicAction;
import by.htp.payments.web.command.CommandChooser;
import by.htp.payments.web.command.CommandType;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("MainServlet - Init");
	}

	public void destroy() {
		System.out.println("MainServlet - destroy");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainServlet - service");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainServlet - doGet");
		processRequest( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainServlet - doPost");
		processRequest( request, response );
	}
	
	private void processRequest( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		System.out.println("processRequest");
		String command = request.getParameter("command");
		CommandType commandType = null;
		if ( command != null ) {
			commandType = CommandType.valueOf( command.toUpperCase() );
		}
		System.out.println( "command: " + commandType );
		BasicAction action = CommandChooser.performAction( commandType );
		if ( action != null ) {
			action.executeAction( request, response );
		}
		
	}

}
