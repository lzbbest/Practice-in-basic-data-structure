/**
 * 
 * ����3-8��ͣ�����������⡣
 * 
 */
import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Example3_8 {

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
	}

	// ͣ������������license��ʾ���ƺ��룬action��ʾ�˳����Ķ���������뿪
	public void parkingManag(String license, String action) throws Exception {
		if ("arrive".equals(action)) {// ��������
			CarInfo info = new CarInfo();// ����һ��������Ϣʵ��
			info.license = license;// �޸ĳ���״̬
			if (S.length() < 10) {// ͣ����δ��
				info.arrTime = (GregorianCalendar) GregorianCalendar.getInstance();// ��ǰʱ���ʼ������ʱ��
				info.state = ARRIVAL;
				S.push(info);
				//System.out.println(info.license + "ͣ����ͣ������" + S.length()+ "��λ�ã�");
			} else {// ͣ��������
				Q.offer(info);// ����������
				//System.out.println(info.license + "ͣ���ڱ����" + Q.length()+ "��λ�ã�");
			}

		} else if ("depart".equals(action)) {// �����뿪
			CarInfo info = null;
			int location = 0;// ������λ��
			SqStack S2 = new SqStack(S.length());// ����һ����ջ���ڴ�������뿪�����µ�����������ʱ�˳�����
			for (int i = S.length(); i > 0; i--) {
				info = (CarInfo) S.pop();
				if (info.license.equals(license)) {// ���뿪�ĳ���
					info.depTime = (GregorianCalendar) GregorianCalendar
							.getInstance();// ��ǰʱ������ʼ���뿪ʱ��
					info.state = DEPARTURE;
					location = i;// ȡ�ó���λ����Ϣ
					break;
				} else
					// ����������ʱ�˳�����
					S2.push(info);
			}

			while (!S2.isEmpty())
				// �����������½���ͣ����
				S.push(S2.pop());

			if (location != 0) {// ͣ�����ڴ���ָ�����ƺ���ĳ���
				double time = (info.depTime.getTimeInMillis() - info.arrTime
						.getTimeInMillis())
						/ (1000 * 60);// ����ͣ��ʱ�䣬���Ѻ��뻻��ɷ���
				DecimalFormat df = new DecimalFormat("0.0");// ��double���и�ʽ����������λ��ЧС��
				System.out.println(info.license + "ͣ��:" + df.format(time)
						+ "���ӣ�����Ϊ:" + df.format(time * fee));// ���
			}

			if (!Q.isEmpty()) {// ����ϵĵ�һ��������ͣ����
				info = (CarInfo) Q.poll();
				info.arrTime = (GregorianCalendar) GregorianCalendar
						.getInstance();// ��ǰʱ������ʼ���뿪ʱ��
				info.state = ARRIVAL;
				S.push(info);
			}
		}
	}
	
	public  void display() {
		//for (int i = S.top - 1; i >= 0; i--)
		//	System.out.print(S.stackElem[i].toString() + " ");
			
	}
	
	public static void main(String[] args) throws Exception {
		Example3_8 pm = new Example3_8();// �������
		for (int i = 1; i <= 12; i++)
			// ��ʼ��12���������ƺŷֱ�Ϊ1��2...12��������10����ͣ��ͣ�����ڣ�2����ͣ���ڱ����
			pm.parkingManag(String.valueOf(i), "arrive");
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�����복�ƺţ�");
		String license = sc.next();
		System.out.println("arrive or depart ?");
		String action = sc.next();
		pm.parkingManag(license, action);// ����ͣ����������
	}
}
// ���н����
// 1ͣ����ͣ������1��λ�ã�
// 2ͣ����ͣ������2��λ�ã�
// 3ͣ����ͣ������3��λ�ã�
// 4ͣ����ͣ������4��λ�ã�
// 5ͣ����ͣ������5��λ�ã�
// 6ͣ����ͣ������6��λ�ã�
// 7ͣ����ͣ������7��λ�ã�
// 8ͣ����ͣ������8��λ�ã�
// 9ͣ����ͣ������9��λ�ã�
// 10ͣ����ͣ������10��λ�ã�
// 11ͣ����ͣ������11��λ�ã�
// 12ͣ����ͣ������12��λ�ã�
// �����복�ƺţ�
// 2
// arrive or depart ?
// depart
// 2ͣ��:8.0���ӣ�����Ϊ:16.0

