package PMS.factory;

import PMS.service.impl.UserServiceImpl;
import service.IUserService;

public class UserServiceFactory {
	public static IUserService getUserServiceInstance(){
		return new UserServiceImpl();
	}
}
