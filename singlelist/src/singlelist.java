import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class singlelist extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	LinkList L=new LinkList();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					singlelist frame = new singlelist();
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
	public singlelist() {
		for(int i=0;i<10;i++)
			try {
				String str=""+i;
				L.insert(i,str);
				//int ii=5;
				//String str=""+ii;
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		L.display();
		
		setTitle("\u5355\u94FE\u8868\u7684\u57FA\u672C\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(274, 10, 150, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(274, 72, 150, 21);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u4F4D\u5E8F\uFF1A");
		lblNewLabel.setBounds(167, 13, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u8F93\u5165\u5143\u7D20\uFF1A");
		label.setBounds(167, 73, 72, 18);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 167, 257, 84);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		JLabel label_1 = new JLabel("\u8F93\u51FA\u4FE1\u606F\uFF1A");
		label_1.setBounds(167, 138, 72, 18);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u7F6E\u7A7A"); 						//置空
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				L.clear();
				textArea.setText("置空操作成功");
			}
		});
		button.setBounds(0, 9, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5224\u7A7A");                  //判空
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(L.isEmpty())
				{
					textArea.setText("空");
				}
				else
				{
					textArea.setText("非空");
				}
			}
		});
		button_1.setBounds(0, 45, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u6C42\u957F\u5EA6");                //求长度
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int l=L.length();
				String s="";
				s=s+l;
				textArea.setText(s);
			}
		});
		button_2.setBounds(0, 83, 93, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u53D6\u5143\u7D20");                       //取元素
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=textField.getText();
				int i=Integer.parseInt(s);
					Object a=0;
					try {
						a = L.get(i);
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				String ss="";
				ss+=a;
				textArea.setText(ss);
			}
		});
		button_3.setBounds(0, 116, 93, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u63D2\u5165");                  //插入
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=Integer.parseInt(textField.getText());
				String x=textField_1.getText();
					try {
						L.insert(i,x+"");
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				L.display();
			}
		});
		button_4.setBounds(0, 152, 93, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("\u5220\u9664");                    // 删除
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=Integer.parseInt(textField.getText());
				try {
					L.remove(i);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		button_5.setBounds(0, 189, 93, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u67E5\u627E");                     //查找
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object x=textField_1.getText().trim();
				int j=L.indexOf(x);
				L.display();
                if(j<L.length() && j>=0){
                	String s="";
                	s+=j;
                	textArea.setText(s);}
                else{
                	textArea.setText("没有要查找的内容");
                }
			}
		});
		button_6.setBounds(0, 222, 93, 23);
		contentPane.add(button_6); 
		
		JButton button_7 = new JButton("\u5C55\u793A");                              //显示
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node node = L.head.getNext();
				String str="";
				for(int i=0;i<L.length();i++){
					str+=node.getData()+",";
					node=node.getNext();
				}
				textArea.setText(str);
			}
		});
		button_7.setBounds(0, 255, 93, 23);
		contentPane.add(button_7);
	}
}
