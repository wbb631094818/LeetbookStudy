package com.demo.leetbookstudy.minnumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/59ypcj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinNumber {

    /**
     *  小堆根   排序从小到大
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {
        Queue<Integer> queue  = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                System.out.println("o1： "+o1);
//                System.out.println("o2： "+o2);
                String strO1 = String.valueOf(o1);
                String strO2 = String.valueOf(o2);
                return (strO1+strO2).compareTo(strO2+strO1);
//                double intO1 = Double.parseDouble(strO1+strO2);
//                double intO2 = Double.parseDouble(strO2+strO1);
//                if (intO1 > intO2){
//                    return 1;
//                }else if (intO1 < intO2){
//                    return -1;
//                }else {
//                    return 0;
//                }
            }
        });
        for (int num: nums) {
            queue.offer(num);
        }
        StringBuilder stringBuilder = new StringBuilder(queue.size());
        while (!queue.isEmpty()){
            stringBuilder.append(queue.poll());
        }
        return stringBuilder.toString();
    }

    /**
     *  快速排序·  Arrays.sort内核为快速排序
     * @param nums
     * @return
     */
    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        return res.toString();
    }



    public static void main(String[] args) {
       int[] nums = {999999998,999999997,999999999};
       System.out.println(minNumber(nums));
    }
}
