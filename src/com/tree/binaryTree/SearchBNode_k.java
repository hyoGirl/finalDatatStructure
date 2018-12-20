/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：先序遍历，查找第K个节点
 * @author 徐磊
 * @version 1.0
 * @date 2018年5月30日
 */
public class SearchBNode_k {
	/**
	 * 1:因为是递归执行，所以这个n是在最外层
	 * 2：因为每次换一个节点来遍历。这个节点就立刻由原来的角色变成了根节点
	 * 这样看来，就是每次都是根节点在输出，所以题目就转换为了
	 * 遍历时，查找第几个根节点的问题了。
	 * 
	 */
	int n=0;
	public void search_K(BNode node ,int k){
		if(node!=null){
			++n;
			if(k==n){
				System.out.println(node.getData());
				return ;
			}
			search_K(node.getLeftNode(), k);
			search_K(node.getRightNode(), k);
		}
	}
}
