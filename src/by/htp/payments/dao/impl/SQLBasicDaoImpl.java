package by.htp.payments.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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
	private static final String SQL_SELECT_ROLE_NAME = "select * from roles where id=?";
	private static final String SQL_ADD_USER = "insert into users (`name`, `age`, `login`, `password`, `role`) values (?, ?, ?, ?, ?)";
	
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
				int roleID = rs.getInt("role");
				String role = this.readRoleName( roleID );
				System.out.println( "name: " + name + "; role: " + role );
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

	@Override
	public void addUser(User user) {
		PreparedStatement ps = null;
		Connection cn = null;

		try {
			Class.forName(DB_DRIVER);

			cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

			try {
				ps = cn.prepareStatement(SQL_ADD_USER);

				ps.setString( 1, user.getName() );
				ps.setInt( 2, user.getAge() );
				ps.setString( 3, user.getLogin() );
				ps.setString( 4, user.getPassword() );
				ps.setInt( 5, 3 );
				//ps.setInt( 5, user.getRole() );
				// ps.executeQuery();
				ps.executeUpdate();
			} catch (SQLException e) {
				/*throw new DaoException("Problem with adding new book", e);*/
				e.printStackTrace();
			} finally {
				ps.close();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			//throw new DaoException("Problem with database connection", e);
			e.printStackTrace();
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public String readRoleName(int roleID) {
		String roleName = null;
		List<String> roleNameList = null;
		PreparedStatement ps = null;
		
			try {
				Class.forName(DB_DRIVER);
				Connection cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				ps = cn.prepareStatement( SQL_SELECT_ROLE_NAME );
				ps.setInt(1, roleID);
				ResultSet rs = ps.executeQuery();
				
				roleNameList = new ArrayList<String>();
				
				while ( rs.next() ) {
					String role = rs.getString("role");
					System.out.println( "role: " + role );
					roleNameList.add( role );
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if ( roleNameList != null && roleNameList.size() > 0 ) {
			roleName = roleNameList.get( 0 );
		}
		
		return roleName;
	}

	
}
