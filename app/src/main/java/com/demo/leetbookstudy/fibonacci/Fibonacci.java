package com.demo.leetbookstudy.fibonacci;

/**
 * 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50fxu1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 解题思路：
 * 1. 通过循环获取f(n-1) 及 f(n-2)的值，并求和就是f(n)
 * 2. 设置初始值 a=0 b = 1  及定义一个int值sum
 * 3. 从2开始循环，求a+b的和，并将a赋值b，b赋值sum,再开始下一轮循环直至结束
 * 4. a+b的和要进行取模就是取余，不能结果取模，防止越界
 * 解题链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/dong-tai-gui-hua-fei-bo-na-qi-shu-lie-by-fpca/
 *
 */
public class Fibonacci {

    public static void main(String[] args) {

//        System.out.println("ss: "+1000008007%1000000007);
        System.out.println(fib2(100));
    }

    public static int fib(int n) {
        if (n == 0){
            return 0;
        }
        // 初始n =1 n =2 时
       int a=0, b = 1, sum;
        for (int i = 2; i <=n ; i++) {
            // 当前总和是前俩数相加
            sum = (a+b)%1000000007;
            // 把a 赋值成前一个
            a = b;
            // 把b赋值成当前值
            b =sum;
        }
        return b;
    }
    public static int fib2(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


}
