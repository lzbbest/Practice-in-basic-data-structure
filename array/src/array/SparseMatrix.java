package array;
//��Ԫ��˳�����
public class SparseMatrix {

    public TripleNode data[];     //��Ԫ���
    private int rows;   //����
    private int cols;   //����
    private int nums;   //����Ԫ�ظ���

    public TripleNode[] getData() {
        return data;
    }

    public void setData(TripleNode[] data) {
        this.data = data;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public SparseMatrix(int maxSize) {   //���췽��
        data = new TripleNode[maxSize];    //Ϊ˳������maxSize���洢��Ԫ
        for (int i = 0; i < data.length; i++) {
            data[i] = new TripleNode();
        }
        rows = 0;
        cols = 0;
        nums = 0;
    }

    //���췽������һ�����󴴽���Ԫ���,matΪϡ�����
    public SparseMatrix(int mat[][]) {
        int i, j, k = 0, count = 0;
        rows = mat.length;            //����
        cols = mat[0].length;         //����
        for (i = 0; i < mat.length; i++) //ͳ�Ʒ���Ԫ�صĸ���
        {
            for (j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    count++;
                }
            }
        }
        nums = count;                 //����Ԫ�صĸ���
        data = new TripleNode[nums];  //������Ԫ����ռ�
        for (i = 0; i < mat.length; i++) {
            for (j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    data[k] = new TripleNode(i, j, mat[i][j]);  //������Ԫ��
                    k++;
                }
            }
        }
    }

    //����ת��
    public SparseMatrix transpose() {
        SparseMatrix tm = new SparseMatrix(nums); //�����������
        tm.cols = rows;      //������Ϊ����
        tm.rows = cols;      //������Ϊ����
        tm.nums = nums;      //����Ԫ�ظ�������
        int q = 0;
        for (int col = 0; col < cols; col++) {
            for (int p = 0; p < nums; p++) {
                if (data[p].getColumn() == col) {
                    tm.data[q].setRow(data[p].getColumn());
                    tm.data[q].setColumn(data[p].getRow());
                    tm.data[q].setValue(data[p].getValue());
                    q++;
                }
            }
        }
        return tm;
    }

    //���پ���ת��
    public SparseMatrix fasttranspose() {
        SparseMatrix tm = new SparseMatrix(nums);  //�����������
        tm.cols = rows;      //������Ϊ����
        tm.rows = cols;      //������Ϊ����
        tm.nums = nums;      //����Ԫ�ظ�������
        int i, j = 0, k = 0;
        int[] num, cpot;
        if (nums > 0) {
            num = new int[cols ];
            cpot = new int[cols ];
            for (i = 0; i < cols; i++) //ÿ�з���Ԫ�ظ�������num��ʼ��
            {
                num[i] = 0;
            }
            for (i = 0; i < nums; i++) //����ÿ�з���Ԫ�ظ���
            {
                j = data[i].getColumn();
                num[j]++;
            }
            cpot[0] = 0;
            for (i = 1; i < cols; i++) //����ÿ�е�1������Ԫ����tm�е�λ��
            {
                cpot[i] = cpot[i - 1] + num[i - 1];
            }
            //ִ��ת�ò���
            for (i = 0; i < nums; i++) {    //ɨ��������Ԫ��˳���
                j = data[i].getColumn();
                k = cpot[j];              //��Ԫ����tm�е�λ��
                tm.data[k].setRow( data[i].getColumn());  //ת��
                tm.data[k].setColumn(data[i].getRow());
                tm.data[k].setValue( data[i].getValue());
                cpot[j]++;             //������һ������Ԫ�Ĵ��λ��
            }
        }
        return tm;
    }

    //���ϡ�����
    public void printMatrix() {
        int i;
        System.out.println("ϡ��������Ԫ��洢�ṹ:");
        System.out.println("������" + rows + ", ������" + cols + ", ����Ԫ�ظ�����" + nums);
        System.out.println("���±�  ���±�  Ԫ��ֵ");
        for (i = 0; i < nums; i++) {
            System.out.println(data[i].getRow() + "\t" + data[i].getColumn() + "\t" + data[i].getValue());
        }
    }
}
