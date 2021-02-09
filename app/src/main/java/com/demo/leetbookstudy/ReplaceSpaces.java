package com.demo.leetbookstudy;

/**
 *  替换空格
 *  请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50ywkd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReplaceSpaces {

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    /**
     *  替换空格成%20  使用C的话效率更高
     *
     * 时间复杂度：O(n)O(n)。遍历字符串 s 一遍。
     * 空间复杂度：O(n)O(n)。额外创建字符数组，长度为 s 的长度的 3 倍。
     * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-by-leetcode-solutio/
     * @param s 原字符串
     * @return 替换后的字符串
     */
    public static String replaceSpace(String s) {
        int length = s.length();
        // 初始化一个长度为原始数字长度3倍的字符数组（%20为3个字符，所以默认乘3）
        char[] arry = new char[length*3];
        // 替换后的字符长度
        int size = 0;
        for (int i = 0; i < length; i++) {
            // 获取字符串中当前位置下的字符
            char c = s.charAt(i);
            // 判断该字符是否等于空格
            if (c == ' '){
                // 由一个空格字符替换成2个字符的%20
                arry[size++] = '%';
                arry[size++] = '2';
                arry[size++] = '0';
            }else {
                arry[size++] = c;
            }
        }
        return new String(arry,0,size);
    }

    /**
     *  方法二 比较简单
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }

}
