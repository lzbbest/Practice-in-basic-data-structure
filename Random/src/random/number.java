package random;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;


public class number extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					number frame = new number();
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
	public number() {
		String[] name = new String[28];
		name[0]="丘远芳";
		name[1]="范鹤禹";
		name[2]="朱业张";
		name[3]="顾越";
		name[4]="任庭姣";
		name[5]="王刘芳";
		name[6]="张晨茜";
		name[7]="袁秉瑞";
		name[8]="张帆";
		name[9]="宋青青";
		name[10]="吕芳";
		name[11]="冷雪琴";
		name[12]="常毓晨";
		name[13]="臧晨旸";
		name[14]="陈赟";
		name[15]="蒙濛";
		name[16]="成淑原";
		name[17]="刘智博";
		name[18]="钱妤雯";
		name[19]="沈勤";
		name[20]="朱琳";
		name[21]="许梅珍";
		name[22]="骆丹";
		name[23]="黄裕海";
		name[24]="刘向茹";
		name[25]="胡学萍";
		name[26]="袁子淇";
		name[27]="刘文举";
		
		setTitle("STUDENT SELECT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 447, 72);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();						//output
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		JButton btnNewButton = new JButton("点名");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectNum=textField_2.getText();
				String classNum=textField.getText();
				int cnum=Integer.parseInt(classNum);
				int sNum=Integer.parseInt(selectNum);
				int[] reult1 = randomCommon(1,cnum,sNum);  
				String out="";   
				for (int i : reult1) {  
				    out+=name[i]+",";    
					//out+=i+",";
				    	//System.out.println(i);  
				}  
				textArea.setText(out);
			}
		});
		btnNewButton.setFont(new Font("ו", Font.PLAIN, 22));
		btnNewButton.setBounds(44, 234, 165, 39);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();				//class number
		textField.setText("28");
		textField.setBounds(197, 23, 106, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();				//group number
		textField_1.setBounds(197, 113, 106, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMax = new JLabel("输入人数：");
		lblMax.setBounds(83, 24, 74, 18);
		contentPane.add(lblMax);
		
		JLabel lblNewLabel = new JLabel("输入组数：");
		lblNewLabel.setBounds(83, 119, 87, 15);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();					//select number
		textField_2.setBounds(197, 68, 106, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("输入点名人数：");
		label.setBounds(83, 71, 95, 15);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("分组");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String group=textField_1.getText();
				String classNum=textField.getText();
				int cnum=Integer.parseInt(classNum);
				int gnum=Integer.parseInt(group);
				int[] reult1 = randomCommon(1,cnum,cnum);
				String out="";
				int a = reult1.length/gnum;
				int temp = 0;
				System.out.println(name[temp]);
				for(int j=0;j<gnum;j++){
					int ggg=j+1;
					out+="第"+ggg+"组：";
					for (int i=a*j;i<a*(j+1);i++) {  
					    //System.out.println(i);
						//out+=reult1[i]+",";
						temp = reult1[i];
						//out+=temp+" ";
						out+=name[temp-1]+",";
					} 
					out+="\n";
				}
				textArea.setText(out);
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnNewButton_1.setBounds(259, 234, 165, 39);
		contentPane.add(btnNewButton_1);
		
	}
	
	public static int[] randomCommon(int min, int max, int n){  
	    max+=1;
		if (n > (max - min + 1) || max < min) {  
	           return null;  
	       }  
	    int[] result = new int[n];  
	    int count = 0;  
	    while(count < n) {  
	        int num = (int) (Math.random() * (max - min)) + min;  
	        boolean flag = true;  
	        for (int j = 0; j < n; j++) {  
	            if(num == result[j]){  
	                flag = false;  
	                break;  
	            }  
	        }  
	        if(flag){  
	            result[count] = num;  
	            count++;  
	        }  
	    }  
	    return result;  
	} 
}
