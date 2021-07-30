package com.demo.leetbookstudy.singlenumbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/eubbnm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SingleNumbers {

    /**
     * hash表法  不好
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.remove(num);
            } else {
                hashMap.put(num, num);
            }
        }
        int[] res = new int[hashMap.size()];
        int count = 0;
        for (Integer value : hashMap.values()) {
            res[count] = value;
            count++;
        }
        return res;
    }

    /**
     * 异运算法   异或运算：两个相同数字异或，必然等于0
     *
     * @param nums
     * @return
     */
    public static int[] singleNumbers2(int[] nums) {
        // 获得俩个不同数字的异或运算结果
        int res = 0;
        for (int num : nums) {
            res ^= num;
//            System.out.println("res: " + res);
        }
        System.out.println("res: " + res);
        // 取出一个分组标准数    从左开始，向左近一位，循环，找出1  该位为1说明这位
        int dev = 1;
        while ((dev & res) == 0){
            dev <<= 1;
//            System.out.println("dev: " + dev);
        }
        System.out.println("dev: " + dev);
        int a = 0,b = 0;
        for (int n:nums) {
            if ((dev & n) != 0){
                a ^= n;
//                System.out.println("a: " + a);
            }else {
                b ^=n;
//                System.out.println("b: " + b);
            }
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        singleNumbers2(new int[]{1,2,10,4,1,4,3,3});
    }
}
