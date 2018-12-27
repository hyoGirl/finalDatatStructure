package cn.data.string;

public class StringModel {
	
	public int BF(char S[],char T[]){//BF字符串匹配算法  
        int i=0,j=0;  
        while(i!=(S.length-1) && j!=(T.length-1)){  
            if(S[i]==T[j]){  
                i++;  
                j++;  
            }else{  
                i=i-j+1;  
                j=0;  
            }  
        } 
        //如果在主串中查找到子串，则称为模式匹配成功，返回模式串的第一个字符在主串中出现的位置。
        if(j==(T.length-1)){  
            return i-j;  
        }else{ 
        	//如果在主串中未找到子串，则称为模式匹配失败，返回-1
            return -1;  
        }  
    }  
    public static void main(String[] args) {  
        StringModel s=new StringModel();  
        char[] S={'a','a','b','d','f','g','d','w'};  
        char[] T={'a','b','d','f'};  
        //从主串S中找到模式串T的位置
        System.out.println(s.BF(S, T));  
    }  
}
