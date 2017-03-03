package staticSearch;

/**
 * ��8.1 ���ֲ��Ҳ��Գ���
 */
//import ch07.SeqList;
//import ch07.RecordNode;
//import ch07.KeyType;
import java.util.Scanner;

public class creatSearchList {

    static SeqList ST = null;

    public static void createSearchList() throws Exception {
        int maxSize = 20;  //���ұ�Ԥ����ռ�Ĵ�С
        ST = new SeqList(maxSize);    //�������ұ����
        int curlen;       //���ʵ�ʳ���
        System.out.print("Please input table length:");
        Scanner sc = new Scanner(System.in);
        curlen = sc.nextInt();
        KeyType[] k = new KeyType[curlen];
        System.out.print("Please input keyword sequence:");
        for (int i = 0; i < curlen; i++) {  //����ؼ�������
            k[i] = new KeyType(sc.nextInt());
        }
        for (int i = 0; i < curlen; i++) {  //��¼˳���
            RecordNode r = new RecordNode(k[i]);
            ST.insert(ST.length(), r);
        }
    }

    public static void main(String[] args) throws Exception {
        createSearchList();   //�������ұ�
        System.out.print("please input search keyword:");  //��ʾ��������ҵĹؼ���
        Scanner sc = new Scanner(System.in); //��������ҹؼ���
        KeyType key1 = new KeyType(sc.nextInt());
        KeyType key2 = new KeyType(sc.nextInt());
        System.out.println("binaryseqSearch(" + key1.getKey() + ")=" + ST.binarySearch(key1));
        System.out.println("binarySearch(" + key2.getKey() + ")=" + ST.binarySearch(key2));
    }
}
