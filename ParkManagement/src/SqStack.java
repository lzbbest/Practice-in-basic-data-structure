

/**
 * 
 * ��˳�����ʵ�ֵ�ջ�����������
 * 
 */
public class SqStack {

	public Object[] stackElem; // ջ�洢�ռ�

	public int top; // �ǿ�ջ��ʼ�ձ�ʾջ��Ԫ�ص���һ��λ�ã���ջΪ��ʱ��ֵΪ0

	// ջ�Ĺ��캯��������һ���洢�ռ�����ΪmaxSize��ջ
	public SqStack(int maxSize) {
		top = 0; // ��ʼ��topΪ0
		stackElem = new Object[maxSize];// Ϊջ����maxSize���洢��Ԫ
	}

	// ��һ���Ѿ����ڵ�ջ�óɿ�
	public void clear() {
		top = 0;
	}

	// ����ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return top == 0;
	}

	// ��ջ�е�����Ԫ�ظ������ɺ���������ֵ
	public int length() {
		return top;
	}

	// �鿴ջ����������Ƴ���������ջ������
	public Object peek() {
		if (!isEmpty())// ջ�ǿ�
			return stackElem[top - 1]; // ջ��Ԫ��
		else
			// ջΪ��
			return null;
	}

	// �Ƴ�ջ��������Ϊ�˺�����ֵ���ظö���
	public Object pop() {
		if (top == 0)// ջΪ��
			return null;
		else {// ջ�ǿ�
			return stackElem[--top];// �޸�ջ��ָ�룬������ջ��Ԫ��
		}
	}

	// ����ѹ��ջ��
	public void push(Object o) throws Exception {
		if (top == stackElem.length)// ջ��
			throw new Exception("ջ����");// ����쳣
		else
			// ջδ��
			stackElem[top++] = o;// o����ջ��Ԫ�غ�top��1
	}

	// ��ӡ��������ӡ����ջ�е�Ԫ��(ջ����ջ��)
	public void display() {
		for (int i = top - 1; i >= 0; i--)
			System.out.print(stackElem[i].toString() + " ");// ��ӡ
	}
}
