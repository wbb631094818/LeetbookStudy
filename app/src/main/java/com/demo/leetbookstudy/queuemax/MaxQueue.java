package com.demo.leetbookstudy.queuemax;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 *  队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/e2t5ug/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 解题思路
 *  队列数据结构的特点是：先入先出   也就是说，当你添加一个数时，之前的比这个数小的数就没有意义了，对于这个队列的最大值来说。后添加的数一定比先添加的数存活时间久。
 *  以次思想我们可以：
 *  1. 使用一个普通队列存储正常添加的值，使用一个单调的双端队列保存队列最大值（这个可以两头进出，也可以两头取出数据，普通队列只能一头进一头出）
 *  2. 当添加队列时，普通队列正常添加，单调双端队列从尾部开始判断，如果尾部数据比添加的小就删除，直到比添加的数据大时，将添加数据添加到尾部
 *  3. 删除队列数据时，普通队列直接删除，单调双端队列判断删除的元素是否等于最头部的元素，是就删除
 *  4. 取最大值时，直接获取单调双端队列的头部数据即可
 *  ps. 1. 使用单调双端队列维护该队列的最大值，保持队列有大到小，最顶部都是最大的也是最先添加的，也会是最先取出或删除的
 *      2. 添加队列是，虽然需要循环单调双端队列取判断数值大小，但此过程并不是每次都会需要循环n遍的，你可以理解成循环了n个常量的方法。整个程序均摊下了，时间复杂度应为O(1)
 *         这个是我当时没做出来的主要原因
 *
 *
 */
public class MaxQueue {

    /**
     *  存储队列
     */
    private Queue<Integer> queue;
    private Deque<Integer> maxQueue;


    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    // 每个数最多进出max一次，平均时间复杂度O(1)
    public void push_back(int value) {
        while(!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        // 插入末尾
        maxQueue.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        } else {
            int val = queue.poll();
            // 如果删除的数据时最大值列队上的头部参数，则也一起删除
            if(val == maxQueue.peekFirst()) {
                maxQueue.pollFirst();
            }
            return val;
        }
    }

}
