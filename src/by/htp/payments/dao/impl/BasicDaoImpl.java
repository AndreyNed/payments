package by.htp.payments.dao.impl;

import java.util.ArrayList;
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
		users.add( new User( "user_1", 33, "login_1", "1", 1 ) );
		users.add( new User( "user_2", 43, "login_2", "2", 2 ) );
		users.add( new User( "user_3", 28, "login_3", "3", 2 ) );
		users.add( new User( "user_4", 46, "login_4", "4", 3 ) );
		users.add( new User( "user_5", 48, "login_5", "5", 3 ) );
		String title = "Title 1";
		
		userCatalog = new UserCatalog( title, users );
				
		return userCatalog;
	}

}
