package cn.data.list.linkedList.single;

/**
 * 说明：单向链表节点，不含有独立头节点，不含有尾部指针
 * @author 徐磊
 * @version 1.0
 * @date 2017年10月16日 下午9:42:31
 */
public class Node<T> {
	
	//存放数据元素的数据域
	public T data;
	
	//存放后继节点指针地址的指针域
	public Node<T> next;
	
	public Node(){
		
	}
	
	public Node(T data){
		
		this.data=data;
		
	}
	public Node(T data,Node<T> next){
		
		this.data=data;
		this.next=next;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
	
}
