package cn.data.Queue;

import java.awt.Font;
import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * 说明：顺序队列的实现.使用循环队列来实现
 * @author 徐磊
 * @version 1.0
 * @date 2017年10月29日 下午7:45:32
 * @param <T>
 */
public class SeqQueue<T> implements Queue<T>,Serializable{
	
	
	private static final long serialVersionUID = 6892180236860184774L;
	
	private static final int DEFAULT_CAPACITY=5;
	
	private T[] array;
	
	//增加头部和尾部指针，来实现O(1)操作
	private int font,rear;
	
	private int size;
	
	/**
	 * 初始化过程中，尾部指针和头部指针不再是指向-1了，而是指向了0
	 */
	public SeqQueue(){
		
		array=(T[]) new Object[DEFAULT_CAPACITY];
		
		font=rear=0;
	}
	public SeqQueue(int size){
		
		array=(T[]) new Object[size];
		
		font=rear=0;
	}
	

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return this.font==this.rear;
	}
	
    /**
     * data 入队,添加成功返回true,否则返回false,可扩容
     * @param data
     * @return
     */
	@Override
	public boolean add(T data) {
		
		if (data==null) {
			return false;
			 
		}
		
		if (this.font==(this.rear+1)%this.array.length) {
			ensureCapacity(array.length*2+1);
		}
		//添加data
		array[this.rear]=data;
		//更新尾部指针的指向，让它指向下一个空节点
		this.rear=(this.rear+1)%array.length;
		
		size++;
		return true;
	}

	private void ensureCapacity(int size) {
		
		if (size < array.length) {
			return;
		}
		T[] old=array;
		
		
		
		array=(T[]) new Object[size];
		
		int j=0;
//		for (int i = 0; i < array.length; i++) {
//			newArray[i]=old[i];
//		}
		
		
		//这里要判断旧数组是否复制完成。不能用上面的判断，现在是循环队列.
		//如果持续出战，那么font就会逐渐往后移动，那么font又会从头开始，
		//所以只要font和rear之间相差一个，就表示队列满了。
		for (int i = font; i !=rear; i=(i+1)%array.length) {
			array[j++]=old[i];
		}
		//复制完成后，还要把原来的指针归位
		font=0;
		rear=j;
	}
	
    /**
     * offer 方法可插入一个元素,这与add 方法不同，
     * 该方法只能通过抛出未经检查的异常使添加元素失败。
     * 而不是出现异常的情况，例如在容量固定（有界）的队列中
     * NullPointerException:data==null时抛出
     * IllegalArgumentException:队满,使用该方法可以使Queue的容量固定
     * @param data
     * @return
     */
	@Override
	public boolean offer(T data) {
		
		
		if (data==null) {
			throw new NullPointerException("The data can\'t be null");
		}
		//队列满抛出异常
		if (this.font==(this.rear+1)%array.length) {
			throw new IllegalArgumentException("The capacity of SeqQueue has reached its maximum");
		}
		
		array[this.rear]=data;
		//这个地方要进行这么写，主要是当尾部指针再次绕到前面的时候。此时取模运算后的结果是余数
		this.rear=(this.rear+1)%this.array.length;
		
		size++;
		
		return true;
	}
	
    /**
     * 返回队头元素,不执行删除操作,若队列为空,返回null
     * @return
     */
	@Override
	public T peek() {
		
		
		
		return array[font];
	}
	
	
    /**
     * 返回队头元素,不执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * @return
     */
	@Override
	public T element() {
		
		if (isEmpty()) {
			throw new NullPointerException("The SeqQueue is empty");
		}
		
		return peek() ;
	}
	
	
    /**
     * 出队,执行删除操作,返回队头元素,若队列为空,返回null
     * @return
     */
	@Override
	public T poll() {
		
		T oldvalue=this.array[font];
		
		this.font=(this.font+1)%this.array.length;
		
		size--;
		return oldvalue;
	}
	
	
    /**
     * 出队,执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * @return
     */
	@Override
	public T remove() {
		
		if (isEmpty()){
            throw new NoSuchElementException("The SeqQueue is empty");
        }
		
		return poll();
	}
	
	@Override
	public void clearQueue() {
		
		for (int i = font; i!=rear; i=(i+1)%array.length) {
			
			array[i]=null;
		}
		
		this.rear=this.font=0;
		size=0;
	}
	
	public static void main(String[] args) {
		
		SeqQueue<String> sq=new SeqQueue<String>();
		sq.add("A0");
		sq.add("A1");
		sq.add("A2");
		sq.add("A3");
		sq.add("A4");
//		sq.add("A5");
//		sq.add("A6");
//		sq.add("A7");
//		sq.add("A8");
		
		
		int size=sq.size();
		
		System.out.println(size);
		
		
		System.out.println("队列的头部指针是： "+sq.font);
		
		System.out.println("队列的尾部指针是： "+sq.rear);
		
		for (int i = 0; i < size; i++) {
			
			System.err.println(sq.poll());
		}
		 
	}
}
