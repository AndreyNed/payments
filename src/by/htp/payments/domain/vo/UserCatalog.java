package by.htp.payments.domain.vo;

import java.io.Serializable;
import java.util.List;

import by.htp.payments.domain.entity.User;

public class UserCatalog implements Serializable {
	
	private static final long serialVersionUID = -5992014586836674794L;
	private String title;
	private List<User> users;
	
	public UserCatalog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserCatalog(String title, List<User> users) {
		super();
		this.title = title;
		this.users = users;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCatalog other = (UserCatalog) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UserCatalog [title=" + title + ", users=" + users + "]";
	}

}
