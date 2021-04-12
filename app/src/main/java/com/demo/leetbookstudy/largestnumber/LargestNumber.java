package com.demo.leetbookstudy.largestnumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * 这就是一个排序问题，通过自己的方式判断大小
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return "";
        }
        if (nums.length == 1) {
            return nums[0] + "";
        }

        int size = nums.length;
        Integer[] numsArr = new Integer[size];
        for (int i = 0; i < size; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (Comparator<Integer>) (o1, o2) -> {
            // o1+o2 ?>o2+o1  字符拼接
            long left = Long.parseLong(o1+""+o2);
            long right = Long.parseLong(o2+""+o1);
            if (left>right){
                return -1;
            }else if (left < right){
                return  1;
            }
         return 0;
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }


}
