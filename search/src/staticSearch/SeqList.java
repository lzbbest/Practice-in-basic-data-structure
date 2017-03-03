package staticSearch;

/**
 * ��7�� ˳�����
 */
public class SeqList {

    private RecordNode[] r;    //˳����¼�������
    private int curlen;        //˳�����,����¼����

    public RecordNode[] getRecord() {
        return r;
    }

    public void setRecord(RecordNode[] r) {
        this.r = r;
    }

    // ˳���Ĺ��췽��������һ���洢�ռ�����ΪmaxSize��˳���
    public SeqList(int maxSize) {
        this.r = new RecordNode[maxSize];  // Ϊ˳������maxSize���洢��Ԫ
        this.curlen = 0;                   // ��˳���ĵ�ǰ����Ϊ0
    }

    // ��˳����е�����Ԫ�ظ������ɺ���������ֵ
    public int length() {
        return curlen; // ����˳���ĵ�ǰ����
    }

    // �ڵ�ǰ˳���ĵ�i�����֮ǰ����һ��RecordNode���͵Ľ��x
    //����iȡֵ��ΧΪ��0��i��length()��
    //���iֵ���ڴ˷�Χ���׳��쳣,��i=0ʱ��ʾ�ڱ�ͷ����һ������Ԫ��x,
    //��i=length()ʱ��ʾ�ڱ�β����һ������Ԫ��x
    public void insert(int i, RecordNode x) throws Exception {
        if (curlen == r.length) {    // �ж�˳����Ƿ�����
            throw new Exception("˳�������");
        }
        if (i < 0 || i > curlen) {  // iС��0���ߴ��ڱ�
            throw new Exception("����λ�ò�����");
        }
        for (int j = curlen; j > i; j--) {
            r[j] = r[j - 1];   // ����λ�ü�֮���Ԫ�غ���
        }
        r[i] = x;   // ����x
        this.curlen++;  // ������1
    }

    public void display() {    //�������Ԫ��
        for (int i = 0; i < this.curlen; i++) {
            System.out.print(" " + r[i].getKey().toString());
        }
        System.out.println();
    }

    //���㷨7.1�� ���������ڵ�ֱ�Ӳ��������㷨
    public void insertSort() {
        RecordNode temp;
        int i, j;
    //    System.out.println("ֱ�Ӳ�������");
        for (i = 1; i < this.curlen; i++) {//n-1��ɨ��
            temp = r[i];  //��������ĵ�i����¼�ݴ���temp��
            for (j = i - 1; j >= 0 && temp.getKey().compareTo(r[j].getKey()) < 0; j--) { //��ǰ���r[i]��ļ�¼����ƶ�
                r[j + 1] = r[j];
            }
            r[j + 1] = temp;          //r[i]���뵽��j+1��λ��
    //        System.out.println("��" + i + "��: ");
            display();
        }
    }

    //���㷨7.2���������ڵ�ֱ�Ӳ��������㷨
    public void insertSortWithGuard() {

        int i, j;
        System.out.println("�������ڵ�ֱ�Ӳ�������");
        for (i = 1; i < this.curlen; i++) {//n-1��ɨ��
            r[0] = r[i]; //��������ĵ�i����¼�ݴ���r[0]�У�ͬʱr[0]Ϊ������
            for (j = i - 1; r[0].getKey().compareTo(r[j].getKey()) < 0; j--) { //��ǰ��ϴ�Ԫ������ƶ�
                r[j + 1] = r[j];
            }
            r[j + 1] = r[0];          // r[i]���뵽��j+1��λ��
            System.out.println("��" + i + "��: ");
            display();
        }
    }

    //���㷨7.3��ϣ�������㷨
    public void shellSort(int[] d) { //d[]Ϊ��������
        RecordNode temp;
        int i, j;
        System.out.println("ϣ������");
        //�����������������룬������ɨ��
        for (int k = 0; k < d.length; k++) {
            //һ���������ӱ�ÿ����¼���Լ������ӱ��ڽ���ֱ�Ӳ�������
            int dk = d[k];
            for (i = dk; i < this.curlen; i++) {
                temp = r[i];
                for (j = i - dk; j >= 0 && temp.getKey().compareTo(r[j].getKey()) < 0; j -= dk) {
                    r[j + dk] = r[j];
                }
                r[j + dk] = temp;
            }
            System.out.print("����dk=" + dk + "  ");
            display();
        }
    }

    //���㷨7.4�� ð�������㷨
    public void bubbleSort() {
        System.out.println("ð������");
        RecordNode temp;       //�������
        boolean flag = true;   //�Ƿ񽻻��ı��
        for (int i = 1; i < this.curlen && flag; i++) { //�н���ʱ�ٽ�����һ�ˣ����n-1��
            flag = false;                              //�ٶ�Ԫ��δ����
            for (int j = 0; j < this.curlen - i; j++) { //һ�αȽϡ�����
                if (r[j].getKey().compareTo(r[j + 1].getKey()) > 0) {     //����ʱ������
                    temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.print("��" + i + "��: ");
            display();
        }
    }

    //���㷨7.5��һ�˿�������
    //���������r[i..j]�ļ�¼��ʹ֧���¼��λ��������������λ��
    //��ʱ����֧��֮ǰ(��)�ļ�¼�ؼ��־�������(С��)��
    public int Partition(int i, int j) {
        RecordNode pivot = r[i];          //��һ����¼��Ϊ֧���¼
        System.out.print(i + ".." + j + ",  pivot=" + pivot.getKey() + "  ");
        while (i < j) {    //�ӱ�����˽�������м�ɨ��
            while (i < j && pivot.getKey().compareTo(r[j].getKey()) <= 0) {
                j--;
            }
            if (i < j) {
                r[i] = r[j];   //����֧���¼�ؼ���С�ļ�¼��ǰ�ƶ�
                i++;
            }
            while (i < j && pivot.getKey().compareTo(r[i].getKey()) > 0) {
                i++;
            }
            if (i < j) {
                r[j] = r[i];   //����֧���¼�ؼ��ִ�ļ�¼����ƶ�
                j--;
            }
        }
        r[i] = pivot;         //֧���¼��λ
        display();
        return i;             //����֧��λ��
    }

    //���㷨7.6�� �ݹ���ʽ�Ŀ��������㷨
    //���ӱ�r[low..high]��������
    public void qSort(int low, int high) {
        if (low < high) {
            int pivotloc = Partition(low, high);  //һ�����򣬽�������Ϊ������
            qSort(low, pivotloc - 1);   //���ӱ�ݹ�����
            qSort(pivotloc + 1, high);  //���ӱ�ݹ�����
        }
    }

    //���㷨7.7��˳�����������㷨
    public void quickSort() {
        qSort(0, this.curlen - 1);
    }

    //���㷨7.8��ֱ��ѡ������
    public void selectSort() {
        System.out.println("ֱ��ѡ������");
        RecordNode temp; //�������
        for (int i = 0; i < this.curlen - 1; i++) {//n-1������
            //ÿ���ڴ�r[i]��ʼ����������Ѱ����СԪ��
            int min = i;               //���i����¼�Ĺؼ�����С
            for (int j = i + 1; j < this.curlen; j++) {//����������ѡ��ؼ�����С�ļ�¼
                if (r[j].getKey().compareTo(r[min].getKey()) < 0) {
                    min = j;             //��ס�ؼ�����С��¼���±�
                }
            }
            if (min != i) {    //�����˹ؼ�����С�ļ�¼���i����¼����
                temp = r[i];
                r[i] = r[min];
                r[min] = temp;
            }
            System.out.print("��" + (i + 1) + "��: ");
            display();
        }
    }

    //���㷨7.9�� ����ѡ������(����������)
    //��������˳��洢����tree,���������򣬲���������ص�r��
    void tournamentSort() {
        TreeNode[] tree;   //ʤ�����������
        int leafSize = 1;  //ʤ������Ҷ�ӽ����
        //�õ�ʤ����Ҷ�ӽ��(����)�ĸ������ø���������2����
        while (leafSize < this.curlen) {
            leafSize *= 2;
        }
        int TreeSize = 2 * leafSize - 1;   //ʤ���������нڵ���
        int loadindex = leafSize - 1;      //Ҷ�ӽ��(����)��ŵ���ʼλ��
        tree = new TreeNode[TreeSize];
        int j = 0;
        //�Ѵ������㸴�Ƶ�ʤ������Ҷ�ӽ����
        for (int i = loadindex; i < TreeSize; i++) {
            tree[i] = new TreeNode();
            tree[i].setIndex(i);
            if (j < this.curlen) {      //���ƽ��
                tree[i].setActive(1);
                tree[i].setData( r[j++]);
            } else {
                tree[i].setActive(0) ;   //�յ�����
            }
        }
        int i = loadindex;    //���г�ʼ�Ƚϲ��ҹؼ�����С���
        while (i > 0) {      //����ʤ����
            j = i;
            while (j < 2 * i) {   //������Ա�����
                if (tree[j + 1].getActive() == 0 || ((tree[j].getData()).getKey().compareTo((tree[j + 1].getData()).getKey())) <= 0) {
                    tree[(j - 1) / 2] = tree[j];      //����(ʤ��)��ֵ�������
                } else {
                    tree[(j - 1) / 2] = tree[j + 1];  //�Һ���(ʤ��)��ֵ�������
                }
                j += 2;     //��һ�Ա�����
            }
            i = (i - 1) / 2;    //�����ϲ���
        }
        for (i = 0; i < this.curlen - 1; i++) {  //����ʣ���n-1����¼
            r[i] = tree[0].getData();               //��ʤ�����ĸ�(��С��)��������r
            tree[tree[0].getIndex()].setActive(0);  //��Ԫ����Ӧ���㲻�ٱ���
            updateTree(tree, tree[0].getIndex());   //����ʤ����
        }
        r[this.curlen - 1] = tree[0].getData();
    }

    //���㷨7.10������ѡ������ĵ����㷨��i�ǵ�ǰ��С�ؼ��ּ�¼���±�
    void updateTree(TreeNode[] tree, int i) {
        int j;
        if (i % 2 == 0) { //iΪż��������Ϊ����
            tree[(i - 1) / 2] = tree[i - 1];
        } else { //iΪ����������Ϊ�ҽ��
            tree[(i - 1) / 2] = tree[i + 1];
        }
        i = (i - 1) / 2;   //��СԪ�����������������������
        while (i > 0) {          //ֱ��i==0
            if (i % 2 == 0) {   //iΪż��������Ϊ����
                j = i - 1;
            } else {            //iΪ����������Ϊ�ҽ��
                j = i + 1;
            }
            //������������һ��Ϊ��
            if (tree[i].getActive() == 0 || tree[j].getActive() == 0) {
                if (tree[i].getActive() == 1) {
                    tree[(i - 1) / 2] = tree[i];  //i�ɲ�ѡ��i�����������
                } else {
                    tree[(i - 1) / 2] = tree[j];  //����j�����������
                }
            } else //˫�����ɲ�ѡ
            //�ؼ���С�������������
            if ((tree[i].getData()).getKey().compareTo((tree[j].getData()).getKey()) <= 0) {
                tree[(i - 1) / 2] = tree[i];
            } else {
                tree[(i - 1) / 2] = tree[j];
            }
            i = (i - 1) / 2;     //i�����������
        }
    }

    //���㷨7.11������ɸѡ���������㷨
    //����lowΪ��������������С���ѣ�low��high�������½���Ͻ�
    public void sift(int low, int high) {
        int i = low;                                //�����ĸ�
        int j = 2 * i + 1;                         //jΪi��������
        RecordNode temp = r[i];
        while (j < high) {  //�ؽ�Сֵ���ӽ������ɸѡ
            if (j < high - 1 && r[j].getKey().compareTo(r[j + 1].getKey()) > 0) {
                j++; //����Ԫ�رȽ�,jΪ���Һ��ӵĽ�С��
            }
            if (temp.getKey().compareTo(r[j].getKey()) > 0) { //����ĸ���ֵ�ϴ�
                r[i] = r[j];           //���ӽ���еĽ�Сֵ����
                i = j;
                j = 2 * i + 1;
            } else {
                j = high + 1;          //�˳�ѭ��
            }
        }
        r[i] = temp;                   //��ǰ������ԭ��ֵ�������λ��
        System.out.print("sift  " + low + ".." + high + "  ");
        display();
    }

    //���㷨7.12�� �������㷨
    public void heapSort() {
        System.out.println("������");
        int n = this.curlen;
        RecordNode temp;
        for (int i = n / 2 - 1; i >= 0; i--) {//������
            sift(i, n);
        }
        for (int i = n - 1; i > 0; i--) {//ÿ�˽���Сֵ���������棬�ٵ����ɶ�
            temp = r[0];
            r[0] = r[i];
            r[i] = temp;
            sift(0, i);
        }
    }

    //���㷨7.13�������������еĹ鲢�㷨
    //��r�������������ڵ������r[h]-r[m]��r[m+1]-r[t]�鲢Ϊһ�������order[h]-order[t]
    public void merge(RecordNode[] r, RecordNode[] order, int h, int m, int t) {
        int i = h, j = m + 1, k = h;
        while (i <= m && j <= t) {//��r���������������й鲢��order��
            if (r[i].getKey().compareTo(r[j].getKey()) <= 0) {//��Сֵ���Ƶ�order��
                order[k++] = r[i++];
            } else {
                order[k++] = r[j++];
            }
        }
        while (i <= m) {//��ǰһ��������ʣ��Ԫ�ظ��Ƶ�order��
            order[k++] = r[i++];
        }
        while (j <= t) {//����һ��������ʣ��Ԫ�ظ��Ƶ�order��
            order[k++] = r[j++];
        }
    }

    //���㷨7.14��һ�˹鲢�㷨
    //������r[n]��ÿ������Ϊs������������鲢������order[n]��
    //s Ϊ�����еĳ��ȣ�nΪ�������еĳ���
    public void mergepass(RecordNode[] r, RecordNode[] order, int s, int n) {
        System.out.print("�����г���s=" + s + "  ");
        int p = 0;  //pΪÿһ�Դ��ϲ���ĵ�һ��Ԫ�ص��±꣬��ֵΪ0
        while (p + 2 * s - 1 <= n - 1) {  //�����鲢���Ⱦ�Ϊs�������
            merge(r, order, p, p + s - 1, p + 2 * s - 1);
            p += 2 * s;
        }
        if (p + s - 1 < n - 1) {  //�鲢����������Ȳ��ȵ������
            merge(r, order, p, p + s - 1, n - 1);
        } else {
            for (int i = p; i <= n - 1; i++) //��ʣ���������Ƶ�order��
            {
                order[i] = r[i];
            }
        }
    }

    //���㷨7.15��2-·�鲢�����㷨
    public void mergeSort() {
        System.out.println("�鲢����");
        int s = 1;                      //sΪ������������г��ȣ���ֵΪ1
        int n = this.curlen;
        RecordNode[] temp = new RecordNode[n];  //���峤��Ϊn�ĸ�������temp
        while (s < n) {
            mergepass(r, temp, s, n);  //һ�˹鲢����r�����и������й鲢��temp��
            display();
            s *= 2;                     //�����г��ȼӱ�
            mergepass(temp, r, s, n);  //��temp�����и��������ٹ鲢��r��
            display();
            s *= 2;
        }
    }

    // ���㷨8.1��˳������㷨
    // ��˳���r[0]��r[n-1]��n��Ԫ����˳����ҳ��ؼ���Ϊkey�ļ�¼
    // �����ҳɹ��������±꣬���򷵻�-1
    public int seqSearch(Comparable key) {
        int i = 0, n = length();
        while (i < n && r[i].getKey().compareTo(key) != 0) {
            i++;
        }
        if (i < n) {   //���ҳɹ��򷵻ظ�Ԫ�ص��±�i�����򷵻�-1
            return i;
        } else {
            return -1;
        }
    }

    // ���㷨8.2���������ڵ�˳������㷨
    // ��˳���r[1]��r[n]��n��Ԫ����˳����ҳ��ؼ���Ϊkey��Ԫ��
    // �����ҳɹ��������±꣬���򷵻�-1
    public int seqSearchWithGuard(Comparable key) {
        int i = length() - 1;
        if((r[0].getKey()).compareTo(key)==0){return 0;}				//************
        else{        
	    	r[0].setKey(key);    //�ڱ�
	        while ((r[i].getKey()).compareTo(key) != 0) {
	            i--;
	        }
	        if (i > 0) {
	            return i;
	        } else {
	            return -1;
	        }
        }
    }

    //���㷨8.3�����ֲ����㷨��
    //����Ԫ���Ѱ��������У������ҳɹ�����Ԫ���±꣬���򷵻�-1
    public int binarySearch(Comparable key) {
        if (length() > 0) {
            int low = 0, high = length() - 1; //���ҷ�Χ���½���Ͻ�
            while (low <= high) {
                int mid = (low + high) / 2;   //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
                //    System.out.print(r[mid].getKey() + "? ");
                if (r[mid].getKey().compareTo(key) == 0) {						//****************
                    return mid;                                //���ҳɹ�
                } else if (r[mid].getKey().compareTo(key) > 0) { //����ֵ��С
                    high = mid - 1;     //���ҷ�Χ��С��ǰ���
                } else {
                    low = mid + 1;      //���ҷ�Χ��С������
                }
            }
        }
        return -1;  //���Ҳ��ɹ�
    }

    public int blockSearch(Comparable key) {
        if (length() > 0) {
            int low = 0, high = length() - 1; //���ҷ�Χ���½���Ͻ�
            while (low <= high) {
                int mid = (low + high) / 2;   //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
                //    System.out.print(r[mid].getKey() + "? ");
                if (r[mid].getKey().compareTo(key) == 0) {						//****************
                    return mid;                                //���ҳɹ�
                } else if (r[mid].getKey().compareTo(key) > 0) { //����ֵ��С
                    high = mid - 1;     //���ҷ�Χ��С��ǰ���
                } else {
                    low = mid + 1;      //���ҷ�Χ��С������
                }
            }
        }
        return -1;  //���Ҳ��ɹ�
    }
}

class TreeNode {      //ʤ�����Ľ����

    private RecordNode data;  //�����¼�������ֵ
    private int index;        //��������������е����
    private int active;       //�μ�ѡ���־��1��ʾ��ѡ��0��ʾ����ѡ

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public RecordNode getData() {
        return data;
    }

    public void setData(RecordNode data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
