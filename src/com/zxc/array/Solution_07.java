package com.zxc.array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zxc
 * @date 2019-04-04 8:57
 * 连续子数组的最大和
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Solution_07 {
    public static void main(String[] args) {
        int[] array = {-3, -2, 7, -15,6, 1, 2, 2};
        int i = find3(array);
        System.out.println(i);
    }

    /** 摘自牛客网 评论
     *  使用动态规划
     F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     F（i）=max（F（i-1）+array[i] ， array[i]）
     res：所有子数组的和的最大值
     res=max（res，F（i））

     如数组[6, -3, -2, 7, -15, 1, 2, 2]
     初始状态：
     F（0）=6
     res=6
     i=1：
     F（1）=max（F（0）-3，-3）=max（6-3，3）=3
     res=max（F（1），res）=max（3，6）=6
     i=2：
     F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
     res=max（F（2），res）=max（1，6）=6
     i=3：
     F（3）=max（F（2）+7，7）=max（1+7，7）=8
     res=max（F（2），res）=max（8，6）=8
     i=4：
     F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7
     res=max（F（4），res）=max（-7，8）=8
     以此类推
     最终res的值为8
     * @param array
     * @return
     */
    public static   int find3(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }

    /**
     * 2、对于一个数组中的一个数x，若是x的左边的数加起来非负，那么加上x能使得值变大，
     * 这样我们认为x之前的数的和对整体和是有贡献的。如果前几项加起来是负数，则认为有害于总和。
     *
     * @param array
     * @return
     */
    public static int find2(int[] array) {
        int cur = array[0];          //注意初始值 不能设为0 防止只有负数
        int rest = array[0];
        for (int i = 1; i < array.length; i++) {    //从1开始 因为0的情况在初始化时完成了
            //sum = sum > 0 ?  sum+array[i] :  array[i];  等价于下面if
            if (cur < 0) {
                cur = array[i];     //记录当前最大值
            } else {
                cur += array[i];    //当array[i]为正数时，加上之前的最大值并更新最大值。
            }
            if (rest < cur) {
                rest = cur;
            }


        }
        return rest;
    }

    /**
     * 1、暴力破解  把所有的都算出来，然后排序，选择最大的值
     *
     * @param array
     * @return
     */
    public static int find(int[] array) {
        ArrayList<Integer> lists = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int num = 0;
            for (int j = i; j < array.length; j++) {
                num += array[j];
                lists.add(num);
            }
        }

        if (lists == null) return 0;
        Collections.sort(lists);
        return lists.get(lists.size() - 1);
    }
}
