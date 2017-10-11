package cn.hundsun.ChooseFile;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

import jxl.JXLException;
import jxl.write.WriteException;
import cn.hundsun.Exchange.ExchangeFile;
import cn.hundsun.Interface.MainInterface;

public class ChooseFile {
	
	public static File file1 = null;//选中的文件
	public static File file2 = null;//选中的文件
	public static JFileChooser filechooser1 = new JFileChooser();//文件选择器
	public static JFileChooser filechooser2 = new JFileChooser();
	
    public static void Button1_response() {
    	
    	filechooser1.setFileSelectionMode(0);			//设定只能选择到文件
    	if (filechooser1 == null) {
    		JOptionPane.showConfirmDialog(null, "请选择要转换的文件", "提示", JOptionPane.CLOSED_OPTION);
    		return;
      }
        int state = filechooser1.showOpenDialog(null);	//此句是打开文件选择器界面的触发语句
        if (state == 1) {
            return;										//撤销则返回
        } else {
        	file1 = filechooser1.getSelectedFile();		//获取选择到的文件的绝对路径
        	
        	/*将获取到的绝对路径放到文本路径中*/
        	MainInterface.filename1.setText(file1.getAbsolutePath());
        }
	}
    
    public static void Button2_response() 
    {
    	filechooser2.setFileSelectionMode(1);			//设定只能选择到目录
    	filechooser2.setCurrentDirectory(new File("D:/"));

        filechooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int state = filechooser2.showOpenDialog(null);	//此句是打开文件选择器界面的触发语句
          
        if (state == 1) {
            return;										//撤销则返回
        } else {
        	file2 = filechooser2.getSelectedFile();		//获取选择到的目录的绝对路径
        	/*将获取到的绝对路径放到文本路径中*/
        	MainInterface.filename2.setText(file2.getAbsolutePath());
        }
    }
    
    public static void Button3_response() 
    {
    	int ret = 0;

    	if (MainInterface.filename1.getText().length() == 0) {
    		JOptionPane.showConfirmDialog(null, "请选择源文件", "提示", 
    				JOptionPane.CLOSED_OPTION);
    		return ;
		}
    	if (MainInterface.filename2.getText().length() == 0) {
    		JOptionPane.showConfirmDialog(null, "请选择目标文件", "提示", 
    				JOptionPane.CLOSED_OPTION);
    		return ;
		}
    	ret = ExchangeFile.ExchangeExcel(file1,file2);
    	switch (ret) {
		case 0:
			JOptionPane.showConfirmDialog(null, "转换成功", "提示", JOptionPane.CLOSED_OPTION);
			break;
		case -1:
			JOptionPane.showConfirmDialog(null, "转换失败，源文件格式不正确", "提示", JOptionPane.CLOSED_OPTION);
			break;
		case -2:
			JOptionPane.showConfirmDialog(null, "转换失败，目标文件格式不正确", "提示", JOptionPane.CLOSED_OPTION);
		default:
			break;
		}
    } 
}
