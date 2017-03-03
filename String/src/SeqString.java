// ˳�����ʵ�֡�
public class SeqString implements IString {

    private char[] strvalue;            //�ַ����飬��Ŵ�ֵ
    private int curlen;                //��ǰ���ĳ���

    
    public String totalString(){							//****************************
    	String str=new String(strvalue);
    	return	str;
    }
    //���췽��1������һ���մ�
    public SeqString() {
        strvalue = new char[0];
        curlen = 0;
    }

    //���췽��2�����ַ����������촮����
    public SeqString(String str) {
        if (str != null) {
            char[] tempchararray = str.toCharArray();
            strvalue = tempchararray;
            curlen = tempchararray.length;
        } 
    }

    //���췽��3�����ַ����鹹�촮����
    public SeqString(char[] value) {
        this.strvalue = new char[value.length];
        for (int i = 0; i < value.length; i++) { //��������
            this.strvalue[i] = value[i];
        }
        curlen = value.length;
    }

    //��һ���Ѿ����ڵĴ��óɿմ�
    public void clear() {
        this.curlen = 0;
    }

    //�жϵ�ǰ���Ƿ�Ϊ�գ�Ϊ���򷵻�true�����򷵻�false
    public boolean isEmpty() {
        return curlen == 0;
    }

    //�����ַ�������
    public int length() {
        return curlen;    //����: strvalue.length����������
    }

    //�����ַ��������Ϊindex���ַ�*******************************************************************************
    public char charAt(int index) {
        if ((index < 0) || (index >= curlen)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return strvalue[index];
    }
    //���ַ��������Ϊindex���ַ�����Ϊch

    public void setCharAt(int index, char ch) {
        if ((index < 0) || (index >= curlen)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        strvalue[index] = ch;
    }

    public void allocate(int newCapacity) //��������������ָ����С����
    {
        char[] temp = strvalue;                           //��������
        strvalue = new char[newCapacity];
        for (int i = 0; i < temp.length; i++) {
            strvalue[i] = temp[i];
        }
    }

    //���ش�����Ŵ�begin��end-1���Ӵ�
    public IString substring(int begin, int end) {
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException("��ʼλ�ò���С��0");
        }
        if (end > curlen) {
            throw new StringIndexOutOfBoundsException("����λ�ò��ܴ��ڴ��ĵ�ǰ����:" + curlen);
        }
        if (begin > end) {
            throw new StringIndexOutOfBoundsException("��ʼλ�ò��ܴ��ڽ���λ��");
        }
        if (begin == 0 && end == curlen) {
            return this;
        } else {
            char[] buffer = new char[end - begin];
            for (int i = 0; i < buffer.length; i++) //�����Ӵ�
            {
                buffer[i] = this.strvalue[i + begin];
            }
            return new SeqString(buffer);
        }
    }

    //���ش�����Ŵ�begin����β���Ӵ�
    public IString substring(int begin) {
        return substring(begin, strvalue.length);
    }

    //�ڵ�ǰ���ĵ�offset���ַ�֮ǰ���봮str��0<=offset<=curlen
    public IString insert(int offset, IString str) {
        if ((offset < 0) || (offset > this.curlen)) {
            throw new StringIndexOutOfBoundsException("����λ�ò��Ϸ�");
        }
        int len = str.length();
        int newCount = this.curlen + len;
        if (newCount > strvalue.length) {
            allocate(newCount);             // ����ռ䲻�㣬����������
        }
        for (int i = this.curlen - 1; i >= offset; i--) {
            strvalue[len + i] = strvalue[i];    //��offset��ʼ����ƶ�len���ַ�
        }
        for (int i = 0; i < len; i++) //�����ַ���str
        {
            strvalue[offset + i] = str.charAt(i);
        }
        this.curlen = newCount;
        return this;
    }
    //ɾ����begin��end-1���Ӵ��� 0��begin��length()-1��1��end��length()��

    public IString delete(int begin, int end) {
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException("��ʼλ�ò���С��0");
        }
        if (end > curlen) {
            throw new StringIndexOutOfBoundsException("����λ�ò��ܴ��ڴ��ĵ�ǰ����:" + curlen);
        }
        if (begin > end) {
            throw new StringIndexOutOfBoundsException("��ʼλ�ò��ܴ��ڽ���λ��");
        }
        for (int i = 0; i < curlen - end; i++) //��end��ʼ����β���Ӵ���ǰ�ƶ�����begin��ʼ��λ��
        {
            strvalue[begin + i] = strvalue[end + i];
        }
        curlen = curlen - (end - begin);  //��ǰ�����ȼ�ȥend-begin
        return this;
    }

    //���ָ����str����ǰ��β
    public IString concat(IString str) {
        return insert(curlen, str);
    }
    //���ַ�c���ӵ�����ǰ��β

    public IString concat(char c) {
        int newCount = curlen + 1;
        if (newCount > strvalue.length) {
            allocate(newCount);
        }
        strvalue[curlen++] = c;
        return this;
    }

    //�Ƚϴ�
    public int compareTo(IString str) {
        return compareTo((SeqString) str);
    }

    public int compareTo(SeqString str) {  //�Ƚϴ�
        //����ǰ����Ĵ�ֵ����str�Ĵ�ֵ����������һ��������
        //����ǰ����Ĵ�ֵ����str�Ĵ�ֵ����������0
        //����ǰ����Ĵ�ֵС��str�Ĵ�ֵ����������һ��������
        int len1 = curlen;
        int len2 = str.curlen;
        //int n = Math.min(len1, len2);
        //char s1[] = strvalue;
        //char s2[] = str.strvalue;
        //int k = 0;
        //while (k < n) {
        //    char ch1 = s1[k];
        //    char ch2 = s2[k];
        //    if (ch1 != ch2) {
        //        return ch1 - ch2;  //���ص�һ��������ַ�����ֵ��
        //    }
        //    k++;
        //}
        //for (int k=0;k<n;k++)
        //     if (strvalue[k]!=str.strvalue[k])
        //         return(strvalue[k]-str.strvalue[k]);

        return len1 - len2;   //���������ַ������ȵ���ֵ��
    }

    public String toString() {
        return new String(strvalue, 0, curlen);   //���ַ�����strvalue���촮
    }

    // ģʽƥ���Brute-Force �㷨
    //����ģʽ��t�������д�start��ʼ�ĵ�һ��ƥ��λ�ã�ƥ��ʧ��ʱ���أ�1��
    public int index_BF(SeqString str, int start) {
        if (this != null && str != null && str.length() > 0 && this.length() >= str.length()) {  //��������ģʽ����ʱ���бȽ�
            int slen, tlen, i = start, j = 0;    //i��ʾ������ĳ���Ӵ������
            slen = this.length();
            tlen = str.length();
            while ((i < slen) && (j < tlen)) {
                if (this.charAt(i) == str.charAt(j)) //jΪģʽ����ǰ�ַ����±�
                {
                    i++;
                    j++;
                } //�����ȽϺ����ַ�
                else {
                    i = i - j + 1;        //�����Ƚ������е���һ���Ӵ�
                    j = 0;                //ģʽ���±��˻ص�0
                }
            }
            if (j >= str.length()) //һ��ƥ�������ƥ��ɹ�
            {
                return i - tlen;         //�����Ӵ����
            } else {
                return -1;
            }
        }
        return -1;                     //ƥ��ʧ��ʱ����-1
    }

    //����ǰ���д��ں�str��ͬ���Ӵ����򷵻�ģʽ��str�������дӵ�start�ַ���ʼ�ĵ�һ�γ���λ�ã����򷵻�-1
    public int indexOf(IString str, int start) {
        return index_KMP(str, start);
    }

    //KMPģʽƥ���㷨
    public int index_KMP(IString STR, int start) {
        //�ڵ�ǰ�����д�start��ʼ����ģʽ��T
        //���ҵ����򷵻�ģʽ��T�������е��״�ƥ��λ�ã����򷵻�-1
        int[] next = getNext(STR);     //����ģʽ����next[]����ֵ
        int i = start;               //����ָ��
        int j = 0;                   //ģʽ��ָ��
        //����������������Ƚ��ַ�
        while (i < this.length() && j < STR.length()) {
            //����Ӧ�ַ�ƥ��
            if (j == -1 || this.charAt(i) == STR.charAt(j)) { // j==-1��ʾS[i]!=T[0]
                i++;
                j++;         //��ת����һ���ַ�
            } else //��S[i]������T[j]ʱ
            {
                j = next[j];        //ģʽ������
            }
        }
        if (j < STR.length()) {
            return -1;                  //ƥ��ʧ��
        } else {
            return (i - STR.length());    //ƥ��ɹ�
        }
    }

    //����ģʽ��T��next[]����ֵ
    private int[] getNext(IString T) {
        int[] next = new int[T.length()];  //next[]����
        int j = 1;    //����ָ��
        int k = 0;   //ģʽ��ָ��
        next[0] = -1;
        if (T.length()>1)
           next[1] = 0;
        while (j < T.length() - 1) {
            if (T.charAt(j) == T.charAt(k)) {  //ƥ��
                next[j + 1] = k + 1;
                j++;
                k++;
            } else if (k == 0) {  //ʧ��
                next[j + 1] = 0;
                j++;
            } else {
                k = next[k];
            }
        }
        return (next);
    }

    //����ģʽ��T��nextval[]����ֵ
    private int[] getNextVal(IString T) {
        int[] nextval = new int[T.length()];  //nextval[]����
        int j = 0;
        int k = -1;
        nextval[0] = -1;
        while (j < T.length() - 1) {
            if (k == -1 || T.charAt(j) == T.charAt(k)) {
                j++;
                k++;
                if (T.charAt(j) != T.charAt(k)) {
                    nextval[j] = k;
                } else {
                    nextval[j] = nextval[k];
                }
            } else {
                k = nextval[k];
            }
        }
        return (nextval);
    }

}
