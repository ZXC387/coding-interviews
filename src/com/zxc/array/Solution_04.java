package com.zxc.array;

import java.util.ArrayList;

/**
 * @author zxc
 * @date 2019-04-01 17:38
 * 顺时针打印矩阵
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution_04 {
    public static void main(String[] args) {
        int array[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

/*       //旋转测试
        int[][] turn = turn(array);
        for (int i = 0; i < turn.length; i++) {
            for (int j = 0; j < turn[i].length; j++) {
                System.out.print(turn[i][j]);
            }
            //换行
            System.out.println();
        }*/
        ArrayList arrayList = print2(array);
        for (Object o : arrayList) {
            System.out.print(o);
        }
    }

    public static ArrayList print2(int[][] array) {
        int row = array.length;
        int col = array[0].length;
        ArrayList list = new ArrayList();

        if (row == 0 && col == 0)
            return list;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            //上：从左到右
            for (int i = left; i <= right; i++)
                list.add(array[top][i]);
            //右：从上到下
            for (int i = top + 1; i <= bottom; i++)
                list.add(array[i][right]);
            //下：从右到左
            if (top != bottom) {
                //防止单行情况
                for (int i = right - 1; i >= left; i--)
                    list.add(array[bottom][i]);
            }
            //左：从下到上
            if (left != right) {
                //防止单列情况
                for (int i = bottom - 1; i > top; i--)
                    list.add(array[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    public static ArrayList print(int[][] array) {
        ArrayList list = new ArrayList();
        int row = array.length;

        while (row != 0) {
            for (int i = 0; i < array[0].length; i++) {
                list.add(array[0][i]);
            }
            //如果只有一行，跳出循环
            if (row == 1)
                break;
            array = turn(array);
            row = array.length;
        }
        return list;
    }

    //删除第一行逆时针旋转
    public static int[][] turn(int array[][]) {
        //旋转后的行==旋转前的列
        int row = array[0].length;
        //旋转后的列 == 旋转前的行
        int col = array.length;

        int[][] newArray = new int[row][col - 1];
        //外层循环控制行，内层循环控制列
        for (int i = 0; i < row; i++) {
            // 因为需要删除第一行，所以旋转后的列也减少一列
            for (int j = 0; j < col - 1; j++) {
                newArray[i][j] = array[j + 1][row - i - 1];
            }
        }
        return newArray;
    }
}
