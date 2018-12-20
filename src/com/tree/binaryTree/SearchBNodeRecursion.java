/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：递归查找结点
 * @author 徐磊
 * @version 1.0
 * @date 2018年5月31日
 */
public class SearchBNodeRecursion {
	
	
	public BNode serach(BNode node,int data){
		
		if(node==null){
			return null;
		}
		
		if(((Integer)node.getData())==data){
			return node;
		}
		
		
//		else{
//			//剪枝操作，当左边不行的时候，才去找右边
//			if(serach(node.getLeftNode(),data)==null){
//				return serach(node.getRightNode(),data);
//			}
//			
//			return node;
//		}
		BNode search = serach(node.getLeftNode(),data);
		
		if(search!=null){
			return search;
		}else{
			return serach(node.getRightNode(),data);
		}
	}
}
