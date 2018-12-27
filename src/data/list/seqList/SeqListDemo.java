package cn.data.list.seqList;

import java.util.Arrays;

import cn.data.list.SequenceList;

public class SeqListDemo<T> implements SequenceList<T>{
	
	/**
	 * 使用动态分配数组来实现顺序表。
	 * 首先声明一个初始化大小
	 */
	
	private static final int DEFAULT_CAPACITY = 10;
	
	 private static final Object[] EMPTY_ELEMENTDATA = {};
	
	 //内部数组
	private Object[] table;
	
	private int length;
	
	public SeqListDemo(){
		this(DEFAULT_CAPACITY);
	}
	
	public SeqListDemo(int capacity){
		//申请数组存储空间,元素初始化为null
		this.table=new Object[capacity];
		this.length=0;
	}
	
	
	
	/**
	 * 传入一个数组，初始化顺序表
	 * @param array
	 */
	public SeqListDemo(T[] array){
		
		if (array==null) {
			throw new RuntimeException("array can\'t be empty!");
		}
		
		//创建对应容量的数组
		this.table=new Object[array.length];
		
		for (int i = 0; i < array.length; i++) {
			table[i]=array[i];
		}
		this.length=array.length;
		
		
	}
	
	@Override
	public boolean isEmpty() {
		
		return this.length==0;
	}

	@Override
	public int length() {
		return this.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		
		if (index>=0 && index <this.length) {
			return (T)this.table[index];
		}
		return null;
	}
	
	/**
     * 根据index插入元素
     * @param index 插入位置的下标,0作为起始值
     * @param data 插入的数据
     * @return
     */
	@Override
	public boolean add(int index, T data) {
		
		if (data==null) {
			return false;
		}
		 //插入下标的容错判断,插入在最前面
		if (index<0) {
			index=0;
		}
		
		 //插入下标的容错判断,插入在最后面
		if (index> this.length) {
			index=this.length;
		}
		
		//判断数组是否已经满了，就是说现在的数组和内部数组是不是一样大了，如果满了，需要扩容
		
		if (this.length==table.length) {
			
			//把内部数组赋值给一个临时数组
			
			Object[] temp=this.table;
			//创建一个1.5倍容量的新数组 >> 右移相当于除以2
			int newCapacity = this.table.length + (this.table.length >> 1);
			//把原来数组的引用指向这个新数组
			this.table=new Object[newCapacity];
			//把原来的内部数组(临时数组)加入到新的大数组中,复制到这个新数组中
			
			for (int i = 0; i < this.length; i++) {
				this.table[i]=temp[i];
			}
			//如果大于原底层数组长度，则以适当长度新
			//建一个原数组的拷贝，并修改原数组，指向这个新建数组。原数组自动抛弃（java垃圾回收机制会自动回收）
			//this.table=Arrays.copyOf(this.table, newCapacity);
			//即使在客户端指定好了新数组newArray 的大小，接收到返回值后也是指向底层new 出来的数组copy 
		}
		
		//把原来的内部数组中的元素，从length-1到index+1一起往后面移动一位
		for (int i = this.length-1; i > index; i--) {
			
			this.table[i+1]=this.table[i];
		}
		
		//把index对应的元素添加进去，
		
		this.table[index]=data;
		this.length++;
		
		return true;
	}

	/**
     * 在尾部插入元素
     * @param data
     * @return
     */
	@Override
	public boolean add(T data) {
		return add(this.length, data);
	}
	
	
	
	/**
	 * 说明：用指定的元素替代指定索引上的元素
	 * @param index
	 * @param data
	 * @return
	 * @author 徐磊
	 * @time：2017年10月15日 下午9:10:57
	 */
	@Override
	public T set(int index, T data) {
		
		//判断下标取值范围
		if (index>=0 && index <this.length && data!=null) {
			
			T old=(T) this.table[index];
			
			this.table[index]=data;
			
			//为什么返回的是原来的值？
			//但是使用get方法的时候，获取到的确实新的值
			return old;
			
		}
		
		return null;
	}


	/**
     * 根据index删除元素
     * @param index 需要删除元素的下标
     * @return
     */
	@Override
	public T remove(int index) {
		
		//前提判断
		if (index>=0 && index < this.length && this.length!=0) {
			
			T old=(T) this.table[index];
			
			//把原来数组中的元素，从index+1 到length-1 依次向前移动一位
			for (int i = index+1; i < this.length; i++) {
				
				this.table[i-1]=this.table[i];
			}
			
			//把原来数组中的元素，从index到length-1 依次向前移动一位
			/*for (int i = index; i < this.length-1; i++) {
				this.table[i]=this.table[i+1];
			}*/
			this.length--;
			return old;
		}
		return null;
	}
	
    /**
     * 根据数据查询下标
     * @param data
     * @return
     */
	@Override
	public int indexOf(T data) {
		
		if (data!=null) {
			
			//遍历整个数组，找到对应相等值的下标
			for (int i = 0; i < this.length; i++) {
				
				if (this.table[i]==data) {
					return i;
				}
			}
		}
		return -1;
	}


    /**
     * 根据data查询最后一个出现在顺序表中的下标
     * @param data
     * @return
     */
	@Override
	public int lastIndexOf(T data) {
		
		//反方向遍历
		if (data!=null) {
			
			for (int i = this.length-1; i > 0; i--) {
				
				if (this.table[i].equals(data)) {
					return i;
				}
			}
		}
		return -1;
	}

    /**
     * 根据data删除某个数据
     * @param data
     * @return
     */
	@Override
	public boolean remove(T data) {
		
		
		if (data!=null) {
			//调用根据索引来删除这个数据
			return this.remove(this.indexOf(data))!=null;
		}
		return false;
	}


    /**
     * 根据data删除所有数据
     * @param data
     * @return
     */
	@Override
	public boolean removeAll(T data) {
		boolean done=false;
		if (data!=null && this.length>0) {
			
			int i=0;
			//循环遍历，查找相同的，然后删除
			while (i< this.length) {
				
				if (data.equals(this.table[i])) {
					this.remove(i);
					done=true;
				}else{
					i++;
				}
				
			}
		}
		return done;
	}



	@Override
	public void clear() {
		this.length=0;
	}


    /**
     * 查询是否包含某个数据
     * @param data
     * @return
     */
	@Override
	public boolean contains(T data) {
		//其实就是根据该数据去查找对应的索引是否存在
		return this.indexOf(data)>=0;
	}



	@Override
    public String toString() {
       
		String str="(";
		
		if (this.length!=0) {
			
			for (int i = 0; i < this.length-1; i++) {
				
				str+=this.table[i].toString()+", ";
			}
			str+=this.table[this.length-1].toString();
		}
		
		return str+")";
		
    }


}
