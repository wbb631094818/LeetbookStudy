package com.demo.leetbookstudy.reverselistnode;

import com.demo.leetbookstudy.listnode.ListNode;

/**
 *  反转链表
 *
 *  定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9pdjbm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseListNode {

    /**
     *  迭代解法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 上一个链表
        ListNode pre = null;
        // 当前链表
        ListNode curr = head;

        while(curr !=null){
            // 临时保存下一个链表
            ListNode next = curr.next;
            // 将当前链表的下一个链表指向上一个链表，第一个指向为null
            curr.next = pre;
            // 重置  上一个链表为当前链表
            pre = curr;
            // 重置  当前链表为下一个链表
            curr = next;
            // 继续循环
        }
        return pre;
    }

    /**
     *  方法二 递归
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        // 1. 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }



}
