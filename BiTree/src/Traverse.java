import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Traverse extends JFrame {
	
	BiTree bigbitree=new BiTree();
	private JPanel contentPane;
	
	/*// 初始化一棵树，并返回其根结点
	BiTreeNode d = new BiTreeNode('D');
	BiTreeNode g = new BiTreeNode('G');
	BiTreeNode h = new BiTreeNode('H');
	BiTreeNode e = new BiTreeNode('E',g,null);
	BiTreeNode b = new BiTreeNode('B',d,e);
	BiTreeNode f = new BiTreeNode('F', null, h);
	BiTreeNode c = new BiTreeNode('C', f, null);
	BiTreeNode root = new BiTreeNode('A', b, c);*/
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traverse frame = new Traverse();
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
	public Traverse() {
		
		setTitle("\u904D\u5386\u4E8C\u53C9\u6811");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 191, 308, 72);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(66, 26, 234, 34);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(66, 87, 234, 34);
		contentPane.add(scrollPane_2);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
		
		JButton button = new JButton("\u521B\u5EFA");   						//create
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textArea_1.setText("ABDEGCFH");
				//textArea_2.setText("DBGEAFHC");
				String preOrder = textArea_1.getText();
				String inOrder = textArea_2.getText();
				BiTree bitree = new BiTree(preOrder, inOrder, 0, 0, preOrder.length());
				bigbitree = bitree;													//将建立的小树赋值给大树
				//textArea.setText(bitree.postRootTraverse());
				textArea.setText(bitree.preRootTraverse());
				//bitree.preRootTraverse();
				//textArea.setText(bitree.inRootTraverse());
			}
		});
		button.setBounds(0, 131, 93, 23);
		contentPane.add(button);
		
				
		/*JButton btnNewButton = new JButton("\u5C42\u6B21\u904D\u5386");			//level
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textArea.setText(bitree.levelTraverse(root));
				textArea.setText(bitree.postRootTraverse());
			}
		});
		btnNewButton.setBounds(346, 26, 93, 23);
		contentPane.add(btnNewButton);*/
		
		JButton btnNewButton_1 = new JButton("\u5148\u6839\u904D\u5386");		//DLR
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textArea.setText(bitree.preRootTraverse(root));
				textArea.setText(bigbitree.preRootTraverse());
			}

			
		});
		btnNewButton_1.setBounds(346, 87, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4E2D\u6839\u904D\u5386");		//LDR
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textArea.setText(bitree.inRootTraverse(root));
				textArea.setText(bigbitree.inRootTraverse());
			}
		});
		btnNewButton_2.setBounds(346, 153, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u540E\u8DDF\u904D\u5386");		//LRD
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textArea.setText(bitree.postRootTraverse(root));
				textArea.setText(bigbitree.postRootTraverse());
			}
		});
		btnNewButton_3.setBounds(346, 216, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("\u5168\u90E8\u6E05\u7A7A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textArea_1.setText("");
				textArea_2.setText("");
			}
		});
		btnNewButton.setBounds(346, 27, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\u5148\u6839\u5E8F\u5217\uFF1A");
		label.setBounds(0, 31, 69, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4E2D\u6839\u5E8F\u5217\uFF1A");
		label_1.setBounds(0, 92, 69, 15);
		contentPane.add(label_1);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BiTreeNode root = bigbitree.getRoot();// 取得树的根结点
				String str=textArea_1.getText();
				String sss="";
				sss+=root;
				if (bigbitree.searchNode(root, str) != null)
					System.out.println("树中包含数据指定元素值的结点为： "+ bigbitree.searchNode(root, str).getData());
							
				else{
					System.out.println("树中不包含数据指定元素值的结点！");
			}
			}
		});
		btnSearch.setBounds(126, 131, 93, 23);
		contentPane.add(btnSearch);
		
		JButton btnCountnode = new JButton("countNode");
		btnCountnode.setBounds(243, 131, 93, 23);
		contentPane.add(btnCountnode);
		
		JButton btnGetdepth = new JButton("getDepth");
		btnGetdepth.setBounds(126, 164, 93, 23);
		contentPane.add(btnGetdepth);
		
		JButton btnEqual = new JButton("equal");
		btnEqual.setBounds(243, 164, 93, 23);
		contentPane.add(btnEqual);
					
	}
}
