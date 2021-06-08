package com.demo.leetbookstudy.mypow;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/57rwmg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MyPow {
    /**
     *  时间超时了
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean isF = false;
        if (n < 0) {
            isF = true;
            n = -n;
        }
        double reslut = 1;
        while (n > 0) {
            reslut = reslut * x;
            n--;
            x=x*x;
        }
        if (isF) {
            reslut = 1 / reslut;
        }
        return reslut;
    }

    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
//            System.out.println("b:"+b+"  x:"+x+" res:"+res);
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;

//            System.out.println("b:"+b+"  x:"+x+" res:"+res);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println("结果为：" + myPow(2, 3));
    }
}
