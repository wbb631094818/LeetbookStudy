package com.demo.leetbookstudy.substructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树的子结构
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dshwe/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SubStructure {



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode21 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(2);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode21;
//        treeNode2.right = treeNode22;

        TreeNode treeNodeB = new TreeNode(3);
//        TreeNode treeNodeB1 = new TreeNode(1);
//        treeNodeB.left = treeNodeB1;

//       System.out.println("返回结果： "+isSubStructure(treeNode,treeNodeB));
    }

    /**
     *  官方解题方法，比我的简单太多了
     *  遍历A二叉树的分支，一个节点判断一下b分支
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


//    自己写的方法  --------------------------------------
    private static HashMap<Integer, Integer> aHash = new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> bHash = new HashMap<Integer, Integer>();
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        if (A.left ==null && A.right == null){
            aHash.put(A.val,0);
        }else {
            RecursiveA(A);
        }
        if (B.left ==null && B.right == null){
            bHash.put(B.val,0);
        }else {
            RecursiveB(B);
        }
        for(Map.Entry<Integer, Integer> entry : aHash.entrySet()){
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            int key = entry.getKey();
            if (aHash.containsKey(key) && aHash.get(key).compareTo(entry.getValue()) == 0){
                return true;
            }
        }
        return false;

    }

    private static TreeNode RecursiveA(TreeNode treeNode) {
        if (treeNode == null){
            return null;
        }
//        if (treeNode.left == null && treeNode.right == null){
//            return treeNode;
//        }
        TreeNode left = RecursiveA(treeNode.left);
        TreeNode right = RecursiveA(treeNode.right);

        if (left!=null){
            aHash.put(treeNode.val,left.val);
        }else {
            aHash.put(treeNode.val,0);
        }
//        System.out.println("val："+treeNode.val);
       if (right!=null){
           aHash.put(treeNode.val,right.val);
//           System.out.println("差值："+valueRight);
       }else {
           aHash.put(treeNode.val,0);
       }
        return treeNode;
    }

    private static TreeNode RecursiveB(TreeNode treeNode) {
        if (treeNode == null){
            return null;
        }
        TreeNode left = RecursiveB(treeNode.left);
        TreeNode right = RecursiveB(treeNode.right);

        if (left!=null){
//            int valueLeft = treeNode.val - left.val;
            bHash.put(treeNode.val,left.val);
//            System.out.println("差值："+valueLeft);
        }else {
            bHash.put(treeNode.val,0);
        }
        if (right!=null){
//            int valueRight = treeNode.val - right.val;
            bHash.put(treeNode.val,right.val);
//            System.out.println("差值："+valueRight);
        }else {
            bHash.put(treeNode.val,0);
        }
        return treeNode;
    }

}
