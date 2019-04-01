package com.zxc.array;

import java.util.ArrayList;

/**
 * @author zxc
 * @date 2019-03-31 23:04
 * 调整数组顺序使奇数位于偶数前面
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution_03 {
    public static void main(String[] args) {
        int[] array = {6, 5, 4, 1, 2, 3};
//        Object[] objects = sort(array);
//        for (Object object : objects) {
//            System.out.print(object);
//        }
        sort2(array);
        for (int i : array) {
            System.out.print(i);
        }
    }

    //遍历数组，遇到奇数放入list,偶数放到list2，然后合并
    public static Object[] sort(int array[]) {
        ArrayList list = new ArrayList();
        ArrayList list2 = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            //奇数放入list，偶数list2
            if (array[i] % 2 != 0) {
                list.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }
        list.addAll(list2);
        return list.toArray();
    }

    //利用冒泡排序的思想
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

    }
}
