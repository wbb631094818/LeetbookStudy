package com.demo.leetbookstudy.levelorder;

import com.demo.leetbookstudy.substructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5vawr3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LevelOrder2 {

    /**
     *  自己写的，还真成功了。主要思想是从上到下打印时，给每层标记一个层数，从0开始
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<List<Integer>>();
        }
        HashMap<Integer,ArrayList<Integer>> hashMap = new HashMap<>();
        HashMap<TreeNode,Integer> treeHashMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        treeHashMap.put(root,0);
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if (treeNode.left!=null){
                treeHashMap.put(treeNode.left,treeHashMap.get(treeNode)+1);
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null){
                treeHashMap.put(treeNode.right,treeHashMap.get(treeNode)+1);
                queue.offer(treeNode.right);
            }
            if (hashMap.get(treeHashMap.get(treeNode))!=null){
                hashMap.get(treeHashMap.get(treeNode)).add(treeNode.val);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(treeNode.val);
                hashMap.put(treeHashMap.get(treeNode),list);
            }
            System.out.println("layerNumber: "+treeHashMap.get(treeNode));
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        int number = 0;
        while (hashMap.get(number)!=null){
            res.add(hashMap.get(number));
            number++;
        }
        return res;
    }


    /**
     *  官方解题方案    与我的方式，核心在于多了一个for循环，循环出了每一层,
     *  循环次数为当前层的队列数，每次循环后，队列数都为当前层的节点数
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int szie = queue.size();
            for (int i = 0; i < szie; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
