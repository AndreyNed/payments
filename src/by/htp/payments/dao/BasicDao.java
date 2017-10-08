package by.htp.payments.dao;

import by.htp.payments.domain.entity.User;
import by.htp.payments.domain.vo.UserCatalog;

public interface BasicDao {
	
	UserCatalog readUserCatalog();
	void addUser( User user );

}
