package by.htp.payments.service;

import by.htp.payments.domain.entity.User;
import by.htp.payments.domain.vo.UserCatalog;

public interface BasicService {

	UserCatalog getUserCatalog();
	
	void registerNewUser( User user );
	
	String getRoleName( int roleID );
	
}
