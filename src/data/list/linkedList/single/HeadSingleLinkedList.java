package cn.data.list.linkedList.single;

import javax.security.sasl.SaslServer;

import org.omg.CORBA.PUBLIC_MEMBER;

import cn.data.list.linkedList.ILinkedList;

/**
 * 说明：实现带有头节点的单链表
 * 
 * @author 徐磊
 * @version 1.0
 * @date 2017年10月17日 下午9:23:06
 * @param <T>
 */
public class HeadSingleLinkedList<T> implements ILinkedList<T> {

	// 带有头节点的单链表，第二个节点才是开始节点

	private Node<T> nodeHead;

	public HeadSingleLinkedList() {
		this.nodeHead = new Node<T>(null);
		
		//初始化这个链表，只有第一个节点为null的时候，它才是null
		this.nodeHead.next=null;
	}

	@Override
	public boolean isEmpty() {
		return this.nodeHead.next == null;
	}

	@Override
	public int length() {

		int length = 0;
		Node<T> currentNode = nodeHead.next;

		while (currentNode != null) {
			length++;
			// currentNode不为null，但是。next可能是为null，因为它是最后一位。
			currentNode = currentNode.next;
		}

		return length++;
	}

	/**
	 * 根据index索引获取值
	 * @param index 下标值起始值为0
	 * @return
	 */
	@Override
	public T get(int index) {

		if (index > 0 && this.nodeHead.next != null) {

			Node<T> currentNode = this.nodeHead.next;

			int count = 0;

			while (count < index && currentNode != null) {

				currentNode = currentNode.next;
				count++;
			}
			if (currentNode != null) {
				return currentNode.data;
			}
		}
		return null;
	}

	/**
	 * 根据索引替换对应结点的data
	 * 
	 * @param index
	 *            下标从0开始
	 * @param data
	 * @return 返回旧值
	 */
	@Override
	public T set(int index, T data) {

		if (index > 0 && this.nodeHead != null && data != null) {

			Node<T> currentNode = this.nodeHead.next;

			int count = 0;
			//获取index对应的数据。
			while (count < index && currentNode != null) {
				currentNode = currentNode.next;
				count++;
			}

			if (currentNode != null) {

				T oldValue = currentNode.data;

				currentNode.data = data;

				return oldValue;
			}
		}
		return null;
	}
	
	
	
	/**
	 * 根据下标添加结点
	 * 
	 * @param index
	 *            下标值从0开始
	 * @param data
	 * @return
	 */
	@Override
	public boolean add(int index, T data) {

		if (data == null && index < 0) {
			return false;
		}
		
			Node<T> currentNode = this.nodeHead;
			
			int count = 0;
			
			while (count < index && currentNode.next!= null) {
				
				currentNode = currentNode.next;
				count++;
			}
			Node<T> node=new Node<T>(data, currentNode.next);
			currentNode.setNext(node);

		return true;
	}
	/**
	 * 默认尾部插入
	 * @param index
	 *            下标值从0开始
	 * @param data
	 * @return
	 */
	@Override
	public boolean add(T data) {
		return add(Integer.MAX_VALUE, data);
	}

	@Override
	public T remove(int index) {

		if (index > 0 && this.nodeHead != null) {

			int count = 0;
			Node<T> current = this.nodeHead.next;
			//最后得到的结果其实就是对应索引所对应的数据，并不是前面一位。
			while (count < index && current != null) {

				current = current.next;
				count++;
			}

			if (current != null) {
				T oldValue = current.data;

				current.next = current.next.next;

				return oldValue;
			}
		}
		return null;
	}

	@Override
	public boolean removeAll(T data) {

		boolean flag = false;

		if (data != null && this.nodeHead != null) {

			Node pre = this.nodeHead;
			Node current = this.nodeHead.next;

			while (current != null) {

				// 第一次遍历的时候如果满足，就删除
				// 如果不满足，那么第一个和第二个就顺延
				if (data.equals(current.data)) {

					pre.next = current.next;
					current = pre.next;
					flag = true;
				} else {
					pre = current;
					current = current.next;
				}
			}
		}
		return flag;
	}

	@Override
	public void clear() {

		this.nodeHead.next = null;

	}

	@Override
	public boolean contains(T data) {
		if (data != null && this.nodeHead != null) {

			Node current = this.nodeHead.next;

			while (current != null) {

				if (data.equals(current.data)) {

					return true;
				}
				current = current.next;
			}
		}
		return false;
	}

	public String toString() {

		String str = "(";

		if (this.nodeHead != null) {

			Node<T> current = this.nodeHead.next;

			while (current != null) {

				str += current.data ;
				current = current.next;
				
				if (current!=null) {
					str+=",";
				}
			}
		}
		return str+ ")";
	}
	
	/**
	 * 反转链表
	 * 从头到尾遍历链表，每遍历一个，就放到新链表的最前端，
	 * @param data
	 */
	
	public Node reverse(HeadSingleLinkedList ss){
		
		
		if (ss!=null) {
			//第一个数据节点
			Node pre=this.nodeHead.next;
			//第二个数据节点
			Node current=pre.next;
			//临时节点
			Node<T> temp=null;
			
			while (current!=null) {
				
				//第三个节点
				temp=current.next;
				
				current.setNext(pre);
				
				pre=current;
				
				current=temp;
			}
			//把最开始的第一个节点的next指向null。因为从一开始，这个第一个节点和第二个节点之间就没有断过。
			//第一个节点成为了第二个节点的下属节点
			//但同时，第二个节点还是第一个节点的下属节点
			this.nodeHead.next.setNext(null);
			
			return pre;
		}
		return null;
	}
	
	
	
	public HeadSingleLinkedList(T[] data) {
		
		//此时必须初始化，要不然会报null，因为this.nodeHead本身就是null。同时只有this.nodeHead.next是null的情况下，链表才是null
		this();
		
		if (data != null && data.length > 0) {
			int count = 1;
			
			this.nodeHead.next=new Node<T>(data[0]);
			
			Node<T> current=this.nodeHead.next;
			
			while (count< data.length) {
				
				current.next=new Node<T>(data[count++]);
				current=current.next;
			}
		}
	}
	
	//先成环再断环的过程.使用3个指针遍历单链表，逐个链接点进行反转。
	public Node<T> reverse2(HeadSingleLinkedList ss){
		
		if (nodeHead.next!=null) {
			Node<T> pre=this.nodeHead.next;
			Node<T> current=pre.next;
			Node<T> temp=null;
			//自动断掉与第二个节点的链接
			nodeHead.next.next=null;
			
			while (current!=null) {
				//指向后面的环
				temp=current.next;
				//自动断掉与后面temp的连接，自动断掉这个环
				current.next=pre;
				//再次连上这个环
				pre=current;
				current=temp;
			}
			this.nodeHead.next=pre;
			return pre;
		}
		return nodeHead;
		
	}
	
	
	//从第2个节点到第N个节点，依次逐节点插入到第1个节点(head节点)之后，最后将第一个节点挪到新表的表尾
	public Node<T> reverse3(HeadSingleLinkedList ss){
	
		
		
		
		
		return null;
	}
	
	
	
	

	public static void main(String[] args) {

		String[] letters = { "A", "B", "C", "D", "E", "F" };

		HeadSingleLinkedList<String> ss = new HeadSingleLinkedList<>(letters);
		System.out.println(ss.toString());
		
//		Node newNode = ss.reverse(ss);
//		String str="(";
//    	while (newNode!=null) {
//			
//    		str+=newNode.data;
//    		
//    		newNode=newNode.next;
//    		
//    		if (newNode!=null) {
//				str+=",";
//			}
//		}
//    	
//    	System.out.println(str+")");
		 ss.reverse2(ss);
		System.out.println(ss.toString());
		
//
//		System.out.println(ss.add("B"));
//		System.out.println(ss.toString());
//
//		System.out.println(ss.removeAll("B"));
//		System.out.println(ss.toString());
		
//		HeadSingleLinkedList<String> ss = new HeadSingleLinkedList<>();
//		
//		ss.add("A");
//		ss.add("B");
//		ss.add("C");
//		ss.add("D");
//		ss.add("D");
		
//		System.out.println(ss.set(1, "M"));
//		
//		System.out.println(ss.toString());
//		
//		ss.removeAll("D");
//		System.out.println(ss.toString());
//		
//		System.out.println(ss.get(2));
		

	}
}
