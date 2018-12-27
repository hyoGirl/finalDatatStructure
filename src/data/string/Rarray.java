package cn.data.string;

import java.util.Stack;

public class Rarray {
	
	public static void main(String[] args) {
		
		
		int[] arr={1,2,3,4,5};
		
		swap(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		String ss="abcdef";
		String reverse = reverse(ss);
		
		System.out.println(reverse);
		
		
	}
	
	public static  String reverse(String ss){
		
		char[] cc = ss.toCharArray();
		
		int i=0;
		int j=cc.length-1;
		
		while (j>i) {
			
			char temp=cc[j];
			
			cc[j]=cc[i];
			cc[i]=temp;
			i++;
			j--;
		}
		
		return new String(cc);
		
	}
	
	

	private static void swap(int[] arr) {
		
		int i=0;
		int j=arr.length-1;
		
		while (j>i) {
			
			int temp=arr[j];
			
			arr[j]=arr[i];
			
			arr[i]=temp;
			
			i++;
			j--;
		}
		 
	}
}
