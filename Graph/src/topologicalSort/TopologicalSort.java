package topologicalSort;
import ALGraph.ALGraph;
import ALGraph.ArcNode;

public class TopologicalSort {
	// 若G无回路，则输出G的顶点的一个拓扑序列并返回true，否则返回false
	public static String topologicalSort(ALGraph G) throws Exception {
		String result = "";
		int count = 0;// 输出顶点计数
		int[] indegree = findInDegree(G);// 求各顶点入度
		LinkStack S = new LinkStack();// 建零入度顶点栈S
		for (int i = 0; i < G.getVexNum(); i++)
			if (indegree[i] == 0)// 入度为0者进栈
				S.push(i);

		while (!S.isEmpty()) {
			int i = (Integer) S.pop();
			result += G.getVex(i) + " ";
			System.out.print(G.getVex(i) + " ");// 输出v号顶点并计数
			++count;
			for (ArcNode arc = G.getVexs()[i].getFirstArc(); arc != null; arc = arc.getNextArc()) {
				int k = arc.getAdjVex();
				if (--indegree[k] == 0)// 对j号顶点的每个邻接点的入度减1
					S.push(k);// 若入度减为0，则入栈
			}
		}
		if (count < G.getVexNum())
			return "有回路";// 该有向图有回路
		else
			return result;
	}

	// 求各顶点入度
	public static int[] findInDegree(ALGraph G) throws Exception {
		int[] indegree = new int[G.getVexNum()];
		for (int i = 0; i < G.getVexNum(); i++)
			for (ArcNode arc = G.getVexs()[i].getFirstArc(); arc != null; arc = arc
					.getNextArc())
				++indegree[arc.getAdjVex()];// 入度增1
		return indegree;
	}

	/*public static void main(String[] args) throws Exception {
		ALGraph G = GenerateGraph.generateALGraph();
		TopologicalSort.topologicalSort(G);
	}*/
}
