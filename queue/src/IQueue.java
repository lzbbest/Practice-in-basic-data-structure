/**
 * 
 * ���еĽӿ�
 * 
 */
public interface IQueue {
	public void clear(); // ��һ���Ѿ����ڵĶ����óɿ�

	public boolean isEmpty(); // ���Զ����Ƿ�Ϊ��

	public int length();// ������е�����Ԫ�ظ������ɺ���������ֵ

	public Object peek();// �鿴���е�ͷ�����Ƴ��������ض��ж���������˶���Ϊ�գ��򷵻� null

	public Object poll();// �Ƴ����е�ͷ����Ϊ�˺�����ֵ���ظö�������˶���Ϊ�գ��򷵻� null

	public void offer(Object o) throws Exception;// ��ָ����Ԫ�ز������

	public void display();// ��ӡ��������ӡ���ж����е�Ԫ��(����ͷ������β)

}
