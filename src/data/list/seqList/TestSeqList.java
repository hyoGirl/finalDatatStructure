package cn.data.list.seqList;

public class TestSeqList {

	public static void main(String[] args) {
		
		
		SeqList<Integer> ss=new SeqList<Integer>();
		
		ss.add(0, 1);
		ss.add(1, 2);
		ss.add(2, 3);
		
		System.out.println(ss.toString());;
		
		ss.set(2, 4);
		
		System.out.println(ss.toString());;
		
		
	}
}
