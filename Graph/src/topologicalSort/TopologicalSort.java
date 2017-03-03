package topologicalSort;
import ALGraph.ALGraph;
import ALGraph.ArcNode;

public class TopologicalSort {
	// ��G�޻�·�������G�Ķ����һ���������в�����true�����򷵻�false
	public static String topologicalSort(ALGraph G) throws Exception {
		String result = "";
		int count = 0;// ����������
		int[] indegree = findInDegree(G);// ����������
		LinkStack S = new LinkStack();// ������ȶ���ջS
		for (int i = 0; i < G.getVexNum(); i++)
			if (indegree[i] == 0)// ���Ϊ0�߽�ջ
				S.push(i);

		while (!S.isEmpty()) {
			int i = (Integer) S.pop();
			result += G.getVex(i) + " ";
			System.out.print(G.getVex(i) + " ");// ���v�Ŷ��㲢����
			++count;
			for (ArcNode arc = G.getVexs()[i].getFirstArc(); arc != null; arc = arc.getNextArc()) {
				int k = arc.getAdjVex();
				if (--indegree[k] == 0)// ��j�Ŷ����ÿ���ڽӵ����ȼ�1
					S.push(k);// ����ȼ�Ϊ0������ջ
			}
		}
		if (count < G.getVexNum())
			return "�л�·";// ������ͼ�л�·
		else
			return result;
	}

	// ����������
	public static int[] findInDegree(ALGraph G) throws Exception {
		int[] indegree = new int[G.getVexNum()];
		for (int i = 0; i < G.getVexNum(); i++)
			for (ArcNode arc = G.getVexs()[i].getFirstArc(); arc != null; arc = arc
					.getNextArc())
				++indegree[arc.getAdjVex()];// �����1
		return indegree;
	}

	/*public static void main(String[] args) throws Exception {
		ALGraph G = GenerateGraph.generateALGraph();
		TopologicalSort.topologicalSort(G);
	}*/
}
