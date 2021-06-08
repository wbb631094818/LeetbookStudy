package com.demo.leetbookstudy.buildtree;

import com.demo.leetbookstudy.substructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/99lxci/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class BuildTree {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int rootVar = preorder[0]; // 根节点
//        // 获取左节点集合
//        List<Integer> lefts = new ArrayList<>();
//        // 获取右节点
//        List<Integer> rights = new ArrayList<>();
//        boolean isRoot = false;
//        for (Integer number:inorder) {
//            if (number == rootVar){
//                // 是的话就是root根节点的值
//                isRoot = true;
//            }else {
//                if (isRoot){
//                    rights.add(number);
//                }else {
//                    lefts.add(number);
//                }
//            }
//        }
//        //
//
//        return new TreeNode(rootVar);
//    }


//    private Map<Integer, Integer> indexMap;
//
//    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
//        if (preorder_left > preorder_right) {
//            return null;
//        }
//
//        // 前序遍历中的第一个节点就是根节点
//        int preorder_root = preorder_left;
//        // 在中序遍历中定位根节点
//        int inorder_root = indexMap.get(preorder[preorder_root]);
//
//        // 先把根节点建立出来
//        TreeNode root = new TreeNode(preorder[preorder_root]);
//        // 得到左子树中的节点数目
//        int size_left_subtree = inorder_root - inorder_left;
//        // 递归地构造左子树，并连接到根节点
//        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
//        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
//        // 递归地构造右子树，并连接到根节点
//        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
//        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
//        return root;
//    }
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        // 构造哈希映射，帮助我们快速定位根节点
//        indexMap = new HashMap<Integer, Integer>();
//        for (int i = 0; i < n; i++) {
//            indexMap.put(inorder[i], i);
//        }
//        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
//    }


//  方法二 ===================================================================
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        System.out.println("root:"+root +", left:"+left+", right:"+right);
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

}
