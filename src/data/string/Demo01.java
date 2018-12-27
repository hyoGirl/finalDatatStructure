package cn.data.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo01 {
	
	public static void main(String[] args) {
		
		String ss="aabbccddffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffjhhhh";
		char[] charArray = ss.toCharArray();
		Map<Character,Integer > map=new HashMap<>();
		Integer max=0;
//		Integer count=0;
		for (char c : charArray) {
			Integer count = map.get(c);
			count=count==null?1:++count;
			map.put(c, count);
			if (count > max) {
				max=count;
			}
			if (count > charArray.length /2 +1) {
				System.out.println("出现最多的次数： "+count +"次！");
				System.out.println("出现次数最多的字符： "+c );
				//终止程序
				System.exit(0);
			}
			
		}
		
		
		System.out.println("出现最多的次数是： "+max +"次！");
		Set<Character> keySet = map.keySet();
		for (Character c : keySet) {
			//如果出现了相等次数的字符
			if (max.compareTo(map.get(c))==0) {
				System.out.println("出现次数最多的字符是： "+c);
			}
		}
		
	}
}
