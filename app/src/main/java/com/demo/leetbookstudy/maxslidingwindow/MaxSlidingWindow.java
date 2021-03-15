package com.demo.leetbookstudy.maxslidingwindow;

/**
 * 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58o46i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {

        int[] ints = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ss = maxSlidingWindow(ints,3);
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i]+",");
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums== null || nums.length<=0){
            return new int[0];
        }
        int start = 0;
        int maxSize = nums.length;
        int[] res = new int[maxSize-k+1];
        int max = 0;

       while (start + k <= maxSize){
           max = Integer.MIN_VALUE;
           for (int i = start; i < k+start; i++) {

               int zhi = nums[i];
               if (zhi>max){
                   max = zhi;
               }
           }
           res[start] = max;
           start++;
       }
       return res;
    }
}


