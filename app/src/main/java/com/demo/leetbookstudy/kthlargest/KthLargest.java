package com.demo.leetbookstudy.kthlargest;

import com.demo.leetbookstudy.substructure.TreeNode;

/**
 * 剑指 Offer 54. 二叉搜索树的第 k 大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58df23/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class KthLargest {

    private int count = 1;
    private int index;
    public int kthLargest(TreeNode root, int k) {
        if(root == null || k == 0){
            return 0;
        }
        rec(root,k);
        return index;
    }

    private void rec(TreeNode node,int k){
        if (node == null){
            return;
        }
        rec(node.right,k);
        System.out.println("数："+node.val +"count: "+count);
        if (count == k){
            index = node.val;
            count++;
            return;
        }
        count++;
        rec(node.left,k);
    }

}
