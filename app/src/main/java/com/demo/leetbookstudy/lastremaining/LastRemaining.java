package com.demo.leetbookstudy.lastremaining;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/oxrkot/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LastRemaining {

    /**
     *  迭代法数学法 和lastRemaining1一样，写法不同·
     *  公式  (当前index + m) % 上一轮剩余数字个数
     *  解题地址：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining3(int n,int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    /**
     * 暴力解法  模拟链表
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining2(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }


    /**
     * 迭代法   两方法原理相同
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining1(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; i++) {
            f = (m + f) % i;
        }
        return f;

    }

    /**
     * 递归法
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        return f(n, m);

    }

    public static int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }


    public static void main(String[] args) {
        System.out.println("最后结果 " + lastRemaining3(5, 3));
    }
}
