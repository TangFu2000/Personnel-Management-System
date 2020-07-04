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
			//����UserFactory���е�getIUserDAOInstance()����ȡ��IEmployeeDAO�ӿڶ���
			//�ڵ���getIUserDAOInstance()ʱ����Ҫͨ��DatabaseConnection����ȡ��Connection�ӿڶ��󣬴��ݽ�ȥ
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
