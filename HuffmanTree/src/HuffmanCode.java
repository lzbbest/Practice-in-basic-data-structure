import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HuffmanCode extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HuffmanCode frame = new HuffmanCode();
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
	public HuffmanCode() {
		setTitle("\u54C8\u5F17\u66FC\u7F16\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(140, 25, 267, 24);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 93, 267, 158);
		contentPane.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JLabel label = new JLabel("\u8F93\u5165\u6743\u503C\uFF1A");
		label.setBounds(10, 25, 92, 24);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F93\u51FA\u7F16\u7801\uFF1A");
		label_1.setBounds(10, 110, 101, 24);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u7F16\u7801");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] s=textArea.getText().split(",");
				int[] W = new int[s.length];
				for(int i=0;i<s.length;i++){
					W[i]=Integer.parseInt(s[i]);
				}				
				HuffmanTree T = new HuffmanTree();// 构造赫夫曼树
				int[][] HN = T.huffmanCoding(W);// 求赫夫曼编码
				String out = "权值"+"\t"+"编码"+"\n";
				for (int i = 0; i < HN.length; i++) {// 输出赫夫曼编码
					String str=W[i]+"\t";
					for (int j = 0; j < HN[i].length; j++) {
						if (HN[i][j] == -1) {// 开始标志符读到数组结尾
							for (int k = j + 1; k < HN[i].length; k++)
								str+=HN[i][k];
							break;
						}
					}
					out+=str+"\n";
				}
				textArea_1.setText(out);
			}
		});
		button.setBounds(9, 189, 93, 23);
		contentPane.add(button);
	}
}
