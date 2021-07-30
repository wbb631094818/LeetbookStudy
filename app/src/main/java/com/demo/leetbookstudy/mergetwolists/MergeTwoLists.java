package com.demo.leetbookstudy.mergetwolists;

import com.demo.leetbookstudy.listnode.ListNode;

/**
 *  剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5vq98s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    /**
     * 使用双指针
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode left = l1;
        ListNode right = l2;
        ListNode root = null;
        ListNode dic = null;
        while (left!=null || right!=null){
            if (left == null || (right!=null && left.val > right.val)){
                if (root == null){
                    root = right;
                }else {
                    dic.next = right;
                }
                dic = right;
                right = right.next;
            }else{
                if (root == null){
                    root = left;
                }else {
                    dic.next = left;
                }
                dic = left;
                left = left.next;
            }
        }
        return root;
    }

    /**
     *  官方写法，原理同方法一相同，使用双指针
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        mergeTwoLists(l1,null);
    }
}
