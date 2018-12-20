/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：查找某个节点的左边子树
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月10日
 */
public class SearchBNode_left {
	
	
	public static BNode getLeft(BNode root,BNode node){
		
		if(root==null){
			return null;
		}
		if(root.getData()==node.getData()){
			return root.getLeftNode();
		}
		BNode left = getLeft(root.getLeftNode(),node);
		if(left!=null){
			return left;
		}
		return getLeft(root.getRightNode(), node);
	}
	
	public static BNode getLeftNoRecursion(BNode root,BNode node){
		
		if(root==null){
			return null;
		}
		BNode current=root;
		while(current.getData()!=node.getData()){
			
			if(((Integer)current.getData())<((Integer)node.getData())){
				current=current.getRightNode();
			}
			if(((Integer)current.getData())>((Integer)node.getData())){
				current=current.getLeftNode();
			}
			
			if(current==null){
				return null;
			}
		}
		
		return current.getLeftNode();
	}
	
}
