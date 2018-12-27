package cn.data.list.linkedList.Double;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 说明：双链表节点
 * @author 徐磊
 * @version 1.0
 * @date 2017年10月19日 下午9:19:53
 * @param <T>
 */
public class Dnode<T> {
	
	public Dnode<T> prev;
	public Dnode<T> next;
	
	public T data;
	
	
	public Dnode(T data,Dnode<T> prev,Dnode<T> next){
		
		this.data=data;
		this.prev=prev;
		this.next=next;
	}
	
	public Dnode(){
		this(null,null,null);
	}
	
	
	public Dnode(T data){
		
		this(data,null,null);
	}

	public String toString()
    {
        return this.data.toString();
    }
	
	
}
