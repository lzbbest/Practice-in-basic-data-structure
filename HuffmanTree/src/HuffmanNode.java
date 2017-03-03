/**
 * 
 * �շ������Ľ����
 * 
 */
public class HuffmanNode {
	private int weight;// ����Ȩֵ

	private int flag;// ����շ������ı�־��flag=0ʱ��ʾ�ý��δ�������������flag=1ʱ���ʾ�ý���Ѽ����������

	private HuffmanNode parent, lchild, rchild; // ����㼰���Һ��ӽ��

	public HuffmanNode() {// ����һ���ս��
		this(0);
	}

	public HuffmanNode(int weight) {// ����һ������Ȩֵ�Ľ��
		this.weight = weight;
		flag = 0;
		parent = lchild = rchild = null;
	}

	public int getFlag() {
		return flag;
	}

	public HuffmanNode getLchild() {
		return lchild;
	}

	public HuffmanNode getParent() {
		return parent;
	}

	public HuffmanNode getRchild() {
		return rchild;
	}

	public int getWeight() {
		return weight;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setLchild(HuffmanNode lchild) {
		this.lchild = lchild;
	}

	public void setParent(HuffmanNode parent) {
		this.parent = parent;
	}

	public void setRchild(HuffmanNode rchild) {
		this.rchild = rchild;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
