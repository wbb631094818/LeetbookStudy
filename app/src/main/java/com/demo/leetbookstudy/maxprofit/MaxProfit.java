package com.demo.leetbookstudy.maxprofit;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58nn7r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *  -6(7)  4(1) 4(1) 5(1)
 *
 *  难得自己没看答案写出来了
 *
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] ss = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(ss));
    }
    public static int maxProfit(int[] prices) {
        int maxMoney = 0;
        int minStart = Integer.MAX_VALUE;
        int szie = prices.length;
        for (int i = 0; i < szie; i++) {
            int temp = prices[i];
            System.out.print("temp: "+temp);
            maxMoney = Math.max(temp-minStart,maxMoney);
            if (temp < minStart){
                minStart = temp;
            }
            System.out.print("maxMoney: "+maxMoney);
            System.out.print("minStart: "+minStart);
            System.out.println("-------------");
        }
        return maxMoney;
    }

}
