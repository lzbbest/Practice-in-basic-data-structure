//ͼ�Ľӿ�
public interface IGraph {
	void createGraph();//����һ��ͼ

	int getVexNum(); // ���ض�����

	int getArcNum();// ���ر���

	Object getVex(int v) throws Exception;// ����v��ʾ����ֵ�� 0 <= v < vexNum

	int locateVex(Object vex);// ���������ֵvex����������ͼ�е�λ�ã����ͼ�в������˶��㣬�򷵻�-1

	int firstAdjVex(int v) throws Exception; // ����v�ĵ�һ���ڽӵ㣬��vû���ڽӵ㣬�򷵻�-1������0��v<vexNum

	int nextAdjVex(int v, int w) throws Exception;// ����v�����w����һ���ڽӵ㣬��w��v�����һ���ڽӵ㣬�򷵻�-1������0��v, w<vexNum

}
