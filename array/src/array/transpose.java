package array;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class transpose extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transpose frame = new transpose();
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
	public transpose() {
		setTitle("array transpose");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 181, 153);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(234, 44, 174, 152);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JButton button = new JButton("\u8F6C\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String M[]=textArea.getText().split("\n");					//由输入的数组取得行数m和列数n
				//System.out.print(M[0]);
				String N[]=M[0].split(" ");
				int m=M.length;
				int n=N.length;
				int mat[][]=new int [m][n];
				//System.out.print(n);
				for(int i=0;i<m;i++){										//成为mat数组
					String line[]=M[i].split(" ");
					//System.out.print(line[i]);
					for(int j=0;j<n;j++){
			            mat[i][j]=Integer.parseInt(line[j]);
			            System.out.print(mat[i][j]+" "); 
					}
				}
				
				SparseMatrix sm=new SparseMatrix(mat);
				SparseMatrix tm=sm.transpose();
				//输出原始三元组
				String begin="";
				begin+="行数："+sm.getRows()+"\t列数："+sm.getCols()+"\t非零元素个数："+sm.getNums()+"\n";
				begin+="行下标\t列下标\t元素值\n";
				for(int i=0;i<sm.getNums();i++){
					begin+=sm.data[i].getRow() + "\t" + sm.data[i].getColumn() + "\t" + sm.data[i].getValue()+"\n";
				}
				textArea.setText(begin);
				//输出转置后的三元组
				String end="";
				end+="行数："+tm.getRows()+"\t列数："+tm.getCols()+"\t非零元素个数："+tm.getNums()+"\n";
				end+="行下标\t列下标\t元素值\n";
				for(int i=0;i<sm.getNums();i++){
					end+=tm.data[i].getRow() + "\t" + tm.data[i].getColumn() + "\t" + tm.data[i].getValue()+"\n";
				}
				textArea_1.setText(end);
			}
		});
		button.setBounds(280, 217, 93, 23);
		contentPane.add(button);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u76EE\u6807\u77E9\u9635\uFF08\u4EE5\u7A7A\u683C\u4E3A\u95F4\u9694\u7B26\uFF09\uFF1A");
		label.setBounds(10, 10, 229, 23);
		contentPane.add(label);
		
		
		JLabel label_1 = new JLabel("\u8F93\u51FA\uFF1A");
		label_1.setBounds(268, 14, 54, 15);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("\u6E05\u7A7A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("请输入目标矩阵");
				textArea_1.setText("");
			}
		});
		btnNewButton.setBounds(52, 217, 93, 23);
		contentPane.add(btnNewButton);
	}
}
