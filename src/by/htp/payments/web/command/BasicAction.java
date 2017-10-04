package by.htp.payments.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BasicAction {
	
	String executeAction( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException;

}
