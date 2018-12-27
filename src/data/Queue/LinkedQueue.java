package cn.data.Queue;

import java.util.NoSuchElementException;

import cn.data.list.linkedList.single.Node;

/**
 * 说明：链表实现队列，增加头尾指针。但是还是使用不带头结点的链表
 * @author 徐磊
 * @version 1.0
 * @date 2017年10月29日 下午11:37:38
 * @param <T>
 */
public class LinkedQueue<T> implements Queue<T> {
	
	
	private Node<T> node;
	
	
	private Node<T> front,rear;
	
	private int size;
	 
	private int maxSize=128;
	
	
	public LinkedQueue(){
		this.front=this.rear=null;
	}
	
	@Override
	public int size() {
		
		return size;
	}
	
	 public void setMaxSize(int maxSize){
	        this.maxSize=maxSize;
	 }

	
	@Override
	public boolean isEmpty() {
		
		return front==null&&rear==null;
	}

	@Override
	public boolean add(T data) {
		Node<T> node=new Node<T>(data);
		//分为头部插入和尾部插入两种。
		if (this.front==null) {
			
			this.front=node;
		}else{
			//尾部插入
			this.rear.next=node;
		}
		
		this.rear=node;
		size++;
		return true;
	}

	@Override
	public boolean offer(T data) {
		return false;
	}
	
	 /**
     * 返回队头元素,不执行删除操作,若队列为空,返回null
     * @return
     */
	@Override
	public T peek() {
		
		
		return this.isEmpty() ? null :this.front.data;
	}
	
    /**
     * 返回队头元素,不执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * @return
     */
	@Override
	public T element() {
		 if(isEmpty()){
	            throw new NoSuchElementException("The LinkedQueue is empty");
	        }
	        return this.front.data;
	}
	
	/**
     * 出队,执行删除操作,返回队头元素,若队列为空,返回null
     * @return
     */
	@Override
	public T poll() {
		
		if (this.isEmpty()) {
			return null;
		}
		T oldValue=this.front.data;
		
		this.front=this.front.next;
		
		if (this.front==null) {
			
			this.rear=null;
		}
		
		size--;
		
		return oldValue;
	}
	
	
	 /**
     * 出队,执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * @return
     */
	@Override
	public T remove() {
		
		if (isEmpty()) {
			 throw new NoSuchElementException("The LinkedQueue is empty");
		}
        T x=this.front.data;
        this.front=this.front.next;
        if (this.front==null)
            this.rear=null;
        size--;
        return x;
	}
	
	
	
	@Override
	public void clearQueue() {
        this.front= this.rear=null;
        size=0;
	}

}
