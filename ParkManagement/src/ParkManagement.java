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
	private SqStack S = new SqStack(100);// ˳��ջ���ͣ�����ڵĳ�����Ϣ
	private LinkQueue Q = new LinkQueue();// �����д�ű���ϵĳ�����Ϣ
	private double fee = 2;// ÿ����ͣ������
	public final static int DEPARTURE = 0;// ��ʶ�����뿪
	public final static int ARRIVAL = 1;// ��ʶ��������
	
	// �ڲ������ڴ�ų�����Ϣ
	public class CarInfo {
		public int state;// ����״̬���뿪/����
		public GregorianCalendar arrTime;// �����ﵽʱ��
		public GregorianCalendar depTime;// �����뿪ʱ��
		public String license;// ���ƺ�
		public String getlicense(){										//ȡ��license����
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
			CarInfo info = new CarInfo();// ����һ��������Ϣʵ��
			info.license = str;// �޸ĳ���״̬
			if (S.length() < 10) {// ͣ����δ��
				info.arrTime = (GregorianCalendar) GregorianCalendar.getInstance();// ��ǰʱ���ʼ������ʱ��						
				info.state = ARRIVAL;
				S.push(info);
				//System.out.println(info.license + "ͣ����ͣ������" + S.length()+ "��λ�ã�");
				total+=info.license + "ͣ����ͣ������" + S.length()+ "��λ�ã�"+"\n";
			} else {// ͣ��������
				Q.offer(info);// ����������
				//System.out.println(info.license + "ͣ���ڱ����" + Q.length()+ "��λ�ã�");
				total+=info.license + "ͣ���ڱ����" + Q.length()+ "��λ�ã�"+"\n";
				}
			}
		textArea.setText(total);
		//System.out.println(total);	
		for (int i = S.top - 1; i >= 0; i--)
				System.out.print(((CarInfo) S.stackElem[i]).getlicense().toString() + " ");      //��ջ��ȡ��ÿ��CarInfo����licenseԪ��
		
		if (!Q.isEmpty()) {
			Node p = Q.front;
			while (p != Q.rear.getNext()) {// �Ӷ�ͷ����β
				System.out.print(p.getData().toString() + " ");
				p = p.getNext();
			}
		}
		
		JButton btnNewButton = new JButton("Arrive");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String license=textField.getText().trim();
				CarInfo info = new CarInfo();// ����һ��������Ϣʵ��
				info.license = license;// �޸ĳ���״̬
				if (S.length() < 10) {// ͣ����δ��
					info.arrTime = (GregorianCalendar) GregorianCalendar
							.getInstance();// ��ǰʱ���ʼ������ʱ��
					info.state = ARRIVAL;
					try {
						S.push(info);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println(info.license + "ͣ����ͣ������" + S.length()+ "��λ�ã�");
					textArea.setText(info.license + "ͣ���ڱ����" + Q.length()+ "��λ�ã�");
				} else {// ͣ��������
					Q.offer(info);// ����������
					//System.out.println(info.license + "ͣ���ڱ����" + Q.length()+ "��λ�ã�");
					textArea.setText(info.license + "ͣ���ڱ����" + Q.length()+ "��λ�ã�");
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
				int location = 0;// ������λ��
				SqStack S2 = new SqStack(S.length());// ����һ����ջ���ڴ�������뿪�����µ�����������ʱ�˳�����
				for (int i = S.length(); i > 0; i--) {
					info = (CarInfo) S.pop();
					if (info.license.equals(license)) {// ���뿪�ĳ���
						info.depTime = (GregorianCalendar) GregorianCalendar.getInstance();// ��ǰʱ������ʼ���뿪ʱ��
						info.state = DEPARTURE;
						location = i;// ȡ�ó���λ����Ϣ
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

				if (location != 0) {// ͣ�����ڴ���ָ�����ƺ���ĳ���
					double time = (info.depTime.getTimeInMillis() - info.arrTime.getTimeInMillis())/ (1000 * 60);// ����ͣ��ʱ�䣬���Ѻ��뻻��ɷ���
					DecimalFormat df = new DecimalFormat("0.0");// ��double���и�ʽ����������λ��ЧС��
					//System.out.println(info.license + "ͣ��:" + df.format(time)+ "���ӣ�����Ϊ:" + df.format(time * fee));// ���
					textArea.setText(info.license + "ͣ��:" + df.format(time)+ "���ӣ�����Ϊ:" + df.format(time * fee));
				}

				if (!Q.isEmpty()) {// ����ϵĵ�һ��������ͣ����
					info = (CarInfo) Q.poll();
					info.arrTime = (GregorianCalendar) GregorianCalendar
							.getInstance();// ��ǰʱ������ʼ���뿪ʱ��
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
