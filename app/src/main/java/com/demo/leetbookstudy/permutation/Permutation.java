package com.demo.leetbookstudy.permutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dfv5h/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Permutation {

    List<String> res = new LinkedList<>();
    char[] chars;
    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int count){
        if (count == chars.length-1){
            res.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = count; i < chars.length; i++) {
            if (set.contains(chars[i]))continue;; // 重复的，剪枝，不加上
            set.add(chars[i]);
            swap(i,count);
            dfs((count+1));
            swap(i,count);
        }
    }

    void swap(int a,int b){
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

}
