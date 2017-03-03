import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeqFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	SeqString s=new SeqString("0123456789");
	private JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeqFrame frame = new SeqFrame();
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
	public SeqFrame() {
		setTitle("\u4E32\u7684\u57FA\u672C\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();							//开始位置
		textField.setBounds(19, 109, 54, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();						//结束位置
		textField_2.setColumns(10);
		textField_2.setBounds(19, 175, 54, 21);
		contentPane.add(textField_2);
		
		textField_1 = new JTextField();						//输入字符串
		textField_1.setBounds(97, 6, 215, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(97, 42, 216, 23);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		JButton btnNewButton = new JButton("\u663E\u793A");					//显示
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String total="";
				total+=s.totalString();
				textArea.setText(total);
				System.out.println(s);
			}
		});
		btnNewButton.setBounds(108, 75, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5224\u7A7A");				//判空
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(s.isEmpty())
				{
					textArea.setText("空");
				}
				else
				{
					textArea.setText("非空");
				}
			}
		});
		btnNewButton_1.setBounds(108, 108, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6C42\u957F\u5EA6");					//求长度
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=String.valueOf(s.length());
				textArea.setText(str);
			}
		});
		btnNewButton_2.setBounds(108, 141, 93, 23);							
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u53D6\u5B57\u7B26");			//取字符	*********************************************	
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=Integer.parseInt(textField.getText().trim());
				String str="";
				str+=s.charAt(index);
				textArea.setText(str);
			}
		});
		btnNewButton_3.setBounds(108, 174, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u622A\u53D6");					//截取子串
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int begin=Integer.parseInt(textField.getText().trim());
				int end=Integer.parseInt(textField_2.getText().trim());
				String str="";
				str+=s.substring(begin, end);
				textArea.setText(str);
			}
		});
		btnNewButton_4.setBounds(108, 207, 93, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u63D2\u5165");					//插入
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int offset=Integer.parseInt(textField.getText().trim());
				SeqString str1 = new SeqString(textField_1.getText().trim());      //******************************************
				s.insert(offset, str1);
				System.out.println(s);    
			}
		});
		btnNewButton_5.setBounds(108, 240, 93, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u5220\u9664");					//删除
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int begin=Integer.parseInt(textField.getText().trim());
				int end=Integer.parseInt(textField_2.getText().trim());
				s.delete(begin, end);
				textArea.setText("删除成功");
			}
		});
		btnNewButton_6.setBounds(108, 270, 93, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("\u8FDE\u63A5");					//连接
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeqString str = new SeqString(textField_1.getText().trim());
				s.concat(str);
			}
		});
		btnNewButton_7.setBounds(108, 303, 93, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("\u6BD4\u8F83");					//比较
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeqString str = new SeqString(textField_1.getText().trim());
				textArea.setText(String.valueOf(s.compareTo(str)));	
			}
		});
		btnNewButton_8.setBounds(108, 336, 93, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("\u5B50\u4E32\u5B9A\u4F4D");					//子串定位
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeqString str = new SeqString(textField_1.getText().trim());
				int start=Integer.parseInt(textField.getText().trim());
				int position=s.indexOf(str, start);
				textArea.setText(String.valueOf(position));
			}
		});
		btnNewButton_9.setBounds(108, 369, 93, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("\u7F6E\u7A7A");				//置空
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.clear();
				textArea.setText("置空操作成功");
			}
		});
		btnNewButton_10.setBounds(108, 400, 93, 23);
		contentPane.add(btnNewButton_10);
		
		
		
		JLabel label = new JLabel("\u5F00\u59CB\u4F4D\u7F6E\uFF1A");
		label.setBounds(19, 84, 66, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F93\u51FA\u7ED3\u679C\uFF1A");
		label_1.setBounds(10, 40, 77, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u5B57\u7B26\u4E32\uFF1A");
		label_2.setBounds(10, 13, 78, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u7ED3\u675F\u4F4D\u7F6E\uFF1A");
		label_3.setBounds(19, 149, 66, 15);
		contentPane.add(label_3);
		
	}
	public void display(){
		String total="";
		total+=s;
		textArea.setText(total);
		System.out.println(s);
	}
}
