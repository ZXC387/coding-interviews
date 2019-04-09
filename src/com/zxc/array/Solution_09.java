package com.zxc.array;

/**
 * @author zxc
 * @date 2019-04-09 21:58
 *数组中的逆序对
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007

输入描述:
题目保证输入的数组中没有的相同的数字

数据范围：
对于%50的数据,size<=10^4
对于%75的数据,size<=10^5
对于%100的数据,size<=2*10^5

示例1
输入 1,2,3,4,5,6,7,0
输出 7

第一就是暴力求解法，时间复杂度为o（n^2）,空间复杂度O(1)
第二种思路就是使用归并排序的思想进行处理，时间复杂度O(nlog(n))
 */
public class Solution_09 {
    public static void main(String[] args) {
        int[] array = {7,5,6,4};
        int count = mergeSort(array, array.length);
        System.out.println(count);
    }

    // 归并排序算法, a是数组，n表示数组大小
    public static int mergeSort(int[] array, int n) {
        return  mergeSortInternally(array, 0, n - 1);
    }

    // 递归调用函数

    private static int mergeSortInternally(int[] array, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return 0;
        }
        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        int left_count = mergeSortInternally(array, 0, q);

        int right_count = mergeSortInternally(array, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        int count = merge(array, p, q, r);
        return (count+left_count+right_count)%1000000007;
    }

    private static int merge(int[] array, int p, int q, int r) {
        int a = q; // 指向左边最后第一个数
        int b = r;// 指向右边最后第一个数
        int k = r - p;
        int count = 0; //记录逆序对个数
        int[] tempArray = new int[r - p + 1];// 申请一个大小跟a[p...r]一样的临时数组
        // 判断条件 左边下标不能大于左部分数组长度(a <= q) 右下标不能大于右部分数组的长度(b <= r)
        while (a >= p && b >= q + 1) {
            if (array[a] > array[b]) {
                tempArray[k--] = array[a--];
                count += b - q;
            } else {
                tempArray[k--] = array[b--];
            }
        }

        // 如果左边数组有剩余，添加到临时数组后面
        while (a >= p) {
            tempArray[k--] = array[a--];
        }
        // 如果右边数组有剩余，添加到临时数组后面
        while (b >= q + 1) {
            tempArray[k--] = array[b--];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (int i = 0; i <= r - p; ++i) {
            array[p + i] = tempArray[i];
        }
        return count;
    }

}
