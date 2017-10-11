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
	
	public static File file1 = null;//ѡ�е��ļ�
	public static File file2 = null;//ѡ�е��ļ�
	public static JFileChooser filechooser1 = new JFileChooser();//�ļ�ѡ����
	public static JFileChooser filechooser2 = new JFileChooser();
	
    public static void Button1_response() {
    	
    	filechooser1.setFileSelectionMode(0);			//�趨ֻ��ѡ���ļ�
    	if (filechooser1 == null) {
    		JOptionPane.showConfirmDialog(null, "��ѡ��Ҫת�����ļ�", "��ʾ", JOptionPane.CLOSED_OPTION);
    		return;
      }
        int state = filechooser1.showOpenDialog(null);	//�˾��Ǵ��ļ�ѡ��������Ĵ������
        if (state == 1) {
            return;										//�����򷵻�
        } else {
        	file1 = filechooser1.getSelectedFile();		//��ȡѡ�񵽵��ļ��ľ���·��
        	
        	/*����ȡ���ľ���·���ŵ��ı�·����*/
        	MainInterface.filename1.setText(file1.getAbsolutePath());
        }
	}
    
    public static void Button2_response() 
    {
    	filechooser2.setFileSelectionMode(1);			//�趨ֻ��ѡ��Ŀ¼
    	filechooser2.setCurrentDirectory(new File("D:/"));

        filechooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int state = filechooser2.showOpenDialog(null);	//�˾��Ǵ��ļ�ѡ��������Ĵ������
          
        if (state == 1) {
            return;										//�����򷵻�
        } else {
        	file2 = filechooser2.getSelectedFile();		//��ȡѡ�񵽵�Ŀ¼�ľ���·��
        	/*����ȡ���ľ���·���ŵ��ı�·����*/
        	MainInterface.filename2.setText(file2.getAbsolutePath());
        }
    }
    
    public static void Button3_response() 
    {
    	int ret = 0;

    	if (MainInterface.filename1.getText().length() == 0) {
    		JOptionPane.showConfirmDialog(null, "��ѡ��Դ�ļ�", "��ʾ", 
    				JOptionPane.CLOSED_OPTION);
    		return ;
		}
    	if (MainInterface.filename2.getText().length() == 0) {
    		JOptionPane.showConfirmDialog(null, "��ѡ��Ŀ���ļ�", "��ʾ", 
    				JOptionPane.CLOSED_OPTION);
    		return ;
		}
    	ret = ExchangeFile.ExchangeExcel(file1,file2);
    	switch (ret) {
		case 0:
			JOptionPane.showConfirmDialog(null, "ת���ɹ�", "��ʾ", JOptionPane.CLOSED_OPTION);
			break;
		case -1:
			JOptionPane.showConfirmDialog(null, "ת��ʧ�ܣ�Դ�ļ���ʽ����ȷ", "��ʾ", JOptionPane.CLOSED_OPTION);
			break;
		case -2:
			JOptionPane.showConfirmDialog(null, "ת��ʧ�ܣ�Ŀ���ļ���ʽ����ȷ", "��ʾ", JOptionPane.CLOSED_OPTION);
		default:
			break;
		}
    } 
}
