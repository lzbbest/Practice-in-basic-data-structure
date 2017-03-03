package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class sort_frame extends JFrame {

	private JPanel contentPane;
	JTextArea textArea_1 = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sort_frame frame = new sort_frame();
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
	public sort_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 33, 321, 56);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();//52 39 67 95 70 8 25 52 56 5
		textArea.setLineWrap(true);
		scrollPane_1.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("\u5E0C\u5C14\u6392\u5E8F");				//shellSort
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp[]=textArea.getText().split(" ");
				int array[]=new int[temp.length];
				for(int i=0;i<temp.length;i++){
					array[i]=Integer.parseInt(temp[i]);
				}
				SeqList seq=new SeqList(temp.length);
				for(int i=0;i<temp.length;i++){
					RecordNode r=new RecordNode(array[i]);
					try {
						seq.insert(seq.length(), r);		//插入到末尾
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int d[]=new int[3];
				d[0]=5;
				d[1]=3;
				d[2]=1;
				seq.shellSort(d);
				String result="";
				for(int i=0;i<seq.length();i++){
					result+=seq.getRecord()[i].getKey()+" ";
				}
				textArea_1.setText(result);
			}
		});
		btnNewButton.setBounds(46, 213, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5FEB\u901F\u6392\u5E8F");					//quickSort
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp[]=textArea.getText().split(" ");
				int array[]=new int[temp.length];
				for(int i=0;i<temp.length;i++){
					array[i]=Integer.parseInt(temp[i]);
				}
				SeqList seq=new SeqList(temp.length);
				for(int i=0;i<temp.length;i++){
					RecordNode r=new RecordNode(array[i]);
					try {
						seq.insert(seq.length(), r);		//插入到末尾
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				seq.quickSort();
				String result="";
				for(int i=0;i<seq.length();i++){
					result+=seq.getRecord()[i].getKey()+" ";
				}
				textArea_1.setText(result);
			}
		});
		btnNewButton_1.setBounds(274, 213, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("\u8F93\u5165\uFF1A");
		label.setBounds(47, 10, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F93\u51FA\uFF1A");
		label_1.setBounds(47, 97, 54, 15);
		contentPane.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 122, 321, 56);
		contentPane.add(scrollPane);
		
		//JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		scrollPane.setViewportView(textArea_1);
	}
}
