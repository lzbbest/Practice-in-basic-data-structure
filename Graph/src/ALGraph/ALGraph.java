package ALGraph;


import java.util.Scanner;

//ͼ���ڽӱ�洢��ʾ
public class ALGraph implements IGraph {

	private int vexNum, arcNum;// ͼ�ĵ�ǰ�������ͱ���

	private VNode[] vexs;// ����

	public ALGraph() {
		this(0, 0, null);
	}

	public ALGraph(int vexNum, int arcNum, VNode[] vexs) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}

	// ��������ͼ
	public void createUDG(int vexNum, int arcNum, String[] vex,String[] vex1,String[] vex2) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		vexs = new VNode[vexNum];
		for (int i = 0; i < vexNum; i++)
			vexs[i] = new VNode(vex[i]);
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			addArc(v,u,0);
			addArc(u,v,0);
		}
	};

	// ��������ͼ
	public void createDG(int vexNum, int arcNum, String[] vex,String[] vex1,String[] vex2) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		vexs = new VNode[vexNum];
		for (int i = 0; i < vexNum; i++)
			vexs[i] = new VNode(vex[i]);
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			addArc(v,u,0);
		}
	};

	// ����������
	public void createUDN(int vexNum, int arcNum, String[] vex,String[] vex1,String[] vex2,int[] value) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		vexs = new VNode[vexNum];
		for (int i = 0; i < vexNum; i++)
			vexs[i] = new VNode(vex[i]);
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			addArc(v,u,value[k]);
			addArc(u,v,value[k]);
		}
	}

	// ����������
	public void createDN(int vexNum, int arcNum, String[] vex,String[] vex1,String[] vex2,int[] value) {	
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		vexs = new VNode[vexNum];
		for (int i = 0; i < vexNum; i++)
			vexs[i] = new VNode(vex[i]);
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			addArc(v,u,value[k]);
		}
	}

	// ��λ��Ϊv��u�Ķ���֮�䣬���һ��������ȨֵΪvalue
	public void addArc(int v, int u, int value) {
		ArcNode arc = new ArcNode(u, value);
		arc.setNextArc(vexs[v].getFirstArc());
		vexs[v].setFirstArc(arc);
	}

	// ���ض�����
	public int getVexNum() {
		return vexNum;
	}

	// ������
	public int getArcNum() {
		return arcNum;
	}

	// ���������ֵvex����������ͼ�е�λ�ã����ͼ�в������˶��㣬�򷵻�-1
	public int locateVex(String vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].getData().equals(vex))
				return v;
		return -1;
	}

	public VNode[] getVexs() {
		return vexs;
	}


	// ����v��ʾ����ֵ�� 0 <= v < vexNum
	public String getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");

		return vexs[v].getData();
	}

	// ����v�ĵ�һ���ڽӵ㣬��vû���ڽӵ��򷵻�-1�� 0 <= v < vexnum
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");

		VNode vex = vexs[v];
		if (vex.getFirstArc() != null)
			return vex.getFirstArc().getAdjVex();
		else
			return -1;
	}

	// ����v�����w����һ���ڽӵ㣬��w��v�����һ���ڽӵ㣬�򷵻�-1������0��v, w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");
		VNode vex = vexs[v];

		ArcNode arcvw = null;
		for (ArcNode arc = vex.getFirstArc(); arc != null; arc = arc
				.getNextArc())
			if (arc.getAdjVex() == w) {
				arcvw = arc;
				break;
			}
		if (arcvw != null && arcvw.getNextArc() != null)
			return arcvw.getNextArc().getAdjVex();
		else
			return -1;
	}
	public String display(){
		String result = "";
		for(int i=0;i<vexNum;i++){
			//while(){
			//	result+=
			//}
		}
		
		return result;
	}
	@Override
	public void createGraph() {
		// TODO Auto-generated method stub
		
	}

}
