package PMS.service.impl;

import java.util.List;

import PMS.dbc.DatabaseConnection;
import PMS.factory.EmployeeDAOFactory;
import PMS.vo.Employee;
import service.IEmployeeService;
/**
 * 当取得本类对象时，就意味着可以进行数据库操作了
 * @author Administrator
 *
 */
public class EmployeeServiceImpl implements IEmployeeService {
	private DatabaseConnection dbc=new DatabaseConnection();
	@Override
	public boolean insert(Employee em) throws Exception {
		boolean flag=false;
		try {
			//利用DAOFactory类中的getIEmployeeDAOInstance()方法取得IEmployeeDAO接口对象
			//在调用getIEmployeeDAOInstance()时候需要通过DatabaseConnection对象取得Connection接口对象，传递进去
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
