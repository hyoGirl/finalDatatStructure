package cn.data.stack;

import java.io.Serializable;

import cn.data.list.linkedList.single.Node;

/**
 * 说明：没有头节点
 * 
 * @author 徐磊
 * @version 1.0
 * @date 2017年10月29日 下午1:55:49
 * @param <T>
 */
public class LinkedStack<T> implements Stack<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3951612204698337979L;

	private Node<T> top;

	private int size;

	public LinkedStack() {

		this.top = new Node<>();
	}

	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return top == null || top.data == null;
	}

	/**
	 * 添加元素,从栈顶(数组尾部)插入
	 * 
	 * @param data
	 */
	@Override
	public void push(T data) {

		if (data == null) {
			throw new RuntimeException("data can\'t be null");
		}
		//初始化的时候top是null，它的data也是null
		if (this.top == null) {
			this.top = new Node<T>(data);
		} else if (this.top.data == null) {
			this.top.data = data;
		} else {
			Node<T> p1 = new Node<T>(data, this.top);
			top = p1;
		}
		size++;
	}

	/**
	 * 获取栈顶元素的值,不删除
	 * 
	 * @return
	 */
	@Override
	public T peek() {

		if (isEmpty()) {
			throw new RuntimeException("Stack empty");
		}
		return this.top.data;
	}

	/**
	 * 从栈顶(顺序表尾部)删除
	 * 
	 * @return
	 */
	@Override
	public T pop() {

		if (isEmpty()) {
			throw new RuntimeException("Stack empty");
		}

		T data = top.data;

		top = top.next;

		size--;

		return data;
	}

	public static void main(String[] args) {
		LinkedStack<String> sl = new LinkedStack<String>();
		sl.push("A");
		sl.push("B");
		sl.push("C");
		int length = sl.size();
		for (int i = 0; i < length; i++) {
			System.out.println("sl.pop->" + sl.pop());
		}
	}

}
