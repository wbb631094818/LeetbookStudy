package com.demo.leetbookstudy.copycomplexlinkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 *  剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  解题思路：1. 用map的方式存储已经复制过的Node
 *          2. 复制过程中判断该node有没有存在，有的话直接返回有的就好
 *          3. 循环链表复制
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9p0yy1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CopyComplexLinkedList {
    private final Map<Node,Node> map = new HashMap<>();

    /**
     *  方法三  链表拼接与拆分
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while(cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while(cur != null) {
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }


    /**
     * 方法二
     *  哈希表  使用Hashmap
     *  时间复杂度 O(N) ： 两轮遍历链表，使用 O(N)O(N) 时间。
     * 空间复杂度 O(N) ： 哈希表 dic 使用线性大小的额外空间。
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head){
        if (head == null) return null;
        // key 为老的链表节点   val 为新的链表节点
        Map<Node,Node> nodeMap = new HashMap<>();
        // 引用个新的，去循环
        Node node = head;
        // 第一个循环，复制基础链表,复制的链表没有链接节点
        while (node!=null){
            nodeMap.put(node,new Node(node.val));
            node = node.next;
        }
        // 重新定义头部Node
        node = head;
        // 第二个循环，对应新链表上的链接节点，链接next和random的指向
        while (node!=null){
            nodeMap.get(node).next = nodeMap.get(node.next);
            nodeMap.get(node).random = nodeMap.get(node.random);
            node = node.next;
        }
        // 返回新链表的头节点
        return nodeMap.get(head);
    }

    /**
     *  方法一
     * @param head
     * 空间复杂度：O(N)   时间复杂度：O(N)
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null){
            return null;
        }
        // 复制第一个,这是要返回的
        Node node = copyNode(head);
        Node temp = node;
        while (head !=null){
            temp = copyNode(head);
            temp.next = copyNode(head.next);
            temp.random = copyNode(head.random);
            head = head.next;
        }

        return node;
    }

    private Node copyNode(Node node){
        if (node == null){
            return null;
        }
        Node copyNode = null;
        if (map.get(node) !=null){
            return map.get(node);
        }
        copyNode = new Node(node.val);
        copyNode.next = node.next;
        copyNode.random = node.random;
        map.put(node,copyNode);
        return copyNode;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
