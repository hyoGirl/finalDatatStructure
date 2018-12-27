package cn.data.list.linkedList.Double;

import cn.data.list.linkedList.ILinkedList;

/**
 * 说明：带头节点的双链表实现，同时还包含了尾部指针，做成循环节点
 * @author 徐磊
 * @version 1.0
 * @date 2017年10月19日 下午9:20:23
 * @param <T>
 */
public class HeadDoubleLinked<T> implements ILinkedList<T> {
	
	
	private Dnode<T> head;
	//带有尾部节点的指针，并不是指的是循环链表。尾部指针可以理解为和头部指针类似
	private Dnode<T> tail;
	
	
	public HeadDoubleLinked(){
		//初始化头节点
		this.head=this.tail=new Dnode<T>();
	}
	
	
	public HeadDoubleLinked(T[] array){
		//先初始化
		this();
		
		if (array!=null && array.length>0) {
			
			int count=1;
			
			this.head.next=new Dnode<T>(array[0]);
			
			tail=this.head.next;
			
			tail.prev=head;
			
			while (count <array.length) {
				
				
				tail.next=new Dnode<>(array[count++]);
				tail.next.prev=tail;
				tail=tail.next;
				
			}
		}
		
		
	}
	
	
	
	@Override
	public boolean isEmpty() {
		return this.head==this.tail;
	}

	@Override
	public int length() {
		int length=0;
		Dnode<T> pre=head.next;
		while (pre.next!=null) {
			pre=pre.next;
			length++;
		}
		return length;
	}

	@Override
	public T get(int index) {
		
		if (index >0) {
			
			int count=0;
			Dnode<T> pre=head.next;
			
			//这个是定位到当前结点，不是上一个节点
			while (pre!=null && count< index) {
				pre=pre.next;
				count++;
			}
			
			if (pre!=null) {
				return pre.data;
			}
		}
		return null;
	}

	@Override
	public T set(int index, T data) {
		
		if (index > 0 && data!=null) {
			
			Dnode<T> node=this.head.next;
			int count=0;
			while (node!=null && count < index) {
				
				count++;
				node=node.next;
			}
			
			if (node!=null) {
				T old=node.data;
				node.data=data;
				return old;
			}
		}
		return null;
	}
	
	/**
     * 插入结点
     * @param index
     * @param data
     * @return
     */
	@Override
	public boolean add(int index, T data) {
		
		
		if (index >=0 && data!=null) {
			
			Dnode<T> font=this.head;
			
			int count=0;
			//定位到插入节点的上一个节点，因为index是从0开始计算的
			while (font.next!=null && count < index) {
				font=font.next;
				count++;
				
			}
			//创建一个新节点，前驱指向当前结点，后驱就是当前结点的后驱
			Dnode<T> nDnode=new Dnode<T>(data,font,font.next);
			
			/**
			 * 当链表在进行添加的时候，需要修改2个地方
			 * 1：把前面一个节点的指针域指向新节点
			 * 2：把新节点的地址赋值给第二个节点的前置指针域
			 */
			
			
			/**
			 * 头部插入和尾部插入都是一样的情形。都是直接更改了尾部指针情形
			 * 1：需要注意的是头节点的下一个节点是不是null
			 * 2：中间插入无需要判断这些
			 * 3：双向链表的添加
			 * 3.1：要修改前面一个节点的后继指针
			 * 3.2： 要修改第3个节点的前继指针
			 */
			
			
			
			//空双链表插入,需要确保front.next不为空，其实上面构建一个这样的节点就可以了
//			if(font.next!=null){
//				font.next.prev=nDnode;
//			}
			font.next=nDnode;
			if (tail==font) {
				
				tail=nDnode;
			}
			
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
			
			//采用尾部指针的好处就是不需要遍历到最后一步。
			Dnode<T> node=new Dnode<T>(data, tail, null);
			
			tail.next=node;
			this.tail=node;
			return true;
		}
		return false;
	}
	
	/**
	 * 说明：
	 * 1:只有一个节点的时候
	 * 2：要删除的节点是中间节点
	 * 3：要删除的节点是尾部节点
	 * @param index
	 * @return
	 * @author 徐磊
	 * @time：2017年10月19日 下午11:17:40
	 */
	@Override
	public T remove(int index) {
		
		if (index >=0) {
			
			Dnode<T> nDnode=this.head;
			int count=0;
			//定位到要删除节点的上一位
			while (count < index && nDnode!=null) {
				nDnode=nDnode.next;
				count++;
			}
			//获取到要删除的节点
			Dnode<T> last=nDnode.next;
			//链表不是null.表明存在下一个节点，该方法适合于中间删除
			if (last!=null) {
				
				nDnode.next=last.next;
			}
			
			//如果是只有一个节点的删除
			last.prev.next=last.next;
			
			//如果要删除的节点是尾部节点
			if (last==tail) {
				tail=nDnode.prev;
				
			}
			
			T old=last.data;
			return old;
			
		}
		return null;
	}
	 /**
	  * 根据data删除结点,无需像单向链表那样去存储要删除结点的前一个结点
	  * 1.头删除
	  * 2.中间删除
	  * 3.尾部删除,更新tail指向
	  * @param data
	  * @return
	  */
	@Override
	public boolean removeAll(T data) {
		
		if (data!=null) {
			
			
			Dnode<T> front=this.head;
			
			Dnode<T> last=this.head.next;
			
			
			while (last!=null) {
				
				if (data.equals(last.data)) {
					
					//如果删除的是尾部节点
					if (data.equals(tail.data)) {
						this.tail=last.prev;
					}
					front.next=last.next.next;
					last=front.next;
				}else{
					front=last;
					last=front.next;
				}
			}
			
		}
		return false;
	}

	@Override
	public void clear() {
		
		this.head.next=null;
		this.head=this.tail;
	}

	@Override
	public boolean contains(T data) {
		
		if (data!=null) {
			
			Dnode<T> node=this.head;
			while (node.next!=null) {
				node=node.next;
				if (data.equals(node.data)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public String toString(){
		
		String str="(";
		Dnode<T> node=this.head;
		
		while (node.next!=null) {
			
			node=node.next;
			str+=node.data;
			if (node!=tail) {
				str+=", ";
			}
		}
		return str+")";
	}
	
	public static void main(String[] args){
		
		
		HeadDoubleLinked<String> list=new HeadDoubleLinked<>();
		
		list.add(0, "A0");
		System.out.println(list.toString());
		list.add(1, "A1");
		System.out.println(list.toString());
		list.add(2, "A2");
		System.out.println(list.toString());
		list.add(3, "A3");
		System.out.println(list.toString());
		list.add(4, "A4");
		System.out.println(list.toString());
		list.add(5, "A5");
		System.out.println(list.toString());
		list.add(4, "A40");
		System.out.println(list.toString());
		
		
		
		
		

//        String[] letters={"A","B","C","D","Z","E","F","Z"};
////        String[] letters={"A"};
//        HeadDoubleLinked<String> list=new HeadDoubleLinked<>(letters);
//
//        System.out.println("list.get(3)->"+list.get(3));
//        System.out.println("list:"+list.toString());
//
//        System.out.println("list.add(4,Y)—>"+list.add(0,"Y"));
//        System.out.println("list.add(8,M)—>"+list.add(8,"M"));
//        System.out.println("list:"+list.toString());
//        System.out.println("list.add(Z)—>"+list.add("Z"));
//        System.out.println("list:"+list.toString());
//
//
//        System.out.println("list.contains(Z)->"+list.contains("Z"));
//        System.out.println("list.set(4,P)-->"+list.set(4,"P"));
//        System.out.println("list:"+list.toString());
//
//
//        System.out.println("list.remove(6)-->"+list.remove(6));
//        System.out.println("list.remove(0)-->"+list.remove(0));
//        System.out.println("list.remove(3)-->"+list.remove(3));
//       System.out.println("list.remove(Z)->"+list.removeAll("Z"));
//        System.out.println("list:"+list.toString());
    }
	
}
