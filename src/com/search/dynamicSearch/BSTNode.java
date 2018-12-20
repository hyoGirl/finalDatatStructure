package com.search.dynamicSearch;

/**
 * @author ashura1110
 * 
 */
public class BSTNode {
	
	
	private int data;
	
	private BSTNode leftNode;
	
	private BSTNode rightNode;

	public BSTNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BSTNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BSTNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BSTNode leftNode) {
		this.leftNode = leftNode;
	}

	public BSTNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BSTNode rightNode) {
		this.rightNode = rightNode;
	}
	
	

}
