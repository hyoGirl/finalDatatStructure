/**
 * 
 */
package com.tree.binaryTree;

/**
 * 说明：根据先序和中序来构建二叉树
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月12日
 */
public class ReConstructBinaryTreeforPreAndIn {
	
	/*
	 * 1:先序顺序
	 * 2：中序顺序
	 * 3：先序遍历的起点
	 * 4：中序遍历的起点
	 * 5：节点数目
	 */
	
	/*
	   	前序遍历第一位是根节点； 
		中序遍历中，根节点左边的是根节点的左子树，右边是根节点的右子树。
		
		例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}。
		
		首先，根节点 是{ 1 }； 
		左子树是：前序{ 2,4,7 } ，中序{ 4,7,2 }； 
		右子树是：前序{ 3,5,6,8 } ，中序{ 5,3,8,6 }；
		
		这时，如果我们把左子树和右子树分别作为新的二叉树，则可以求出其根节点，左子树和右子树。
		
		这样，一直用这个方式，就可以实现重建二叉树。
	 */
	public BNode reConstruct(String preOrder,String inOrder,int preIndex,int inIndex, int count){
		
		BNode root=null;
		if(count>0){
		//第一个节点永远是先序的第一位
		char data=preOrder.charAt(preIndex);
		int k=0;
		//求出中序遍历的根节点的位置。
//		while(inOrder.charAt(k)!=data){
//			k++;
//		}
//		//递归退出的条件?
		for(;k<count;k++){
			if(data==inOrder.charAt(k+inIndex)){
				break;
			}
//			if(data==inOrder.charAt(k)){
//				break;
//			}
		}
		
		root=new BNode(data);
		//左边先序，从第二位开始，左边中序，从0开始   数据量，就是中序中根所在的坐标值
		root.leftNode=reConstruct(preOrder, inOrder, preIndex+1,inIndex,k);
		//右边先序 开始位置 自己计算     右边中序，也是从中序中根节点的位置后面一位开始
		root.rightNode=reConstruct(preOrder, inOrder, preIndex+k+1, inIndex+k+1, count-k-1);
		
		}
		return root;
		
	}
	
	public BNode rc(String preOrder, String inOrder ,int preIndex,int inIndex,int count){ 
		
		 BNode root =null;
        if(count>0){  
            char data = preOrder.charAt(preIndex);  
            int i = 0;  
            for( ; i<count; i++){  
                if(data == inOrder.charAt(i+inIndex))  
                    break;  
            }  
            root = new BNode(data);  
            root.leftNode = rc(preOrder,inOrder,preIndex +1,inIndex,i);  
            root.rightNode = rc(preOrder,inOrder,preIndex + i + 1,inIndex + i + 1,count - i - 1);  
        }  
        
        return root;
    }  
	
	
	public void preOrderRecursion(BNode node){
		
		if(node!=null){
			node.display();
			preOrderRecursion(node.getLeftNode());
			preOrderRecursion(node.getRightNode());
		}
		
	}
	
	public static void main(String[] args) {
		
		ReConstructBinaryTreeforPreAndIn rc=new ReConstructBinaryTreeforPreAndIn();
		
		
		String perOrder = "ABDHECFG";
		String inOrder = "HDBEAFCG";  
		
		BNode rcnode = rc.reConstruct(perOrder, inOrder, 0, 0, 8);
//		BNode rcnode = rc.rc(perOrder, inOrder, 0, 0, 8);
		
		
		
		rc.preOrderRecursion(rcnode);
		
	}

}
