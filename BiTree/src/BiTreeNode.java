/**
 * 
 * ������ʽ�洢�ṹ�µĶ��������
 * 
 */
public class BiTreeNode {
	private Object data;// ��������Ԫ��

	private BiTreeNode lchild, rchild; // ���Һ���

	public BiTreeNode() {// ����һ���ս��
		this(null);
	}

	public BiTreeNode(Object data) {// ����һ�����Һ���Ϊ�յĽ��
		this(data, null, null);
	}

	public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild) {// ����һ������Ԫ�غ����Һ��Ӷ���Ϊ�յĽ��
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}

	public Object getData() {
		return data;
	}

	public BiTreeNode getLchild() {
		return lchild;
	}

	public BiTreeNode getRchild() {
		return rchild;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setLchild(BiTreeNode lchild) {
		this.lchild = lchild;
	}

	public void setRchild(BiTreeNode rchild) {
		this.rchild = rchild;
	}

}
