package cn.hundsun.Interface;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import cn.hundsun.EventResponse.ButtonResponse;

public class MainInterface extends Frame{
	
	public static final Container con1 = new Container();//����1
	public static final Container con2 = new Container();//����2
	public static final JLabel label1 = new JLabel("Դ�ļ�");
	public static final JLabel label2 = new JLabel("Ŀ���ļ�");
	public static JTextField filename1 = new JTextField();
	public static JTextField filename2 = new JTextField();
	public static final JButton button1 = new JButton("ѡ���ļ�");
	public static final JButton button2 = new JButton("ѡ��·��");
	public static final JButton button3 = new JButton("��ʼת��");
	public static final JButton button4 = new JButton("ȡ��");
	public static final JFrame frame = new JFrame("ExcelExchangeTools");
	
	public MainInterface() throws HeadlessException {
		super();
	}
	public void interface_init()
	{
		System.out.println("Init to exchange");
		int windowWidth;
		int windowHeight;
		int screenWidth;
		int screenHeight;
			
		JTabbedPane tabPane = new JTabbedPane();//ѡ�����
		Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
	    
	    button1.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				ButtonResponse.ButtonChoose(e);
			}
		});
	    
	    button2.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				ButtonResponse.ButtonChoose(e);
			}
		});
	    
	    button3.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				ButtonResponse.ButtonChoose(e);
			}
		});
	    
	    button4.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	    
	    frame.setSize(400, 250);
	    frame.setBackground(Color.WHITE);
	    frame.setVisible(true);
	    
	    windowWidth = frame.getWidth(); 			//��ô��ڿ�
	    windowHeight = frame.getHeight(); 			//��ô��ڸ�
	    Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
	    screenWidth = screenSize.width; 			//��ȡ��Ļ�Ŀ�
	    screenHeight = screenSize.height; 			//��ȡ��Ļ�ĸ�
	    
	    frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
	    
	    label1.setBounds(20, 10, 70, 20);
        label2.setBounds(20, 30, 100, 20);
        filename1.setBounds(90, 10, 120, 20);
        filename2.setBounds(90, 30, 120, 20);
        button1.setBounds(220, 10, 100, 20);
        button2.setBounds(220, 30, 100, 20);
        button3.setBounds(50,60,100,20);
        button4.setBounds(200,60,100,20);
        
	    con1.add(label1);
	    con1.add(label2);
	    con1.add(filename1);
	    con1.add(filename2);
	    con1.add(button1);
	    con1.add(button2);
	    con1.add(button3);
	    con1.add(button4);
	    
	    tabPane.add("Please choose the file",con1);
	    frame.setContentPane(tabPane);
	    
	    frame.addWindowListener(new WindowAdapter() {
			public void WIndowClosing(WindowEvent evt) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	    
		System.out.println("Init End");
	}	
}
