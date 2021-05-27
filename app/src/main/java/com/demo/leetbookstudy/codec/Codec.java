package com.demo.leetbookstudy.codec;

import com.demo.leetbookstudy.substructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/990pf2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
                builder.append(node.val+",");
            } else {
                builder.append("null,");
            }
        }
        builder.append("]");

        return builder.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String[] strings = data.replace("[", "").replace("]", "").split(",");
        if (strings == null || strings.length <= 0) {
            return null;
        }

        TreeNode heard = new TreeNode(Integer.parseInt(strings[0]));
        // 保存需要连接添加的二叉树节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(heard);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            // 一个节点读取两条数据
            // 先读取第一个，不是null就赋值给该节点的左链接，并将其加入队列中
            if (i<strings.length&&!"null".equals(strings[i])){
                node.left = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.left);
            }
            i++;
            // 再读取第一个，不是null就赋值给该节点的右链接，并将其加入队列中
            if (i<strings.length&&!"null".equals(strings[i])){
                node.right = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.right);
            }
            i++;
        }
        return heard;
    }

}
