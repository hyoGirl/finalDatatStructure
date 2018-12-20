/**
 * 
 */
package com.tree.binaryTree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 说明：寻找二叉树的宽度。具有节点数目最多的那一层
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月3日
 */
public class BinaryTreeWidth {
	
	/**
	 * 1:对于非空树。根所在的层为第一层，如果知道了当前节点的层号，就能推算出左右孩子的层号。
	 * 
	 * 即为当前节点的层号+1;从而获取所有测层号
	 * 
	 * 2：在层序遍历中，使用了循环队列来表示，如果存储队列的数组足够长，能够存储下所有的节点
	 * 
	 * 那么就会导致对头(尾)指针可以一直往后增加。不会再折返。
	 * 
	 * font=(font+1)%maxSize 就会变化成 font=(font+1);队尾也是一样的。
	 * 
	 * 出队操作，就不会去删除元素，而是简单的增加font
	 * 
	 * 
	 * 解决方法：
	 * 
	 * 1：取消使用循环队列，使用非循环队列，容量无限大
	 * 2：从第一点中获取所有的队列节点的层号
	 *    从第二点中知道访问的节点最终保存在数组中，修改层次遍历的算法模型，在其中添加了求层号的操作。
	 *    
	 *    在遍历结束后，数组中记录了树中所有节点的层号信息，从而求出包含节点最多的层上的节点数目。
	 * 
	 */
	
	/**
	 * 说明：获取二叉树的最大宽度
	 * @param node
	 * @return
	 * @author 徐磊
	 * @time：2018年6月3日 下午3:11:40
	 */
	public int getMaxWidth(BNode node){
		
		if(node==null){
			return 0;
		}
		/*
		Deque 接口的大小可变数组的实现。数组双端队列没有容量限制；它们可根据需要增加以支持使用。它们不是线程安全的；
		在没有外部同步时，它们不支持多个线程的并发访问。禁止 null 元素。此类很可能在用作堆栈时快于 Stack，在用作队列时快于 LinkedList。 
		
		*/
		Queue<BNode> queue=new ArrayDeque<BNode>();
		
//		使用队列，层次遍历二叉树。
//		在上一层遍历完成后，下一层的所有节点已经放到队列中，此时队列中的元素个数就是下一层的宽度。以此类推，依次遍历下一层即可求出二叉树的最大宽度。
		int maxWidth=1;
		
		queue.add(node); //入队
		
		while(true){
			int len=queue.size();  // 当前层的节点个数 
			
			/**
			 * 一开始 len=1.因为队列里只有root。
			 * 后来队头弹出去了，所以len=0；
			 * 
			 * 
			 * 但是再弹出去的过程中，又增加了新的元素，注意：此时的len没有变大，还是保持这原来的数目。
			 * 只要len>0 它就会一直从队头弹出元素。
			 * 
			 * 当它为0的时候，就说明了上一层元素都弹出去了(因为它一直保存着上一层的最大数目)，此时把它赋值为最大值。也就是第二层的两个节点。len=2
			 * 
			 * 在第三层的4个还没有完全进来的时候，len里面一直保存着上一层的最大节点数目。
			 * 
			 * 但len==0的时候，上一层就已经全部弹完了。
			 * 但是有一点很重要。只有当len为0的时候，我们才开始把len变化为队列里的元素数目的最大值
			 *   
			 */
			
			
			if(len==0){
				break;
			}
			while(len > 0){  // 如果当前层，还有节点
				
				
				/**
				 * 由于队列是先进先出的，所以每次都会把上一层还没来得及丢出的元素给弹出去。
				 * 当len为0的时候。
				 */
				BNode temp = queue.poll();
				
				len--;
				
				if(temp.getLeftNode()!=null){  // 下一层节点入队
					
					queue.add(temp.getLeftNode());
				}
				if(temp.getRightNode()!=null){  // 下一层节点入队
					queue.add(temp.getRightNode());
				}
				
				maxWidth = Math.max(maxWidth, queue.size());
			}
		}
		return maxWidth;
	}
	
	
	/**
	 * 说明：自己整理的二叉树的最大宽度
	 * @param node
	 * @return
	 * @author 徐磊
	 * @time：2018年6月3日 下午3:29:02
	 */
	public int getMaxWidth_my(BNode node){
		
		if(node==null){
			return 0;
		}
		Queue<BNode> queue=new ArrayDeque<BNode>();
		
		queue.add(node);
		
		int width=1;
		
		while(true){
			
			int len =queue.size();
			
			if(len==0){
				break;
			}
			
			while(len > 0){
				BNode temp = queue.poll();
				
				len--;
				
				if(temp.getLeftNode()!=null){
					
					queue.add(temp.getLeftNode());
				}
				if(temp.getRightNode()!=null){
					queue.add(temp.getRightNode());
				}
				width=Math.max(width, queue.size());
			}
		}
		return width;
	}
	
	
	
	/**
	 * 说明：获取每一层的宽度。保存当前层的len就可以了。
	 * @return
	 * @author 徐磊
	 * @time：2018年6月3日 下午3:28:49
	 */
	public Map<Integer,Object> getEveryLevelWidth(BNode node){
		
		if(node==null){
			return null;
		}
		Queue<BNode> queue=new ArrayDeque<BNode>();
		
		queue.add(node);
		
		//第一层
		int level=0;
		
		Map<Integer,Object> result=new HashMap<Integer,Object>();
		while(true){
			int len=queue.size();
			if(len==0){
				break;
			}
			level++;
			//map里面保存了每一层的层数和每一层的最大宽度，也就是节点数目
			result.put(level, len);
			while(len >0){
				
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
		return result;
	}
}
