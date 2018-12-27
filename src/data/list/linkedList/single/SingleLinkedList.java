package cn.data.list.linkedList.single;

import org.omg.CORBA.ULongLongSeqHelper;

import cn.data.list.linkedList.ILinkedList;

public class SingleLinkedList<T> implements ILinkedList<T> {
	
	//带数据的第一个节点
	protected Node<T> head;
	
	public SingleLinkedList(Node<T> head){
		this.head=head;
	}

	@Override
	public boolean isEmpty() {
		return head==null;
	}

	@Override
	public int length() {
		return 0;
	}
	
    /**
     * 根据index索引获取值
     * @param index 下标值起始值为0
     * @return
     */
	@Override
	public T get(int index) {
		
		if (this.head!=null&& index>=0) {
			
			int count=0;
			Node<T> p=this.head;
			
			while (p!=null && count<index) {
				p=p.next;
				count++;
			}
			
			while (p!=null) {
				return p.data;
			}
		}
		return null;
	}
	
	/**
     * 根据索引替换对应结点的data
     * @param index 下标从0开始
     * @param data
     * @return 返回旧值
     */
	@Override
	public T set(int index, T data) {
		
		if (this.head!=null && index>0 && data!=null) {
			
			
			//遍历获取这个值
			
			Node<T> p=this.head;
			int count=0;
			
			while (count<index && p!=null) {
				
				p=p.next;
				count++;
			}
			
			if (p!=null) {
				
				T oldValue = p.data;
				//设置新值，返回旧值
				p.data=data;
				
				return oldValue;
			}
			
		}
		return null;
	}
	
    /**
     * 根据下标添加结点
     * 1.头部插入
     * 2.中间插入
     * 3.末尾插入
     * @param index 下标值从0开始
     * @param data
     * @return
     */
	@Override
	public boolean add(int index, T data) {
		
		if (data==null) {
			
			return false;
		}
		//从头部第一次插入
		if (this.head==null) {
			
			this.head=new Node<T>(data, this.head);
		}else{
			//在尾部或者中间插入
			int count=0;
			Node<T> p=this.head;
			//找到前面一位
//			while (this.head.next!=null && count<index) {
//				
//				
//			}
			while(p.next!=null&&count<index){
				p=p.next;
				count++;
			}
			if (p!=null) {
				
				p.next=new Node<T>(data, p.next);
			}
			return true;
		}
		return false;
	}

	
    /**
     * 默认尾部插入
     * @param data
     * @return
     */
	@Override
	public boolean add(T data) {
		return add(Integer.MAX_VALUE, data);
	}
	
    /**
     * 根据索引删除结点
     * @param index
     * @return
     */
	@Override
	public T remove(int index) {
		
		
		if (this.head!=null && index > 0) {
			
			if (index==0) {
				this.head=null;
			}else{
				int count=0;
				Node<T> p=this.head;
				while (p.next!=null&&count< index) {
					p=p.next;
					count++;
				}
				if (p.next!=null) {
					T oldValue=p.next.data;
					p.next=p.next.next;
					return oldValue;
				}
			}
		}
		return null;
	}
	
    /**
     * 根据data移除所有数据相同的结点
     * @param data
     * @return
     */
	@Override
	public boolean removeAll(T data) {
		
		boolean flag=false;
		
		
		if (this.head!=null && data!=null) {
			
			if (data.equals(this.head.data)) {
				
				this.head=this.head.next;
				flag=true;
			}else{
				
				//遍历整个链表，找到相同的就删除
				Node<T> p=this.head;
				
				Node<T> free=p.next;
				
				while (free!=null) {
					
					//  。如果正好是每次开始遍历的第一个是满足的。
					if (data.equals(free.data)) {
						
						p.next=free.next;
						//此时还需要进行再次遍历，找到下一个数据
						free=p.next;
					}else{
						//如果第二个不满足,就再从第二个开始遍历，此时在这轮遍历中，p就是第二个节点了，不再是整个链表的头节点
						p=free;
						//同时，free就是第三个节点了，以此类推。
						free=free.next;
					}
				}
				flag=true;
			}
		}
		return flag;
	}

	@Override
	public void clear() {
		this.head=null;
	}
	/**
     * 判断是否包含某个值
     * @param data
     * @return
     */
	@Override
	public boolean contains(T data) {
		
		if (this.head!=null && data!=null) {
			
			Node<T> p=this.head;
			
			while(p.next!=null){
				if (data.equals(p.data)) {
					
					return true;
				}
				p=p.next;
				
			}
		}
		return false;
	}
	
    /**
     * 从末尾连接两个链表
     * @param list
     */
    public void concat(SingleLinkedList<T> list){
    
       if (this.head==null) {
		
    	   this.head=list.head;
		}else{
			
			Node<T> p=this.head;
			while (p.next!=null) {
				p=p.next;
			}
			
			p.next=list.head;
		}
       
    }
    
    public String toString(){
    	
    	String str="(";
    	
    	Node<T> p=this.head;
    	
    	while(p!=null){
    		
    		str+=p.data;
    		//p.next可以为null，
    		p=p.next;
    		if (p!=null) {
				str+=",";
			}
    	}
    	return str+")";
    }
    
    
    public Node reverse(SingleLinkedList ss){
    	
    	
    	if (head==null) {
			return null;
		}
    	Node<T> pre=head;
    	
    	Node<T> cur=head.next;
    	
    	Node<T> temp;
    	
    	while (cur!=null) {
			
    		temp=cur.next;
    		
    		cur.setNext(pre);
    		pre=cur;
    		
    		cur=temp;
		}
    	 // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点  
    	head.setNext(null);
    	
    	return pre;
    	
    }
    
    public SingleLinkedList(T[] array){
    	
    	this.head=null;
    	if (array!=null && array.length>0) {
			
    		int count=1;
    		
    		this.head=new Node<T>(array[0]);
    		
    		Node p=this.head;
    		while (count< array.length) {
    			p.next= new Node<T>(array[count++]);
    			p=p.next;
    			
			}
    		
		}
    }
    
    
    
    public Node<T> reverse2(SingleLinkedList ss){
    	
    	if (head!=null) {
    		Node<T> pre=this.head;
    		Node<T> current=pre.next;
    		Node<T> temp=null;
    		head.next = null; //旧的头指针是新的尾指针，next需要指向NULL 
    		while (current!=null) {
    			temp=current.next;
    			current.setNext(pre);
    			pre=current;
    			current=temp;
			}
    		this.head=pre;
    		return pre;
		}
		return null;
    	
    }
    
    public static void main(String[] args) {
		
    	 String[] letters={"A","B","C","D","E","F"};
    	 
    	 SingleLinkedList<String> ss=new SingleLinkedList<>(letters);
    	 
    	System.out.println( ss.toString());
    	
    	 // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点  
    	//Node node = ss.reverse(ss);
    	Node node = ss.reverse2(ss);
    	//遍历新链表的头节点，开始打印，不能再使用以前的toString方法
//    	String str="(";
//    	while (node!=null) {
//			
//    		str+=node.data;
//    		
//    		node=node.next;
//    		
//    		if (node!=null) {
//				str+=",";
//			}
//		}
//    	
//    	System.out.println(str+")");
    	System.out.println( ss.toString());
    	
    	System.out.println(ss.add("B"));
    	System.out.println( ss.toString());
    	
    	System.out.println(ss.removeAll("B"));
    	System.out.println( ss.toString());
    	
    	
    	
	}
}
