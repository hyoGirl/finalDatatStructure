
package com.tree.binaryTree;

import java.util.Stack;

/**
 * 说明：
 * @author 徐磊
 * @version 1.0
 * @date 2018年5月22日
 */
public class MyBinaryTree {
	// 根
	private BNode root;
	
	
	/**
	 * 说明：插入数据，从根开始查找要插入节点的父结点，父结点找到后，根据值来决定插入到哪一个位置
	 * @param data
	 * @author 徐磊
	 * @time：2018年5月22日 下午10:40:47
	 */
	public void insert(int data){
		
		BNode newNode=new BNode(data);
		/**
		 * 1：先判断根节点是否存在
		 * 2：在根节点存在的情形下，与根节点相比，判断大小来循环插入
		 */
		
		if(root==null){
			root=newNode;
		}else{
			BNode current=root;
			BNode parent;
			while(true){
				parent=current;
				/**
				 * 通过判断如果小于上级节点，就把新结点放置在左边。
				 * 通过判断如果大于，就去判断下面的else。就把新结点放置右边
				 */
				if(((Integer)data)<((Integer)current.getData())){
					current=current.getLeftNode();
					/**
					 * 如果获取的左节点为空，而这个左节点又是当前节点了。
					 * 
					 * 重点：  需要再用一个节点来时刻保持当前节点的上一个节点
					 * 
					 * 所以需要保持对上级结点的引用。然后设置当前节点(要添加进去的节点)为上级节点的左结点。
					 */
					if(current==null){
						parent.setLeftNode(newNode);
						return;
					}
				}else{
					current=current.getRightNode();
					if(current==null){
						parent.setRightNode(newNode);
						return;
					}
				}
			}
		}
	}
	/**
	 * 	
	 * 说明：从根开始查找，如果查找结点比父节点要小，就查找左子树，否则就是查找右子树，直到null为止
	 * @return
	 * @author 徐磊
	 * @time：2018年5月23日 下午9:12:57
	 */
	public BNode searchNode(int data){
		if(root==null){
			return null;
		}
		BNode current=root;
		while(((Integer)current.getData())!=data){
			if(data<((Integer)current.getData())){
				current=current.getLeftNode();
			}else{
				current=current.getRightNode();
			}
			if(current==null){
				return null;
			}
		}
		return current;
		
	}
	
	
	
	int n=0;
	public void search_K(BNode node ,int k){
		if(node!=null){
			++n;
			if(k==n){
				System.out.println("先序遍历的第   "+k+" 个数据是： "+node.getData());
				return ;
			}
			search_K(node.getLeftNode(), k);
			search_K(node.getRightNode(), k);
		}
	}
	
	/**
	 * 
	 * 说明：先序遍历---递归
	 * @param node
	 * @author 徐磊
	 * @time：2018年5月22日 下午11:13:58
	 */
	public void preOrderRecursion(BNode node){
		
		if(node!=null){
			node.display();
			preOrderRecursion(node.getLeftNode());
			preOrderRecursion(node.getRightNode());
		}
		
	}
	
	/**
	 * 
	 * 说明：中序遍历--递归
	 * @param node
	 * @author 徐磊
	 * @time：2018年5月23日 下午10:16:52
	 */
	public void inOrderRecursion(BNode node){
		
		if(node!=null){
			inOrderRecursion(node.getLeftNode());
			node.display();
			inOrderRecursion(node.getRightNode());
		}
	}
	
	/**
	 * 
	 * 说明：后序遍历--递归
	 * @param node
	 * @author 徐磊
	 * @time：2018年5月23日 下午10:18:55
	 */
	public void postOrderRecursion(BNode node){
		
		if(node!=null){
			postOrderRecursion(node.getLeftNode());
			postOrderRecursion(node.getRightNode());
			node.display();
			
		}
	}
	
	
	/**
	 * 
	 * 说明：先序遍历--非递归
	 * 使用栈来模拟，要实现 根左右的出现，那么就必须是右 左 根的压入才能。先进后出。
	 * 但是根要第一个出来。所以首先把根压入，然后弹出.然后才是右边的压入，左边的压入
	 * 
	 * 然后弹出左边的，此时左边的元素就相当于根了。再继续压入它的右边和左边.
	 * 
	 * 每次都是从栈顶弹出，所以就是根  左 右，要记住一点，每次从栈顶弹出的都是当前节点，而是当前节点的上一个节点
	 * @param node
	 * @author 徐磊
	 * @time：2018年5月23日 下午9:37:02
	 */
	public void preOrder(BNode node){
		
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
	 * 说明：中序遍历--非递归  左边--根--右边
	 * @param node
	 * @author 徐磊
	 * @time：2018年5月23日 下午10:20:46
	 */
	
//	　对于任一结点P，
//
//	  　1)若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前结点P再进行相同的处理；
//
//	 　 2)若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，然后判断栈顶元素是否存在右边节点。有就把右边节点入栈；
//
//	  　3)直到P为NULL并且栈为空则遍历结束。
//	  4)每次从栈顶弹出的不是当前的node，而是上一次压入的数字。
	
	
	
	/*
	 *       1                
	 *    2      4
	 * 3     5 
	 * 
	 * 顺序：先是1进入  内：1
	 * 然后判断1 是否有左孩子，内： 1--2
	 * 
	 * 接着再次判断2是否有左孩子。内：  1--2--3
	 * 
	 * 3没有左孩子了，所以3出去，内：1--2  外：3
	 * 
	 * 现在到2了，2没有了左孩子，2出去，但是2有右边孩子5.于是5进来。内：1--5  外：3--2
	 * 
	 * 
	 * 5什么都没有，所以5出去，到1了。1没有左边了，1也出去，但是1还有4.所以4 进来。内：4  外：3--2--5--1
	 * 
	 * 最后就是 3--2--5--1--4
	 * 
	 * 
	 * 总结：只要当前节点没有左孩子，就弹出去，又右孩子就把它的右边放进来，在此之前，一直放入左边孩子。
	 */
	
	public void inOrder(BNode node){
		
		Stack<BNode> stack = new Stack<>();
        while(node != null || !stack.empty())
        {
            while (node != null){
                stack.push(node);
                node = node.getLeftNode();
            }
            if(!stack.empty()){
            	node = stack.pop();
            	node.display();
            	node = node.getRightNode();
            }
        }
	}
	
	/**
	 * 
	 * 说明：删除节点：1：删除的节点是叶子节点。2：删除的节点只有一个节点。3：删除的节点有两个节点
	 * @author 徐磊
	 * @time：2018年5月24日 下午10:38:19
	 */
	public boolean deleteNode(int data){
		
		//1：先找到要删除的节点
		if(root==null){
			return false;
		}
		//当前节点的引用
		BNode current=root;
		//当前节点的父节点的引用
		BNode parent=root;
		
		//是否为左边节点。因为不知道是从左边找，还是右边找.要删除的节点是左节点还是右节点
		boolean isLeftChild = true;
		
		while(((Integer)current.getData())!=data){
			parent=current;
			if(data>((Integer)current.getData())){
				current=current.rightNode;
				isLeftChild=false;
			}else{
				current=current.leftNode;
				isLeftChild=true;
			}
			
			if(current==null){
				return false;
			}
		}
		
		//删除叶子节点，也就是该节点没有子节点
		if(current.getLeftNode()==null && current.getRightNode()==null ){
			//如果该节点是左边的叶子节点
			if(isLeftChild){
				parent.setLeftNode(null);
			}else if(!isLeftChild){
				parent.setRightNode(null);
			}else{
				root=null;
			}
			//如果当前节点只有右子树,但是当前节点有可能在右边，有可能在左边
			// 例如下面的 10满足只有右子树，但是10是左边节点  25也满足只有右子树，但是25是右边节点
//						  20
//				  12	              25
//			 10        17                    28
//			    11   15  
		}else if(current.getLeftNode()==null){
			if(isLeftChild){   //如果要删除的是10.
				parent.setLeftNode(current.getRightNode());
			}else if(!isLeftChild){  //如果要删除的是25.
				parent.setRightNode(current.getLeftNode());
			}else{  //如果删除的是root 比如20. 那么root就是25了。
				root=current.getRightNode();
			}
		}else if(current.getRightNode()==null){ //如果只有左子树
			
			if(isLeftChild){
				parent.setLeftNode(current.getLeftNode());
			}else if(!isLeftChild){
				parent.setRightNode(current.getRightNode());
			}else{
				root=current.getLeftNode();
			}
		}else{ //如果它有左右子树。
			
		}
		
		
		
		return true;
		
	}
	public BNode getRoot() {
		return root;
	}
}
