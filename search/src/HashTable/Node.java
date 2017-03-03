package HashTable;

public class Node {
	public String data; // 存放结点值

	public Node next; // 后继结点的引用

	public Node() { // 无参数时的构造函数
		this(null, null);
	}

	public Node(String data) { // 构造值为data的结点
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

