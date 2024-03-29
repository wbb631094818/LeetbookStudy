package com.demo.leetbookstudy.getkthfromend;

import com.demo.leetbookstudy.listnode.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第 k 个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58tl52/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class GetKthFromEnd {

    /**
     *  递归法  递归到最后一个节点  向上记录到第K个节点后，一路返回这个节点
     */
    private int count = 0;
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null){
            return null;
        }
        ListNode node = getKthFromEnd(head.next,k);
        System.out.println("head "+head.val);
        count++;
        System.out.println("count "+count);
        if (count > k){
            return node;
        }
        return head;
    }

    /**
     *  双指针法   先用一个指针移动到K的距离  再设置一个指针从头开始  双指针同时移动，到第一个指针移动到末尾时，另一个指针的节点就是结果
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;
        for (int i = 0; i <k ; i++) {
            // 如果发生越界
            if(former == null) {
                return null;
            }
            former = former.next;
        }
        while (former!=null){
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
