/**
 * 
 * �շ������������
 * 
 */
public class HuffmanTree {

	// ��շ���������㷨��W���n���ַ���Ȩֵ(��>0)
	public int[][] huffmanCoding(int[] W) {
		int n = W.length;// �ַ�����
		int m = 2 * n - 1;// �շ������Ľ����
		HuffmanNode[] HN = new HuffmanNode[m];
		int i;
		for (i = 0; i < n; i++)
			HN[i] = new HuffmanNode(W[i]);// ����n������Ȩֵ�Ľ��

		for (i = n; i < m; i++) {// ���շ�����
			// ��HN[0..i - 1]ѡ���ںշ���������weight��С���������min1��min2
			HuffmanNode min1 = selectMin(HN, i - 1);
			min1.setFlag(1);
			HuffmanNode min2 = selectMin(HN, i - 1);
			min2.setFlag(1);

			// ����min1��min2�ĸ���㣬���޸��Ҹ�����Ȩֵ
			HN[i] = new HuffmanNode();
			min1.setParent(HN[i]);
			min2.setParent(HN[i]);
			HN[i].setLchild(min1);
			HN[i].setRchild(min2);
			HN[i].setWeight(min1.getWeight() + min2.getWeight());
		}

		// ��Ҷ�ӵ���������ÿ���ַ��ĺշ�������
		int[][] HuffCode = new int[n][n];// ����n���ַ�����洢�ռ�
		for (int j = 0; j < n; j++) {
			int start = n - 1;// ����Ŀ�ʼλ�ã���ʼ��Ϊ����Ľ�β
			for (HuffmanNode c = HN[j], p = c.getParent(); p != null; c = p, p = p.getParent())
				// ��Ҷ�ӵ������������
				if (p.getLchild().equals(c))// ���ӱ���Ϊ0
					HuffCode[j][start--] = 0;
				else
					// �Һ��ӱ���Ϊ1
					HuffCode[j][start--] = 1;
			HuffCode[j][start] = -1;// ����Ŀ�ʼ��־Ϊ -1��������-1֮���0��1����
		}
		return HuffCode;
	}

	// ��HN[0..i - 1]ѡ���ںշ���������weight��С�Ľ��
	private HuffmanNode selectMin(HuffmanNode[] HN, int end) {
		HuffmanNode min = HN[end];
		for (int i = 0; i <= end; i++) {
			HuffmanNode h = HN[i];
			if (h.getFlag() == 0 && h.getWeight() < min.getWeight())// ���ںշ���������weight��С�Ľ��
				min = h;
		}
		return min;
	}

	/*public static void main(String[] args) {
		int[] W = { 23, 11, 5, 3, 29, 14, 7, 8 };// ��ʼ��Ȩֵ
		HuffmanTree T = new HuffmanTree();// ����շ�����
		int[][] HN = T.huffmanCoding(W);// ��շ�������

		System.out.println("�շ�������Ϊ��");
		for (int i = 0; i < HN.length; i++) {// ����շ�������
			System.out.print(W[i] + " ");
			for (int j = 0; j < HN[i].length; j++) {
				if (HN[i][j] == -1) {// ��ʼ��־�����������β
					for (int k = j + 1; k < HN[i].length; k++)
						System.out.print(HN[i][k]);// ���
					break;
				}
			}
			System.out.println();// �������
		}
	}*/
}

// ���н����
// �շ�������Ϊ��
// 23 01
// 11 001
// 5 11111
// 3 11110
// 29 10
// 14 110
// 7 1110
// 8 000
