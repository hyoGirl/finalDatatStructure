/**
 * 
 */
package com.queue.array;

/**
 * 说明：顺序表实现循环队列
 * @author 徐磊
 * @version 1.0
 * @date 2018年6月3日
 */
public class SequenceQueue<T> {
	
	
	private static int DEFAULT_SIZE=15;
	
	private T[] elementData;
	//定义了头尾指针
	private int front;
	
	private int rear;
	//定义数组大小
	private int size;
	
	@SuppressWarnings("unchecked")
	public SequenceQueue() {
		elementData=(T[]) new Object[DEFAULT_SIZE];
		front=rear=0;
	}
	
	
	@SuppressWarnings("unchecked")
	public SequenceQueue(int capacity){
		elementData=(T[]) new Object[capacity];
		front=rear=0;
	}

	public int getSize(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return front==rear;
	}
	
	/**
	 * 入队操作，成功返回true。失败返回false
	 */
	public boolean add(T data){
		
		/*
		 * 判断是否满了，
		 */
		if(this.front==((this.rear+1)%elementData.length)){
			ensureCapacity(elementData.length*2);
		}
		
		//添加数据的时候，尾部指针向后移动
		elementData[rear]=data;
		//更新rear指针指向后一个数据位置
		this.rear=(rear+1)%elementData.length;
		//增加元素个数
		size++;
		
		return true;
	}


	/**
	 * 说明：扩容操作
	 * @author 徐磊
	 * @time：2018年6月3日 下午12:54:53
	 */
	
	private void ensureCapacity(int capacity) {
		
		//如果需要拓展的容量比现在数组的容量还小,则无需扩容？
		
		T[] old=elementData;
		//创建一个新数组的容量，然后复制元素
		elementData=(T[]) new Object[capacity];
		
		int j=0;
		//从当前的头指针，一直遍历到当前的尾部指针
		for(int i=this.front;i!=this.rear;i=(i+1)%old.length){
			elementData[j++]=old[i];
		}
		//恢复指针
		this.front=0;
		this.rear=j;
	}
	
	/**
	 * 
	 * 说明：出队,执行删除操作,返回队头元素,若队列为空,返回null
	 * @return
	 * @author 徐磊
	 * @time：2018年6月3日 下午1:11:55
	 */
	public T pop(){
		T temp=elementData[this.front];
		
		//注意这里 front++ 和front+1 的区别
		this.front=(this.front+1)%elementData.length;
		
		//减少数量
		size--;
		return temp;
	}
	
	//说明：出队,执行删除操作,返回队头元素,若队列为空,异常
	public T remove(){
		if(isEmpty()){
			
			throw new NullPointerException();
		}
		return pop();
	}
	
	/**
	 * 
	 * 说明：清空队列
	 * @author 徐磊
	 * @time：2018年6月3日 下午1:19:35
	 */
	public void cleanQueue(){
		//把每一个值都设置为null
		for(int i=this.front;i!=this.rear;i=(i+1)%elementData.length){
			elementData[i]=null;
		}
		this.rear=this.front=0;
		this.size=0;
	}
	
	
	
	/**
     * 返回队头元素,不执行删除操作,若队列为空,返回null
     * @return
     */
	public T peek(){
		
		return elementData[front];
	}
	
	//返回队头元素,不执行删除操作,若队列为空,异常
	public T element(){
		
		if(isEmpty()){
			throw new NullPointerException();
		}
		return peek();
	}
}
