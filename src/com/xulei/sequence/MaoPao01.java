package com.xulei.sequence;

import java.util.Arrays;

public class MaoPao01 {

    public static void main(String[] args) {

        int[] arr={1,5,2,6,4,7,8};

        System.out.println(Arrays.toString(arr));

//        show1(arr);
        show2(arr);
    }

    public  static void show1(int[] arr ){
        int count=0;
        for(int i=0;i<arr.length-1;i++){

            for(int j=0;j<arr.length-1-i;j++){
                int temp;
                count++;
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                }
            }
        }
        System.out.println(count);//21  1+2+3+4+5+6 /2
        System.out.println(Arrays.toString(arr));
    }


    public static void show2(int[] arr ){
        int count=0;
        boolean flag=true;
        for(int i=0;i<arr.length-1 && flag ;i++){

                flag=false;
            for(int j=0;j<arr.length-1-i;j++){
                int temp;
                count++;
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;

                }
            }
        }
        System.out.println(count);//15
        System.out.println(Arrays.toString(arr));


    }
}
