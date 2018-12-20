/**
 * 
 */
package com.tree.Threaded.BinaryTree;

/**
 * 说明：
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月9日
 */
public class TBTNode {
	
	/**
	 * 在一般的二叉树中，我们只知道某一个节点的左右孩子，并不能知道某个节点在某种遍历方式下的
	 * 
	 * 直接前驱和直接后继，如果能够知道直接前驱和直接后继，就可以把二叉树看成一个链表结构。
	 * 
	 * 从而可以想遍历链表一样遍历二叉树。进而提高效率。
	 * 
	 */
	
	//数据域
	public Object data;
	//左标识域。  1标识左节点为前驱结点，0标识左节点为左子节点 
    public	int leftTag;
    // 右标识域。
    public int rightTag;
    
    public boolean isFirst;
    
    //左边节点
    public TBTNode leftNode;
    //右边节点
    public TBTNode rightNode;
    
    
	public Object getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getLeftTag() {
		return leftTag;
	}
	public void setLeftTag(int leftTag) {
		this.leftTag = leftTag;
	}
	public int getRightTag() {
		return rightTag;
	}
	public void setRightTag(int rightTag) {
		this.rightTag = rightTag;
	}
	public TBTNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TBTNode leftNode) {
		this.leftNode = leftNode;
	}
	public TBTNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TBTNode rightNode) {
		this.rightNode = rightNode;
	}
	
	
	public TBTNode() {
		super();
	}
	
	public TBTNode(Object data) {
		this.data=data;
	}
	public TBTNode(int data, int leftTag, int rightTag, TBTNode leftNode, TBTNode rightNode) {
		super();
		this.data = data;
		this.leftTag = leftTag;
		this.rightTag = rightTag;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	
    
}
