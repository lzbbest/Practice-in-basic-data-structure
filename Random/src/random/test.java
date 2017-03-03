package random;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class test {
	/** 
	 * 随机指定范围内N个不重复的数 
	 * 最简单最基本的方法 
	 * @param min 指定范围最小值 
	 * @param max 指定范围最大值 
	 * @param n 随机数个数 
	 */  

	public static void read() throws IOException {
		FileReader fr=new FileReader("C:\\Users\\Colin\\Desktop\\111.txt");
		BufferedReader br=new BufferedReader(fr); 
		String eachLine = null;	
		eachLine = br.readLine();
		ArrayList <String> name = new ArrayList<String>();
		while(eachLine!= null){
			String temp[] = eachLine.split("\t");
			name.add(temp[2]);
		}
		String out[]=new String[name.size()];
		for(int i=0;i<name.size();i++){
			out[i]=name.get(i);
			//System.out.println(test.get(i));
			System.out.println(out[i]);
		}
		
	}
}  