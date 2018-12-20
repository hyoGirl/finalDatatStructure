/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：中序遍历，查找第K个节点
 * @author 徐磊
 * @version 1.0
 * @date 2018年5月30日
 */
public class InOrderSearchBNode_K {
	
	int n=0;
	public void search_k(BNode node,int k){
		/**
		 * 1：每遍历一个节点，这个节点就是根
		 * 2：通过判断k与n的大小，得到当前为根的节点是多少。
		 */
		if(node!=null){
			search_k(node.getLeftNode(), k);
			++n;
			if(k==n){
				System.out.println("中序遍历的第   "+k+" 个数据是： "+node.getData());
			}
			search_k(node.getRightNode(), k);
			
		}
	}
}
