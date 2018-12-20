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
public class InsertTree {
	
	private BNode root;
	
	public void insertBNode(int data){
		BNode node=new BNode(data);
		if(root==null){
			return ;
		}
	
		
	//插入的时候要保持对上一个节点的引用。。。。
	BNode current=root;
	BNode parent=root;
	while(((Integer)current.getData())!=data){
		parent=current;
		if(((Integer)current.getData()) > data){
			current=current.getLeftNode();
			//如果上一个节点没有左子树
			if(current==null){
				parent.setLeftNode(current);
				return;
			}
		}
		if(((Integer)current.getData()) < data){
			current=current.getRightNode();
			//如果上一个节点没有右子树
			if(current==null){
				parent.setRightNode(current);
				return;
			}
		}
	}
	}
}
