package by.htp.payments.service.impl;

import by.htp.payments.dao.BasicDao;
import by.htp.payments.dao.impl.BasicDaoImpl;
import by.htp.payments.dao.impl.SQLBasicDaoImpl;
import by.htp.payments.domain.entity.User;
import by.htp.payments.domain.vo.UserCatalog;
import by.htp.payments.service.BasicService;

public class BasicServiceImpl implements BasicService {

	@Override
	public UserCatalog getUserCatalog() {
		System.out.println( "BasicServiceImpl: getCatalog is working..." );
		BasicDao dao = new SQLBasicDaoImpl();
		UserCatalog userCatalog = dao.readUserCatalog();
		return userCatalog;
	}

	@Override
	public void registerNewUser(User user) {
		System.out.println("BasicServiceImpl: registerNewUser is working...");
		BasicDao dao = new SQLBasicDaoImpl();
		dao.addUser(user);
	}

	@Override
	public String getRoleName(int roleID) {
		String roleName = null;
		BasicDao dao = new SQLBasicDaoImpl();
		roleName = dao.readRoleName( roleID );
		return roleName;
	}
	
}
