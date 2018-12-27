package cn.data.digui;

public class Demo1 {
	
	/**
	 * Fn=0 当n=0的时候。
	 * Fn=1 当n=1的时候。
	 * Fn=F(n-1)+F(n-2) 当n>1的时候。
	 */
	public static void main(String[] args) {
		//要么定义长度，要么定义具体内容
		//int[] arr1=new int[]{1,2,3,4,5,6};
		//int[] arr2={1,2,3,4,5};
		int[] arr=new int[10];
		
		arr[0]=0;
		arr[1]=1;
		
		if (1>0) {
			
		}
		
		for (int i = 2; i < arr.length; i++) {
			
			arr[i]=arr[i-1]+arr[i-2];
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("------采用递归打印--------");
		System.out.println();
		
//		for (int i = 2; i < arr.length; i++) {
//			
//			System.out.print(fib(i)+" ");
//		}
		
	}
	
	public static  int fib(int i){
		
		
		if (i < 2) {
			
			return i==0 ? 0 : 1;
			
			
		}else{
			
			return fib(i-1)+fib(i-2);
		}
	}
	
}
