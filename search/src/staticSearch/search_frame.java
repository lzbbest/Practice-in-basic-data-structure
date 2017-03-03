package staticSearch;

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

public class search_frame extends JFrame {
	
	private JPanel contentPane;
	JTextArea textArea_1 = new JTextArea();
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_frame frame = new search_frame();
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
	public search_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 33, 161, 56);
		contentPane.add(scrollPane_1);
		
		textField = new JTextField();
		textField.setBounds(254, 44, 98, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(254, 94, 98, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea textArea = new JTextArea("52 39 67 95 70 8 25 56 5");//39 67 95 70 8 25 52 56 5
		textArea.setLineWrap(true);
		scrollPane_1.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("\u987A\u5E8F\u67E5\u627E");				//seqSearch
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
				int key=Integer.parseInt(textField.getText());
				String result="";
				result+=seq.seqSearchWithGuard(key);
				textArea_1.setText(result);
			}
		});
		btnNewButton.setBounds(46, 213, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4E8C\u5206\u67E5\u627E");					//binarySearch
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
				int key=Integer.parseInt(textField.getText());
				result += seq.binarySearch(key);
				textArea_1.setText(result);
			}
		});
		btnNewButton_1.setBounds(176, 213, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("\u8F93\u5165\u5E8F\u5217\uFF1A");
		label.setBounds(47, 10, 74, 15);
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
		
		JButton button = new JButton("\u6392\u5E8F");					//blockSearch
		button.addActionListener(new ActionListener() {								//sort
			public void actionPerformed(ActionEvent arg0) {
				/*String result="";
				String temp[]=textArea.getText().split(",");
				String b = textField_1.getText();
				int blocknum = Integer.parseInt(b);
				int[] array=new int[temp.length];
				for(int i=0;i<temp.length;i++){
					array[i]=Integer.parseInt(temp[i]);
				}
				//int[] array={14,31,8,22,18,43,62,49,35,52,88,78,71,83,75};
				//求分块索引
				int[][] index = new int[2][blocknum];
				int[][] arr = new int[blocknum][(array.length)/blocknum];
				//System.out.print(array[3]);
				for(int j=0;j<blocknum;j++){
					//int[] temparr = new int[(array.length)/blocknum];
					for(int i=0;i<(array.length)/blocknum;i++){
						arr[j][i]=array[i+j*(array.length)/blocknum];
						//result+=arr[j][i]+" ";
						//temparr[i]=array[i+j*array.length];;
					}
					index[0][j] =min(arr[j]);
				}
				for(int j=0;j<blocknum;j++){
					index[1][j] =max(arr[j]);
				}
				
				
				int key=Integer.parseInt(textField.getText());
				//for(int i=0;i<blocknum;i++){result+=index[0][i]+",";}
				if(key<index[0][0] || key>index[1][blocknum-1]){
					result +="不存在";
				}else if(key<=index[1][0] && key>=index[0][0]){
					result+=seqSearch(key,arr[0]);
				}else{
					for(int i=0;i<blocknum;i++){
						if(key>index[1][i] && key<index[1][i+1]){
							int locate=seqSearch(key,arr[i+1]);
							locate+=(i+1)*(array.length)/blocknum;
							result+=locate;
						}
					}
				}
				textArea_1.setText(result);*/
				
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
		button.setBounds(307, 213, 93, 23);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u67E5\u627E\u5173\u952E\u5B57\uFF1A");
		label_2.setBounds(254, 10, 114, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8F93\u5165\u5206\u5757\u6570\uFF1A");
		label_3.setBounds(254, 74, 88, 15);
		contentPane.add(label_3);
		
		
	}
	public int min(int[] r) {
       int min=r[0];
       for(int i=0;i<r.length;i++){
    	   if(r[i]<min){
    		   min = r[i];
    	   } 
       }
       return min;
    }
	public int max(int[] r){
		int max = r[0];
		 for(int i=0;i<r.length;i++){
			 if(r[i]>max){
    		   max = r[i];
    	   }
		 }
		 return max;
	}
	public int seqSearch(int key,int[] r) {
        int i = 0, n = r.length;
        while (i < n && r[i] != key) {
            i++;
        }
        if (i < n) {   //查找成功则返回该元素的下标i，否则返回-1
            return i;
        } else {
            return -1;
        }
    }
}
