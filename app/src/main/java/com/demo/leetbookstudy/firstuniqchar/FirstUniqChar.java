package com.demo.leetbookstudy.firstuniqchar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5viisg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FirstUniqChar {

    /**
     *  使用普通hash表遍历得出结果
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        if (s == null || "".equals(s)){
            return ' ';
        }
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.containsKey(chars[i])){
                hashMap.put(chars[i],hashMap.get(chars[i])+1);
            }else {
                hashMap.put(chars[i],1);
            }
        }
        // 遍历hashmap 取出第一个数值是1的
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i])  == 1){
                return chars[i];
            }
        }
        return ' ';
    }

    /**
     *  使用有序hash表 遍历hash表
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) {
                return d.getKey();
            }
        }
        return ' ';
    }


    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
