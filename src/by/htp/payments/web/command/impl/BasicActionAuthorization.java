package by.htp.payments.web.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.payments.domain.entity.User;
import by.htp.payments.domain.vo.UserCatalog;
import by.htp.payments.service.BasicService;
import by.htp.payments.service.impl.BasicServiceImpl;
import by.htp.payments.web.command.BasicAction;

public class BasicActionAuthorization implements BasicAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println( "Basic action: Authorization: execute action" );
		String login = request.getParameter( "login" );
		String password = request.getParameter( "pass" );
		System.out.println("login: " + login + "; password: " + password);
		BasicService service = new BasicServiceImpl();
		UserCatalog userCatalog = service.getUserCatalog();
		if ( userCatalog != null ) {
			List<User> users = userCatalog.getUsers();
			System.out.println("users: " + users);
			String url = null;
			if ( users != null ) {
				url = getURL( users, login, password );
			}
			if ( url != null ) {
				System.out.println( "URL: " + url );
				RequestDispatcher requestDispatcher = request.getRequestDispatcher( url );
				requestDispatcher.forward( request, response );
			}
		}
		return null;
	}
	
	private String getURL( List<User> users, String login, String password ) {
		System.out.println("getURL is working...");
		String url = null;
		for ( int i = 0; i < users.size(); i++ ) {
			User user = users.get( i );
			//System.out.println("user before check: " + user);
			if ( user.getLogin().equalsIgnoreCase( login ) &&
					user.getPassword().equals( password ) ) {
				System.out.println("User: " + user);
				switch ( user.getRole() ) {
				case 1: //admin
					url = "/WEB-INF/jsp/admin.jsp";
					break;
				case 2: //user
					url = "/WEB-INF/jsp/user.jsp";
					break;
				case 3:  //guest
					url = "/WEB-INF/jsp/guest.jsp";
					break;
				default:
					url = "/WEB-INF/jsp/unregistered.jsp";
				}
			}
		}
		return url;
	}

}
