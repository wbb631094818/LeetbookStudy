package com.demo.leetbookstudy.pathsum;

import com.demo.leetbookstudy.substructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PathSum {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);

        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(11);
        TreeNode treeNode4 = new TreeNode(13);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(5);
        TreeNode treeNode9 = new TreeNode(1);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;

//        pathSum(treeNode, 22);
    }

    private ArrayList<List<Integer>> lists = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return lists;
    }

    public void recur(TreeNode treeNode,int tar) {
        if (treeNode == null) {
            return ;
        }
//        System.out.println("var: "+treeNode.val);
        path.add(treeNode.val);
        tar= tar -treeNode.val;
        if (tar==0 && treeNode.left == null && treeNode.right == null){
            lists.add(new ArrayList<>(path));
        }
        recur(treeNode.left,tar);
        recur(treeNode.right,tar);
        path.removeLast();  // 删除上一个数据

    }
}
