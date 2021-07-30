package com.demo.leetbookstudy.exchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *  剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5v8a6t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Exchange {

    /**
     *  循环暴力法
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 0){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        for (int num:nums) {
            if (num % 2 != 0){
                list.add(0,num);
            }else {
                list.add(num);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    /**
     *  官方双指针方法
     *  一个指针i从左开始，查找所有的偶数   一个指针j从右开始，查找所有的奇数   左边查到一个偶数和右边查到一个奇数交换
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && nums[i]%2 == 1) {
                i++;
            }
            while(i < j && nums[j]%2 == 0) {
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

}
