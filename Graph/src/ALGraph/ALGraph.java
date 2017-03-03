package ALGraph;


import java.util.Scanner;

//图的邻接表存储表示
public class ALGraph implements IGraph {

	private int vexNum, arcNum;// 图的当前顶点数和边数

	private VNode[] vexs;// 顶点

	public ALGraph() {
		this(0, 0, null);
	}

	public ALGraph(int vexNum, int arcNum, VNode[] vexs) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}

	// 创建无向图
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

	// 创建有向图
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

	// 创建无向网
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

	// 创建有向网
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

	// 在位置为v、u的顶点之间，添加一条弧，其权值为value
	public void addArc(int v, int u, int value) {
		ArcNode arc = new ArcNode(u, value);
		arc.setNextArc(vexs[v].getFirstArc());
		vexs[v].setFirstArc(arc);
	}

	// 返回顶点数
	public int getVexNum() {
		return vexNum;
	}

	// 返边数
	public int getArcNum() {
		return arcNum;
	}

	// 给定顶点的值vex，返回其在图中的位置，如果图中不包含此顶点，则返回-1
	public int locateVex(String vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].getData().equals(vex))
				return v;
		return -1;
	}

	public VNode[] getVexs() {
		return vexs;
	}


	// 返回v表示结点的值， 0 <= v < vexNum
	public String getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		return vexs[v].getData();
	}

	// 返回v的第一个邻接点，若v没有邻接点则返回-1， 0 <= v < vexnum
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		VNode vex = vexs[v];
		if (vex.getFirstArc() != null)
			return vex.getFirstArc().getAdjVex();
		else
			return -1;
	}

	// 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0≤v, w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
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
