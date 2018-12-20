package com.search.dynamicSearch;

import java.util.Stack;

/**
 * @author ashura1110
 *  二叉排序树
 */
public class BSTree {
	
	
	private BSTNode root;
	
	/**
	 * 非递归构建二叉排序树
	 */
	public void createBST(int data) {
		BSTNode node=new BSTNode(data);
		if(root==null) {
			root=node;
		}
		BSTNode current=root;
		BSTNode parent;
		while(true) {
			parent=current;
			if(node.getData() > current.getData()) {
				current=current.getRightNode();
				if(current==null) {
					parent.setRightNode(node);
					return;
				}
			}else {
				current=current.getLeftNode();
				
				if(current==null) {
					parent.setLeftNode(node);
					return;
				}
			}
		}
	}
	
	
public void insert(int data){
		
	BSTNode newNode=new BSTNode(data);
		/**
		 * 1：先判断根节点是否存在
		 * 2：在根节点存在的情形下，与根节点相比，判断大小来循环插入
		 */
		
		if(root==null){
			root=newNode;
		}else{
			BSTNode current=root;
			BSTNode parent;
			while(true){
				parent=current;
				/**
				 * 通过判断如果小于上级节点，就把新结点放置在左边。
				 * 通过判断如果大于，就去判断下面的else。就把新结点放置右边
				 */
				if(((Integer)data)<((Integer)current.getData())){
					current=current.getLeftNode();
					/**
					 * 如果获取的左节点为空，而这个左节点又是当前节点了。
					 * 
					 * 重点：  需要再用一个节点来时刻保持当前节点的上一个节点
					 * 
					 * 所以需要保持对上级结点的引用。然后设置当前节点(要添加进去的节点)为上级节点的左结点。
					 */
					if(current==null){
						parent.setLeftNode(newNode);
						return;
					}
				}else{
					current=current.getRightNode();
					if(current==null){
						parent.setRightNode(newNode);
						return;
					}
				}
			}
		}
	}
	
//	public void createTree(BSTNode node,Scanner scanner) {
//		
//		int data = scanner.nextInt();
//		
//		if(data==0) {
//			return;
//		}else {
//			node=new BSTNode(data);
//		}
//		
//	}
	
	
	public void ordBSTree(BSTNode node) {
		
		if(node==null) {
			return;
		}else {
			ordBSTree(node.getLeftNode());
			System.err.print(node.getData()+" ");
			
			ordBSTree(node.getRightNode());
		}
	}
	
	
	public void ord(BSTNode node) {
		
		Stack stack=new Stack();
		
		if(node==null) {
			return;
		}
		
		while(node!=null || !stack.isEmpty()) {
			
			
			while(node!=null) {
				stack.push(node);
				node=node.getLeftNode();
			}
			
			if(!stack.isEmpty()) {
				
				 node = (BSTNode) stack.pop();
				 
				 System.out.print(node.getData()+" ");
				 
				 node=node.getRightNode();
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		
		BSTree tree=new BSTree();
		
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(25);
		tree.insert(50);
		tree.insert(15);
		tree.insert(11);
		tree.insert(27);
		
		tree.ordBSTree(tree.getRoot());
		System.out.println();
		Thread.sleep(200);
		tree.ord(tree.getRoot());
	}
	
	
	public BSTNode getRoot() {
		return root;
	}
}
