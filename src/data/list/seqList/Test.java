package cn.data.list.seqList;

public class Test {

	public static void main(String[] args) {
		
		
		SeqListDemo<Integer> ss=new SeqListDemo<Integer>();
		
		ss.add(0, 1);
		ss.add(1, 2);
		ss.add(2, 3);
		ss.add(3, 3);
		ss.add(4, 3);
		ss.add(5, 3);
		ss.add(6, 3);
		ss.add(7, 3);
		ss.add(8, 3);
		ss.add(9, 3);
		ss.add(6, 6);
		
		System.out.println(ss.toString());;
		
		ss.set(2, 4);
		
		System.out.println(ss.toString());;
		
		System.out.println(ss.get(2));;
		
		
	}
}
