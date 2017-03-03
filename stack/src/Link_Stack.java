import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Link_Stack extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	LinkStack L=new LinkStack();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Link_Stack frame = new Link_Stack();
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
	public Link_Stack() {
		for(int i=0;i<30;i++){
			String str=""+i;
			L.push(str);
		}

		setTitle("\u961F\u5217\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(170, 26, 174, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u8F93\u5165\u5143\u7D20\uFF1A");
		label.setBounds(25, 29, 77, 18);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 304, 309, 80);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		JButton btnNewButton = new JButton("\u6E05\u7A7A");					//clear
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				L.clear();
				textArea.setText("置空操作成功");
			}
		});
		btnNewButton.setBounds(9, 98, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5224\u7A7A");				//isEmpty
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton_1.setBounds(130, 98, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6C42\u4E2A\u6570");			//length
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int l=L.length();
				String s="";
				s=s+l;
				textArea.setText(s);
			}
		});
		btnNewButton_2.setBounds(261, 98, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u6808\u9876\u5143\u7D20");	//peek
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o=L.peek();
				String ss=""+o;
				textArea.setText(ss);
			}
		});
		btnNewButton_3.setBounds(9, 164, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5165\u6808");              //push
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x=textField.getText().trim();
					L.push(x);
			}
		});
		btnNewButton_4.setBounds(130, 164, 93, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u51FA\u6808");             //pop
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object oo=L.pop();
				String sss=""+oo;
				textArea.setText(sss+"  had removed");
			}
		});
		btnNewButton_5.setBounds(261, 164, 93, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u663E\u793A");          //display
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node p = L.gettop();
				String all="";
				while (p != null) 
				{
					all+=p.getData().toString() + " ";
					p = p.getNext();
				}
				textArea.setText(all);
			}
		});
		btnNewButton_6.setBounds(130, 241, 93, 23);
		contentPane.add(btnNewButton_6);
		
	}

}
