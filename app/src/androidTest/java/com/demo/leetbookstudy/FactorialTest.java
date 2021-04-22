package com.demo.leetbookstudy;


/**
 *  测试阶乘，使用递归
 */
public class FactorialTest {

    public static void main(String[] args) {
       long ll=  factorial(2,300);
       System.out.println(ll);
    }


    /**
     *  该结果步骤就是
     *  递归到最后number，例 ：number = 2
     *  2
     *  2*2
     *  2*2*2
     *  2*2*2*2
     *  2*2*...*2   n个2
     *
     *
     * @param number
     * @param n
     * @return
     */
    public static long factorial(long number,int n){
        // 递归到最后一个number返回
        if (n<=1){
            return number;
        }
        // 前一个结果，再乘上这个数
       return factorial(number,n-1)*number;
    }


}
