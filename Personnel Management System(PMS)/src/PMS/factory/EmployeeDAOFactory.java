package PMS.factory;

import java.sql.Connection;

import PMS.dao.IEmployeeDAO;
import PMS.dao.impl.EmployeeDAOImpl;

public class EmployeeDAOFactory {
	public static IEmployeeDAO getIEmployeeDAOInstance(Connection conn) {
		return new EmployeeDAOImpl(conn);
	}
}
