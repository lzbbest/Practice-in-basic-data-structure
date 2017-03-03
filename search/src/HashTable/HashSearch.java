package HashTable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HashSearch extends JFrame {
	HashTable hash;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashSearch frame = new HashSearch();
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
	public HashSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 10, 310, 68);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(114, 123, 310, 68);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JButton btnNewButton = new JButton("\u67E5\u627E");					//search
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(hash.contain(textArea.getText())){
						textArea_1.setText("查找成功");
					}else{
						textArea_1.setText("查找不成功");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(112, 228, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u63D2\u5165");				//insert
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					hash.insert(textArea.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textArea_1.setText("插入成功");
			}
		});
		btnNewButton_1.setBounds(215, 228, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("\u5220\u9664");						//delete
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(hash.remove(textArea.getText())){
						textArea_1.setText("删除成功");
					}else{
						textArea_1.setText("删除不成功");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(331, 228, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u521B\u5EFA");						//create
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = "";//wang li zhang liu chen yang huang zhao wu zhou du
				String[] name=textArea.getText().split(" ");
				HashTable ht = new HashTable(name.length);
				for(int i=0;i<name.length;i++){
					try {
						ht.insert(name[i]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//int key = result.hashCode();
				result+=ht.printHashTable();
				textArea_1.setText(result);
				hash = ht;
			}
		});
		button_1.setBounds(9, 228, 93, 23);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("\u8F93\u5165\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(21, 34, 81, 32);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F93\u51FA\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(21, 145, 81, 32);
		contentPane.add(label_1);
		
		JButton btnNewButton_2 = new JButton("\u5168\u90E8\u6E05\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea_1.setText("");
			}
		});
		btnNewButton_2.setBounds(245, 272, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnhash = new JButton("\u663E\u793Ahash");
		btnhash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText(hash.printHashTable());
			}
		});
		btnhash.setBounds(66, 272, 93, 23);
		contentPane.add(btnhash);
	}
}
