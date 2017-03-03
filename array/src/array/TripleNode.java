package array;
//��Ԫ��˳�����
public class TripleNode //��Ԫ������
{

    private int row;           //�к�
    private int column;        //�к�
    private int value;         //Ԫ��ֵ

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TripleNode(int row, int column, int value) //�вι��췽��
    {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public TripleNode() //�޲ι��췽��
    {
        this(0, 0, 0);
    }

    public String toString() //��Ԫ�������ַ���
    {
        return "(" + row + "," + column + "," + value + ")";
    }
}