package com.demo.leetbookstudy.majorityelement;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 *  
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/99iy4g/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MajorityElement {

    /**
     * 哈希表 方法 简单
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int size = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > size) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 摩尔投票法  通过+1  -1的方式得到众数   该方法主要目的是求一组数中的众数
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        int res = 0;
        int count = 0; // 记录投票数
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count = count + 1;
            } else {
                if (res == num) {
                    count = count + 1;
                } else {
                    count = count - 1;
                }
            }
        }
        // 验证res是否是众数  该题目不需要验证
        for(int num : nums) {
            if(num == res) {
                count++;
            }
        }
        return count > nums.length / 2 ? res : 0; // 当无众数时返回 0
    }

}
