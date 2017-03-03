import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParkManagement extends JFrame {
	public JTextArea textArea;
	private JPanel contentPane;
	private JTextField textField;
	private SqStack S = new SqStack(100);// 顺序栈存放停车场内的车辆信息
	private LinkQueue Q = new LinkQueue();// 链队列存放便道上的车辆信息
	private double fee = 2;// 每分钟停车费用
	public final static int DEPARTURE = 0;// 标识车辆离开
	public final static int ARRIVAL = 1;// 标识车辆到达
	
	// 内部类用于存放车辆信息
	public class CarInfo {
		public int state;// 车辆状态，离开/到达
		public GregorianCalendar arrTime;// 车辆达到时间
		public GregorianCalendar depTime;// 车辆离开时间
		public String license;// 车牌号
		public String getlicense(){										//取得license属性
			return license;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkManagement frame = new ParkManagement();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ParkManagement() throws Exception {	
	
		setTitle("ParkManage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(263, 43, 104, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 79, 296, 87);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		String total="";
		for (int i = 1; i <= 12; i++)
			{String str=""+i;
			CarInfo info = new CarInfo();// 构造一个车辆信息实例
			info.license = str;// 修改车辆状态
			if (S.length() < 10) {// 停车场未满
				info.arrTime = (GregorianCalendar) GregorianCalendar.getInstance();// 当前时间初始化到达时间						
				info.state = ARRIVAL;
				S.push(info);
				//System.out.println(info.license + "停放在停车场第" + S.length()+ "个位置！");
				total+=info.license + "停放在停车场第" + S.length()+ "个位置！"+"\n";
			} else {// 停车场已满
				Q.offer(info);// 进入便道队列
				//System.out.println(info.license + "停放在便道第" + Q.length()+ "个位置！");
				total+=info.license + "停放在便道第" + Q.length()+ "个位置！"+"\n";
				}
			}
		textArea.setText(total);
		//System.out.println(total);	
		for (int i = S.top - 1; i >= 0; i--)
				System.out.print(((CarInfo) S.stackElem[i]).getlicense().toString() + " ");      //从栈中取出每个CarInfo类中license元素
		
		if (!Q.isEmpty()) {
			Node p = Q.front;
			while (p != Q.rear.getNext()) {// 从对头到队尾
				System.out.print(p.getData().toString() + " ");
				p = p.getNext();
			}
		}
		
		JButton btnNewButton = new JButton("Arrive");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String license=textField.getText().trim();
				CarInfo info = new CarInfo();// 构造一个车辆信息实例
				info.license = license;// 修改车辆状态
				if (S.length() < 10) {// 停车场未满
					info.arrTime = (GregorianCalendar) GregorianCalendar
							.getInstance();// 当前时间初始化到达时间
					info.state = ARRIVAL;
					try {
						S.push(info);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println(info.license + "停放在停车场第" + S.length()+ "个位置！");
					textArea.setText(info.license + "停放在便道第" + Q.length()+ "个位置！");
				} else {// 停车场已满
					Q.offer(info);// 进入便道队列
					//System.out.println(info.license + "停放在便道第" + Q.length()+ "个位置！");
					textArea.setText(info.license + "停放在便道第" + Q.length()+ "个位置！");
				}
			}
		});
		btnNewButton.setBounds(71, 205, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("input license\uFF1A");
		lblNewLabel.setBounds(69, 44, 95, 18);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Depart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String license=textField.getText().trim();
				CarInfo info = null;
				int location = 0;// 车辆的位置
				SqStack S2 = new SqStack(S.length());// 构造一个新栈用于存放因车辆离开而导致的其他车辆暂时退出车场
				for (int i = S.length(); i > 0; i--) {
					info = (CarInfo) S.pop();
					if (info.license.equals(license)) {// 将离开的车辆
						info.depTime = (GregorianCalendar) GregorianCalendar.getInstance();// 当前时间来初始化离开时间
						info.state = DEPARTURE;
						location = i;// 取得车辆位置信息
						break;
					} else
						try {
							S2.push(info);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}

				while (!S2.isEmpty())
					try {
						S.push(S2.pop());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				if (location != 0) {// 停车场内存在指定车牌号码的车辆
					double time = (info.depTime.getTimeInMillis() - info.arrTime.getTimeInMillis())/ (1000 * 60);// 计算停放时间，并把毫秒换算成分钟
					DecimalFormat df = new DecimalFormat("0.0");// 对double进行格式化，保留两位有效小数
					//System.out.println(info.license + "停放:" + df.format(time)+ "分钟，费用为:" + df.format(time * fee));// 输出
					textArea.setText(info.license + "停放:" + df.format(time)+ "分钟，费用为:" + df.format(time * fee));
				}

				if (!Q.isEmpty()) {// 便道上的第一辆车进入停车场
					info = (CarInfo) Q.poll();
					info.arrTime = (GregorianCalendar) GregorianCalendar
							.getInstance();// 当前时间来初始化离开时间
					info.state = ARRIVAL;
					try {
						S.push(info);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(274, 205, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
