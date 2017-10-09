package by.htp.payments.dao;

import java.util.HashMap;

import by.htp.payments.domain.entity.User;
import by.htp.payments.domain.vo.UserCatalog;

public interface BasicDao {
	
	UserCatalog readUserCatalog();
	
	String readRoleName( int roleID );
	
	void addUser( User user );

}
