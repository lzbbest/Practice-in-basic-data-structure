//�ַ��������������͵Ľӿڶ���
public interface IString {

    public void clear();          //��һ���Ѿ����ڵĴ��óɿմ�

    public boolean isEmpty();    //�жϵ�ǰ���Ƿ�Ϊ�գ�Ϊ���򷵻�true�����򷵻�false

    public int length();         //�����ַ����ĳ���

    public char charAt(int index);   //���ش������Ϊindex���ַ�

    public IString substring(int begin, int end); //���ش����ַ���Ŵ�begin��end-1���Ӵ�

    public IString insert(int offset, IString str);  //�ڵ�ǰ���ĵ�offset���ַ�֮ǰ���봮str

    public IString delete(int begin, int end);   //ɾ����ǰ���д����begin��ʼ�����end-1Ϊֹ���Ӵ�

    public IString concat(IString str);  //���ָ����str����ǰ��β

    //����ǰ����Ŀ�괮str���бȽϣ�����ǰ������str���򷵻�һ��������������ǰ������str���򷵻�0������ǰ��С��str���򷵻�һ����������
    public int compareTo(IString str);
    //����ǰ���д��ں�str��ͬ���Ӵ����򷵻�ģʽ��str�������дӵ�start�ַ���ʼ�ĵ�һ�γ���λ�ã����򷵻�-1
    public int indexOf(IString str,int start);
}
