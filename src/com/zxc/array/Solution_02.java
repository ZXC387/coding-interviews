package com.zxc.array;

/**
 * @author zxc
 * @date 2019-03-30 22:49
 * 旋转数组的最小数字
 * 题目描述:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution_02 {
    public static void main(String[] args) {
        int array[] = {0,1,1,1,1};
        System.out.println(find((array)));
    }

    public static int find(int[] array) {
        if (array.length == 0 || array == null) return 0;
        int right = array.length - 1;
        int left = 0;
        //旋转条件
        while (array[left] >= array[right]) {
            //循环终止条件
            if (right - 1 == left) {
                return array[right];
            }

            int mid = left + ((right - left) >> 1);
            //中间的值大于左第一个值，最小的元素肯定位于中间元素后面，左指针指向中间
            if (array[mid] > array[left]) {
                left = mid;
            }
            //中间的值小于左第一个值，最小的元素肯定位于中间元素的前面，右指针指向中间
            if (array[mid] < array[left]) {
                right = mid;
            }
            //如果第一个元素等于最后元素和中间元素，不能判断中间元素位于前面递增数组还是后面递增数组，需要遍历查询
            if (array[left] == array[mid] && array[left] == array[right]) {
              return   findMin(left,right,array);
            }

        }
        return 0;
    }
    public static int findMin(int left, int right, int array[]){
        int min = array[left];
        for (int i = left; i < right; i++) {
            if(min > array[i+1]){
                min=array[i+1];
            }
        }
        return min;
    }
}

