package by.htp.payments.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import by.htp.payments.dao.BasicDao;
import by.htp.payments.domain.entity.User;
import by.htp.payments.domain.vo.UserCatalog;

public class BasicDaoImpl implements BasicDao {

	@Override
	public UserCatalog readUserCatalog() {
		UserCatalog userCatalog = testCatalog();
		System.out.println( "BasicDaoImpl: readUserCatalog: " + userCatalog );
		return userCatalog;
	}
	
	private UserCatalog testCatalog() {
		UserCatalog userCatalog = null;
		
		List<User> users = new ArrayList<User>();
		users.add( new User( "user_1", 33, "login_1", "1", "admin" ) );
		users.add( new User( "user_2", 43, "login_2", "2", "user" ) );
		users.add( new User( "user_3", 28, "login_3", "3", "user" ) );
		users.add( new User( "user_4", 46, "login_4", "4", "guest" ) );
		users.add( new User( "user_5", 48, "login_5", "5", "guest" ) );
		String title = "Title 1";
		
		userCatalog = new UserCatalog( title, users );
				
		return userCatalog;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String readRoleName( int roleID ) {
		// TODO Auto-generated method stub
		return null;
	}

}
