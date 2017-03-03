package HashTable;

public class Node {
	public String data; // ��Ž��ֵ

	public Node next; // ��̽�������

	public Node() { // �޲���ʱ�Ĺ��캯��
		this(null, null);
	}

	public Node(String data) { // ����ֵΪdata�Ľ��
		this(data, null);
	}

	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}

