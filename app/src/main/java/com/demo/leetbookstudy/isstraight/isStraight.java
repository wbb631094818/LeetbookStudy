package com.demo.leetbookstudy.isstraight;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/57mpoj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class isStraight {


    /**
     *  自己写的方式 排序遍历法
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        if (nums==null || nums.length<=0){
            return false;
        }
        // 先排序
        Arrays.sort(nums);
        int last = nums[0];
        int kingCount = 0;
        if (nums[0] == 0){
            kingCount++;
        }
        for (int i = 1; i < nums.length; i++) {
            System.out.println("last: "+last +"   num: "+nums[i]);
           if (nums[i] == 0){
               kingCount++;
               continue;
           }
           if (last == 0){
               last = nums[i];
               continue;
           }
           if (nums[i]-last == 1){
               last = nums[i];
               continue;
           }else {
               if (kingCount>0){
                   last = last+1;
                   i = i-1;
                   kingCount--;
                   continue;
               }
               return false;
           }
        }
        return true;
    }

    /**
     *  只要满足 最大的牌 - 最小的牌 < 5 则就是顺子  大小王除外
     * @param nums
     * @return
     */
    public static boolean isStraight2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int max = 0;
        int min = 14; // 牌最大13 设初始值最大
        for (int num: nums) {
            if (num == 0){
                // 大小王跳过
                continue;
            }
            max = Math.max(max,num);
            min = Math.min(min,num);
            if (hashSet.contains(num)){
                // 如果牌有重复的，那肯定不是顺子
                return false;
            }
            // 把每张牌添加到map里
            hashSet.add(num);
        }
        return max - min < 5;  // 最大牌 - 最小牌 < 5  就是顺子
    }


    public static void main(String[] args) {
       System.out.println("输出："+isStraight(new int[]{0,0,8,5,4}));
    }
}
