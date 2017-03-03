package ALGraph;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AdjacencyList extends JFrame {
	ALGraph algraph = new ALGraph();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdjacencyList frame = new AdjacencyList();
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
	public AdjacencyList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u521B\u5EFADG");
		btnNewButton.addActionListener(new ActionListener() {					//DG
			public void actionPerformed(ActionEvent e) {
				int vexNum=Integer.parseInt(textField.getText());
				int arcNum=Integer.parseInt(textField_1.getText());
				String vexs[]=textField_2.getText().split(" ");
				String dingdian[]=textField_3.getText().split(" ");
				if(dingdian.length!=arcNum || vexs.length!=vexNum)
					{textArea.setText("输入不合理");}
				String[] vex1 = new String[arcNum];
				String[] vex2 = new String[arcNum];	
				//int[] vex3 = new int[arcNum];
				for(int i=0;i<dingdian.length;i++){
					String line[]=dingdian[i].split(",");
					for(int j=0;j<line.length;j++){
						vex1[i] = line[0];
						vex2[i] = line[1];
						//vex3[i] = Integer.parseInt(line[2]);
					}
				}				
				ALGraph al1=new ALGraph();
				al1.createDG(vexNum, arcNum, vexs, vex1, vex2);
				algraph = al1;
				textArea.setText("创建成功");
			}
		});
		btnNewButton.setBounds(10, 10, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u521B\u5EFAUDG");
		btnNewButton_1.addActionListener(new ActionListener() {					//UDG
			public void actionPerformed(ActionEvent arg0) {
				int vexNum=Integer.parseInt(textField.getText());
				int arcNum=Integer.parseInt(textField_1.getText());
				String vexs[]=textField_2.getText().split(" ");
				String dingdian[]=textField_3.getText().split(" ");
				if(dingdian.length!=arcNum || vexs.length!=vexNum)
					{textArea.setText("输入不合理");}
				String[] vex1 = new String[arcNum];
				String[] vex2 = new String[arcNum];	
				//int[] vex3 = new int[arcNum];
				for(int i=0;i<dingdian.length;i++){
					String line[]=dingdian[i].split(",");
					for(int j=0;j<line.length;j++){
						vex1[i] = line[0];
						vex2[i] = line[1];
						//vex3[i] = Integer.parseInt(line[2]);
					}
				}				
				ALGraph al2=new ALGraph();
				al2.createUDG(vexNum, arcNum, vexs, vex1, vex2);
				algraph = al2;
				textArea.setText("创建成功");
			}
		});
		btnNewButton_1.setBounds(113, 10, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u521B\u5EFADN");
		btnNewButton_2.addActionListener(new ActionListener() {				//DN
			public void actionPerformed(ActionEvent e) {
				int vexNum=Integer.parseInt(textField.getText());
				int arcNum=Integer.parseInt(textField_1.getText());
				String vexs[]=textField_2.getText().split(" ");
				String dingdian[]=textField_3.getText().split(" ");
				if(dingdian.length!=arcNum || vexs.length!=vexNum)
					{textArea.setText("输入不合理");}
				String[] vex1 = new String[arcNum];
				String[] vex2 = new String[arcNum];	
				int[] vex3 = new int[arcNum];
				for(int i=0;i<dingdian.length;i++){
					String line[]=dingdian[i].split(",");
					for(int j=0;j<line.length;j++){
						vex1[i] = line[0];
						vex2[i] = line[1];
						vex3[i] = Integer.parseInt(line[2]);
					}
				}			
				ALGraph al4 = new ALGraph();
				al4.createDN(vexNum, arcNum, vexs, vex1, vex2, vex3);
				algraph = al4;
				textArea.setText("创建成功");
			}
		});
		btnNewButton_2.setBounds(216, 10, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u521B\u5EFAUDN");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					//UDN
				int vexNum=Integer.parseInt(textField.getText());
				int arcNum=Integer.parseInt(textField_1.getText());
				String vexs[]=textField_2.getText().split(" ");
				String dingdian[]=textField_3.getText().split(" ");
				if(dingdian.length!=arcNum || vexs.length!=vexNum)
					{textArea.setText("输入不合理");}
				String[] vex1 = new String[arcNum];
				String[] vex2 = new String[arcNum];	
				int[] vex3 = new int[arcNum];
				for(int i=0;i<dingdian.length;i++){
					String line[]=dingdian[i].split(",");
					for(int j=0;j<line.length;j++){
						vex1[i] = line[0];
						vex2[i] = line[1];
						vex3[i] = Integer.parseInt(line[2]);
					}
				}			
				ALGraph al3 = new ALGraph();
				al3.createUDN(vexNum, arcNum, vexs, vex1, vex2, vex3);
				algraph = al3;
				textArea.setText("创建成功");
			}
		});
		btnNewButton_3.setBounds(319, 10, 93, 23);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(113, 43, 93, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(319, 43, 93, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(113, 84, 299, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(113, 126, 299, 23);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 124, 119);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton button = new JButton("\u9876\u70B9\u6570");
		button.addActionListener(new ActionListener() {				//getVexNum
			public void actionPerformed(ActionEvent e) {
				String s="";
				s+=algraph.getVexNum();
				textArea.setText(s);
			}
		});
		button.setBounds(149, 171, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FB9\u6570");
		button_1.addActionListener(new ActionListener() {				//getArcNum
			public void actionPerformed(ActionEvent e) {
				String s="";
				s+=algraph.getArcNum();
				textArea.setText(s);
			}
		});
		button_1.setBounds(298, 171, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u6C42\u9876\u70B9\u4F4D\u7F6E");
		button_2.addActionListener(new ActionListener() {						//locateVex
			public void actionPerformed(ActionEvent e) {
				String location = "";
				location += algraph.locateVex(textField_4.getText());
				textArea.setText(location);
			}
		});
		button_2.setBounds(149, 204, 93, 23);
		contentPane.add(button_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(298, 205, 93, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("\u6C42\u9876\u70B9\u503C");
		btnNewButton_4.addActionListener(new ActionListener() {						//getVex
			public void actionPerformed(ActionEvent e) {
				int v = Integer.parseInt(textField_5.getText());
				String vexs = "";
				try {
					vexs += algraph.getVex(v);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(vexs);
			}
		});
		btnNewButton_4.setBounds(149, 237, 93, 23);
		contentPane.add(btnNewButton_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(298, 238, 93, 23);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton button_3 = new JButton("\u7B2C\u4E00\u90BB\u63A5\u70B9");
		button_3.addActionListener(new ActionListener() {						//firstAdjVex
			public void actionPerformed(ActionEvent e) {
				int v = Integer.parseInt(textField_6.getText());
				String vexs = "";
				try {
					vexs += algraph.firstAdjVex(v);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(vexs);
			}
		});
		button_3.setBounds(149, 270, 93, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u4E0B\u4E00\u90BB\u63A5\u70B9");
		button_4.addActionListener(new ActionListener() {					//nextAdjVex
			public void actionPerformed(ActionEvent e) {
				int v1 = Integer.parseInt(textField_7.getText());
				int v2 = Integer.parseInt(textField_8.getText());
				String vexs = "";
				try {
					vexs += algraph.nextAdjVex(v1, v2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(vexs);
			}
		});
		button_4.setBounds(149, 307, 93, 23);
		contentPane.add(button_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(298, 271, 93, 23);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(10, 308, 129, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(298, 308, 93, 22);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label = new JLabel("\u9876\u70B9\u6570");
		label.setBounds(20, 46, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8FB9\u6570");
		label_1.setBounds(238, 43, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u9876\u70B9\u95F4\u9694\u7A7A\u683C");
		label_2.setBounds(0, 87, 134, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8F93\u5165\u5404\u8FB9\u9876\u70B9");
		label_3.setBounds(10, 115, 103, 19);
		contentPane.add(label_3);	
		
		JLabel label_4 = new JLabel("(\u6743\u503C)\u4EE5\",\"\" \"\u9694\u5F00");
		label_4.setBounds(10, 144, 93, 15);
		contentPane.add(label_4);
		
		JButton button_5 = new JButton("\u5168\u90E8\u6E05\u7A7A");
		button_5.addActionListener(new ActionListener() {					//clear all
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textArea.setText("");
			}
		});
		button_5.setBounds(10, 351, 93, 23);
		contentPane.add(button_5);
		
		JButton btnNewButton_5 = new JButton("\u5E7F\u5EA6\u641C\u7D22");
		btnNewButton_5.addActionListener(new ActionListener() { 				//BFS
			public void actionPerformed(ActionEvent arg0) {
				String out = "";
				try {
					out += BTraverser.BFSTraverse(algraph);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textArea.setText(out);
			}
		});
		btnNewButton_5.setBounds(149, 351, 93, 23);
		contentPane.add(btnNewButton_5);
		
		JButton button_6 = new JButton("\u6DF1\u5EA6\u641C\u7D22");
		button_6.addActionListener(new ActionListener() {						//DFS
			public void actionPerformed(ActionEvent arg0) {
				String out = "";
					try {
						out += DTraverser.DFSTraverse(algraph);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				textArea.setText(out);
			}
		});
		button_6.setBounds(298, 351, 93, 23);
		contentPane.add(button_6);
	}
}
