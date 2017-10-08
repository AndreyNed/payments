package by.htp.payments.web.command;

import by.htp.payments.web.command.impl.BasicActionAbout;
import by.htp.payments.web.command.impl.BasicActionAuthorization;
import by.htp.payments.web.command.impl.BasicActionError;
import by.htp.payments.web.command.impl.BasicActionHome;
import by.htp.payments.web.command.impl.BasicActionLogin;
import by.htp.payments.web.command.impl.BasicActionRegValidation;
import by.htp.payments.web.command.impl.BasicActionRegister;

public class CommandChooser {
	
	public static BasicAction performAction ( CommandType command ) {
		
		BasicAction action = null;
		switch( command ) {
		case LOGIN:
			action = new BasicActionLogin();
			break;
		case AUTHORIZE:
			action = new BasicActionAuthorization();
			break;
		case HOME:
			action = new BasicActionHome();
			break;
		case ABOUT:
			action = new BasicActionAbout();
			break;
		case REGISTRATION:
			action = new BasicActionRegister();
			break;
		case REG_VALIDATION:
			action = new BasicActionRegValidation();
			break;
		default:
			System.out.println( "Action still has not been implemented..." + command );
			action = new BasicActionError();
		}
		
		return action;
	}

}
