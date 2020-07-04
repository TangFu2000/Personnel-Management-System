package PMS.factory;

import java.sql.Connection;

import PMS.dao.IUserDAO;
import PMS.dao.impl.UserDAOImpl;

public class UserDAOFactory {
	public static IUserDAO getIUserDAOInstance(Connection conn) {
		return new UserDAOImpl(conn);
	}
}
