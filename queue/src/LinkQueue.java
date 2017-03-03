/**
 * 
 * ��������
 * 
 */

public class LinkQueue implements IQueue {
	public Node front;// ��ͷ������

	public Node rear;// ��β�����ã�ָ���βԪ��

	// ��������Ĺ��캯��
	public LinkQueue() {
		front = rear = null;
	}

	// ��һ���Ѿ����ڵĶ����óɿ�
	public void clear() {
		front = rear = null;

	}

	// ���Զ����Ƿ�Ϊ��
	public boolean isEmpty() {
		return front == null;
	}

	// ������е�����Ԫ�ظ������ɺ���������ֵ
	public int length() {
		Node p = front;
		int length = 0;// ���еĳ���
		while (p != null) {// һֱ���ҵ���β
			p = p.getNext();
			++length;// ������1
		}
		return length;
	}

	// ��ָ����Ԫ�ز������
	public void offer(Object o) {
		Node p = new Node(o);// ��ʼ���µĽ��
		if (front != null) {// ���зǿ�
			rear.setNext(p);
			rear = p;// �ı����β��λ��
		} else
			// ����Ϊ��
			front = rear = p;
	}

	// �鿴���е�ͷ�����Ƴ��������ض��ж���������˶���Ϊ�գ��򷵻� null
	public Object peek() {
		if (front != null) // ���зǿ�
			return front.getData();// ���ض���Ԫ��
		else
			return null;
	}

	// �Ƴ����е�ͷ����Ϊ�˺�����ֵ���ظö�������˶���Ϊ�գ��򷵻� null
	public Object poll() {
		if (front != null) { // ���зǿ�
			Node p = front;// pָ�����ͷ���
			front = front.getNext();
			return p.getData();// ���ض���ͷ�������
		} else
			return null;
	}

	// ��ӡ��������ӡ���ж����е�Ԫ��(����ͷ������β)
	public void display() {
		if (!isEmpty()) {
			Node p = front;
			while (p != rear.getNext()) {// �Ӷ�ͷ����β
				System.out.print(p.getData().toString() + " ");
				p = p.getNext();
			}
		} else {
			System.out.println("�˶���Ϊ��");
		}
	}
}
