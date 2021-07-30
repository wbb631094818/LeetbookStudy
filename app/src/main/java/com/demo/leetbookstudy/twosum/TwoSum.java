package com.demo.leetbookstudy.twosum;

/**
 * 剑指 Offer 57. 和为 s 的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5832fi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TwoSum {

    /**
     * 暴力法  超出时间限制了
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            if (left>target){
                break;
            }
            for (int j = i+1; j < nums.length; j++) {
                int right = nums[j];
                if (left+right == target){
                    result[0] = left;
                    result[1]= right;
                    return result;
                }else if (left+right>target){
                    break;
                }
            }
        }
        return result;
    }

    /**
     *  双指针对撞法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length -1;
        while (i<j){
            int num = nums[i] + nums[j];
            if (num<target){
                i++;
            }else if (num>target){
                j--;
            }else {
                return new int[]{nums[i],nums[j]};
            }
        }
        return new int[0];
    }
}
