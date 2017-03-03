import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Graph extends JFrame {

	private JPanel contentPane;
	MGraph mgraph=new MGraph();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graph frame = new Graph();
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
	public Graph() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(129, 278, 204, 79);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("\u521B\u5EFAUDG");//UDG
		btnNewButton.addActionListener(new ActionListener() {
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
				String s="";				
				MGraph m1=new MGraph();
				m1.createUDG(vexNum, arcNum, vexs, vex1, vex2);
				mgraph = m1;
				for(int i=0;i<vexNum;i++){
					for(int j=0;j<vexNum;j++){
							s+=m1.getArcs()[i][j]+" ";
					}s+="\n";
				}textArea.setText(s);
			}
		});
		btnNewButton.setBounds(10, 10, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u521B\u5EFADG");//DG
		btnNewButton_1.addActionListener(new ActionListener() {
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
				String s="";				
				MGraph m2=new MGraph();
				m2.createDG(vexNum, arcNum, vexs, vex1, vex2);
				mgraph = m2;
				for(int i=0;i<vexNum;i++){
					for(int j=0;j<vexNum;j++){
							s+=m2.getArcs()[i][j]+" ";
					}s+="\n";
				}textArea.setText(s);
			}
		});
		btnNewButton_1.setBounds(129, 10, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u521B\u5EFAUDN");//UDN
		btnNewButton_2.addActionListener(new ActionListener() {
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
				String s="";				
				MGraph m3=new MGraph();
				m3.createUDN(vexNum, arcNum, vexs, vex1, vex2, vex3);
				mgraph = m3;
				for(int i=0;i<vexNum;i++){
					for(int j=0;j<vexNum;j++){
						if(m3.getArcs()[i][j]!=m3.INFINITY)
							s+=m3.getArcs()[i][j]+" ";
						else
							s+="*";
					}s+="\n";
				}textArea.setText(s);
			}
		});
		btnNewButton_2.setBounds(261, 10, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u521B\u5EFADN");//DN
		btnNewButton_3.addActionListener(new ActionListener() {
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
				String s="";				
				MGraph m4=new MGraph();
				m4.createDN(vexNum, arcNum, vexs, vex1, vex2, vex3);
				mgraph = m4;
				for(int i=0;i<vexNum;i++){
					for(int j=0;j<vexNum;j++){
						if(m4.getArcs()[i][j]!=m4.INFINITY)
							s+=m4.getArcs()[i][j]+" ";
						else
							s+="*";
					}s+="\n";
				}textArea.setText(s);
			}
		});
		btnNewButton_3.setBounds(379, 10, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u9876\u70B9\u6570");//getVexNum
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s="";
				s+=mgraph.getVexNum();
				textArea.setText(s);
			}
		});
		btnNewButton_4.setBounds(10, 43, 93, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u8FB9\u6570");//getArcNum
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s="";
				s+=mgraph.getArcNum();
				textArea.setText(s);
			}
		});
		btnNewButton_5.setBounds(129, 43, 93, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u9876\u70B9\u4F4D\u7F6E");//llocateVex
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String location = "";
				location += mgraph.locateVex(textField_6.getText());
				textArea.setText(location);
			}
		});
		btnNewButton_6.setBounds(261, 43, 93, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("\u9876\u70B9\u503C");//getVex
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int v = Integer.parseInt(textField_6.getText());
				String vexs = "";
				try {
					vexs += mgraph.getVex(v);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(vexs);
			}
		});
		btnNewButton_7.setBounds(379, 43, 93, 23);
		contentPane.add(btnNewButton_7);
		
		JLabel label = new JLabel("\u9876\u70B9\u6570");
		label.setBounds(20, 133, 45, 23);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(95, 134, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8FB9\u6570");
		label_1.setBounds(220, 137, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(284, 134, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u5404\u4E2A\u9876\u70B9(\u7A7A\u683C\u9694\u5F00)");
		label_2.setBounds(10, 168, 151, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 162, 314, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8F93\u5165\u4E24\u6761\u8FB9\u5B9A\u70B9\uFF08\u6743\u503C\uFF09\u4EE5\",\"\u548C\" \"\u9694\u5F00");
		label_3.setBounds(10, 202, 265, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 227, 462, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8F93\u51FA");
		label_4.setBounds(20, 300, 54, 15);
		contentPane.add(label_4);
		
		JButton button = new JButton("\u7B2C\u4E00\u90BB\u63A5\u70B9");//firstAdjVex
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int v = Integer.parseInt(textField_6.getText());
				String vexs = "";
				try {
					vexs += mgraph.firstAdjVex(v);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(vexs);
			}
		});
		button.setBounds(10, 76, 121, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u4E0B\u4E00\u4E2A\u90BB\u63A5\u70B9");//nextAdjVex
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int v1 = Integer.parseInt(textField_4.getText());
				int v2 = Integer.parseInt(textField_5.getText());
				String vexs = "";
				try {
					vexs += mgraph.nextAdjVex(v1, v2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(vexs);
			}
		});
		button_1.setBounds(10, 109, 121, 23);
		contentPane.add(button_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(261, 106, 66, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(379, 106, 66, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8F93\u5165\u4E24\u4E2A\u9876\u70B9\u4F4D\u7F6E");
		label_5.setBounds(141, 113, 111, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u548C");
		label_6.setBounds(346, 109, 23, 15);
		contentPane.add(label_6);
		
		JButton btnNewButton_8 = new JButton("\u5168\u90E8\u6E05\u7A7A");//clear all
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textArea.setText("");
			}
		});
		btnNewButton_8.setBounds(351, 76, 121, 23);
		contentPane.add(btnNewButton_8);
		
		JLabel label_7 = new JLabel("\u8F93\u5165");
		label_7.setBounds(198, 76, 54, 15);
		contentPane.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(261, 76, 66, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
	}
}
