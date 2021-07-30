package com.demo.leetbookstudy.singlenumbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9hyq1r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ThreeSingleNumbers {

    /**
     * hash表的方式
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (list.contains(num)) {
                    list.remove(Integer.valueOf(num));
                }
            } else {
                list.add(num);
                map.put(num, num);
            }
        }
        return list.get(0);
    }

    /**
     * 位运算 + 有限状态自动机
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }

    /**
     * 遍历统计法
     *只需要修改求余数值 mm ，即可实现解决 除了一个数字以外，其余数字都出现 mm 次 的通用问题。
     * @param nums
     * @return
     */
    public static int singleNumber3(int[] nums) {
        int[] counts = new int[32];
        for (int num:nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] +=num & 1;
                num >>>= 1;
            }
        }
        int res = 0,m =3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("结果为： " + singleNumber3(new int[]{9, 1, 7, 9, 7, 9, 7}));
    }
}
