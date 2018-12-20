/**
 * 
 */
package com.tree.binaryTree;

import java.util.Stack;

/**
 * 说明：先序非递归遍历
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月5日
 */
public class NoRecursionPreOrder {
	
	//先序遍历，是根-->左-->右
	//栈是先进后出的，要满足先序，
	public void pre(BNode node){
		
		/**
		 * 栈本身是没有add方法的，是下面的子类vector有这个方法，返回的是true
		 * 而push返回的却是放入的元素
		 * 
		 * 总结：根节点入栈，然后根节点出栈，右边节点入栈，左边节点入栈，然后左边节点就变成了根节点，出栈，开始循环。
		 * 
		 * 
		 */
		
		
		Stack<BNode> stack=new Stack<BNode>();
		
		if(node!=null){
			stack.push(node);
			
			while(!stack.empty()){
				
				node=stack.pop();
				node.display();
				
				if(node.getRightNode()!=null){
					stack.push(node.getRightNode());
				}
				
				if(node.getLeftNode()!=null){
					stack.push(node.getLeftNode());
				}
			}
		}
		
	}
	
	/**
	 * 
	 * 说明：换种方式来写前序
	 * @author 徐磊
	 * @time：2018年6月8日 下午10:20:24
	 */
	public void myPre(BNode node){
		
		/*
		 * 先序遍历，就是根--左--右 
		 * 
		 * 1：在压入之前进行访问，然后把所有的左子树都压入进去，类似实现了 根 --左
		 * 
		 * 
		 * 2：然后要实现最后的左边子树的右边，此时前提是左边没有左子树了，所以弹出当前层的左节点，
		 * 
		 * 然后获取了右边节点，如果右边没有，就反向再次弹出当前层的根节点(也是上一层的左节点)。一直往上递归
		 * 
		 * 如果有，那么就压入，在压入之前访问，那么就是实现了访问的根 --左--右。这里的根指向左边子树当前层的根
		 * 
		 * 最原始的根，就是等当前左边子树完全出来后，再弹出来的，和上面思路不一样。
		 */
		
		Stack<BNode> stack1=new Stack<BNode>() ;
		while(!stack1.isEmpty() || node!=null){
			
			if(node!=null){
				
				//在压入之前进行访问
				System.out.println(node.getData()+"-->");
				
				stack1.push(node);
				
				node=node.getLeftNode();
			}
			if(!stack1.isEmpty()){
				node = stack1.pop();
				
				node=node.getRightNode();
			}
			
		}
	}
	
}
