/**
 * 
 */
package com.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.queue.array.SequenceQueue;

/**
 * 说明：层序遍历
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月3日
 */
public class LevelSearch {
		
	/*
	 * 层序遍历，就是从根节点来遍历完第一层
	 * 然后从第二层再次遍历。
	 * 需要满足先遍历的，先出来，所以可以使用循环队列来实现。
	 */
	public void level(BNode node){
		//LinkedList是list的实现类，同时也是queue的实现类
		Queue<BNode> queue=new LinkedList<BNode>();
		
		if(node==null){
			return;
		}
		queue.add(node);
		while(!queue.isEmpty()){
			BNode temp=queue.poll();
			System.out.print(temp.getData()+"--");
			if(temp.getLeftNode()!=null){
				queue.add(temp.getLeftNode());
			}
			if(temp.getRightNode()!=null){
				queue.add(temp.getRightNode());
			}
		}
	}
	
	
	public void levelMyQueue(BNode node){
		
		SequenceQueue<BNode> sequenceQueue=new SequenceQueue<BNode>();
		
		if(node==null){
			return ;
		}
		
		sequenceQueue.add(node);
		
		while(!sequenceQueue.isEmpty()){
			
			BNode temp = sequenceQueue.pop();
			
			System.out.print(temp.getData()+"->");
			
			if(temp.getLeftNode()!=null){
				sequenceQueue.add(temp.getLeftNode());
			}
			if(temp.getRightNode()!=null){
				sequenceQueue.add(temp.getRightNode());
			}
		}
		
	}
}
