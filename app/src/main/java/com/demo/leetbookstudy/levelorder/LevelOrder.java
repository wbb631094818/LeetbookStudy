package com.demo.leetbookstudy.levelorder;

import com.demo.leetbookstudy.substructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9ackoe/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode9 = new TreeNode(2);
        TreeNode treeNode20 = new TreeNode(3);
        TreeNode treeNode15 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(5);

        treeNode.left = treeNode9;

        treeNode.right = treeNode20;
        treeNode9.left = treeNode15;
        treeNode9.right = treeNode7;

        int[] ints = levelOrder(treeNode);
        for (int i: ints) {
            System.out.print(i+",");
        }

    }


    /**
     *  使用辅助队列的方式，没读取一个左右子节点，
     *  根据队列先进先出的原则，先保存左边节点再保存右边节点。再取出最先存入的节点，记录值
     * @param root
     * @return
     */
    public static int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null){
                continue;
            }
            list.add(treeNode.val);
//            System.out.println("val: "+treeNode.val);
            if (treeNode.left!=null)
                queue.offer(treeNode.left);
            if (treeNode.right!=null)
                queue.offer(treeNode.right);

        }

        int[] results = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            results[i] = list.get(i);
        }
        return results;
    }

}
