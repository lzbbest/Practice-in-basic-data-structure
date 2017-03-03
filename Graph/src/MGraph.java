import java.util.Scanner;

//图的数组表示法
public class MGraph {
	public final static int INFINITY = Integer.MAX_VALUE;

	private GraphKind kind;// 图的种类标志

	private int vexNum, arcNum;// 图的当前顶点数和边数

	private String[] vexs;// 顶点

	private int[][] arcs;// 邻接矩阵

	public MGraph() {
		this(null, 0, 0, null, null);
	}

	public MGraph(GraphKind kind, int vexNum, int arcNum, String[] vexs,
			int[][] arcs) {
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		this.arcs = arcs;
	}


	// 创建无向图
	public void createUDG(int vexNum, int arcNum, String[] vexs,String[] vex1,String[] vex2) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// 初始化邻接矩阵
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = 0;
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			arcs[v][u] = arcs[u][v] = 1;
		}
	};

	// 创建有向图
	public void createDG(int vexNum, int arcNum, String[] vexs,String[] vex1,String[] vex2) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// 初始化邻接矩阵
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = 0;
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			arcs[v][u] = 1;
		}
	};

	// 创建无向网
	public void createUDN(int vexNum, int arcNum, String[] vexs,String[] vex1,String[] vex2,int[] vex3) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// 初始化邻接矩阵
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			arcs[v][u] = arcs[u][v] = vex3[k];
		}
	}

	// 创建有向网
	public void createDN(int vexNum, int arcNum, String[] vexs,String[] vex1,String[] vex2,int[] vex3) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// 初始化邻接矩阵
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			arcs[v][u] = vex3[k];
		}

	}

	// 返回顶点数
	public int getVexNum() {
		return vexNum;
	}

	// 返回边数
	public int getArcNum() {
		return arcNum;
	}

	// 给定顶点的值vex，返回其在图中的位置，如果图中不包含此顶点，则返回-1
	public int locateVex(String vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].equals(vex))
				return v;
		return -1;
	}

	// 返回v表示结点的值， 0 <= v < vexNum
	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		return vexs[v];
	}

	// 返回v的第一个邻接点，若v没有邻接点则返回-1， 0 <= v < vexnum
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;

		return -1;
	}

	// 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0≤v, w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		for (int j = w + 1; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;

		return -1;
	}

	public GraphKind getKind() {
		return kind;
	}

	public int[][] getArcs() {
		return arcs;
	}

	public Object[] getVexs() {
		return vexs;
	}

}
