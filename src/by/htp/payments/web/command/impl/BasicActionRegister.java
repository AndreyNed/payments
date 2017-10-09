package by.htp.payments.web.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.payments.web.command.BasicAction;

public class BasicActionRegister implements BasicAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println( "Basic action: Register: execute action" );		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher( "/WEB-INF/jsp/registration.jsp" );
		requestDispatcher.forward( request, response );
		return null;
	}

}
