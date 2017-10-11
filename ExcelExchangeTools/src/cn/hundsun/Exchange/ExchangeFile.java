package cn.hundsun.Exchange;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.JxlWriteException;
import cn.hundsun.main.Gloable;

public class ExchangeFile {
	
	public static int Read_Write_excel(File file1,File file2) throws WriteException {
		
		Workbook workbook1 = null;
		Workbook workbook2 = null;
		Label label = null;

		Cell cells;
		int row1 = 0,column1 = 0,row2 = 0,column2 = 1;
		String str1 = "";
		String str2 = null;
		
		//创建一个可写的工作簿  
        WritableWorkbook writableWorkbook1 = null;
		try {
			writableWorkbook1 = Workbook.createWorkbook(file2);
		} catch (IOException e1) {
			JOptionPane.showConfirmDialog(null, "文件已经被打开，写入失败", "提示", 
    				JOptionPane.CLOSED_OPTION);
			// TODO Auto-generated catch block
			return Gloable.errno_number5;
			//e1.printStackTrace();
		} 
		
        //创建目标文件新的一页
        WritableSheet writableSheet = writableWorkbook1.createSheet("First Sheet", 0);
        
        //创建要显示的具体内容
        WritableCellFormat cellFormat=new WritableCellFormat();
        //设置对齐
        cellFormat.setAlignment(jxl.format.Alignment.CENTRE);					//水平居中
        cellFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);	//垂直居中
        cellFormat.setWrap(true);												//环绕模式
        cellFormat.setShrinkToFit(true);
       
        
        //设置新表格的标题
        for (int i = 0; i < Gloable.Test_Title.length; i++) {
        	 label = new Label(i,0, Gloable.Test_Title[i]);
        	 //设置表格格式
        	 label.setCellFormat(cellFormat);
             //将内容写入表格中
        	 writableSheet.addCell(label);
		}
 
        try {
			workbook1 = Workbook.getWorkbook(file1);
		} catch (BiffException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
        Sheet sheet1 = workbook1.getSheet(0);					//获取源文件的第一页					
		int total_rows0 = sheet1.getRows();						//获取第一页总共多少行
		int total_columns0 = sheet1.getColumns();				//获取第一页总共多少列
		int function_point_flag = 0;
		int test_point_flag = 0;
        
        /*添加合并单元格，第一个参数是起始列，第二个参数是起始行，第三个参数是终止列，
        	第四个参数是终止行*/
        //sheet.mergeCells(0, 0, 4, 0);
  
		
    	for (column1 = 1; column1 <total_rows0; column1++) {				//源文件的第几行
			cells = sheet1.getCell(0,column1);
			if (str1 != null) {
				str2 = str1;
			}
			str1 = cells.getContents().toString();				//获取第几行第几列的单元格的内容
			//writableSheet.setRowView(1, true);
			
			//将功能说明写入表格
			if(str1.equals(Gloable.Test_Title[0]) == true)
			{
				label = new Label(0,1, sheet1.getCell(0+2,column1).getContents());
				label.setCellFormat(cellFormat);
				writableSheet.addCell(label);

			}
			//将需求说明/需求描述写入表格
			else if(str1.indexOf(Gloable.Test_Title[1]) !=-1)
			{
				//将多个功能点对应的功能说明合并单元格
				if (function_point_flag >= 2) {
					function_point_flag = 0;
				}
				label = new Label(row2+1,column2, sheet1.getCell(0+2,column1).getContents());
				label.setCellFormat(cellFormat);
				writableSheet.addCell(label);
			}
			//将功能点写入表格
			else if(str1.equals(Gloable.Test_Title[4]) == true)
			{
				label = new Label(row2+4,column2, sheet1.getCell(0+2,column1).getContents());
				label.setCellFormat(cellFormat);
				writableSheet.addCell(label);
				
				function_point_flag ++;
				column2++;
				
				
			}
			//将测试点写入表格
			else if(str1.equals(Gloable.Test_Title[5]) == true)
			{
				
				if (str2 .equals(Gloable.Test_Title[4]) == true ) {
					label = new Label(row2+5,column2-1, sheet1.getCell(0+2,column1).getContents());
				}
				else //if (str2 .equals(Gloable.Test_Title[5]) == true) {
				{
					label = new Label(row2+5,column2, sheet1.getCell(0+2,column1).getContents());
					column2++;
				}
				label.setCellFormat(cellFormat);
				try {
					writableSheet.addCell(label);
				} catch (JxlWriteException e) {
					// TODO: handle exception
					System.out.println("write error:"+str2);
					break;
				}
					
				test_point_flag ++; 	
			}
			//将测试场景写入表格
			else if(str1.equals(Gloable.Test_Title[6]) == true )
			{
				if (str2 .equals(Gloable.Test_Title[5]) == true ) {
					label = new Label(row2+6,column2-1, sheet1.getCell(0+2,column1).getContents());
				}
				else {
					label = new Label(row2+6,column2, sheet1.getCell(0+2,column1).getContents());
					column2++;
				}
				
				label.setCellFormat(cellFormat);
				writableSheet.addCell(label);
					
				test_point_flag ++; 	
			}
			//将多个测试场景写入表格
			else if((str1.length() == 0) 
					&& (sheet1.getCell(0+2,column1).getContents().length() != 0 ))
			{
				label = new Label(row2+6,column2, sheet1.getCell(0+2,column1).getContents());
				column2++;
				label.setCellFormat(cellFormat);
				try {
					writableSheet.addCell(label);
				} catch (JxlWriteException e) {
					// TODO: handle exception
					System.out.println("write error:"+str2);
					break;
				}
					
				test_point_flag ++; 	
			}			
		}
    	//将剩下的固定内容填充好
    	for (int k = 1; k < column2; k++) {
    		label = new Label(row2+2,k, Gloable.Test_content[0]);
			label.setCellFormat(cellFormat);
			writableSheet.addCell(label);
			
			label = new Label(row2+3,k, Gloable.Test_content[1]);
			label.setCellFormat(cellFormat);
			writableSheet.addCell(label);
			
			label = new Label(row2+7,k, Gloable.Test_content[2]);
			label.setCellFormat(cellFormat);
			writableSheet.addCell(label);
		}
    	//一定要用write()把创建的内容写入到输出流中，并关闭输出流
        try {
        	writableWorkbook1.write();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return Gloable.errno_number4;
		}  
		try {
			writableWorkbook1.close();
		} catch (WriteException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return 0;   
	}
	
	public static int ExchangeExcel(File file1,File file2) {
		
		int ret = 0;
		String str1 = file1.getPath();
		String str2 = null;
		File newfile = null;

		if (!str1.endsWith(".xls")) 							//判断源文件的格式是否为.xls
		{
			JOptionPane.showConfirmDialog(null, "很抱歉，本软件当前仅支持.xls格式的表格", "提示", 
    				JOptionPane.CLOSED_OPTION);
			return Gloable.errno_number2;
		}

		if (file2.isDirectory()) {								//判断目标文件是否为目录
			str2 = file2 + "\\ExcelExchange_excel.xls" ; 
			newfile = new File(str2);
			System.out.println(newfile);
			if (newfile.exists()) {								//判断目标文件是否已经存在，如果存在则删除
				JOptionPane.showConfirmDialog(null, "文件已存在，将替换该文件", "提示", 
	    				JOptionPane.CLOSED_OPTION);
				newfile.delete();	
				newfile = new File(str2);
			}			
		}
		else {
			return Gloable.errno_number3;
		}

		try {
			ret = Read_Write_excel(file1, newfile);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return Gloable.errno_number2;
		}
		
//		Object[] options = { "确定", "取消" }; 
//		JOptionPane.showOptionDialog(null, "点击确定继续，点取取消则返回", "提示：", 
//		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]); 
		
		return ret;
	}
	
}
