package com.demo.leetbookstudy.countdigitone;

/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：6
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/572jxs/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CountDigitOne {

    /**
     * 暴力求和法   超出时间限制  pass
     *
     * @param n
     * @return
     */
    public static int countDigitOne0(int n) {
        int res = 0;
        int value = 0;
        for (int i = 1; i < n + 1; i++) {
            value += 1;
            String str = String.valueOf(value);
            if (str.contains("1")) {
                for (char s : str.toCharArray()) {
                    if (s == '1') {
                        res++;
                    }
                }
            }
        }
        return res;
    }


    /**
     *  解题思路  https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
     * @param n
     * @return
     */
    public static int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res = res + (high * digit);
            } else if (cur == 1) {
                res = res + (high * digit + low + 1);
            } else {
                res = res + ((high + 1) * digit);
            }
            low = low + (cur * digit);
            cur = high % 10;
            high = high / 10;
            digit = digit * 10;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println("输出：" + countDigitOne(10));
    }
}
