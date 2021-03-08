package com.demo.leetbookstudy.minstack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50bp33/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> stackMin; // 该库里为stack里的数据对应的最小数 如：

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
        stackMin.push(Integer.MAX_VALUE);
    }

    /**
     * 元素入栈
     *
     * @param x
     */
    public void push(int x) {
        stack.push(x);
        if (!stackMin.isEmpty()) {
            // 获取最小集合栈顶的数据，
            int min = stackMin.peek();
            if (min > x) {
                stackMin.push(x);
            } else {
                stackMin.push(min);
            }
        } else {
            stackMin.push(x);
        }

    }

    public void pop() {
        if (!stack.isEmpty())
            stack.pop();
        if (!stackMin.isEmpty())
            stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}