/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月10日
 */
public class BinaryTreeSize {
	/*
	 * 最后遍历到叶子节点了，那么返回的是1.这个1此时就变成了当前叶子节点。同样右边也是1.
	 * 
	 */
	
	private  static int count=0;
	public static int getSize(BNode node){
		
		
		if(node==null){
			return 0;
		}else{
			return getSize(node.getLeftNode())+getSize(node.getRightNode())+1;
		}
	}
	
	/*
	 * 通过遍历来获取二叉树的节点个数
	 */
	public static int pre(BNode node){
		
		if(node==null){
			return 0;
		}
		count++;
		node.display();
		pre(node.getLeftNode());
		pre(node.getRightNode());
		
		return count;
	}
}
