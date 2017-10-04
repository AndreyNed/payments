package by.htp.payments.dao;

import java.util.ArrayList;
import java.util.List;

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
		users.add( new User( "user_1", "1", "admin", 34 ) );
		users.add( new User( "user_2", "2", "user", 34 ) );
		users.add( new User( "user_3", "3", "user", 34 ) );
		users.add( new User( "user_4", "4", "guest", 34 ) );
		users.add( new User( "user_5", "5", "guest", 34 ) );
		String title = "Title 1";
		
		userCatalog = new UserCatalog( title, users );
				
		return userCatalog;
	}

}
