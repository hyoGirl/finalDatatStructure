package cn.data.string;

import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {

		String src = "abcdefg";

		//String reverse = reverse(src);
		//System.out.println(reverse);
		
		String reverse6 = reverse6(src);
		
		System.out.println(reverse6);
		

		System.out.println(src);

	}

	private static String reverse(String ss) {

		char[] charArray = ss.toCharArray();
		int i = 0;
		int j = charArray.length - 1;
		while (j > i) {
			swap(charArray[i], charArray[j]);

			i++;
			j--;
		}
		return new String(charArray);
	}

	// 這個地方交換的只是两个简单的数字，而不是数组里面的元素
	private static void swap(char charAt, char charAt2) {
		char temp = charAt2;
		charAt2 = charAt;
		charAt = temp;
	}

	public static String reverse5(String orig) {
		char[] s = orig.toCharArray();
		int n = s.length - 1;
		int halfLength = n / 2;
		for (int i = 0; i <= halfLength; i++) {
			char temp = s[i];
			s[i] = s[n - i];
			s[n - i] = temp;
		}
		return new String(s);
	}
	
	
	
	public static String reverse6(String ss){
		
		Stack<Character> stack=new Stack<Character>();
		
		for (int i = 0; i < ss.length(); i++) {
			
			stack.push(ss.charAt(i));
		}
		String reverse="";
		
		for (int i = 0; i < ss.length(); i++) {
			reverse+=stack.pop();
		}
		
		return reverse;
	}
}
