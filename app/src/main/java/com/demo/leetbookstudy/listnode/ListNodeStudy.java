package com.demo.leetbookstudy.listnode;

import android.util.Log;

public class ListNodeStudy {

    public static void main(String[] args) {
        // 实例化节点
        ListNode n1 = new ListNode(1); // 节点 head
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

// 构建引用指向
        n1.next = n2;
        n2.next = n3;

        int[] arry = reversePrint(n1);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }

    }

    /**
     *  方法一  先获取链表长度，倒着循环便利
     * @param head 开始的链表
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        ListNode tempHead = head;
        int size = 0;
        while (tempHead != null) {
            tempHead = tempHead.next;
            size++;
        }
        int[] arry = new int[size];
        while (head != null) {
            arry[size - 1] = head.val;
            head = head.next;
            size--;
        }
        return arry;
    }

    static int[] res;
    static int i = 0;
    static int j = 0;

    /**
     *  方法二 使用递归  递归到最后一个取值再到倒数第二的取值，一直到第一个
     * @param head
     * @return
     */
    public static int[] reversePrint2(ListNode head) {
        solve(head);
        return res;
    }

    public static void solve(ListNode head) {
        if (head == null) {
            res = new int[i];
            return;
        }
        i++;
        solve(head.next);
        System.out.print(i + ",");
        res[j] = head.val;
        j++;
    }
}
