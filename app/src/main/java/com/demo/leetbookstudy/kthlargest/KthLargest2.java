package com.demo.leetbookstudy.kthlargest;

import com.demo.leetbookstudy.substructure.TreeNode;

/**
 *  官方解题思路   和我的区别就是我是新加了一个数++  他是直接--
 */
public class KthLargest2 {

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }

}
