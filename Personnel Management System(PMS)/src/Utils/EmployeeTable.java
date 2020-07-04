package Utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import PMS.vo.Employee;

public class EmployeeTable extends JTable{
	// JTable表分页信息相关变量
    public int currentPage = 1;
    public int pageCount = 20;
    public int totalPage = 0;
    public int totalRowCount = 0;
    public int column = 0;
    public int restCount;
    public Object[][] resultData;
    // JTable表信息相关变量
    private  List<Employee> arraylist=new ArrayList<Employee>();
    public String[] columnNames = { "职工编号", "姓名", "身份证号", "民族", "性别", "出生日期", "学历", "部门", "职称", "住址","手机号码", "电子邮件","编辑时间", "备注" };
    public DefaultTableModel model = null;
    
    public String[] getColumnNames() {
    	return this.columnNames ;
    }
    public int getArraylistLength() {
    	return arraylist.size();
    }
    public int getTotalRowCount() {
		return totalRowCount;
	}
	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}
	public EmployeeTable() {
    	initTable();
    }
    public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
     * 设置当前页
     * @param currentPage
     */
    public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
    
	public  void setArraylist(List<Employee> arraylist) {
    	this.arraylist=arraylist;
    }
	public List<Employee> getArraylist(){
		return this.arraylist;
	}
	
    /**
     * 获取下一页
     */
    public int getNextPage() {
        if (this.currentPage != this.totalPage) {
            return ++currentPage;
        }
        return -1;
    }

    /**
     * 获取上一页
     */
    public int getPreviousPage() {
        if (this.currentPage != 1) {
            return --currentPage;
        }
        return -1;
    }

    /**
     * 获取最后一页
     */
    public int getLastPage() {
        return this.totalPage;
    }

    /**
     * 获取第一页
     */
    public int getFirstPage() {
        return 1;
    }

    /**
     * 获取总页数
     */
    public int getTotolPage() {
        return this.totalPage;
    }

    /**
     * 获取当前页
     */
    public int getCurrentPage() {
        return this.currentPage;
    }
	
	/**
	 * 获得原始数据集
	 * @param arraylist
	 * @return
	 */
	public Object[][] getData(List<Employee> arraylist){
		if(arraylist.size()>0) {
			Object[][] data=new Object[arraylist.size()][14];
			for(int i=0;i<arraylist.size();i++) {
				Employee em= arraylist.get(i);
				Object[] a={em.getEmployeeID(),em.getName(),em.getCardNumber(),em.getNation(),em.getSex(),em.getBirthday(),em.getSchoolRecord(),em.getDepartment(),em.getPositionName(),em.getRoad(),em.getTellphone(),em.getEmail(),em.getEditTime(),em.getInfo()};
				data[i]=a;
			}
			return data;
		}
		return null;
}
				
	public void initResultData(Object[][] data) {
		if(data!=null) {
			resultData=data;//总的结果集
			column=data[0].length;//表的列数
			totalRowCount=data.length;//表的长度
			totalPage=totalRowCount%pageCount==0?totalRowCount/pageCount:totalRowCount/pageCount+1;//结果集的总页数
			restCount=totalRowCount%pageCount==0?20:totalRowCount%pageCount;//最后一页的数据数
		}
	}
	/**
	 * 获取分页数据
	 * @return
	 */
	public Object[][] getPageData(){
		Object[][] currentPageData=new Object[pageCount][column];//构造每页数据集
		if(this.getCurrentPage()<this.totalPage) {//如果当前页数小于总页数，那么每页数目应该是规定的书Page Count
			for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+pageCount;i++) {
				for(int j=0;j<column;j++) {//把结果集中对应的每一行数据全部赋值给当前页的每一行每一列
					currentPageData[i%pageCount][j]=resultData[i][j];
				}
			}
		}
		else {
			//在动态改变数据结果集的时候，如果当前页没有数据了，则回到前一页（一般针对最后一页而言）
			if(pageCount*(this.getCurrentPage()-1)>=totalRowCount) 
				this.currentPage=this.getTotolPage();
			for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+restCount;i++) {
				for(int j=0;j<column;j++) {
					currentPageData[i%pageCount][j]=resultData[i][j];
				}
			}
		}
		return currentPageData;
	}
    
	/**
	 * 初始化表格数据
	 */
    public void initTable() {
    	Object[][] data=getData(arraylist);
    	if(data!=null) {
    		initResultData(data);
    		model=new DefaultTableModel(getPageData(),columnNames);
    	}else {
    		//如果结果集中没有数据，那么就用空来代替数据集中的每一行
    		Object[][] nothing= {{},{},{},{},{},{},{},{},{},{},{},{},{},{}};
    		model=new DefaultTableModel(nothing,columnNames);
    		totalRowCount=0;
    	}
    	this.setModel(model);
    	this.setRowHeight(20);
    	DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Object.class, r);
    }   
}
