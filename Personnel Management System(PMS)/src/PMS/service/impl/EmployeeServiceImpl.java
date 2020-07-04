package PMS.service.impl;

import java.util.List;

import PMS.dbc.DatabaseConnection;
import PMS.factory.EmployeeDAOFactory;
import PMS.vo.Employee;
import service.IEmployeeService;
/**
 * ��ȡ�ñ������ʱ������ζ�ſ��Խ������ݿ������
 * @author Administrator
 *
 */
public class EmployeeServiceImpl implements IEmployeeService {
	private DatabaseConnection dbc=new DatabaseConnection();
	@Override
	public boolean insert(Employee em) throws Exception {
		boolean flag=false;
		try {
			//����DAOFactory���е�getIEmployeeDAOInstance()����ȡ��IEmployeeDAO�ӿڶ���
			//�ڵ���getIEmployeeDAOInstance()ʱ����Ҫͨ��DatabaseConnection����ȡ��Connection�ӿڶ��󣬴��ݽ�ȥ
			return EmployeeDAOFactory.getIEmployeeDAOInstance(this.dbc.getConnection()).doCreate(em);	
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Employee em) throws Exception {
		try {
			return EmployeeDAOFactory.getIEmployeeDAOInstance(this.dbc.getConnection()).doUpdate(em);
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(Employee em) throws Exception {
		try {
			return EmployeeDAOFactory.getIEmployeeDAOInstance(this.dbc.getConnection()).doRemove(em);
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Employee> findByAll(Employee em) throws Exception {
		try {
			return EmployeeDAOFactory.getIEmployeeDAOInstance(this.dbc.getConnection()).findByAll(em);
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Employee> findAll() throws Exception {
		try {
			return EmployeeDAOFactory.getIEmployeeDAOInstance(this.dbc.getConnection()).findAll();
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

}
