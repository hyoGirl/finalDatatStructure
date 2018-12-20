/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：查找二叉树的父节点
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月10日
 */
public class SearchBNode_parent {
	
	
	public static BNode getParent(BNode root,BNode  node){
		
		if(root==null||node==null){
			return null;
		}
		
		//如果某个节点的左/右 子树是要查找的节点，那么这个节点就是我们需要查找的。
		if(root.leftNode.getData()==node.getData() || root.rightNode.getData() ==node.getData()){
			return root;
		}
		//使用递归。先从左边子树开始，
		BNode p = getParent(root.getLeftNode(), node);
		
		if(p!=null){
			return p;
		}
		
		return getParent(root.getRightNode(), node);
		
	}
	
	
	public static BNode searchNode(BNode root,BNode  node){
		
		if(root==null){
			return null;
		}
		if(root.getData()==node.getData()){
			return root;
		}
		
		BNode searchNode = searchNode(root.getLeftNode(), node);
		
		if(searchNode!=null){
			return searchNode;
		}
		
		return searchNode(root.getRightNode(),node);
		
	}
	
	
}
