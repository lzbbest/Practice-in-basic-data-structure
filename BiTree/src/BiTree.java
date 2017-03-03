/**
 * 
 *������ʽ�洢�ṹ�µĶ�����
 * 
 */
public class BiTree {

	private BiTreeNode root;// ���ĸ����

	public BiTree() {// ����һ�ÿ���
		this.root = null;
	}

	public BiTree(BiTreeNode root) {// ����һ����
		this.root = root;
	}

	// ���ȸ�������������и����������齨��һ�ö�����
	// ���в���preOrder���������� �ȸ�������inOrder�����������и�������preIndex��
	// �ȸ�������preOrder�ַ����еĿ�ʼλ�ã�inIndex���и��������ַ���inOrder�еĿ�ʼλ�ã�count��ʾ�����ĸ���
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex,
			int count) {
		if (count > 0) {// �ȸ����и��ǿ�
			char r = preOrder.charAt(preIndex);// ȡ�ȸ��ַ����еĵ�һ��Ԫ����Ϊ�����
			int i = 0;
			for (; i < count; i++)
				// Ѱ�Ҹ�������и������ַ����е�����
				if (r == inOrder.charAt(i + inIndex))
					break;

			root = new BiTreeNode(r);// �������ĸ����
			root.setLchild(new BiTree(preOrder, inOrder, preIndex + 1, inIndex,
					i).root);// ��������������
			root.setRchild(new BiTree(preOrder, inOrder, preIndex + i + 1,
					inIndex + i + 1, count - i - 1).root);// ��������������
		}
	}

	// �ɱ������������ȸ��������н���һ�ö�����
	private static int index = 0;// ���ڼ�¼preStr������ֵ

	public BiTree(String preStr) {
		char c = preStr.charAt(index++);// ȡ���ַ�������Ϊindex���ַ�����index��1
		if (c != '#') {// �ַ���Ϊ#
			root = new BiTreeNode(c);// �������ĸ����
			root.setLchild(new BiTree(preStr).root);// ��������������
			root.setRchild(new BiTree(preStr).root);// ��������������
		} else
			root = null;
	}

	// �ȸ��������������������ĵݹ��㷨
	public String preRootTraverse(BiTreeNode T) {
		String tree="";															//��
		if (T != null) {
			tree+=T.getData();
			System.out.print(T.getData()); // ���ʸ����
			tree+=preRootTraverse(T.getLchild());// ����������
			tree+=preRootTraverse(T.getRchild());// ����������
		}
		return tree;
	}

	// �ȸ��������������������ķǵݹ��㷨
	public String preRootTraverse() {
		String tree="";
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// ����ջ
			S.push(T);// �������ջ
			while (!S.isEmpty()) {
				T = (BiTreeNode) S.pop();// �Ƴ�ջ����㣬������ȥֵ
				tree+=T.getData();
				System.out.print(T.getData()); // ���ʽ��
				while (T != null) {
					if (T.getLchild() != null) // ��������
						{System.out.print(T.getLchild().getData()); // ���ʽ��
						tree+=T.getLchild().getData();}
					if (T.getRchild() != null)// �Һ��ӷǿ���ջ
						S.push(T.getRchild());
					T = T.getLchild();
				}
			}
		}
		return tree;
	}

	// �и��������������������ĵݹ��㷨
	public String inRootTraverse(BiTreeNode T) {					//��
		String tree="";
		if (T != null) {
			tree+=inRootTraverse(T.getLchild());// ����������
			tree+=T.getData();
			System.out.print(T.getData()); // ���ʸ����
			tree+=inRootTraverse(T.getRchild());// ����������
		}
		return tree;
	}

	// �и��������������������ķǵݹ��㷨
	public String inRootTraverse() {
		String tree="";
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// ������ջ
			S.push(T); // �������ջ
			while (!S.isEmpty()) {
				while (S.peek() != null)
					// ��ջ�������������ӽ����ջ
					S.push(((BiTreeNode) S.peek()).getLchild());
				S.pop(); // �ս����ջ
				if (!S.isEmpty()) {
					T = (BiTreeNode) S.pop();// �Ƴ�ջ����㣬������ȥֵ
					tree+=T.getData();
					System.out.print(T.getData()); // ���ʽ��
					S.push(T.getRchild());// �����Һ�����ջ
				}
			}
		}
		return tree;
	}

	// ����������������������ĵݹ��㷨
	public String postRootTraverse(BiTreeNode T) {										//��
		String tree="";
		if (T != null) {
			tree+=postRootTraverse(T.getLchild());// ����������
			tree+=postRootTraverse(T.getRchild());// ����������
			tree+=T.getData();
			System.out.print(T.getData()); // ���ʸ����
		}
		return tree;
	}

	// ����������������������ķǵݹ��㷨
	public String postRootTraverse() {											//��
		String tree = "";
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// ������ջ
			S.push(T); // ������ջ
			Boolean flag;// ���ʱ��
			BiTreeNode p = null;// pָ��ձ����ʵĽ��
			while (!S.isEmpty()) {
				while (S.peek() != null)
					// ��ջ�������������ӽ����ջ
					S.push(((BiTreeNode) S.peek()).getLchild());
				S.pop(); // �ս����ջ
				while (!S.isEmpty()) {
					T = (BiTreeNode) S.peek();// �鿴ջ��Ԫ��
					if (T.getRchild() == null || T.getRchild() == p) {
						tree+=T.getData();								//******
						System.out.print(T.getData()); // ���ʽ��
						S.pop();// �Ƴ�ջ��Ԫ��
						p = T;// pָ��ձ����ʵĽ��
						flag = true;// ���÷��ʱ��
					} else {
						S.push(T.getRchild());// �Һ��ӽ����ջ
						flag = false;// ����δ�����ʱ��
					}
					if (!flag)
						break;
				}
			}
		}return tree;
	}

	// ��α��������������������㷨(��������)
	public String levelTraverse(BiTreeNode T) {							//���Ӳ�������***********
		//BiTreeNode T = root;
		String tree="";
		if (T != null) {
			LinkQueue L = new LinkQueue();// �������
			L.offer(T);// ����������
			while (!L.isEmpty()) {
				T = (BiTreeNode) L.poll();
				tree+=T.getData();
				System.out.print(T.getData()); // ���ʽ��
				if (T.getLchild() != null)// ���ӷǿգ������
					L.offer(T.getLchild());
				if (T.getRchild() != null)// �Һ��ӷǿգ������
					L.offer(T.getRchild());
			}
		}
		return tree;
	}

	public BiTreeNode getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode root) {
		this.root = root;
	}
	public BiTreeNode searchNode(BiTreeNode T, String x) {
		String t="";
		if (T != null) {
			t+=T.getData();
			if (t.equals(x))// �Ը��������ж�
				return T;
			else {
				BiTreeNode lresult = searchNode(T.getLchild(), x);// ����������
				return lresult != null ? lresult : searchNode(T.getRchild(), x);// ������������У��򷵻�ֵΪx�Ľ�㣬�������������в��Ҳ���������
			}
		}
		return null;
	}
}
