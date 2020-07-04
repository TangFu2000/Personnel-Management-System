package PMS.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import PMS.dao.IEmployeeDAO;
import PMS.vo.Employee;
/**
 * 如果要想操作数据层子类，那么一定要在构造方法中传入Connection接口对象
 * @author Administrator
 *
 */
public class EmployeeDAOImpl implements IEmployeeDAO {
	private Connection conn;	//数据库连接对象
	private PreparedStatement pstmt ;	//数据库的操作对象
	/**
	 * 实例化数据层子类对象，同时传入一个数据库连接对象
	 * @param conn Connection连接对象，如果为null，表示数据库没有打开
	 */
	public EmployeeDAOImpl(Connection conn) {
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Employee em) throws Exception {
		String sql = "insert into Employee(employeeID,name,cardNumber,nation,sex ,birthday,schoolRecord,department,positionName,road,tellphone,email,editTime,info) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,em.getEmployeeID());
		this.pstmt.setString(2,em.getName());
		this.pstmt.setString(3,em.getCardNumber());
		this.pstmt.setString(4,em.getNation());
		this.pstmt.setString(5,em.getSex());
		this.pstmt.setString(6,em.getBirthday());
		this.pstmt.setString(7,em.getSchoolRecord());
		this.pstmt.setString(8,em.getDepartment());
		this.pstmt.setString(9,em.getPositionName());
		this.pstmt.setString(10,em.getRoad());
		this.pstmt.setString(11,em.getTellphone());
		this.pstmt.setString(12,em.getEmail());
		this.pstmt.setString(13,em.getEditTime());
		this.pstmt.setString(14,em.getInfo());
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Employee em) throws Exception {
		String sql = "UPDATE Employee set name=?,cardNumber=?,nation=?,sex=? ,birthday=?,schoolRecord=?,department=?,positionName=?,road=?,tellphone=?,email=?,editTime=?,info=? where employeeID=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,em.getName());
		this.pstmt.setString(2,em.getCardNumber());
		this.pstmt.setString(3,em.getNation());
		this.pstmt.setString(4,em.getSex());
		this.pstmt.setString(5,em.getBirthday());
		this.pstmt.setString(6,em.getSchoolRecord());
		this.pstmt.setString(7,em.getDepartment());
		this.pstmt.setString(8,em.getPositionName());
		this.pstmt.setString(9,em.getRoad());
		this.pstmt.setString(10,em.getTellphone());
		this.pstmt.setString(11,em.getEmail());
		this.pstmt.setString(12,em.getEditTime());
		this.pstmt.setString(13,em.getInfo());
		this.pstmt.setString(14,em.getEmployeeID());
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(Employee em) throws Exception {
		String sql="DELETE from Employee where employeeID ='"+em.getEmployeeID()+"'";
		this.pstmt=this.conn.prepareStatement(sql);
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public List<Employee> findByAll(Employee em) throws Exception {
		List<Employee> list=new ArrayList<Employee>();
		StringBuffer sql=new StringBuffer("select * from Employee where");
		if(!em.getEmployeeID().trim().equals("")) {
			sql.append(" employeeID like '%"+em.getEmployeeID().trim()+"%'");
		}
		if(!em.getName().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and"); 
			}
			sql.append(" name like '%"+em.getName().trim()+"%'");
		}
		if(!em.getCardNumber().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" cardNumber like '%"+em.getCardNumber().trim()+"%'");
		}
		if(!em.getNation().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" nation like '%"+em.getNation().trim()+"%'");
		}
		if(!em.getSex().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" sex='"+em.getSex().trim()+"'");
		}
		
		if(!em.getBirthday().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" brithday like '%"+em.getBirthday().trim()+"%'");
		}
		if(!em.getSchoolRecord().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" schoolRecord like '%"+em.getSchoolRecord().trim()+"%'");
		}
		if(!em.getDepartment().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" department like '%"+em.getDepartment().trim()+"%'");
		}
		if(!em.getPositionName().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" positionName like '%"+em.getPositionName().trim()+"%'");
		}
		if(!em.getRoad().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" road like '%"+em.getRoad().trim()+"%'");
		}
		if(!em.getTellphone().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" tellphone like '%"+em.getTellphone().trim()+"%'");
		}
		if(!em.getEmail().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" email like '%"+em.getEmail().trim()+"%'");
		}
		if(!em.getEditTime().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" editTime like '%"+em.getEditTime().trim()+"%'");
		}
		if(!em.getInfo().trim().equals("")) {
			if(!sql.toString().endsWith("where")) {
				sql.append(" and");
			}
			sql.append(" info like '%"+em.getInfo().trim()+"%'");
		}
		this.pstmt=this.conn.prepareStatement(sql.toString());
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			Employee e=new Employee();
			e.setEmployeeID(rs.getString(1));
			e.setName(rs.getString(2));
			e.setCardNumber(rs.getString(3));
			e.setNation(rs.getString(4));
			e.setSex(rs.getString(5));
			e.setBirthday(rs.getString(6));
			e.setSchoolRecord(rs.getString(7));
			e.setDepartment(rs.getString(8));
			e.setPositionName(rs.getString(9));
			e.setRoad(rs.getString(10));
			e.setTellphone(rs.getString(11));
			e.setEmail(rs.getString(12));
			e.setEditTime(rs.getString(13));
			e.setInfo(rs.getString(14));
			list.add(e);
		}
		return list;
	}

	@Override
	public List<Employee> findAll() throws Exception {
		List<Employee> all=new ArrayList<Employee>();
		String sql="select * from Employee";
		this.pstmt=this.conn.prepareStatement(sql.toString());
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			Employee e=new Employee();
			e.setEmployeeID(rs.getString(1));
			e.setName(rs.getString(2));
			e.setCardNumber(rs.getString(3));
			e.setNation(rs.getString(4));
			e.setSex(rs.getString(5));
			e.setBirthday(rs.getString(6));
			e.setSchoolRecord(rs.getString(7));
			e.setDepartment(rs.getString(8));
			e.setPositionName(rs.getString(9));
			e.setRoad(rs.getString(10));
			e.setTellphone(rs.getString(11));
			e.setEmail(rs.getString(12));
			e.setEditTime(rs.getString(13));
			e.setInfo(rs.getString(14));
			all.add(e);
		}
		return all;
	}

}
