package cn.hundsun.main;

public class Gloable {
	public static final int errno_number1 = 0;	//no error
	public static final int errno_number2 = -1;	//the file is error
	public static final int errno_number3 = -2;	//is not the directory
	public static final int errno_number4 = -3;	//there is a write-error
	public static final int errno_number5 = -4;	//the file has been open by others
	
	static final String Test_Type = "��������";
	static final String Test_Mode = "ģ��";
	static final String Test_FuncPoint = "���ܵ�";
	static final String Test_TestPoint = "���Ե�";
	static final String Test_TestScenes = "���Գ���";
	static final String Test_Posi_Nega = "������";
	static final String Test_Priority = "���ȼ�";
	static final String Test_GroupNo = "���";
	static final String Test_ScriptName = "�ű���";
	static final String Test_PreCondit = "ǰ������";
	static final String Test_InputDdata = "��������";
	static final String Test_InterExpec = "��������";
	static final String Test_CheckState = "������";
	static final String Test_DataExpect = "��������";
	static final String Test_Remarks = "��ע";
	static final String Test_WhethPerfo= "�Ƿ�ִ��";
	static final String Test_ResulCarry = "ִ�н��";
	static final String Test_ErrorMessa = "������Ϣ";
	
	static final String Test_FuncDescrip = "����˵��";
	static final String Test_RequiDescrip = "����";
	
	static final String Type_Function = "����";
	static final String Type_BackServi = "��̨����";
	static final String Type_PosNegExa = "��";			//������
	
	public static final String[] Test_Title = {Test_FuncDescrip,Test_RequiDescrip,Test_Type,Test_Mode,Test_FuncPoint,Test_TestPoint,Test_TestScenes,
		Test_Posi_Nega,Test_Priority,Test_GroupNo,Test_ScriptName,Test_PreCondit,Test_InputDdata,
		Test_InterExpec,Test_DataExpect,Test_Remarks,Test_WhethPerfo,Test_ResulCarry,
		Test_ErrorMessa};
	public static final String[] Title_exception={Test_FuncDescrip,Test_RequiDescrip};	
	
	public static final String[] Test_content={Type_Function,Type_BackServi,Type_PosNegExa};
}
							
