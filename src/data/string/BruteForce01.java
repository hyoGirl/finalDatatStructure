package cn.data.string;

/**
 * 说明：BF算法，从主串S的第一个字符S[0]开始和模式T的第一个字符T[0]开始比较，若相等，则继续比较二者后续的字符，
 * 若不等，则从主串S的第二个字符S[0]与模式串的第一个字符T[0]进行比较。依次类推S[N]与T[0]比较
 * 需要注意的是，第一次如果前面几个匹配了，但最后一个失败了，那么再次回退的时候。就直接从S[1]与T[0]比较
 * 
 * @author 徐磊
 * @version 1.0
 * @date 2017年11月5日 下午12:39:35
 */
public class BruteForce01 {

	public static void main(String[] args) {
		
		char[] s={'a','a','b','d','f','g','d','w'};
		char[] t={'a','b','d','f'};
		
		System.err.println(bf(s, t));
	}

	public static int bf(char[] s, char[] t) {

		int i = 0;
		int j = 0;

		while (i != s.length - 1 && j != t.length - 1) {
			if (s[i] == t[j]) {
				i++;
				j++;
			} else {
				// 第一次必须回退到i=1.第一次回退的时候i和j都是相等的，所以i-j然后+1。用来保证这个回退到第一个点上
				// 第二次回退的时候j一直都是0.而此时的i是回退后从0开始计算的。只需要保证获取到的是下一个节点就可以了。
				i = i - j + 1;
				j = 0;
			}
		}
		// 如果在主串中查找到子串，则称为模式匹配成功，返回模式串的第一个字符在主串中出现的位置。
		
		//如果j最后走到了模式串的末尾，就证明完全匹配了。此时要返回模式串的第一个字符在主串中出现的位置。
		//此时i=正好匹配的第一个字符+整个模式串的长度
		//,j=t.length-1.，j正好走到了模式串的末尾那么i-j真好是t中第一个字符在s中的位置
		if (j==t.length-1) {
			return i-j;
		} else {
			return -1;
		}

	}

}
