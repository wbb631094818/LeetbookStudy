package com.demo.leetbookstudy.findcontinuoussequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为 s 的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/eufzm7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindContinuousSequence {

    /**
     * 滑动窗口   双指针 解法
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence1(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if (s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }

    /**
     * 求和公式 解法
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence2(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if (i < j && j == (int) j) {
                int[] ans = new int[(int) j - i + 1];
                for (int k = i; k <= (int) j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }


    /**
     *  分段暴力求解   也不算太暴力   自己写的方法
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {
        ArrayList<int[]> list = new ArrayList<>();

        int fendui = 2; // 分段
        int middle = target / fendui; // 中间数
        while (middle > 1) {
            int[] items = new int[fendui];
            int jia = 1;
            int sub = 1;
            int sum = middle;
            items[0] = middle;
            // 分成几段就是几个数
            for (int i = 1; i < fendui; i++) {
                if (jia == sub) {
                    items[i] = middle + jia;
                    sum = sum + middle + jia;
                    jia++;
                } else {
                    if (middle - sub <= 0){
                        sum = -1;
                        break;
                    }
                    items[i] = middle - sub;
                    sum = sum + middle - sub;
                    sub++;
                }
            }
            if (sum == target){
                Arrays.sort(items);
                list.add(items);
//                System.out.println("item: "+Arrays.toString(items));
//                System.out.println("sum: "+sum);
            }
            fendui++;
            middle = target / fendui;
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[res.length-i-1] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println("ss: " + Arrays.toString(findContinuousSequence(10)));
    }
}
