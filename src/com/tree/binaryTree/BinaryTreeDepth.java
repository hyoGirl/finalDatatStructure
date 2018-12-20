/**
 * 
 */
package com.tree.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 说明：查找二叉树的深度
 * @author 徐磊
 * @version 1.0
 * @date 2018年5月31日
 */
public class BinaryTreeDepth {
/*	
	    30
	  /   \
	22     35
	/ \     \
   20   28    48 
	\
     15
	
*/	
	
	
	/**
	 * 
	 * 其实思路就是 有一层就加1  最开始就是0
	 * 
	 * 二叉树的深度就是左右子树深度的最大值+1
	 * 
	 * 要记住，每当换一个节点来考虑的时候，这个节点就是临时根节点
	 * 
	 * 递归来讨论：
	 * 1：程序运行时先走完获取左子树，然后再开始运行获取右子树。
	 * 2：当第一次走到左子树的时候20，发现是null了，返回的是0
	 * 于是开始走当前节点(该节点的下一个节点是null) 20 的右子树 15。
	 * 接着走15，发现15的右子树为null，于是也返回了0.
	 * 
	 * 最后结果就是返回了1.  
	 * 
	 * 这样就是针对20这个节点走完了。
	 * 
	 * 回溯到22上，
	 * 
	 * 此时 leftDepth=1；
	 * 
	 * 开始走22的右子树了。
	 *  22--28  --null  返回0；
	 *  
	 *  对比，返回了2.
	 *  
	 *  递归，其实就是指当前节点如果走完了，就开始在这一层范围内走另外一方，但是最终结果却只是一层。这层完毕后
	 *  把这一层的结果当作该层的上一层的一个方面的结果来处理，同时开始上一层的另外一方面。
	 * 
	 */
	public int getDepth(BNode node){
		
		if(node==null){
			return 0;
		}
		
		int leftDepth=getDepth(node.getLeftNode());
		
		int rightDepth=getDepth(node.getRightNode());
		
		return (leftDepth>rightDepth?leftDepth:rightDepth)+1;
		
		//return leftDepth+rightDepth;
		
	}
	
	
	/**
	 * 说明：使用层序遍历来获取二叉树深度
	 * @param node
	 * @return
	 * @author 徐磊
	 * @time：2018年6月3日 下午3:59:48
	 */
	public int getDepth_my(BNode node){
		
		Queue<BNode> queue=new ArrayDeque<>();
		if(node==null){
			return 0;
		}
		
		queue.add(node);
		int level=0;
		
		while(true){
			int len=queue.size();
			if(len==0){
				break;
			}
			level++;
			while(len>0){
				BNode temp = queue.poll();
				len--;
				if(temp.getLeftNode()!=null){
					queue.add(temp.getLeftNode());
				}
				if(temp.getRightNode()!=null){
					queue.add(temp.getRightNode());
				}
			}
		}
		return level;
	}
}
