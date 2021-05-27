package com.demo.leetbookstudy.sumnums;

/**
 * 剑指 Offer 64. 求 1 + 2 + … + n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9h44cj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 解题步骤：
 *
 * 通过&&  符号  如果第一个n>1 不成立那么sumNums()方法就不会执行了。从而达到停止递归的目的，这样在n= 1时，递归到最深处，运行下面的res = 0+1
 * 之后再返回 res=res+2 = 0+1+2   ...  一直到n
 *
 *
 */
public class SumNums {
    int res = 0;
    public int sumNums(int n) {
        boolean x= n>1 && sumNums(n-1)>0;
        res+=n;
        return res;
    }


    /**
     *  方法二  使用bug停止循环
     * @param n
     * @return
     */
    public int sumNums2(int n) {
        int res = 0;
        int[] bugs = new int[n];
        while (true){
            res = res+n;
            n=n-1;
            try {
                int s = bugs[n];
            }catch (Exception e){
                return res;
            }
        }
    }
}
