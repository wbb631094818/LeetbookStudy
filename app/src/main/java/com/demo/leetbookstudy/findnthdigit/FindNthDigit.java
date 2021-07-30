package com.demo.leetbookstudy.findnthdigit;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/57vzfh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindNthDigit {


    /**
     * 0~9 10
     * 10~ 99 10 * 2
     * 100 ~ 999  10 * 3
     *
     * @param n
     * @return
     */
    public static int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }
        // 第一步，找出第n为在哪个位数的区间内   0~9？ 10~99？ 100~999？....
        // 获取区间的最小数和最大数  就是  0 9，10 99， 100 999， ...
        long start = 1; // 从一开始
        int digit = 1; // 位数从一位开始
        long count = 9; // 该位数下的最大的数
        while (n > count) {
            n = (int) (n - count);
            start = start * 10;
            digit = digit + 1;
            count = digit * start * 9;
        }
        System.out.println("start: " + start + ", n: " + n + ", digit: " + digit);
        // 求出位数后，开始计算在该区间的位数 此时的n为在该基数区间里的位数  比如 一开始 n = 11  到这就是 1了
        long num = start + (n - 1) / digit;  // 10+(2-1)/2
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        System.out.println("数字位数： " + findNthDigit(1000000000));
    }

}
