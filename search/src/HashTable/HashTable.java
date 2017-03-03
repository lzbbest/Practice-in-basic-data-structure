package HashTable;

/**
 * ��8�� ��������ַ���Ĺ�ϣ���࣬�������롢ɾ�������ҡ������Ȳ�����
 */

public class HashTable   //��������ַ���Ĺ�ϣ����
{

    private LinkList[] table;      //��ϣ��Ķ�������

    public HashTable(int size)    //����ָ����С�Ĺ�ϣ��
    {
        this.table = new LinkList[size];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkList();     //����յ�����
        }
    }

    public int hash(int key) //������������ϣ�����������ǹ�ϣ����
    {
        return key % table.length;
    }

    public void insert(String element) throws Exception {  //�ڹ�ϣ���в���ָ��Ԫ��
        int key = element.hashCode();   //ÿ�������hashCode()������������ֵ
        int i = hash(key);              //�����ϣ��ַ
        table[i].insert(0, element);
    }

    public String printHashTable() //�����ϣ���и��������Ԫ��
    {
    	String result="";
        for (int i = 0; i < table.length; i++) {
            result+="table["+i+"]"+table[i].display();
        	System.out.print("table[" + i + "]= ");  //�������������Ԫ��ֵ
            table[i].display();
        }
        return result;
    }

    public String search(String element) throws Exception {    //�ڹ�ϣ���в���ָ�����������ҳɹ����ؽ�㣬���򷵻�null
        int key = element.hashCode();
        int i = hash(key);
        int index = table[i].indexOf(element);  //����Ԫ���ڵ������е�λ��
        if (index >= 0) {
            return  table[i].get(index);  //�����ڵ��������ҵ��Ľ��
        } else {
            return null;
        }
    }

    public boolean contain(String element) throws Exception {   //�Բ��ҽ���жϹ�ϣ���Ƿ����ָ����������������true�����򷵻�false
        return this.search(element) != null;
    }

    public boolean remove(String element) throws Exception {   //ɾ��ָ��������ɾ���ɹ�����true�����򷵻�false
        int key = element.hashCode();
        int i = hash(key);
        int index = table[i].indexOf(element);
        if (index >= 0) {
            table[i].remove(index); //�ڵ�������ɾ������
            return true;
        } else {
            return false;
        }
    }   
}
