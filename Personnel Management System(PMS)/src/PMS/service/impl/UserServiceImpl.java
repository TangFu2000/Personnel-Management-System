package PMS.service.impl;

import PMS.dbc.DatabaseConnection;
import PMS.factory.UserDAOFactory;
import PMS.vo.User;
import service.IUserService;

public class UserServiceImpl implements IUserService {
	private DatabaseConnection dbc=new DatabaseConnection();
	@Override
	public boolean login(User user) throws Exception {
		boolean flag=false;
		try {
			//利用UserFactory类中的getIUserDAOInstance()方法取得IEmployeeDAO接口对象
			//在调用getIUserDAOInstance()时候需要通过DatabaseConnection对象取得Connection接口对象，传递进去
			UserDAOFactory.getIUserDAOInstance(this.dbc.getConnection()).login(user);
			flag=true;	
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}
}
