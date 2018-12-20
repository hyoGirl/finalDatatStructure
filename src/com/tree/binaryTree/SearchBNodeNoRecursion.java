/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：
 * @author 徐磊
 * @version 1.0
 * @date 2018年5月30日
 */
public class SearchBNodeNoRecursion {
	
	private BNode root;
	public BNode search(int data){
		if(root==null){
			return null;
		}
		
		BNode current=root;
		while(((Integer)current.getData())!=data){
			
			if(((Integer)current.getData()) < data){
				current=current.getLeftNode();
			}
			if(((Integer)current.getData()) > data){
				current=current.getLeftNode();
			}
			if(current==null){
				return null;
			}
		}
		return current;
		
	}
}
