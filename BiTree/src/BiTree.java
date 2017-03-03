/**
 * 
 *二叉链式存储结构下的二叉树
 * 
 */
public class BiTree {

	private BiTreeNode root;// 树的根结点

	public BiTree() {// 构造一棵空树
		this.root = null;
	}

	public BiTree(BiTreeNode root) {// 构造一棵树
		this.root = root;
	}

	// 由先根遍历的数组和中根遍历的数组建立一棵二叉树
	// 其中参数preOrder是整棵树的 先根遍历，inOrder是整棵树的中根遍历，preIndex是
	// 先根遍历从preOrder字符串中的开始位置，inIndex是中根遍历从字符串inOrder中的开始位置，count表示树结点的个数
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex,
			int count) {
		if (count > 0) {// 先根和中根非空
			char r = preOrder.charAt(preIndex);// 取先根字符串中的第一个元素作为根结点
			int i = 0;
			for (; i < count; i++)
				// 寻找根结点在中根遍历字符串中的索引
				if (r == inOrder.charAt(i + inIndex))
					break;

			root = new BiTreeNode(r);// 建立树的根结点
			root.setLchild(new BiTree(preOrder, inOrder, preIndex + 1, inIndex,
					i).root);// 建立树的左子树
			root.setRchild(new BiTree(preOrder, inOrder, preIndex + i + 1,
					inIndex + i + 1, count - i - 1).root);// 建立树的右子树
		}
	}

	// 由标明空子树的先根遍历序列建立一棵二叉树
	private static int index = 0;// 用于记录preStr的索引值

	public BiTree(String preStr) {
		char c = preStr.charAt(index++);// 取出字符串索引为index的字符，且index增1
		if (c != '#') {// 字符不为#
			root = new BiTreeNode(c);// 建立树的根结点
			root.setLchild(new BiTree(preStr).root);// 建立树的左子树
			root.setRchild(new BiTree(preStr).root);// 建立树的右子树
		} else
			root = null;
	}

	// 先根遍历二叉树基本操作的递归算法
	public String preRootTraverse(BiTreeNode T) {
		String tree="";															//改
		if (T != null) {
			tree+=T.getData();
			System.out.print(T.getData()); // 访问根结点
			tree+=preRootTraverse(T.getLchild());// 访问左子树
			tree+=preRootTraverse(T.getRchild());// 访问右子树
		}
		return tree;
	}

	// 先根遍历二叉树基本操作的非递归算法
	public String preRootTraverse() {
		String tree="";
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// 构造栈
			S.push(T);// 根结点入栈
			while (!S.isEmpty()) {
				T = (BiTreeNode) S.pop();// 移除栈顶结点，并返回去值
				tree+=T.getData();
				System.out.print(T.getData()); // 访问结点
				while (T != null) {
					if (T.getLchild() != null) // 访问左孩子
						{System.out.print(T.getLchild().getData()); // 访问结点
						tree+=T.getLchild().getData();}
					if (T.getRchild() != null)// 右孩子非空入栈
						S.push(T.getRchild());
					T = T.getLchild();
				}
			}
		}
		return tree;
	}

	// 中根遍历二叉树基本操作的递归算法
	public String inRootTraverse(BiTreeNode T) {					//改
		String tree="";
		if (T != null) {
			tree+=inRootTraverse(T.getLchild());// 访问左子树
			tree+=T.getData();
			System.out.print(T.getData()); // 访问根结点
			tree+=inRootTraverse(T.getRchild());// 访问右子树
		}
		return tree;
	}

	// 中根遍历二叉树基本操作的非递归算法
	public String inRootTraverse() {
		String tree="";
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// 构造链栈
			S.push(T); // 根结点入栈
			while (!S.isEmpty()) {
				while (S.peek() != null)
					// 将栈顶结点的所有左孩子结点入栈
					S.push(((BiTreeNode) S.peek()).getLchild());
				S.pop(); // 空结点退栈
				if (!S.isEmpty()) {
					T = (BiTreeNode) S.pop();// 移除栈顶结点，并返回去值
					tree+=T.getData();
					System.out.print(T.getData()); // 访问结点
					S.push(T.getRchild());// 结点的右孩子入栈
				}
			}
		}
		return tree;
	}

	// 后根遍历二叉树基本操作的递归算法
	public String postRootTraverse(BiTreeNode T) {										//改
		String tree="";
		if (T != null) {
			tree+=postRootTraverse(T.getLchild());// 访问左子树
			tree+=postRootTraverse(T.getRchild());// 访问右子树
			tree+=T.getData();
			System.out.print(T.getData()); // 访问根结点
		}
		return tree;
	}

	// 后根遍历二叉树基本操作的非递归算法
	public String postRootTraverse() {											//改
		String tree = "";
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// 构造链栈
			S.push(T); // 根结点进栈
			Boolean flag;// 访问标记
			BiTreeNode p = null;// p指向刚被访问的结点
			while (!S.isEmpty()) {
				while (S.peek() != null)
					// 将栈顶结点的所有左孩子结点入栈
					S.push(((BiTreeNode) S.peek()).getLchild());
				S.pop(); // 空结点退栈
				while (!S.isEmpty()) {
					T = (BiTreeNode) S.peek();// 查看栈顶元素
					if (T.getRchild() == null || T.getRchild() == p) {
						tree+=T.getData();								//******
						System.out.print(T.getData()); // 访问结点
						S.pop();// 移除栈顶元素
						p = T;// p指向刚被访问的结点
						flag = true;// 设置访问标记
					} else {
						S.push(T.getRchild());// 右孩子结点入栈
						flag = false;// 设置未被访问标记
					}
					if (!flag)
						break;
				}
			}
		}return tree;
	}

	// 层次遍历二叉树基本操作的算法(自左向右)
	public String levelTraverse(BiTreeNode T) {							//增加参数传递***********
		//BiTreeNode T = root;
		String tree="";
		if (T != null) {
			LinkQueue L = new LinkQueue();// 构造队列
			L.offer(T);// 根结点入队列
			while (!L.isEmpty()) {
				T = (BiTreeNode) L.poll();
				tree+=T.getData();
				System.out.print(T.getData()); // 访问结点
				if (T.getLchild() != null)// 左孩子非空，入队列
					L.offer(T.getLchild());
				if (T.getRchild() != null)// 右孩子非空，入队列
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
			if (t.equals(x))// 对根结点进行判断
				return T;
			else {
				BiTreeNode lresult = searchNode(T.getLchild(), x);// 查找左子树
				return lresult != null ? lresult : searchNode(T.getRchild(), x);// 如果在左子树中，则返回值为x的结点，否则在右子树中查找并返回其结果
			}
		}
		return null;
	}
}
