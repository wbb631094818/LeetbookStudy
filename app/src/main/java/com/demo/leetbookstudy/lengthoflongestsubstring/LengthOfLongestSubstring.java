package com.demo.leetbookstudy.lengthoflongestsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dgr0c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println("输出： "+lengthOfLongestSubstring1("pwwkew"));
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int maxNumber = 0;
        int left = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                // 这是取第一次出现重复的最大索引值
                // 这个索引不是当前这个索引，而是这个数之前的重复数索引，不然直接left=i结了，谨记
                left = Math.max(left,map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i);
            System.out.println("索i： "+i);
            System.out.println("索left： "+left);
            maxNumber=Math.max(maxNumber,i-left);
        }
        return maxNumber;
    }


    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            }
            dic.put(s.charAt(j), j); // 哈希表记录
            System.out.println("索j： "+j);
            System.out.println("索left： "+i);
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }

}
