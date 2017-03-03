package ALGraph;


public class BTraverser {
	private static boolean[] visited;// ���ʱ�־����

	// ��ͼG��������ȱ���
	public static  String BFSTraverse(IGraph G) throws Exception {
		String result = "";
		visited = new boolean[G.getVexNum()];// ���ʱ�־����
		for (int v = 0; v < G.getVexNum(); v++)
			// ���ʱ�־�����ʼ��
			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v]) // v��δ����
				result += BFS(G, v);
		return result;
	}

	private static  String BFS(IGraph G, int v) throws Exception {
		String result = "";
		visited[v] = true;
		result+=G.getVex(v).toString() + " ";
		System.out.print(G.getVex(v).toString() + " ");
		LinkQueue Q = new LinkQueue();// ��������Q
		Q.offer(v);// v�����
		while (!Q.isEmpty()) {
			int u = (Integer) Q.poll();// ��ͷԪ�س����в���ֵ��u
			for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))
				if (!visited[w]) {// wΪu����δ���ʵ��ڽӶ���
					visited[w] = true;
					result+=G.getVex(w).toString() + " ";
					System.out.print(G.getVex(w).toString() + " ");
					Q.offer(w);
				}
		}
		return result;
	}

	/*public static void main(String[] args) throws Exception {
		ALGraph G = GenerateGraph.generateALGraph();
		BTraverser.BFSTraverse(G);
	}*/
}

// ���Խ����
// v1 v4 v3 v2 v6 v5 v8 v7 v9
