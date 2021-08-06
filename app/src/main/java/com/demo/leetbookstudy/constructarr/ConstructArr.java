package com.demo.leetbookstudy.constructarr;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/57d8cm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ConstructArr {


    /**
     *  暴力法  超时  gg
     * @param a
     * @return
     */
    public int[] constructArr1(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
            for (int j = 0; j < a.length; j++) {
                if (j == i) {
                    continue;
                }
                res[i] = res[i] * a[j];
            }
        }
        return res;
    }


    public int[] constructArr(int[] a){
        if (a == null || a.length == 0){
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        // 先算下半页  从1开始  b[i] = b[i-1] * a[i-1]
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i-1] * a[i-1];
        }
        // 再计算上半页 从倒数第二个开始   b[i] = b[i] * a[i+1]
        for (int i = a.length-2; i >=0; i--) {
            tmp = tmp * a[i+1];
            // 将上半页的值与下半页的值相乘
            b[i] = b[i] * tmp;
        }
        return b;
    }
}
