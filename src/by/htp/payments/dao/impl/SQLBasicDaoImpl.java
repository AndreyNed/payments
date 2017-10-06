package by.htp.payments.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.payments.dao.BasicDao;
import by.htp.payments.domain.entity.User;
import by.htp.payments.domain.vo.UserCatalog;

public class SQLBasicDaoImpl implements BasicDao {
	
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";
	private static final String DB_URL = "jdbc:mysql://localhost/payments?useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String SQL_SELECT_USERS = "select * from users";
	
	@Override
	public UserCatalog readUserCatalog() {
		
		List<User> users = null;
		
		try {
			
			Class.forName(DB_DRIVER);
			Connection cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_USERS);
			users = new ArrayList<User>();
			
			while ( rs.next() ) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String login = rs.getString("login");
				String password = rs.getString("password");
				int role = rs.getInt("role");
				User user = new User( name, age, login, password, role );
				users.add( user );
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		UserCatalog catalog = new UserCatalog();
		catalog.setUsers(users);
		
		return catalog;
	}

}
