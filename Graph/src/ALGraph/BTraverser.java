package ALGraph;


public class BTraverser {
	private static boolean[] visited;// 访问标志数组

	// 对图G做广度优先遍历
	public static  String BFSTraverse(IGraph G) throws Exception {
		String result = "";
		visited = new boolean[G.getVexNum()];// 访问标志数组
		for (int v = 0; v < G.getVexNum(); v++)
			// 访问标志数组初始化
			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v]) // v尚未访问
				result += BFS(G, v);
		return result;
	}

	private static  String BFS(IGraph G, int v) throws Exception {
		String result = "";
		visited[v] = true;
		result+=G.getVex(v).toString() + " ";
		System.out.print(G.getVex(v).toString() + " ");
		LinkQueue Q = new LinkQueue();// 辅助队列Q
		Q.offer(v);// v入队列
		while (!Q.isEmpty()) {
			int u = (Integer) Q.poll();// 队头元素出队列并赋值给u
			for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))
				if (!visited[w]) {// w为u的尚未访问的邻接顶点
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

// 调试结果：
// v1 v4 v3 v2 v6 v5 v8 v7 v9
