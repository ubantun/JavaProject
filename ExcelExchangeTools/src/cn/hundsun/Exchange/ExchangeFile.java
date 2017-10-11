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
		
		//����һ����д�Ĺ�����  
        WritableWorkbook writableWorkbook1 = null;
		try {
			writableWorkbook1 = Workbook.createWorkbook(file2);
		} catch (IOException e1) {
			JOptionPane.showConfirmDialog(null, "�ļ��Ѿ����򿪣�д��ʧ��", "��ʾ", 
    				JOptionPane.CLOSED_OPTION);
			// TODO Auto-generated catch block
			return Gloable.errno_number5;
			//e1.printStackTrace();
		} 
		
        //����Ŀ���ļ��µ�һҳ
        WritableSheet writableSheet = writableWorkbook1.createSheet("First Sheet", 0);
        
        //����Ҫ��ʾ�ľ�������
        WritableCellFormat cellFormat=new WritableCellFormat();
        //���ö���
        cellFormat.setAlignment(jxl.format.Alignment.CENTRE);					//ˮƽ����
        cellFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);	//��ֱ����
        cellFormat.setWrap(true);												//����ģʽ
        cellFormat.setShrinkToFit(true);
       
        
        //�����±��ı���
        for (int i = 0; i < Gloable.Test_Title.length; i++) {
        	 label = new Label(i,0, Gloable.Test_Title[i]);
        	 //���ñ���ʽ
        	 label.setCellFormat(cellFormat);
             //������д������
        	 writableSheet.addCell(label);
		}
 
        try {
			workbook1 = Workbook.getWorkbook(file1);
		} catch (BiffException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
        Sheet sheet1 = workbook1.getSheet(0);					//��ȡԴ�ļ��ĵ�һҳ					
		int total_rows0 = sheet1.getRows();						//��ȡ��һҳ�ܹ�������
		int total_columns0 = sheet1.getColumns();				//��ȡ��һҳ�ܹ�������
		int function_point_flag = 0;
		int test_point_flag = 0;
        
        /*��Ӻϲ���Ԫ�񣬵�һ����������ʼ�У��ڶ�����������ʼ�У���������������ֹ�У�
        	���ĸ���������ֹ��*/
        //sheet.mergeCells(0, 0, 4, 0);
  
		
    	for (column1 = 1; column1 <total_rows0; column1++) {				//Դ�ļ��ĵڼ���
			cells = sheet1.getCell(0,column1);
			if (str1 != null) {
				str2 = str1;
			}
			str1 = cells.getContents().toString();				//��ȡ�ڼ��еڼ��еĵ�Ԫ�������
			//writableSheet.setRowView(1, true);
			
			//������˵��д����
			if(str1.equals(Gloable.Test_Title[0]) == true)
			{
				label = new Label(0,1, sheet1.getCell(0+2,column1).getContents());
				label.setCellFormat(cellFormat);
				writableSheet.addCell(label);

			}
			//������˵��/��������д����
			else if(str1.indexOf(Gloable.Test_Title[1]) !=-1)
			{
				//��������ܵ��Ӧ�Ĺ���˵���ϲ���Ԫ��
				if (function_point_flag >= 2) {
					function_point_flag = 0;
				}
				label = new Label(row2+1,column2, sheet1.getCell(0+2,column1).getContents());
				label.setCellFormat(cellFormat);
				writableSheet.addCell(label);
			}
			//�����ܵ�д����
			else if(str1.equals(Gloable.Test_Title[4]) == true)
			{
				label = new Label(row2+4,column2, sheet1.getCell(0+2,column1).getContents());
				label.setCellFormat(cellFormat);
				writableSheet.addCell(label);
				
				function_point_flag ++;
				column2++;
				
				
			}
			//�����Ե�д����
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
			//�����Գ���д����
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
			//��������Գ���д����
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
    	//��ʣ�µĹ̶���������
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
    	//һ��Ҫ��write()�Ѵ���������д�뵽������У����ر������
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

		if (!str1.endsWith(".xls")) 							//�ж�Դ�ļ��ĸ�ʽ�Ƿ�Ϊ.xls
		{
			JOptionPane.showConfirmDialog(null, "�ܱ�Ǹ���������ǰ��֧��.xls��ʽ�ı��", "��ʾ", 
    				JOptionPane.CLOSED_OPTION);
			return Gloable.errno_number2;
		}

		if (file2.isDirectory()) {								//�ж�Ŀ���ļ��Ƿ�ΪĿ¼
			str2 = file2 + "\\ExcelExchange_excel.xls" ; 
			newfile = new File(str2);
			System.out.println(newfile);
			if (newfile.exists()) {								//�ж�Ŀ���ļ��Ƿ��Ѿ����ڣ����������ɾ��
				JOptionPane.showConfirmDialog(null, "�ļ��Ѵ��ڣ����滻���ļ�", "��ʾ", 
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
		
//		Object[] options = { "ȷ��", "ȡ��" }; 
//		JOptionPane.showOptionDialog(null, "���ȷ����������ȡȡ���򷵻�", "��ʾ��", 
//		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]); 
		
		return ret;
	}
	
}
