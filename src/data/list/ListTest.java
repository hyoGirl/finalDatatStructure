package cn.data.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	
	public static void main(String[] args) {
		
		
		List list=new ArrayList();
		
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		
		int length=list.size();
		System.out.println(length);
		
		
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
//		list.set(0, 5);
//		
//		System.out.println(list.get(0));
	}
}
