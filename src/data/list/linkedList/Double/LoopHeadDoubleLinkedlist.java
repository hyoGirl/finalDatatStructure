package cn.data.list.linkedList.Double;

import cn.data.list.linkedList.ILinkedList;

public class LoopHeadDoubleLinkedlist<T> implements ILinkedList<T> {
	
	public Dnode<T> head;
	
	
	
	public LoopHeadDoubleLinkedlist(){
		
		//初始化头部节点
		this.head=new Dnode<T>();
		
		this.head.next=this.head;
		
		this.head.prev=this.head;
	}
	
	
	public LoopHeadDoubleLinkedlist(T[] array){
		
		
		this();
		if (array!=null && array.length > 0) {
			
			
			
			int count=1;
			
			/*Dnode<T>  node=new Dnode<T>(array[0], this.head, this.head.next);
			
			font.next=node;
			while (node.next!=font && count < array.length) {
				
				node.next=new Dnode<T>(array[count++],node,node.next);
				
				count++;
			}*/
			
			Dnode<T> p=new Dnode<>(array[0]);
			head.prev=p;
			head.next=p;
			p.next=head;
			p.prev=head;
			while (count < array.length) {
				p.next=new Dnode<>(array[count++],p,head);
                head.prev=p.next;
                p=p.next;
			}
		}
	}
	
	
	
	@Override
	public boolean isEmpty() {
		return this.head==null;
	}

	@Override
	public int length() {
		int length=0;
		Dnode<T> node=this.head;
		while (node.next!=null) {
			node=node.next;
			length++;
		}
		return length;
	}

	@Override
	public T get(int index) {
		
		
		if (index >=0) {
			int count=0;
			Dnode<T> node=this.head;
			while (count <  index && node.next!=null) {
				node=node.next;
				count++;
			}
			if (node.next!=head) {
				T old=node.next.data;
				return old;
			}
		}
		return null;
	}

	@Override
	public T set(int index, T data) {
		
		if (index >=0 && data!=null) {
			int count=0;
			Dnode<T> node=this.head.next;
			while (node.next!=head && count < index) {
				node=node.next;
				count++;
			}
			if (node.next!=head) {
				T old=node.data;
				node.data=data;
				return old;
			}
		}
		return null;
	}

	@Override
	public boolean add(int index, T data) {
		if (index >=0 && data!=null) {
			Dnode<T> node=this.head;
			int count =0;
			while (count < index && node.next!=head) {
				node=node.next;
				count++;
			}
			Dnode<T> add=new Dnode<T>(data, node, node.next);
			
			//此时不用判断这个node.next是不是head，是head代表了尾部添加，不是，那就是头部和中部都适合
			//但是如果是尾部添加，那也没关系，只要修改前后指针就可以了。
//			if (node.next!=head) {
//				node.next.prev=add;
//			}
			node.next=add;
			//修改第三个节点的前继指针为add节点
			node.next.prev=add;
			return true;
		}
		return false;
	}
	
   /**
     * 尾部添加
     * @param data
     * @return
     */
	@Override
	public boolean add(T data) {
		
		if (data!=null) {
			//默认尾部添加的时候，只需要把add节点的前继指针指向这个最后一个节点，也就是head.prev,,后继指针指向这个头节点
		/*	Dnode<T> add=new Dnode<T>(data);
			
			//更新原先最后一个节点的后继指针指向
			this.head.prev.next=add;
			
			//更新现在的最后一个节点
			this.head.prev=add;
			
			return true;*/
			
		    Dnode<T> p=new Dnode<>(data,head.prev,head);
	        //更新tail后继指针的指向
	        this.head.prev.next=p;
	        this.head.prev=p;

	        return true;
		}
		return false;
	}

	@Override
	public T remove(int index) {
		
		T oldValue=null;
		
		if (index >=0) {
			
			Dnode<T> node=this.head;
			int count=0;
			while (count < index && node.next!=head) {
				node=node.next;
				count++;
			}
			
			/**
			 * 不是从第一个节点开始遍历，就必须手动获取这个要删除的节点
			 */
			
			//获取要删除的节点
			Dnode<T>  removeNode=node.next;
			
			if (removeNode!= head) {
				oldValue=removeNode.data;
				removeNode.next.prev=removeNode.prev;
				removeNode.prev.next=removeNode.next;
			}
			/*
			//从第一个开始判断的好处就是,如果它是head，那么就直接返回了。
			//同时遍历获取到的节点不再是当前结点的前一个节点，而就是当前要删除的节点
			Dnode<T> node=this.head.next;
			
			int count=0;
			
			//此时获取到的node就是要删除的节点本身，因为我们是从第一个节点开始便利的。不是从头节点遍历的
			while (node!=head && count <  index) {
			
				node=node.next;
				count++;
			}
			*//**
			 * 如果是头部删除，
			 *//*
			if (node!=head) {
				oldValue=node.data;
				
				node.next.prev=node.prev;
				
				node.prev.next=node.next;
			}*/
			return oldValue;
		}
		return null;
	}

	@Override
	public boolean removeAll(T data) {
		
		boolean flag=false;
		
		if (data!=null) {
			
			
			Dnode<T> removeNode=this.head.next;
			
			Dnode<T> font=this.head;
			
			//如果是等于head的情况下，其实就是在删除整个链表，
			
			//所以返回的是false
//			while (removeNode!=head) {
//				if (data.equals(removeNode.data)) {
//					removeNode.next.prev=font;
//					font.next=removeNode.next;
//					flag=true;
//				}else{
//					removeNode=removeNode.next;
//					font=removeNode;
//				}
//			}
			//还有一个更简单的方法，就是只用一个节点来判断
			while (removeNode!=head) {
				if (data.equals(removeNode.data)) {
					removeNode.next.prev=removeNode.prev;
					
					removeNode.prev.next=removeNode.next;
				}else{
					removeNode=removeNode.next;
				}
			}
			
		}
		return flag;
	}

	@Override
	public void clear() {
		this.head.next=this.head;
		this.head.prev=this.head;
	}

	@Override
	public boolean contains(T data) {
		
		
		if (data!=null) {
			
			Dnode<T> node=this.head.next;
			
			
			while (node!=head) {
				
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
		Dnode<T> node=this.head.next;
		
		while (node!=head) {
			str+=node.data.toString();
			
			node=node.next;
			if (node!=head) {
				str+=", ";
			}
			
			
		}
		return str+")";
		
	}
	
	
	public static void main(String[] args){
		
		
/*		LoopHeadDoubleLinkedlist<String> list1=new LoopHeadDoubleLinkedlist<String>();
		
		System.out.println(list1.add("M0"));
		System.out.println(list1.toString());
		System.out.println(list1.add("M1"));
		System.out.println(list1.add(1,"M2"));
		System.out.println(list1.toString());
		System.out.println(list1.add("M2"));
		System.out.println(list1.toString());*/

        String[] letters={"A","B","C","D","Z","E","F"};
        LoopHeadDoubleLinkedlist<String> list=new LoopHeadDoubleLinkedlist<String>(letters);
        
        

        System.out.println("init list-->"+list.toString());

        System.out.println("list.get(3)->"+list.get(3));
        System.out.println("list:"+list.toString());

        System.out.println("list.add(4,Y)—>"+list.add(4,"Y"));
        System.out.println("list:"+list.toString());
        System.out.println("list.add(Z)—>"+list.add("Z"));
        System.out.println("list:"+list.toString());


        System.out.println("list.contains(Z)->"+list.contains("Z"));
        System.out.println("list.set(4,P)-->"+list.set(4,"P"));
        System.out.println("list:"+list.toString());


        System.out.println("list.remove(3)-->"+list.remove(3));
        System.out.println("list.remove(Z)->"+list.removeAll("Z"));
        System.out.println("list:"+list.toString());
    }

}
