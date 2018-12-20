/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月9日
 */
public class CompleteBinaryTree {
	
	/**
	 * 
	 * 说明：递归方式来构建完全二叉树
	 * @author 徐磊
	 * @time：2018年6月9日 下午10:38:23
	 */
	public BNode createCompleteBinaryTree(int[] arr,int i){
		
		BNode p=null;
		//这里是可以获取到最后一个下标的
		if(i<arr.length){
			p=new BNode(arr[i],null,null);
			p.leftNode=createCompleteBinaryTree(arr, 2*i+1);
			p.rightNode=createCompleteBinaryTree(arr, 2*1+2);
			
		}
		return p;
		
	}

}
