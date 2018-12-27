package cn.data.stack;

import java.io.Serializable;

public class SeqStack<T> implements Stack<T>, Serializable {

	private static final long serialVersionUID = 1L;

	// 栈顶指针 -1
	private int top = -1;

	// 初始容量 10
	private int capacity = 10;

	// 存放元素的数组
	private T[] array;

	// 元素个数
	private int size;

	@SuppressWarnings("unchecked")
	public SeqStack(int capacity) {
		array = (T[]) new Object[capacity];
	}

	@SuppressWarnings("unchecked")
	public SeqStack() {
		array = (T[]) new Object[this.capacity];
	}

	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {

		return this.top == -1;
	}
	
	/**
     * 添加元素,从栈顶(数组尾部)插入
     * @param data
     */
	@Override
	public void push(T data) {

		if (data != null) {

			if (array.length==size) {
				// 1:判断栈是不是满了
				int newCapacity=size + (size >> 1);
				ensureCapacity(newCapacity);
			}
			// 2：开始进栈。从栈顶开始添加元素
			array[++top] = data;
			size++;
		}
	}
	
	/**
     * 获取栈顶元素的值,不删除
     * @return
     */
	@Override
	public T peek() {
		
		if (isEmpty()) {
			throw new RuntimeException("Stack empty");
		}
		return array[top];
	}
	
	/**
     * 从栈顶(顺序表尾部)删除
     * @return
     */
	@Override
	public T pop() {
		

		if (isEmpty()) {
			throw new RuntimeException("Stack empty");
		}
		T oldValue=array[top--];
		size--;
		return oldValue;
	}

	private void ensureCapacity(int newCapacity) {

		if (newCapacity < size) {

			return;
		}
		T[] old = array;

		array = (T[]) new Object[newCapacity];

		for (int i = 0; i < size; i++) {
			array[i] = old[i];
		}
	}
	
	public static void main(String[] args) {
		
		SeqStack<String> s=new SeqStack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        s.push("C0");
        s.push("C1");
        s.push("C2");
        s.push("C3");
        s.push("C4");
        s.push("C5");
        s.push("C6");
        s.push("C7");
        s.push("C8");
        s.push("C9");
        
        System.out.println("size->"+s.size());
        int l=s.size();//size 在减少,必须先记录
        for (int i=0;i<l;i++){
            System.out.println("从尾部取出的第"+i+"个元素是： "+s.pop());
        }

        System.out.println("s.peek->"+s.peek());
		
	}
}
