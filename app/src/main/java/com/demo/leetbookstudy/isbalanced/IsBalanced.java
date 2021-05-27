package com.demo.leetbookstudy.isbalanced;

import com.demo.leetbookstudy.substructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *  
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9hzffg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return recur(root)!=-1;
    }

    private int recur(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = recur(node.left);
        if (left == -1){
            return -1;
        }
        int right = recur(node.right);
        if (right == -1){
            return -1;
        }
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }



    /**
     *  方法二   较上面时间复杂度高
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
