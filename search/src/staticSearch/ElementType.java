package staticSearch;

/**
 * ˳����¼�������Ԫ����
 */
public class ElementType {

    private String data;  //�û����Զ�������������

    public String getdata() {
        return data;
    }

    public void setdata(String data) {
        this.data = data;
    }

    public ElementType(String data) {
        this.data = data;
    }

    public ElementType() {
    }

    public String toString() { //����toString()����
        return data;
    }
}
