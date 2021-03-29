package com.demo.leetbookstudy.numways;

/**
 * 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/57hyl5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NumWays {

    public static void main(String[] args) {
        System.out.println("有"+numWays(2)+"个跳法");
    }

    public static int numWays(int n) {
        // n =1  1  n=2 2  n=3 3  n=4 5  f(n) = f(n-1)+f(n-2)  斐波那契
        if (n == 0 || n ==1){
            return 1;
        }
        int a=1,b=2, sum;
        for (int i = 3; i <= n; i++) {
            sum =(a+b)%1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
}
