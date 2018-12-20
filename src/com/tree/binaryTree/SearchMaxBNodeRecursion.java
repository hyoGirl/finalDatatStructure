/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：查找二叉树的最大节点
 * @author 徐磊
 * @version 1.0
 * @date 2018年5月31日
 */
public class SearchMaxBNodeRecursion {
	
//	
//	     1
//	   /   \
//	 -5     2
//	 / \   /  \
//	0  3 -4  -5 
	
	/**
	 * 
	 * 说明：递归查找，返回左右子树的最大值
	 * 
	 * 每当换一个节点的时候，这个节点就是一个根。
	 * 对当前这个节点进行左子树操作完毕后，开始操作右子树。
	 * 最后得到的结果其实是当前这个节点的上一个节点的左边子树结果。
	 * 
	 * 
	 * 所以这类题目就可以抽象为3个节点。
	 * 
	 *      A
	 *     B  C
	 *     
	 *  先去获取B的值，与A的值进行比较，  取最大的值给A。
	 *  再去获取C的值，与A的值进行比较。 取最大的值给A。
	 *  
	 *  为啥？因为A只是上一层左边的结果，还要继续比较下去。
	 *  此时这个A不是代表了整个小团体的根节点，只是代表了整个小团体中的最大值而已。
	 */
	public BNode searchMax(BNode node){
		
		if(node==null){
			return null;
		}else{
			
			BNode left=node;
			BNode right=node;
			
			
			//判断它是不是为null，就是为了再次去开启一个小团体，在这个小团体中再去找最大值
			
			//当它没有了左子树的时候，它就开始找自己的右子树，(假如该右子树下面没有了)。对比大小值，赋值，然后开启回溯。
			
			//去找它的上级了。
			if(node.getLeftNode()!=null){
				left=searchMax(node.getLeftNode());
			}
			if(node.getRightNode()!=null){
				right=searchMax(node.getRightNode());
			}
			
			if(((Integer)left.getData())>((Integer)node.getData())){
				node.setData(((Integer)left.getData()));
			}
			if(((Integer)right.getData())>((Integer)node.getData())){
				node.setData(((Integer)right.getData()));
			}
			
			return node;
		}
	}
}
