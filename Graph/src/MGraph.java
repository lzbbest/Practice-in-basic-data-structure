import java.util.Scanner;

//ͼ�������ʾ��
public class MGraph {
	public final static int INFINITY = Integer.MAX_VALUE;

	private GraphKind kind;// ͼ�������־

	private int vexNum, arcNum;// ͼ�ĵ�ǰ�������ͱ���

	private String[] vexs;// ����

	private int[][] arcs;// �ڽӾ���

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


	// ��������ͼ
	public void createUDG(int vexNum, int arcNum, String[] vexs,String[] vex1,String[] vex2) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// ��ʼ���ڽӾ���
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = 0;
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			arcs[v][u] = arcs[u][v] = 1;
		}
	};

	// ��������ͼ
	public void createDG(int vexNum, int arcNum, String[] vexs,String[] vex1,String[] vex2) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// ��ʼ���ڽӾ���
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = 0;
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			arcs[v][u] = 1;
		}
	};

	// ����������
	public void createUDN(int vexNum, int arcNum, String[] vexs,String[] vex1,String[] vex2,int[] vex3) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// ��ʼ���ڽӾ���
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			arcs[v][u] = arcs[u][v] = vex3[k];
		}
	}

	// ����������
	public void createDN(int vexNum, int arcNum, String[] vexs,String[] vex1,String[] vex2,int[] vex3) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// ��ʼ���ڽӾ���
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(vex1[k]);
			int u = locateVex(vex2[k]);
			arcs[v][u] = vex3[k];
		}

	}

	// ���ض�����
	public int getVexNum() {
		return vexNum;
	}

	// ���ر���
	public int getArcNum() {
		return arcNum;
	}

	// ���������ֵvex����������ͼ�е�λ�ã����ͼ�в������˶��㣬�򷵻�-1
	public int locateVex(String vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].equals(vex))
				return v;
		return -1;
	}

	// ����v��ʾ����ֵ�� 0 <= v < vexNum
	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");
		return vexs[v];
	}

	// ����v�ĵ�һ���ڽӵ㣬��vû���ڽӵ��򷵻�-1�� 0 <= v < vexnum
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");

		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;

		return -1;
	}

	// ����v�����w����һ���ڽӵ㣬��w��v�����һ���ڽӵ㣬�򷵻�-1������0��v, w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");

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
