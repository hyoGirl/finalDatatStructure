package cn.data.list.linkedList.single;

import cn.data.list.linkedList.ILinkedList;

/**
 * 说明：循环单链表
 * 
 * @author 徐磊
 * @version 1.0
 * @date 2017年10月18日 下午8:35:39
 * @param <T>
 */
public class CircularHeadLinkedList<T> implements ILinkedList<T> {
	
	//不带数据的头节点
	protected Node<T> nodeHead;
	
	//指向尾部的指针
	protected Node<T> tail;
	
	
	/**
	 * 循环单链表的初始化时1：第一个节点保存的地址引用就是头节点
	 * 2：尾部节点的引用也是头节点
	 * 3：头节点一直都是null
	 */
	public CircularHeadLinkedList(){
		//初始化头部指针和尾部节点
		
		this.nodeHead=new Node<T>(null);
		
		this.nodeHead.next=nodeHead;
		
		this.tail=nodeHead;
	}
	
	
	public CircularHeadLinkedList(T[] array){
		
		this();
		if (array!=null && array.length > 0) {
			
			//构建第一个节点
			this.nodeHead.next=new Node<T>(array[0], this.nodeHead);
			int count=1;
			//此时尾指针就是第一个节点了
			tail=this.nodeHead.next;
			while (count<array.length) {
				tail.next=new Node<T>(array[count++]);
				tail.next.next=this.nodeHead;
				//更改尾部指针指向
				tail=tail.next;
			}
		}
	}
	
	@Override
	public boolean isEmpty() {
		return this.nodeHead.next==nodeHead;
	}
	
	
	@Override
	public int length() {
		
		int length=0;
		
		Node<T> node=this.nodeHead.next;
		
		while (node!=nodeHead) {
			
			node=node.next;
			length++;
		}
		return length;
	}
	
	
	/**
	 * 根据index索引获取值
	 * @param index 下标值起始值为0
	 * @return
	 */
	@Override
	public T get(int index) {
		
		if (index > 0 && this.nodeHead.next!=this.nodeHead) {
			
			int count=0;
			
			Node<T> current=this.nodeHead.next;
			
			
			while (current!=this.nodeHead && count < index) {
				current=current.next;
				count++;
			}
			if (current!=null) {
				
				return current.data;
			}
			
		}
		return null;
	}

	@Override
	public T set(int index, T data) {
		
		if (index> 0 && data!=null) {
			Node<T> node=this.nodeHead.next;
			int count=0;
			
			while (node!=nodeHead && count < index) {
				node=node.next;
				count++;
			}
			if (node!=null) {
				T oldValue=node.data;
				node.data=data;
				return oldValue;
			}
		}
		return null;
	}
	

	/**
	 * 说明：添加数据节点
	 * @param index
	 * @param data
	 * @return
	 * @author 徐磊
	 * @time：2017年10月18日 下午9:14:41
	 */
	@Override
	public boolean add(int index, T data) {
		
		if (index > 0 && data!=null) {
			//寻找插入点的位置的前一个结点
			Node<T> node=this.nodeHead;
			
			int count=0;
			while (count < index && node!=null) {
				
				node=node.next;
				count++;
			}
			Node<T> node2=new Node<T>(data, nodeHead.next);
			
			node.setNext(node2);
			
			if (node==tail) {
				this.tail=node2;
			}
			
		}
		return false;
	}

	/**
	 * 说明：默认从尾部添加
	 * @param data
	 * @return
	 * @author 徐磊
	 * @time：2017年10月18日 下午9:10:50
	 */
	@Override
	public boolean add(T data) {
		
		boolean flag=false;
		
		
		if (data!=null) {
			//新增加的节点的后续指针指向的地址就是原来尾部指针指向的地址
			tail.next=new Node<T>(data,tail.next);
			tail=tail.next;
			flag=true;
		}
		return flag;
	}

	@Override
	public T remove(int index) {
		
		if (index > 0) {
			
			Node<T> node=this.nodeHead.next;
			int count=0;
			
			//定位到上一个节点
			while (count < index && node!=nodeHead) {
				node=node.next;
				count++;
			}
			if (node!=nodeHead) {
				
				T oldValue=node.next.data;
				
				if (tail==node.next) {
					//更改尾部指针指向
					tail=node;
				}
				node.next=node.next.next;
				
				return oldValue;
			}
		}
		return null;
	}

	@Override
	public boolean removeAll(T data) {
		
		boolean flag=false;
		if (data!=null) {
			
			Node<T> font=this.nodeHead;
			Node<T> current=this.nodeHead.next;
			//为了避免死循环，不判断current是否为null了。
			
			//如果current=this.nodeHead,那么循环就结束了，
			
			//可是还有一个问题，如果这个正好是最后一个相等。还是不会报错，因为这个current是最后一个，但不是null，它的next是null
			while (current!=this.nodeHead) {
				
				if (data.equals(current.data)) {
					
					if (tail.data.equals(data)) {
						
						 this.tail=font;
					}
					
					font.next=current.next;
					current=font.next;
					
					flag=true;
				}else{
					font=current;
					current=current.next;
				}
			}
		}
		return flag;
	}

	@Override
	public void clear() {
		this.nodeHead.next=nodeHead;
		this.tail=nodeHead;
	}

	@Override
	public boolean contains(T data) {
		
		
		if (data!=null) {
			
			
			Node<T> node=this.nodeHead.next;
			
			while (node!=nodeHead) {
				
				if (data.equals(node.data)) {
					return true;
				}
				node=node.next;
			}
			
		}
		return false;
	}
	
	
	
	public String toString(){
		
		String str="(";
		
		Node<T> node=this.nodeHead.next;
		
		while (node!=nodeHead) {
			
			str+=node.data;
			
			node=node.next;
			
			//这个地方还需要判断的原因是，最后的一个节点后面不需要加， 
			//通过这个判断，可以选择出不是最后的
			if (node!=nodeHead) {
				str+=",";
			}
		}
		return str+")";
	}

    public static void main(String[] args){

        String[] letters={"A","B","C","D","E","F"};
        CircularHeadLinkedList<String> list=new CircularHeadLinkedList<>(letters);

        System.out.println("list.get(3)->"+list.get(3));
        System.out.println("list:"+list.toString());

        System.out.println("list.add(4,Y)—>"+list.add(4,"Y"));
        System.out.println("list:"+list.toString());
        System.out.println("list.add(Z)—>"+list.add("Z"));
        System.out.println("list:"+list.toString());


        System.out.println("list.contains(Z)->"+list.contains("Z"));
        System.out.println("list.set(4,P)-->"+list.set(4,"P"));
        System.out.println("list:"+list.toString());

        System.out.println("list.removeAll(Z)->"+list.removeAll("Z"));
        System.out.println("list.remove(4)-->"+list.remove(4));
        System.out.println("list:"+list.toString());
    }
}
