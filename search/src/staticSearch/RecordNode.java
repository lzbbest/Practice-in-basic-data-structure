package staticSearch;

/**
 * ˳����¼�����
 */
public class RecordNode {

    private Comparable key;      //�ؼ���
    private Object element;      //����Ԫ��

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Comparable getKey() {
        return key;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public RecordNode(Comparable key) {  //���췽��1
        this.key = key;

    }

    public RecordNode(Comparable key, Object element) {  //���췽��2
        this.key = key;
        this.element = element;
    }

    public String toString() { //����toString()����
        return "[" + key + "," + element + "]";
    }
}

