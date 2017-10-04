package by.htp.payments.web.command;

import by.htp.payments.web.command.impl.BasicActionAuthorization;
import by.htp.payments.web.command.impl.BasicActionLogin;

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
		default:
			System.out.println( "Action still has not been implemented..." + command );
		}
		
		return action;
	}

}
