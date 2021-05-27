package com.demo.leetbookstudy.maxdepth;

import com.demo.leetbookstudy.substructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9hgr5i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxDepth {

    /**
     *  后序遍历   比较左节点层级和右节点层级，取最大的
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left+1, right+1);
    }

    /**
     *  层级遍历   一层一层的往下
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root== null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            System.out.println(" count: "+count);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode != null && treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode != null && treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
        return count;
    }
}
