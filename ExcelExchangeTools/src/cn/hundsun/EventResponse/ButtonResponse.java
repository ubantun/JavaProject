package cn.hundsun.EventResponse;

import java.awt.event.ActionEvent;

import cn.hundsun.ChooseFile.ChooseFile;
import cn.hundsun.Interface.MainInterface;

public class ButtonResponse {
		
	public static  void ButtonChoose(ActionEvent e) {
		
		if (e.getSource().equals(MainInterface.button1)) {		//�жϴ��������İ�ť���ĸ�			
			ChooseFile.Button1_response();
        }
        if (e.getSource().equals(MainInterface.button2)) {
        	ChooseFile.Button2_response();
        }
        if (e.getSource().equals(MainInterface.button3)) {
            ChooseFile.Button3_response();
        }
	}
	
}
