package cn.data.digui;

import java.util.Scanner;

public class HanNuoTa {
	
	public static void main(String[] args) {
		
		char x='x';
		char y='y';
		char z='z';
		
		Scanner scanner = new Scanner(System.in);
	    System.out.print("请输入汉诺塔层数：");
	    //此处会让你通过控制台输入数字
	    int num = scanner.nextInt();
	    //System.out.println(num + 1);
		show(num, x, y, z);
		
		
	}
	/**
	 * 
	 * 说明：
	 * @param n  层数
	 * @param x  起始柱子
	 * @param y  中间柱子
	 * @param z  目标柱子
	 * @author 徐磊
	 * @time：2017年11月4日 下午8:36:26
	 */
	public static void show(int n,char x,char y,char z){
		if (n==0) {
			//System.out.println("n---0");
		}else{
			//第一步，把n-1个原盘，从X移动到Y上，通过Z,此时中间柱子是z，开始柱子是X，目的柱子是y。
			show(n-1, x, z, y);
			//第二步，把最大的盘移动到Z上
			System.out.println(x+"-->"+z);
			//第三步，把n-1个盘从Y移动到z上，通过x, 此时中间柱子是x，开始柱子是y。目的柱子是Z
			show(n-1, y, x, z);
		}
		
	}
}
