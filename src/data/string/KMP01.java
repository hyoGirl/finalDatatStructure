package cn.data.string;

public class KMP01 {
	
	
	
	/**
	 * 说明：
	 * @param src S串
	 * @param dest T串
	 * @return  T串在S串中的下标
	 * @author 徐磊
	 * @time：2017年11月19日 下午6:53:07
	 */
	public static int kmpmatch(String src,String dest){
		
		int slength=src.length();
		
		int tlength=dest.length();
		
		int[] next=getNextArray(dest);
		
		
		int sindex=0;
		int tindex=0;
		
		while (sindex < slength && tindex < tlength) {
			
			//tindex都是从next数组中获取到的，如果是-1，那么就代表了。第一个元素T0无法匹配到S串上的元素，那么将S串上元素持续相加。
			//同时T回复到T0。。接下来继续从next、数组中获取元素。继续判断
			//这个地方需要判断是-1的情形.主要是为了来解决，如果T[0]和S[0]不能匹配，那么就用T【0】去匹配S[1],S[2]等等
			//因为index=-1，所以++后还是0，就保证了只有整个一直都是T【0】。
			//如果接下去不再匹配了，那么就再次从next数组上获取指定位置的元素来进行匹配
			if (tindex==-1||src.charAt(sindex)==dest.charAt(tindex)) {
				
				sindex++;
				tindex++;
			}else{
				tindex=next[tindex];
			}
		}
		
		if (tindex==tlength) {
			
			return sindex-tindex;
		}else{
			
			return -1;
		}
	}
	
	
	//next 数组考虑的是除当前字符外的最长相同前缀后缀。第一位的时候是-1
	//next 数组确实是只要将各个最大前缀后缀的公共元素的长度值右移一位，且把初值赋为-1 
	//next 数组存在的价值就是当模式串与主串失配的时候，告诉模式串，下一步该用模式创中的那个元素去匹配
	
	public static int[] getNextArray(String dest) {
		
		int length=dest.length();
		//int 数组初始化值都是0
		int[] nextArr=new int[length];
		
		//i代表了后缀
		int i=0;
		//j代表了前缀
		int j=-1;
		
		nextArr[0]=-1;
		
		while (i<length-1) {
			//如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++，继续匹配下一个字符；
			if(j==-1 || dest.charAt(i)==dest.charAt(j)){
				j++;
				i++;
				//失配位置上填写对应的next值。next[j] = k 代表p[j] 之前的模式串子串中，有长度为k 的相同前缀和后缀
				
				/*已知next [j] = k（相当于“p0 pk-1” = “pj-k pj-1” = AB，可以看出k为2），现要求next [j + 1]等于多少？
						因为pk = pj = C，所以next[j + 1] = next[j] + 1 = k + 1*/
				
				
				nextArr[i]=j;
			}else{
				//1：如果一开始就不能匹配，那么就把T串整体向后移动。
				//移动的本质其实就是从next数组中去找到  T串该用那一个元素去进行下一轮匹配。
				//中间移动的位数是：原始的j匹配到现在的next[j]来进行匹配。j-next【j】
				j=nextArr[j];
				
				
				//当匹配失败时，模式串向右移动的位数为：失配字符所在位置 - 失配字符对应的next 值，
				//即移动的实际位数为：j - next[j]，且此值大于等于1。
				
				/*拿前缀 p0 pk-1 pk 去跟后缀pj-k pj-1 pj匹配，如果pk 跟pj 失配，下一步就是用p[next[k]] 去跟pj 继续匹配，
				如果p[ next[k] ]跟pj还是不匹配，则需要寻找长度更短的相同前缀后缀，即下一步用p[ next[ next[k] ] ]去跟pj匹配*/
			}
			
		}
		return nextArr;
	}
	
	public static void main(String[] args) {
		
		
		 String destStr = "BBC";
		 
		 String onceStr = "BASBBC";
		 
		 int index=kmpmatch(onceStr, destStr);
		 
		 System.out.println(index);
		 
		 int[] next=getNextArray(destStr);
		 
		 for(int i = 0; i < next.length; i++){
	            System.out.print(next[i]+" ");            
	        }
		 
		 
	}
}

