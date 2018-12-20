/**
 * 
 */
package com.tree.binaryTree;

import java.util.Map;

/**
 * 说明：
 * @author 徐磊
 * @version 1.0
 * @date 2018年5月22日
 */
public class TestMyBinaryTree {

	/**
	 * 说明：
	 * @param args
	 * @author 徐磊
	 * @time：2018年5月22日 下午11:19:29
	 */

	public static void main(String[] args) {
		
		MyBinaryTree bt=new MyBinaryTree();
		
		bt.insert(30);
		bt.insert(22);
		bt.insert(20);
		bt.insert(35);
		bt.insert(8);
		bt.insert(15);
		bt.insert(48);
		bt.insert(28);
		bt.insert(13);
		
		/*		
				   30			
			22				35	
			
		20		28				48
			
	8							
		15			
		
*/		
		//new NoRecursionPostOrder().post(bt.getRoot());
		new NoRecursionInOrder().in(bt.getRoot());
		System.out.println();
//		new NoRecursionPostOrder().postOneStack(bt.getRoot());
//		
//		System.out.println();
//		BNode parent = SearchBNode_parent.getParent(bt.getRoot(), new BNode(35));
//		
//		
//		System.out.println(parent.getData());
		
		
//		BNode left = SearchBNode_left.getLeft(bt.getRoot(), new BNode(22));
//		
//		System.out.println(left.getData());
//		
//		BNode leftNoRecursion = SearchBNode_left.getLeftNoRecursion(bt.getRoot(),new BNode(22));
//		
//		System.out.println(leftNoRecursion.getData());
//		
//		int pre = BinaryTreeSize.pre(bt.getRoot());
//		System.out.println();
//		System.out.println(pre);
//		
//		System.out.println(BinaryTreeSize.getSize(bt.getRoot()));
//		
//	    bt.preOrderRecursion(bt.getRoot());	
//	    
//	    System.out.println();
//	    
//	    BNode searchNode = bt.searchNode(8);
//	    System.out.println();
//	    searchNode.display();
//	    System.out.println();
//	    bt.search_K(bt.getRoot(), 3);
	    
//	    new SearchBNode_k().search_K(bt.getRoot(), 3);
//	    bt.inOrderRecursion(bt.getRoot());
//	   new InOrderSearchBNode_K().search_k(bt.getRoot(), 4);
//	   
//	   	System.err.println(new BinaryTreeDepth().getDepth(bt.getRoot()));
//	    
//	    System.out.println(new SearchBNodeRecursion().serach(bt.getRoot(), 8));
	    
	    
//	    System.out.println((new SearchMaxBNodeRecursion().searchMax(bt.getRoot())).getData());
//	    bt.preOrder(bt.getRoot());
//	    
//	    System.out.println();
//	    bt.inOrderRecursion(bt.getRoot());
//	    System.out.println();
//	    bt.inOrder(bt.getRoot());
//	    System.out.println("-------开启层序遍历--------");
//	    new LevelSearch().level(bt.getRoot());
//	    System.out.println("自己实现队列来进行层序遍历");
//	    new LevelSearch().levelMyQueue(bt.getRoot());
//	    
//	    System.out.println();
//	    System.out.println("------使用层序遍历查找二叉树的最大宽度-------");
//	    
//	    int maxWidth_my = new BinaryTreeWidth().getMaxWidth_my(bt.getRoot());
//	    
//	    System.out.println(maxWidth_my);
//	    
//	    
//	    Map<Integer, Object> map = new BinaryTreeWidth().getEveryLevelWidth(bt.getRoot());
//	    
//	    for( Map.Entry<Integer, Object> obj:map.entrySet()){
//	    	
//	    	
//	    	System.out.println("层数："+obj.getKey()+" 结点数目："+obj.getValue());
//	    }
//	    
//		System.out.println();
//		
//		System.out.println("使用层序遍历来获取二叉树的深度");
//		
//		int depth_my = new BinaryTreeDepth().getDepth_my(bt.getRoot());
//		
//		System.out.println("二叉树的最大深度是： "+depth_my);
		
		
		//bt.postOrderRecursion(bt.getRoot());
		
		System.out.println();
		new NoRecursionPostOrder().post(bt.getRoot());
	
	}

}
