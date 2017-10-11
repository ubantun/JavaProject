package cn.hundsun.main;

public class Gloable {
	public static final int errno_number1 = 0;	//no error
	public static final int errno_number2 = -1;	//the file is error
	public static final int errno_number3 = -2;	//is not the directory
	public static final int errno_number4 = -3;	//there is a write-error
	public static final int errno_number5 = -4;	//the file has been open by others
	
	static final String Test_Type = "测试类型";
	static final String Test_Mode = "模块";
	static final String Test_FuncPoint = "功能点";
	static final String Test_TestPoint = "测试点";
	static final String Test_TestScenes = "测试场景";
	static final String Test_Posi_Nega = "正反例";
	static final String Test_Priority = "优先级";
	static final String Test_GroupNo = "组号";
	static final String Test_ScriptName = "脚本名";
	static final String Test_PreCondit = "前置条件";
	static final String Test_InputDdata = "输入数据";
	static final String Test_InterExpec = "界面期望";
	static final String Test_CheckState = "检查语句";
	static final String Test_DataExpect = "数据期望";
	static final String Test_Remarks = "备注";
	static final String Test_WhethPerfo= "是否执行";
	static final String Test_ResulCarry = "执行结果";
	static final String Test_ErrorMessa = "错误信息";
	
	static final String Test_FuncDescrip = "功能说明";
	static final String Test_RequiDescrip = "需求";
	
	static final String Type_Function = "功能";
	static final String Type_BackServi = "后台服务";
	static final String Type_PosNegExa = "正";			//正反例
	
	public static final String[] Test_Title = {Test_FuncDescrip,Test_RequiDescrip,Test_Type,Test_Mode,Test_FuncPoint,Test_TestPoint,Test_TestScenes,
		Test_Posi_Nega,Test_Priority,Test_GroupNo,Test_ScriptName,Test_PreCondit,Test_InputDdata,
		Test_InterExpec,Test_DataExpect,Test_Remarks,Test_WhethPerfo,Test_ResulCarry,
		Test_ErrorMessa};
	public static final String[] Title_exception={Test_FuncDescrip,Test_RequiDescrip};	
	
	public static final String[] Test_content={Type_Function,Type_BackServi,Type_PosNegExa};
}
							
