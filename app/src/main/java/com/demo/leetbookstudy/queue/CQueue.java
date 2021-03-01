package com.demo.leetbookstudy.queue;


import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5d3i87/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * 解题思路
 * 维护两个栈，第一个栈支持插入操作，第二个栈支持删除操作。
 * <p>
 * 根据栈先进后出的特性，我们每次往第一个栈里插入元素后，第一个栈的底部元素是最后插入的元素，第一个栈的顶部元素是下一个待删除的元素。为了维护队列先进先出的特性，我们引入第二个栈，用第二个栈维护待删除的元素，在执行删除操作的时候我们首先看下第二个栈是否为空。如果为空，我们将第一个栈里的元素一个个弹出插入到第二个栈里，这样第二个栈里元素的顺序就是待删除的元素的顺序，要执行删除操作的时候我们直接弹出第二个栈的元素返回即可。
 * <p>
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CQueue {

    // 栈  先进后出
    private Stack<Integer> stack1; // 负责添加
    private Stack<Integer> stack2; // 负责取出

    public CQueue() {
        stack1 = new Stack<>();  // 12345
        stack2 = new Stack<>();
    }

    /**
     * 添加数据到尾部
     *
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 取出栈里有值，直接取出
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            // 取出栈里没有值，把添加栈里的值拿出来添加到取出栈里，再取出值
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }

}
