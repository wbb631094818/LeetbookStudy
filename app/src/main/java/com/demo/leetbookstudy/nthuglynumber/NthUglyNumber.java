package com.demo.leetbookstudy.nthuglynumber;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9h3im5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NthUglyNumber {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }


    /**
     *  动态规划
     *  前提：最小堆，会存储较多的丑数，导致空间复杂度较高。维护最小堆的过程也导致时间复杂度较高。所以可以用动态规划优化
     *  时间复杂度 O(N) ： 其中 N = n，动态规划需遍历计算 dp 列表。
     *  空间复杂度 O(N) ： 长度为 N 的 dp 列表使用 O(N) 的额外空间。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

    /**
     *  最小堆
     *  通过循环，从1开始，取出最小的1，把1与2，3，5相乘后，得到3个丑数{2，3，5}，存到队列中，再取出最小的2, 相乘得到了{4，6，10}，存到队列中。这时队列中数据为{3,4,5,6,10}。
     *  再取出最小的3，相乘得到三个丑数，去重保存。以次类推，第n个取出的最小丑数就是第n丑数
     *  使用hashset去除重复，
     *  PriorityQueue 优先队列从小到大排序，获得第n个数
     *
     *  这个会存储较多的丑数，导致空间复杂度较高。维护最小堆的过程也导致时间复杂度较高
     * @return
     */
    public static int nthUglyNumber2(int n){
        int[] factors = {2,3,5};
        // 去除重复丑数
        Set<Long> seen = new HashSet<>();
        // 使用优先级队列，从小到大排序，
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        // 添加第一个丑数1
        seen.add(1L);
        priorityQueue.offer(1L);
        // 最后输出的丑输  默认0
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            // 取出队列里最小的。
            long curr = priorityQueue.poll();
            ugly = (int) curr;
            for (int factor: factors) {
                long next = curr*factor;
                if (seen.add(next)){
                    priorityQueue.offer(next);
                }
            }
        }
        return ugly;

    }


    /**
     *  暴利法   超出时间限制
     *  从1开始循环，每次+1 然后对这个数因式分解判断是否是丑数，循环不确定
     * @param n
     * @return
     */
    public static int nthUglyNumber1(int n) {
        int number = 0;
        int start = 1;
        int nthug = 1;
        while (number < n) {
            if (isUgly(start)) {
                number++;
                nthug = start;
            }
            start++;
        }
        return nthug;

    }


    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if (n == 2 || n == 3 || n == 5) {
                return true;
            }
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

}
