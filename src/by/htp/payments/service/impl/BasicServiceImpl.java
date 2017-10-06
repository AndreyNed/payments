package by.htp.payments.service.impl;

import by.htp.payments.dao.BasicDao;
import by.htp.payments.dao.impl.BasicDaoImpl;
import by.htp.payments.dao.impl.SQLBasicDaoImpl;
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
	
}
