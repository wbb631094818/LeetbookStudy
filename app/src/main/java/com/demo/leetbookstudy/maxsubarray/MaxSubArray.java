package com.demo.leetbookstudy.maxsubarray;

import java.util.Random;

/**
 *  连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/59gq9c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 解： 数组里，前一个与当前数相加，如果大于当前的数，说明前一个数大于当前的数，他俩相加有机会成为最大值，
 * 反之，如果相加之后小于当前的数，那么前面的数直接舍弃，用当前数开始
 *
 *  ----------- 动态规划算法可以说是 '记住求过的解来节省时间' ---------
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println("最大值是："+maxSubArray(nums));
    }



    public static int maxSubArray(int[] nums) {
        if (nums == null){
            return 0;
        }
        int size = nums.length;
        int temp = nums[0];
        int max = temp;
        for (int i = 1; i < size; i++) {
            temp = getMax(temp+nums[i],nums[i]);
            if (temp>=max){
                max = temp;
            }
        }
        return max;

    }

    private static int getMax(int a,int b){
        return Math.max(a, b);
    }
}
