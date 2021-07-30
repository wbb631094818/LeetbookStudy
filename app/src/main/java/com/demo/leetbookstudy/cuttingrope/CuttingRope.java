package com.demo.leetbookstudy.cuttingrope;

/**
 *  剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5v1026/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CuttingRope {

    /**
     *  数学解法。推导看不懂
     *  记住结论
     *  n <= 3 时   结果为 n-1
     *  n > 3 时  求 n除3的余数  (b = n % 3)   有三种情况
     *    b = 0 时   结果为：  3^a  3的a次方
     *    b = 1 时   结果为：  3^a-1 * 4    (3的a-1次方 再乘4)
     *    b = 其他 时   结果为：  3^a * 2  (3的a次方 再乘2)
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if (n <= 3){
            return n-1;
        }
        int a = n/3,b = n%3;
        System.out.println();
        if (b==0){
            return (int) Math.pow(3,a);
        }
        if (b == 1){
          return (int) (Math.pow(3,a-1)*4);
        }
        return (int) (Math.pow(3,a)*2);

    }

    public static int cuttingRope2(int n){
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i=3;i<=n;++i){
            // i-j >= 2
            for (int j=1;j<=i-2;++j){
                // 这里因为m>1，所以dp[2] = 1而不是2，dp[3]不能是dp[2] * 1，这样答案是1，错误.
                // 因此下面要添加Math.max(dp[i-j], i-j)。
                System.out.println("dp[i-j]: "+dp[i-j]);
                System.out.println("i-j: "+(i-j));
                System.out.println("j: "+(j));
                System.out.println("dp[i]: "+(dp[i]));
                dp[i] = Math.max(Math.max(dp[i-j], i-j) * j, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
       System.out.println("结果："+cuttingRope(120));
    }
}
