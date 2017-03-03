import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class list extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	SqList L = new SqList(10);
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_8;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					list frame = new list();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public list() {
		for (int i = 0; i <= 6; i++)
			try {
				L.insert(i, i);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u7F6E\u7A7A");					//置空
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				L.clear();
				textField.setText("成功");
				L.display();
				String str="";
				for (int j = 0; j < L.curLen; j++)
					str=str+L.listElem[j] + " ";
				textField_9.setText(str);
				
			}
		});
		btnNewButton.setBounds(10, 10, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5224\u7A7A");				//判断空
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(L.isEmpty())
				{
					textField_1.setText("空");
				}
				else
				{
					textField_1.setText("非空");
				}
				String str="";
				for (int j = 0; j < L.curLen; j++)
					str=str+L.listElem[j] + " ";
				textField_9.setText(str);
			}
		});
		btnNewButton_1.setBounds(10, 60, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6C42\u957F\u5EA6");				//求长度
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sss=L.length();
				String ssss=""+sss;
				textField_2.setText(ssss);
				String str="";
				for (int j = 0; j < L.curLen; j++)
					str=str+L.listElem[j] + " ";
				textField_9.setText(str);
			}
		});
		btnNewButton_2.setBounds(10, 105, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u53D6\u5143\u7D20");				//取元素
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=textField_3.getText();
				int i=Integer.parseInt(s);
				try {
					L.get(i);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				String str="";
				str=str+L.listElem[i];
				textField_10.setText(str);
			}
		});
		btnNewButton_3.setBounds(10, 153, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u63D2\u5165");				//插入
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=Integer.parseInt(textField_4.getText());
				String x=textField_5.getText();
				try {
					L.insert(i,x+"");
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				L.display();
				String str="";
				for (int j = 0; j < L.curLen; j++)
					str=str+L.listElem[j] + " ";
				textField_9.setText(str);
			}
		});
		btnNewButton_4.setBounds(10, 203, 93, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u5220\u9664");				//删除
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=Integer.parseInt(textField_6.getText());
				try {
					L.remove(i);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				String str="";
				for (int j = 0; j < L.curLen; j++)
					str=str+L.listElem[j] + " ";
				textField_9.setText(str);
			}
		});
		btnNewButton_5.setBounds(10, 253, 93, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u67E5\u627E");						//查找
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object x=textField_7.getText().trim();
				L.indexOf(x);
				L.display();
				int j = 0;
				while (j < L.curLen && !L.listElem[j].equals(x))
					j++;
				if (j < L.curLen)
					{
					String i="";
					i=i+j;
					textField_8.setText(i);
					}				
				else
					textField_8.setText("无");
			}
		});
		btnNewButton_6.setBounds(10, 308, 93, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("\u8F93\u51FA");						//显示
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				L.display();
				String str="";
				for (int j = 0; j < L.curLen; j++)
					str=str+L.listElem[j] + " ";
				textField_9.setText(str);
			}
		});
		btnNewButton_7.setBounds(10, 360, 93, 23);
		contentPane.add(btnNewButton_7);
		
		textField = new JTextField();
		textField.setBounds(200, 11, 66, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 61, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 106, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 154, 66, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(200, 204, 66, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(352, 204, 66, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(200, 254, 66, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(200, 309, 66, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 430, 335, 40);
		contentPane.add(scrollPane);
		
		textField_9 = new JTextField();
		scrollPane.setViewportView(textField_9);
		textField_9.setColumns(10);
		
		JLabel label = new JLabel("\u7ED3\u679C\u663E\u793A");
		label.setBounds(10, 443, 54, 15);
		contentPane.add(label);
		
		textField_10 = new JTextField();
		textField_10.setBounds(352, 154, 66, 21);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u5E8F\u53F7\uFF1A");
		label_1.setBounds(126, 153, 64, 23);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u5E8F\u53F7\uFF1A");
		label_2.setBounds(126, 203, 64, 23);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8F93\u5165\u5E8F\u53F7\uFF1A");
		label_3.setBounds(126, 253, 64, 23);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u8F93\u5165\u5143\u7D20\uFF1A");
		label_4.setBounds(276, 203, 64, 23);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u8F93\u5165\u5143\u7D20\uFF1A");
		label_5.setBounds(126, 308, 64, 23);
		contentPane.add(label_5);
		
		textField_8 = new JTextField();
		textField_8.setBounds(352, 309, 66, 21);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
	}
}
