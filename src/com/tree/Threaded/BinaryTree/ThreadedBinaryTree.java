/**
 * 
 */
package com.tree.Threaded.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 说明：线索二叉树
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月9日
 */
public class ThreadedBinaryTree {
	
	private static List<TBTNode> nodeList=null;
	
	//创建一个完全二叉树
	void createTree(Object[] array){
		
		nodeList=new LinkedList<TBTNode>();
		
		
		for(int i=0;i<array.length;i++){
			
			nodeList.add(new TBTNode(array[i]));
		}
		for(int j=0;j<array.length/2-1;j++){
			
			nodeList.get(j).leftNode=nodeList.get(j*2+1);
			
			nodeList.get(j).rightNode=nodeList.get(j*2+2);
		}
		
		//最后一个节点可能没有右边孩子，   是一个满二叉树
		
		int index=array.length/2-1;
		
		nodeList.get(index).leftNode=nodeList.get(2*index+1);
		// 右孩子,如果数组的长度为奇数才建立右孩子  
		if(array.length%2==1){
			nodeList.get(index).rightNode=nodeList.get(2*index+2);
		}
	}
	
	//先序遍历
	/**
	 * 先序遍历，是先根，然后右边进入栈顶，最后左边进入，最后再弹出
	 * @param node
	 */
	void pre(TBTNode node){
		
		Stack<TBTNode> nodeStack=new Stack<TBTNode>();
		if(node!=null){
		
			nodeStack.push(node);
			
				while(!nodeStack.isEmpty()){
					node=nodeStack.pop();
					
					System.out.print(node.getData()+" ");
					
					if(node.getRightNode()!=null){
						nodeStack.push(node.getRightNode());
					}
					if(node.getLeftNode()!=null){
						nodeStack.push(node.getLeftNode());
					}
				}
			}
	}
	
	//中序遍历
	/**
	 * 左边  根  右边
	 * 
	 * 先把所有的左边都压入栈顶，没有左边了就弹出，判断有没有右边，有右边右边就入栈，否则看栈是不是空，不是就继续弹出
	 * @param node
	 */
	void inOrder(TBTNode node){
		Stack<TBTNode> nodeStack=new Stack<TBTNode>();
		if(node==null){
			return;
		}
		
		while(!nodeStack.isEmpty() || node!=null){
			
			//左边 --》 根 --> 右边
			
			while(node!=null){
				
				nodeStack.push(node);
				node=node.leftNode;
			}
			
			if(!nodeStack.isEmpty()){
				node=nodeStack.pop();
				
				System.out.print(node.getData()+" ");
				node=node.rightNode;
			}
		}
		
	}
	/**
	 * 后序遍历  左边  右边 根
	 * 
	 * 就是判断弹出的时候是从左边弹出，还是右边弹出，如果是左边就在压进去，如果是右边就直接弹出，根据标志来判断
	 * @param node
	 */
	void postOrder(TBTNode node){
		Stack<TBTNode> nodeStack=new Stack<TBTNode>();
		if(node==null){
			return;
		}
		//左边  右边  根
		while(!nodeStack.isEmpty() || node!=null){
			
			while(node!=null){
				nodeStack.push(node);
				node.isFirst=true;
				node=node.leftNode;
			}
			if(!nodeStack.isEmpty()){
				node=nodeStack.pop();
				
				if(node.isFirst){
					node.isFirst=false;
					
					nodeStack.push(node);
					node=node.rightNode;
				}else{
					
					System.out.print(node.getData()+" ");
				}
			}
			
		
		}
	}
	
	
	//中虚线索化
	/**
	 * 1：先递归找到最左边的节点，
	 * 2：前驱节点线索化：判断这个节点的左子树是不是空，是空，就设置标志位为链。然后设置当前节点的左子树为前驱节点
	 * 
	 * 3：后继节点线索化： 如果前驱节点，没有右边子树，那么前驱节点就设置标志位。同时前驱节点的下一个节点，就是前驱节点的右字数
	 * 
	 * 4: 前驱节点转换位当前节点
	 * @param node
	 * @param pre
	 */
	void inThreadList(TBTNode node,TBTNode pre){
		if(node==null){
			return;
		}
		//找到最左边的节点
		inThreadList(node.getLeftNode(), pre);
		//开始前驱结点的线索化
		if(node.getLeftNode()==null){
			node.setLeftTag(1);
			node.leftNode=pre;
		}
		//后继节点的线索化
		if(pre.rightNode==null && pre!=null){
			
			pre.setRightTag(1);
			
			pre.rightNode=node;
		}
		pre=node;
		//处理右子树
		inThreadList(node.getRightNode(),pre);
		
	}
	
	//线索：        二叉链表中的空指针改为指向前驱节点或后继节点的线索
	//中序遍历线索二叉树
	
	void inTBT(TBTNode node){
		
		
		    //1、找中序遍历方式开始的节点
			while(node!=null && node.leftNode!=null){
				node=node.getLeftNode();
			}
			
			//
			while(node!=null){
				System.out.print(node.getData()+" ");
				
				//判断是否存在右边的线索
				if(node.rightTag==1){
					
					node=node.rightNode;
				}else{  //表示有右边子树
					
					
					
					
				}
				
				
			}
			
			
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		ThreadedBinaryTree tbt=new ThreadedBinaryTree();
		
		String[] array = {"A", "B", "C", "D", "E", "F", "G", "H"};
		
		tbt.createTree(array);
		
		tbt.pre(nodeList.get(0));
		
		
	}
	

}
