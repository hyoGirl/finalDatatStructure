package cn.data.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FindChar {
	
	
	public static void main(String[] args) {
		
		String ss="aabbcccdddffffjhhhh";
		
		getMaxCountChar(ss);
		
		
	}
	
	public static Map<String, Integer> getMaxCountChar(String input){  
        Map<String, Integer> result = new HashMap<String, Integer>();  
          
          
  
        char[] charArray = input.toCharArray();  
          
        List<String> linkedList = new LinkedList<String>();  
        
        Set<String> treeSet = new TreeSet<String>();  
          
        for(int i = 0; i < charArray.length; i++){  
            linkedList.add(String.valueOf(charArray[i]));  
            treeSet.add(String.valueOf(charArray[i]));  
        }  
        Collections.sort(linkedList);  
        System.out.println("排序后的字符串是：" + linkedList);  
          
        StringBuffer sb = new StringBuffer();  
        for (String s : linkedList) {  
            sb.append(s);  
        }  
        input = sb.toString();  
      //存放出现次数比当前次数（即：maxCount）多的字符，有多少存多少，且按字典顺序存放
        List<String> maxList = new ArrayList<String>();  
      //保存出现最多的次数
        int maxCount = 0; 
      //保存出现次数最多的字符，如果t和y都是出现次数最多的字符则按字典顺序保存t
        String maxString = "";  
          
          
          
        Iterator<String> it = treeSet.iterator();  
        while(it.hasNext()){  
            String temp = it.next();  
            int start = input.indexOf(temp);  
            int end = input.lastIndexOf(temp);  
            int value = end - start + 1;  
            if(value > maxCount){  
                maxCount = value;  
                maxString = temp;  
                maxList.add(temp);  
            }else if(value == maxCount){  
                maxList.add(temp);  
            }  
        }  
        int index = 0;  
        for (int i = 0; i < maxList.size(); i++) {  
            //如果第i个元素和最先达到最多次数的字符相等那么i之后的所有元素必定也都出现了maxCount次   ①  
            if(maxList.get(i).equals(maxString)){  
                index = i;  
                break;  
            }  
        }  
          
        //由①可知  
        for(int i = index; i < maxList.size(); i++){  
            System.out.println("出现次数最多的元素是：" + maxList.get(i));  
            result.put(maxList.get(i), maxCount);  
        }  
          
        System.out.println("最多出现的次数是：" + maxCount);  
      
        return result;  
          
    }
}
