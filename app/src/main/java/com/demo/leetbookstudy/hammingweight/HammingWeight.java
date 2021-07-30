package com.demo.leetbookstudy.hammingweight;

/**
 *  剑指 Offer 15. 二进制中 1 的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5vk1l3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class HammingWeight {

    /**
     *  方法一、面向对象方法，使用JAVA自带方法解题
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        String result = Integer.toBinaryString(n).replace("0","");
        return result.toCharArray().length;
    }



    /**
     * 逐位判断
     *  使用&运算  当一个数n&1时，结果只要1，0  二进制最后位为1时，则为1，二进制最后位是0时，则为0。
     *  通过判断该数字二进制最后一位的是否是1还是0来记录该数字的1的数据。每次判断为进行无字符位移。再进行判断记录
     * @param n
     * @return
     */
    public static int hammingWeight2(int n) {
        int res = 0;
        while (n != 0){
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight3(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 1;
        StringBuilder stringBuilder = new StringBuilder();
        int[] res= new int[32];
        for(int i = 31;i >= 0; i--){
//            stringBuilder.append(n>>>i&1);
            System.out.print(n&1);
            res[i] = n&1;
            n >>>= 1;
        }

        for (int i:
             res) {
            stringBuilder.append(i);
        }

        System.out.println("----");
        System.out.println(stringBuilder.toString());

//        System.out.println("s: "+(5&4));
        System.out.println(""+hammingWeight(9));

    }

}
