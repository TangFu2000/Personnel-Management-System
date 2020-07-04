package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelExporter{
	public ExcelExporter() { }
	public void exportTable(JTable table, File file) throws IOException, RowsExceededException, WriteException {
	    try {
	        OutputStream out = new FileOutputStream(file);
	        TableModel model = table.getModel();
	        WritableWorkbook wwb = Workbook.createWorkbook(out);
	        // 创建子表，并写入数据
	        WritableSheet ws = wwb.createSheet("人员信息", 0);
	        // 添加标题
	        for (int i = 0; i < model.getColumnCount(); i++) {
	            jxl.write.Label labelN = new jxl.write.Label(i, 0, model.getColumnName(i));
	            try {
	                ws.addCell(labelN);
	            } catch (RowsExceededException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (WriteException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        // 添加信息
	        for (int i = 0; i < model.getColumnCount(); i++) {
	            for (int j = 1; j <= model.getRowCount(); j++) {
	            	if(model.getValueAt(j - 1, i)==null) {//不判空，写入会报错
	            		jxl.write.Label labelN = new jxl.write.Label(i, j, "");
	            		ws.addCell(labelN);
	            	}
	            	else {
	            		jxl.write.Label labelN = new jxl.write.Label(i, j, model.getValueAt(j - 1, i).toString());
	            		ws.addCell(labelN);
	            	}
	            }
	        }
	        wwb.write();
	        JOptionPane.showMessageDialog(null, "导出工作表成功！");
	        try {
	            wwb.close();
	            out.close();
	        } catch (WriteException e) {
	            e.printStackTrace();
	        }
	    } catch (FileNotFoundException e) {
	        JOptionPane.showMessageDialog(null, "导入数据前请关闭工作表");
	    }
	}

}