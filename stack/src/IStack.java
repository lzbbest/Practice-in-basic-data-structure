

/****ջ�Ľӿ�**/
public interface IStack {
	public void clear(); // ��һ���Ѿ����ڵ�ջ�óɿ�

	public boolean isEmpty(); // ����ջ�Ƿ�Ϊ��

	public int length();// ��ջ�е�����Ԫ�ظ������ɺ���������ֵ

	public Object peek();// �鿴ջ����������Ƴ���������ջ������

	public Object pop();// �Ƴ�ջ��������Ϊ�˺�����ֵ���ظö���

	public void push(Object o) throws Exception;// ����ѹ��ջ��

	public void display();// ��ӡ��������ӡ����ջ�е�Ԫ��(ջ�׵�ջ��)
}
