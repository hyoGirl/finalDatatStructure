/**
 * 
 */
package com.tree.binaryTree;

import java.util.Stack;

/**
 * 说明：中序遍历，非递归
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月5日
 */


//每次思考，就只思考3个节点。其余不管。因为都是这3个节点在重复
public class NoRecursionInOrder {
	
	//中序遍历 就是左 --> 根 --> 右
	//栈 就是先进后出的,这里不是一直往里面添加的，还是要判断下大致顺序
	//每一个节点都当作根节点来考虑。
	/*
	 * 再放入的过程中，如果是root的右边节点先放入，那么会出现问题。
	 * 
	 * 因为二叉树有点特性，每一个节点都是根节点，如果你首先放入了原始根节点的右边节点，
	 * 
	 * 那么在左边节点来看，每一个节点都是一棵树，左边节点的这颗树的右边节点和root的右边节点，到底哪个才是应该最先放入的右边节点尼？
	 * 
	 * 就算你要左 根 右  也是在左边这个整体树上来完成左 根 右。
	 * 
	 * 
	 * 所以还是要按照root的左边节点来全部进入，但是又要满足左 -- 根 --右。。由于每一个节点都可以看出是一个根节点，所以
	 * 
	 * 
	 * 当这个根节点放入栈中，继续放入左边，如果没有左边节点了，就弹出来，同时把根弹出来。然后判断是否有右边节点，如果有继续放进去。此时放入的右边节点有事一个根了。循环开启。
	 * 
	 * 如果每一个根节点有左边节点，而要满足左--根，同时还是栈，所以就是先放入自己，再放入左边。
	 * 
	 * 
	 * 总结：先放入根，然后判断是否有左边，有左边就放入，此时左边变成了根。那么继续。
	 * 如果该层左边没有了，就回溯到当前遍历的这一层，就弹出自己，并且还把当前层的根弹出去。再来开始考虑是否有右边。
	 * 
	 * 
	 * 最终：如果栈顶节点的左边孩子存在，就入栈。如果左边孩子没有了，就出栈，同时输出栈顶元素，接着判断栈顶右边是否存在，如果存在就入栈。
	 * 
	 * 
	 * 如果栈顶元素存在左边孩子，就入栈。如果没有，就出栈，此时出的是栈顶，结束后，如果有右边孩子，就入栈，没有就出栈。
	 */
	public void inOrder(BNode node){
		
			Stack<BNode> nodeStack=new Stack<BNode>();
			
			//这里是个或循环，主要是为了满足当前栈不是空，但是当前节点的右边节点是null。此时必须把这个当前节点弹出去。
			while(!nodeStack.isEmpty()|| node!=null){
				//这里判断为null。是为了确定这个节点是不是没有左节点了，如果没有，就直接是根，就可以弹出去了。
				while(node!=null){
					nodeStack.push(node);
					//此时开启放入根的整体左边节点。在这个左边节点上来实现左 根 右
					node = node.getLeftNode();
				}
				if(!nodeStack.isEmpty()){
					//当上面的node是null的时候，就标识着当前的节点是一个小团体中的根了。因为没有左边节点了，那么首先就会弹出这个根。
					//而这个根其实只是上一层的左边子树，弹出了这个左子树后，此时栈顶就是它上一层的根了。
					//如果当前这个节点没有右子树，那么就node==null，就继续弹出栈顶元素。所以上面才是或运算，如果是与，就无法弹出去。
					//如果当前节点有右边子树，那么栈顶元素被压下去了。而当前节点的右子树成为了根。
					//总结：关于右子树，不需要判断是否是null才去获取，而是不管有没有，都转化为右边。
					//如果你判断了，那么node永远不是null。那么栈顶根就跑不出去了。
					node = nodeStack.pop();
					System.out.println(node.getData()+"--");
					node=node.getRightNode();
				}
			}
	}
	
	
	
	
	public void inorder(BNode node){
		
			Stack<BNode> nodeStack=new Stack<BNode>();
			//这里并不是与 而是或。原因：假如是与，当右子树是null的时候，栈顶还有个元素没有出来。就是根节点没有出来。
			while(!nodeStack.isEmpty()||node!=null){
				
				while(node!=null){
					//只要压入，就是根了。
					nodeStack.push(node);
					
					node=node.getLeftNode();
				}
				
				if(!nodeStack.isEmpty()){
					node=nodeStack.pop();
					System.out.print(node.getData()+"-->");
					//这里有可能为null，也有可能不是null，但是都必须去获取右边子树。所以不需要判断。
					node=node.getRightNode();
				}
				
			}
		
	}
	
	/*
	 * 根节点入栈，左入栈，
	 * 
	 * 左节点空不空，不空，不空就入栈。
	 * 
	 * 空，左就出去，
	 * 
	 * 出去后，右边空不空，不空就入栈。就变成了根。
	 * 
	 * 如果右边是空，就看栈空不空，栈不空就把栈顶元素出栈。
	 * 
	 * 然后继续循环
	 * 
	 * 直到根节点的所有左边节点完毕，
	 */
	public void in(BNode node){
		if(node==null){
			return ;
		}
		/*
		 * 先访问了左边，再访问根，再访问右边
		 * 所以，先根入，然后左边入，然后左边出来，右边再入
		 */
		Stack<BNode> nodeStack=new Stack<BNode>();
		while(!nodeStack.isEmpty() || node!=null){
			//先根入栈左边入栈顶。
			while(node!=null){
				nodeStack.push(node);
				node=node.getLeftNode();
			}
			if(!nodeStack.isEmpty()){
				node= nodeStack.pop();
				node.display();
				/*
				 * 
				 * 如果这里添加了判断，那么右边节点node就一直不是null，
				 * 但是如果node不是null，就会把node再次压入，
				 * 
				 * 但是如果node是null尼。此时由于是在这个if里面
				 * 所以node是获取不到右边节点，就是说node不能转换为右边节点，导致再次把node压入。死循环了。
				 * 
				 * 
				 * 所以如果要判断是不是为空，其实可以在上面的第二个while里面判断。
				if(node.getRightNode()!=null){
					node=node.getRightNode();
					if(node!=null){
						nodeStack.push(node);
					}
				}
				*/
				node=node.getRightNode();
				
			}
			
			
		}
	}
	
	
	
	
	/*
	 * 要先访问哪一边节点，就必须先把这一边的节点全部压栈，这样就可以不停的先弹出它，然后再出根，然后再次压入另外一边，再弹出。
	 * 
	 * 一定保证左遍历完毕
	 * 
	 * 要想访问一个节点，一定要保证左边子树访问完成，
	 * 
	 * 要想保证左边子树访问完成，一定要保证，只要这个节点的左子树不空就一定把左边子树全部入栈。
	 * 
	 * 只有左边子树为空了，就可以出栈，去访问。才轮到任何一个节点的访问。
	 * 
	 * 访问完成节点后，就要看这个节点的右子树空不空。如果右边不空，就在右边继续二叉树中序。
	 */
	
	
	
	
	
	
	
	
	
	
}
