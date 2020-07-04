package PMS.factory;

import PMS.service.impl.EmployeeServiceImpl;
import service.IEmployeeService;

public class EmloyeeServiceFactory {
	public static IEmployeeService getIEmpServiceInstance(){
		return new EmployeeServiceImpl();
	}
}
