/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：
 * @author 徐磊
 * @version 1.0
 * @date 2018年5月22日
 */
public class BNode {
	//关键数据
	private Object data;
	
	//左节点
	BNode leftNode;
	
	//右结点
	BNode rightNode;
	
	//是否是左节点
	Boolean isLeafNode;
	
	//是否是右节点
	Boolean isRightNode;
	//是否是第一次出现
	Boolean isFirst;
	
	public void display(){
		System.out.print(data+"-->");
	}
	

	public Object getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BNode leftNode) {
		this.leftNode = leftNode;
	}

	public BNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BNode rightNode) {
		this.rightNode = rightNode;
	}

	public BNode(Object data) {
		super();
		this.data = data;
	}
	
	
	public BNode(Object data, BNode leftNode, BNode rightNode) {
		super();
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}


	public BNode() {
		super();
	}
	
	
	
}
