/**
 * 
 * �ڵ�������ʵ�ֵ�ջ�����������
 * 
 */
public class LinkStack {

	private Node top; // ջ��Ԫ�ص�����

	// ��һ���Ѿ����ڵ�ջ�óɿ�
	public void clear() {
		top = null;
	}

	// ����ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return top == null;
	}

	// ��ջ�е�����Ԫ�ظ������ɺ���������ֵ
	public int length() {
		Node p = top;// ��ʼ��,pָ��ջ�����,lengthΪ������
		int length = 0;
		while (p != null) {// ��ջ����������ң�ֱ��pָ��ջ�����
			p = p.getNext();// ָ���̽��
			++length;// ������1
		}
		return length;
	}

	// �鿴ջ����������Ƴ���������ջ������
	public Object peek() {
		if (!isEmpty())
			return top.getData();// ����ջ��Ԫ��
		else
			return null;
	}

	// �Ƴ�ջ��������Ϊ�˺�����ֵ���ظö���
	public Object pop() {
		if (!isEmpty()) {
			Node p = top;// pָ��ջ�����
			top = top.getNext();
			return p.getData();
		} else
			return null;
	}

	// ����ѹ��ջ��
	public void push(Object x) {
		Node p = new Node(x); // ����һ���µĽ��
		p.setNext(top);
		top = p;// �ı�ջ�����
	}

	// ��ӡ��������ӡ����ջ�е�Ԫ��(ջ����ջ��)
	public void display() {
		Node p = top; // pָ��ջ����㣬qָ��p����һ���
		while (p != null) {// ��ӡ���зǿյĽ��
			System.out.print((p.getData().toString() + " ")); // ��ӡ
			p = p.getNext();// ָ��p��һԪ��
		}
	}
}
