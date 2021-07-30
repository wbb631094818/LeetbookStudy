package com.demo.leetbookstudy.reversewords;

/**
 *  剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/586ecg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseWords {

    /**
     * 分割 + 倒序
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s == null){
            return null;
        }
        String[] chars = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length-1; i >=0 ; i--) {
            String str = chars[i].replace(" ","");
            if ("".equals(str)) {
                continue;
            }
            System.out.println("str； "+chars[i]);
            stringBuilder.append(str);
            if (i!=0) {
                stringBuilder.append(" ");
            }
        }
        String s1 = stringBuilder.toString();
        if (s1.endsWith(" ")){
            s1 = s1.substring(0,s1.length()-1);
        }
        return s1;
    }

    /**
     *  双指针 i指针遇到不是空格就向前 遇到了截取i到j的间隔字符，存储下来 然后遇到空格也向前，知道没有空格时，j下标就移动到i。
     *  然后i重复之前的操作，直到i小于0，退出循环
     * @param s
     * @return
     */
    public static String reverseWords2(String s) {
        s = s.trim(); // 删除首位空格
        int j = s.length() -1,i = j;
        StringBuilder stringBuilder = new StringBuilder();
        while (i>=0){
            while (i>=0 && s.charAt(i)!= ' '){
                i--;
            }
            stringBuilder.append(s.substring(i+1,j+1)).append(" ");
            while (i>=0 && s.charAt(i) == ' '){
                i--;
            }
            j = i;
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }
}
