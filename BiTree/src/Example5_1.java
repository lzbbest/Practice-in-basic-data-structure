/**
 * 
 * ��д��Ա��������ڶ������в�������Ԫ��ֵΪx�Ľ��Ĳ���
 * �ڶ������в�������Ԫ�ز�����Ҫ���ǣ�����TΪ�����Ķ������в�������Ԫ��ֵΪx�Ľ�㣬���ҵ��򷵻ظý�㣬���򷵻ؿ�ֵ
 */

public class Example5_1 {

	// �����ȸ������ķ�ʽ�������б������ȽϽ�������Ԫ�������������Ԫ�ص�ֵ
	public BiTreeNode searchNode(BiTreeNode T, Object x) {
		if (T != null) {
			if (T.getData().equals(x))// �Ը��������ж�
				return T;
			else {
				BiTreeNode lresult = searchNode(T.getLchild(), x);// ����������
				return lresult != null ? lresult : searchNode(T.getRchild(), x);// ������������У��򷵻�ֵΪx�Ľ�㣬�������������в��Ҳ���������
			}
		}
		return null;
	}

	public static void main(String[] args) {
		BiTree biTree = new BiTreeCreator().createBiTree();// ����һ����
		BiTreeNode root = biTree.getRoot();// ȡ�����ĸ����

		// ���ԡ���5-1 ����д��Ա��������ڶ������в�������Ԫ��ֵΪx�Ľ��Ĳ���
		Example5_1 e = new Example5_1();
		String str="A";
		Object o=(Object)str;
		if (e.searchNode(root, "A") != null)
			System.out.println("���а�������ָ��Ԫ��ֵ�Ľ��Ϊ�� "+ e.searchNode(root, "A").getData());				
		else
			System.out.println("���в���������ָ��Ԫ��ֵ�Ľ�㣡");
	}
}
// ���н����
// ���а�������ָ��Ԫ��ֵ�Ľ��Ϊ�� B
