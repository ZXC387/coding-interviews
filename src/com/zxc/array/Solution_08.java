package com.zxc.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zxc
 * @date 2019-04-08 19:54
 * 把数组排成最小的数
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution_08 {
    public static void main(String[] args) {
        int[] array = {3, 32, 321};
        String s = find(array);
        System.out.println(s);

    }

    public static String find(int[] arrays) {
        ArrayList<Integer> lists = new ArrayList<>();
        for (int array : arrays) {
            lists.add(array);
        }
        Collections.sort(lists, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = o1 + "" + 02;
                String b = o1 + "" + o1;
                return a.compareTo(b);
            }
        });
        //lambda表达式
//        Comparator<Integer> com = (o1, o2) -> {
//            String a = o1 + "" + 02;
//            String b = o1 + "" + o1;
//            return a.compareTo(b);
//        };
//        Collections.sort(lists,com );
        String result = "";
        for (Integer list : lists) {
            result += list;
        }
        return result;
    }

}