package ALGraph;

//ͼ���ڽӱ�洢��ʾ�еĶ�������
public class VNode {
	private String data;// ������Ϣ

	private ArcNode firstArc;// ָ���һ�������ڸö���Ļ�

	public VNode() {
		this(null, null);
	}
	public VNode(String data) {
		this(data, null);
	}
	public VNode(String data, ArcNode firstArc) {
		this.data = data;
		this.firstArc = firstArc;
	}

	public String getData() {
		return data;
	}

	public ArcNode getFirstArc() {
		return firstArc;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setFirstArc(ArcNode firstArc) {
		this.firstArc = firstArc;
	}



}
