package com.demo.leetbookstudy.rotatestring;

/**
 *  左旋转字符串
 *  字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/589fz2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RotateString {

    public static void main(String[] args) {

        System.out.print("字符"+reverseLeftWords2("cdefgabwerfsds",4));
    }

    /**
     * 自己写的优化前的
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords1(String s, int n) {
        if (s == null){
            return "";
        }
        char[] all = s.toCharArray();
        int size= all.length;
        char[] front = new char[n];
        StringBuffer stringBuffer = new StringBuffer(size);
        for (int i = 0; i < size; i++) {
            if (i>= n){
                // 开始第一个
                stringBuffer.append(all[i]);
            }else{
                // 保存
                front[i] = all[i];
            }
        }
       return stringBuffer.append(front).toString();
    }

    /**
     *  优化后
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        if (s == null){
            return "";
        }
        char[] all = s.toCharArray();
        int size= all.length;
        StringBuilder stringBuffer = new StringBuilder(size);
        for (int i = n; i < size; i++) {
            stringBuffer.append(all[i]);
        }
        for (int i = 0; i < n; i++) {
            stringBuffer.append(all[i]);
        }
        return stringBuffer.toString();
    }

    /**
     *  利用取余运算
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++){
            System.out.println("数："+i+" % "+s.length()+" = "+(i % s.length()));
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }

}
