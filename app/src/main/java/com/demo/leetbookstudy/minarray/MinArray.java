package com.demo.leetbookstudy.minarray;

import java.util.Arrays;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50xofm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinArray {


    /**
     *  最小排序法  暴力
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length < 0) {
            return -1;
        }
        Arrays.sort(numbers);
        return numbers[0];
    }

    /**
     *  二分查找法
     * @param numbers
     * @return
     */
    public int minArray1(int[] numbers) {
        if (numbers == null || numbers.length < 0) {
            return -1;
        }
        int i = 0;
        int j = numbers.length-1;
        while (i <j){
            int findId= (i+j)/2;
            if (numbers[findId] > numbers[j]){
                i = findId+1;
            }else if (numbers[findId]<numbers[j]){
                j= findId;
            }else {
                int x= i;
                for (int k =i+1; k < j; k++) {
                    if (numbers[k] < numbers[x]){
                        x= k;
                    }
                }
                return numbers[x];
            }
        }
        return numbers[i];
    }
}
