package com.liang.erhua.arithmetic.twotree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangjia
 * @version 1.0
 * @date 09:33/2020-02-17
 * @description
 */
public class TreeNodeSolution {
    public static void main(String[] args) {

    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderTraveral(node.leftNode);
        preOrderTraveral(node.rightNode);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftNode);
        System.out.print(node.val + " ");
        inOrderTraveral(node.rightNode);
    }

    public void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftNode);
        postOrderTraveral(node.rightNode);
        System.out.print(node.val + " ");
    }

    List<List<Integer>> levels = new ArrayList<>();

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        levelHelper(root,0);
        return levels;
    }

    private void levelHelper(TreeNode root,int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(root.val);
        if (root.leftNode != null) {
            levelHelper(root.leftNode,level + 1);
        }
        if (root.rightNode != null) {
            levelHelper(root.rightNode,level + 1);
        }
    }

    /**
     * 获取树的最大高度
     * @param node
     * @return
     */
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.leftNode),height(node.rightNode));
    }

    public int minHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.leftNode == null && root.rightNode == null) {
            return 1;
        }
        int deep = Integer.MAX_VALUE;

        if (root.leftNode != null) {
            deep = Math.min(minHeight(root.leftNode),deep);
        }
        if (root.rightNode != null) {
            deep = Math.min(minHeight(root.rightNode),deep);
        }

        return 1 + deep;
    }

}
