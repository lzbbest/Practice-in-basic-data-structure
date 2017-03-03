package HashTable;

/**
 * 第8章 采用链地址法的哈希表类，包括插入、删除、查找、遍历等操作。
 */

public class HashTable   //采用链地址法的哈希表类
{

    private LinkList[] table;      //哈希表的对象数组

    public HashTable(int size)    //构造指定大小的哈希表
    {
        this.table = new LinkList[size];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkList();     //构造空单链表
        }
    }

    public int hash(int key) //除留余数法哈希函数，除数是哈希表长度
    {
        return key % table.length;
    }

    public void insert(String element) throws Exception {  //在哈希表中插入指定元素
        int key = element.hashCode();   //每个对象的hashCode()方法返回整数值
        int i = hash(key);              //计算哈希地址
        table[i].insert(0, element);
    }

    public String printHashTable() //输出哈希表中各单链表的元素
    {
    	String result="";
        for (int i = 0; i < table.length; i++) {
            result+="table["+i+"]"+table[i].display();
        	System.out.print("table[" + i + "]= ");  //遍历单链表并输出元素值
            table[i].display();
        }
        return result;
    }

    public String search(String element) throws Exception {    //在哈希表中查找指定对象，若查找成功返回结点，否则返回null
        int key = element.hashCode();
        int i = hash(key);
        int index = table[i].indexOf(element);  //返回元素在单链表中的位置
        if (index >= 0) {
            return  table[i].get(index);  //返回在单链表中找到的结点
        } else {
            return null;
        }
    }

    public boolean contain(String element) throws Exception {   //以查找结果判断哈希表是否包含指定对象，若包含返回true，否则返回false
        return this.search(element) != null;
    }

    public boolean remove(String element) throws Exception {   //删除指定对象，若删除成功返回true，否则返回false
        int key = element.hashCode();
        int i = hash(key);
        int index = table[i].indexOf(element);
        if (index >= 0) {
            table[i].remove(index); //在单链表中删除对象
            return true;
        } else {
            return false;
        }
    }   
}
