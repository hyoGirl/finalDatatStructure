package com.tree.binaryTree;

import java.util.Stack;

/**
 * 说明：
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月6日
 */
public class NoRecursionPostOrder {
	
	
//	
//   	   80
//  	 /   \
//	   50     90
//	   / \    /  \
//    30  60  85  95 
	
	
	/*                  左边                        右边
	 * 先序遍历   80--【50--30--60】--【90--85--95】
	 * 				右边	                            左边
	 * 逆后序      80--【90-95-85】--【50-60-30】    
	 * 
	 * 从上面来看，
	 * 
	 * 1：把先序的左右子树里面的左右顺序变化，就可以得到逆后序了。  
	 * 
	 * 2：达到逆后序，然后再次逆转，就可以实现后序  
	 * 
	 * 3：总结，需要两个栈，一个是存储先序变换顺序，
	 * 
	 * 一个是把上一个栈弹出的数据，再次放进去。最后数据是来自这个栈
	 * 
	 * 后序遍历    【30--60--50】--【85--95--90】--80
	 */
	
	/*
	 * 上面的不是这个方法的解释
	 */
	public void post(BNode node){
		
		/**
		 * 后序： 左  右  根
		 * 只需要一个中间栈，保存好根 右 左的顺序就好，然后根据先入后出就能按照   左  -- 右  -- 根  弹出来。
		 * 
		 * 那么就需要另外一个栈，不停的获取左边孩子，然后压入到开始的那个栈。
		 * 
		 * 那么就是先把根压入，然后压入右边孩子，然后判断右边是否为空，空，就继续出。不是，就获取左边。进入。
		 * 
		 * 有点类似中序，先把根压入，左边全部压入。在弹出的过程中，把左边全部访问了，再访问根，再来访问右边。
		 * 
		 * 总结：就是要访问一个节点，就必须先保证右边子树全部访问完毕。右 根 左了。
		 * 
		 * 
		 * 总结：
		 * 
		 * 要实现 左 右 根顺序，可以直接保存为根 右 左。
		 * 一个栈要维持好 根 右 左的顺序，就可以先把根 右放进去，让另一个栈弹出左边元素，左边弹出后，再压入第一个就实现了。
		 * 所以重点在于，另外一个栈要维持 右边  根 左边这样的访问顺序。它不停的加入上一个栈没有的左边元素，就可以了。
		 * 
		 * 
		 * 后序遍历，就是要实现左 右 根。
		 */
		Stack<BNode> stack1=new Stack<BNode>();
		Stack<BNode> stack2=new Stack<BNode>();
			while(stack1.size()>0 || node!=null){
				//先把右边孩子和根全部压入这两个栈中。然后再压入左边孩子。
				//后面会回溯，压入当前层的左边孩子。
				if(node!=null){
					stack2.push(node);
					stack1.push(node);
					node=node.getRightNode();
				}else{
					node=stack1.pop();//这里弹出的是栈顶元素
					node=node.getLeftNode(); //这里获取的是弹出的上一个栈顶元素的左边节点
				}
			}
			//其实打印出来的数据一直是来自最后这个栈
			//而这个栈，一直放进去的都是  右边子树  root 左边子树。
			while(!stack2.isEmpty()){
				System.out.print(stack2.pop().getData()+"-->");
			}
	}
	
	
	/*
	 * 一个栈来实现后序遍历
	 * 
	 * 后序就是  左  右  根
	 * 
	 * 就是说要保证 左边  右边 都访问完毕后，才能去访问根。
	 * 
	 * 1：按照先访问左节点，完毕后，根就出现在栈顶了，但是此时还不能出栈，因为，右边可能还没有访问。
	 * 2：把右边访问完毕后，根又出现在栈顶了，此时才可以退出去。
	 * 
	 * 总结：根在栈顶出现了2次。所以需要一个标志，来表示是否是第一次出现在栈顶
	 * 
	 * 要保证哪一个在前面。那么这一个就必须全部放入栈顶
	 * 
	 */
	public void postOneStack(BNode node){
		
		Stack<BNode> nodeStack=new Stack<BNode>();
		
		if(node==null ){
			return;
		}
		
		while(!nodeStack.isEmpty() || node!=null){
			while(node!=null){
				nodeStack.push(node);
				node.isFirst=true;
				node=node.getLeftNode();
			}
			if(!nodeStack.isEmpty()){
				BNode pop = nodeStack.pop();
				if(pop.isFirst==true){
					pop.isFirst=false;
					nodeStack.push(pop);
					node=pop.getRightNode();
				}else{
					pop.display();
				}
			}
		}
	}
	
	/*
	 * 判断左子树是不是空，不空就放入栈。
	 * 
	 * 空，就出去，此时栈顶就剩下根。此时修改根的标志，将从左边弹出来的修改为右边。
	 * 
	 * 判断右边空不空，不空就压入，
	 * 
	 * 空，就看栈空不空，栈不空，就把栈顶元素弹出去。
	 * 
	 * 左边不是空，那么就看栈是不是空，栈不是，就出栈。
	 * 
	 * 
	 */
}
