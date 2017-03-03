package ALGraph;

public class DTraverser {
	private static boolean[] visited;// ���ʱ�־����

	// ��ͼG��������ȱ���
	public static String DFSTraverse(IGraph G) throws Exception {
		String result = "";
		visited = new boolean[G.getVexNum()];
		for (int v = 0; v < G.getVexNum(); v++)
			// ���ʱ�־�����ʼ��
			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v])// ����δ���ʵĶ������DFS
				result += DFS(G, v);
		return result;
	}

	// �ӵ�v����������ݹ��������ȱ���ͼG
	public static String DFS(IGraph G, int v) throws Exception {
		String result="";
		visited[v] = true;
		result+=G.getVex(v).toString() + " ";
		System.out.print(G.getVex(v).toString() + " ");// ���ʵ�v������
		for (int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w))
			if (!visited[w])// ��v����δ���ʵ��ڽӶ���w�ݹ����DFS
				result+=DFS(G, w);
		return result;
	}

	/*public static void main(String[] args) throws Exception {
		ALGraph G = GenerateGraph.generateALGraph();
		DTraverser.DFSTraverse(G);
	}*/
}

// ���Խ����
// v1 v4 v6 v8 v9 v3 v5 v7 v2
