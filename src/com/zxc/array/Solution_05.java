package com.zxc.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zxc
 * @date 2019-04-02 21:46
 * 数组中出现次数超过一半的数字
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution_05 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = find2(array);
        System.out.println(i);

    }
    //借助hashmap存储数组中每个数出现的次数，最后看是否有数字出现次数超过数组长度的一半；
    public static int find(int array[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                Integer value = map.get(array[i]);
                map.put(array[i], value + 1);
                if (map.get(array[i]) > (array.length / 2)) {
                    return array[i];
                }
            } else {
                map.put(array[i], 1);
            }
        }
        System.out.println(map);
        return 0;
    }

    //排序。数组排序后，如果某个数字出现次数超过数组的长度的一半，则一定会数组中间的位置。
    // 所以我们取出排序后中间位置的数，统计一下它的出现次数是否大于数组长度的一半；
    public static int find2(int[] array) {
        int len = array.length;
        if (len < 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(array);
        int num = array[len / 2];
        for (int i = 0; i < len; i++) {
            if (num == array[i])
                count++;
        }
        if (count <= (len / 2)) {
            num = 0;
        }
        return num;
    }
}
