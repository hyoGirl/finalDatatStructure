package cn.data.list.linkedList.Double;

import cn.data.list.linkedList.ILinkedList;

/**
 * 说明：升序排序链表.需要实现整个comparator
 * @author 徐磊
 * @version 1.0
 * @date 2017年10月21日 下午8:20:46
 * @param <T>
 */
public class SortLoopHeadDoubleLinkedList<T extends Comparable<T>> implements ILinkedList<T> {
	
	public Dnode<T> head;
	
	public SortLoopHeadDoubleLinkedList(){
		this.head=new Dnode<>();
		this.head.next=head;
		this.head.prev=head;
	}
	
	
	
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(int index, T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(T data) {
		// TODO Auto-generated method stub
		return false;
	}

}
