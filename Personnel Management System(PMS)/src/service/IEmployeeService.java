package service;

import java.util.List;

import PMS.vo.Employee;
 
public interface IEmployeeService {
	/**
	 * 实现员工数据的增加操作，调用的是IEmployeeDAO.doCreate()方法保存员工信息
	 * @param em 包含了要增加数据的Employee类对象
	 * @return 数据增加成功返回true，否则返回false
	 * @throws Exception IEmployeeDAO接口中的抛出异常
	 */
	public boolean insert(Employee em) throws Exception;
	/**
	 * 显示数据的修改操作，调用的是IEmployeeDAO.doUpdate()方法修改员工信息
	 * @param em 包含了要修改的数据信息
	 * @return 
	 * @throws Exception IEmployeeDAO接口中的抛出异常
	 */
	public boolean update(Employee em)throws Exception;
	/**
	 * 实现数据的删除操作，调用的是IEmployeeDAO.doRemove()方法删除员工信息
	 * @param em 包含了要删除的数据信息
	 * @return 删除成功返回true， 否则返回false
	 * @throws Exception IEmployeeDAO接口中的抛出异常
	 */
	public boolean delete(Employee em)throws Exception;	
	/**
	 * 查询符合条件的员工的完整信息，调用的是IEmployeeDAO.findByAll()方法查询员工信息
	 * @param em 包含了要查询的数据信息
	 * @return 将查询到的内容以List的形式返回
	 * @throws Exception 如果数据库没有连接，则抛出NullPointerExceptino,如果SQL语句错误抛出SQLException
	 */
	public List<Employee> findByAll(Employee em) throws Exception;
	/**
	 * 查询数据表中的全部数据，调用的是IEmployeeDAO.findAll()方法查询员工信息
	 * @return 全部查询数据行，如果没有数据返回则集合长度为0(size()==0)
	 * @throws Exception 如果数据库没有连接，则抛出NullPointerExceptino,如果SQL语句错误抛出SQLException
	 */
	public List<Employee> findAll() throws Exception;
	
}
