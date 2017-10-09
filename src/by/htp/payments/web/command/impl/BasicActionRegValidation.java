package by.htp.payments.web.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.payments.domain.entity.User;
import by.htp.payments.service.BasicService;
import by.htp.payments.service.impl.BasicServiceImpl;
import by.htp.payments.web.command.BasicAction;

public class BasicActionRegValidation implements BasicAction{

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Registration - validation has been started: ");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		String passwordRe = request.getParameter("re_pass");
		String role = request.getParameter("role");
		int age = 0;
		//int role = Integer.parseInt(roleStr);
		BasicService service = new BasicServiceImpl();
		if ( ageStr != null ) {
			age = Integer.parseInt(ageStr);
		}
		if ( name != null && age > 0 && login != null && password != null && passwordRe != null && password.equals(passwordRe) ) {
			System.out.println("Registration data: name: " + name + ", age: " + age +
					", login: " + login + ", password: " + password + ", re-entered password: " +
					passwordRe + ", role: " + role);
			User user = new User(name, age, login, password, role);
			System.out.println("New User: " + user);
			service.registerNewUser(user);
			List<User> users = new ArrayList<User>();
			users = service.getUserCatalog().getUsers();
			System.out.println("Catalog has been updated: " + users);
		}
		else {
			System.out.println("Registration is rejected: wrong data");
		}
		return null;
	}

}
