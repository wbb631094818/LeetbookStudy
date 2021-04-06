package com.demo.leetbookstudy.translatnum;

/**
 * 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/99wd55/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 解题思路：当前俩位数<=25时，为斐波那契数列  fn = f(n-1)+f(n-2)
 *
 */
public class TranslatNum {

    public static void main(String[] args) {
        System.out.println("数："+translateNum(12258));
    }

    public static int translateNum1(int num) {
        char[] strings = String.valueOf(num).toCharArray();
        if (strings.length<=1){
            return 1;
        }
        int[] dp = new int[strings.length];
        dp[0] = 1;
        if (strings[0] == '1' || (strings[0] == '2' && strings[1]<='5')){
            // 如果这个数子小于25
            dp[1] = 2;
        }else {
            dp[1] = 1;
        }
        for (int i = 2; i < strings.length; i++) {
            if (strings[i-1] == '1' || (strings[i-1] == '2' && strings[i]<='5')){
                // 如果这个数子小于25
                dp[i] = dp[i-1]+dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[strings.length -1];

    }

    public static int translateNum(int num) {
        if (num == 0){
            return 1;
        }
        char[] chars = String.valueOf(num).toCharArray();
        int[] dp = new int[chars.length];
        dp[0] = 1;
        if (chars[0] == '1'|| (chars[0] == '2' && chars[1]<='5')){
            dp[1] = 2;
        }else {
            dp[1] = 1;
        }

        for (int i = 2; i < chars.length; i++) {
            if (chars[i-1] == '1'|| (chars[i-1] == '2' && chars[i]<='5')){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }

        return dp[chars.length-1];
    }
}
