package com.demo.leetbookstudy.cuttingrope;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5vcapc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CuttingRope2 {

    /**
     * 数学推导
     *
     * @param n
     * @return
     */
    public int cuttingRope0(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a = (a / 2)) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if (b == 0) return (int) (rem * 3 % p);
        if (b == 1) return (int) (rem * 4 % p);
        return (int) (rem * 6 % p);
    }

    /**
     * 数学推导的不同表达
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3, p = 1000000007;
        long ret = 1;
        int lineNums = n / 3;           //线段被我们分成以3为大小的小线段个数
        for (int i = 1; i < lineNums; i++) //从第一段线段开始验算，3的ret次方是否越界。注意是验算lineNums-1次。
        {
            ret = 3 * ret % p;
            System.out.println("ret: "+ret);
        }
        if (b == 0) {
            return (int) (ret * 3 % p);   //刚好被3整数的，要算上前一段
        }
        if (b == 1) {
            return (int) (ret * 4 % p);   //被3整数余1的，要算上前一段
        }

        return (int) (ret * 6 % p);       //被3整数余2的，要算上前一段
    }

    public static void main(String[] args) {
        cuttingRope(270);
    }
}
