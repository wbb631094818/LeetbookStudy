package com.demo.leetbookstudy.medianfinder;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5vd1j2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MedianFinder {

    private Queue<Integer> left;  // 小顶堆，保存较大的一半
    private Queue<Integer> right; // // 大顶堆，保存较小的一半
    /** initialize your data structure here. */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public MedianFinder() {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (left.size() != right.size()){
            // 左边堆的数据不等于右边堆的数据
            // 左边添加新的
            left.add(num);
            // 右边添加左边最大的
            right.add(left.poll());
        }else {
            right.add(num);
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() != right.size()){
            return left.peek();
        }else {
           return (left.peek()+right.peek())/2.0;
        }
    }
}
