package com.zxc.array;

/**
 * @author zxc
 * @date 2019-03-30 20:56
 * 二维数组中的查找
 * 题目描述：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution_01 {
    public static void main(String[] args) {
        int array[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9,}
        };

        System.out.println(find2(array, 3));
    }

    /**
     *  解题思想：
     * 目标值大于右上角的值，下移
     * 目标值小于右上角的值，左移
     * 如果越界，说明不在数组中
     * @param array
     * @param target
     * @return
     */
    public static boolean find(int array[][], int target) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;

        int row = 0;  //行
        int col = array[0].length - 1; //列
        //因为row是增加的，所以只要小于数组行的长度就可以
        //因为col是减少的，所以只要>=0就可以了
        while (row < array.length && col >= 0) {
            int temp = array[row][col];  //右上角的值，初始为[0,2]
            if (target == temp) {
                return true;
            } else if (target < temp) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * 把每一行看成有序递增的数组，
       利用二分查找，
       通过遍历每一行得到答案，
       时间复杂度是nlogn
     * @param array
     * @param target
     * @return
     */
    public static boolean find2(int array[][], int target) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;

        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length-1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target == array[i][mid]) {
                    return true;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}
