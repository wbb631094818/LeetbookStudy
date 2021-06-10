package com.demo.leetbookstudy.missingnumber;

/**
 * 剑指 Offer 53 - II. 0～n-1 中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58iqo5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MissingNumber {

    /**
     *  二分查找法
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length <= 0){
            return -1;
        }
        int i=0,j = nums.length-1;
        while (i<=j){
            int m = (i+j)/2;
            if (nums[m] == m){
                i = m+1;
            }else if (nums[m] > m){
                j = m-1;
            }
        }
        return i;
    }

    /**
     *  暴力法  判断下标
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums){
        if (nums == null || nums.length <= 0){
            return -1;
        }
        if (nums[0]==1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0}));
    }
}
