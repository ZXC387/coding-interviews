package com.zxc.array;

import java.util.Arrays;

/**
 * @author zxc
 * @date 2019-04-03 23:01
 * 最小的K个数
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution_06 {
    public static void main(String[] args) {
        int [] array = {4,5,1,6,2,7,3,8};
        int[] ints = find(array, 4);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] find(int[] array, int k){
        int[] a = new int[k];
        //利用冒泡排序，每次找到最小的数移动到前面，只需要排序k次
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j+1] < array [j]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        a = Arrays.copyOf(array, 4);
        return a;
    }
}
