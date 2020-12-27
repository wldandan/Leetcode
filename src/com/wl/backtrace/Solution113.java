package com.wl.backtrace;

import com.wl.bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) return res;

        track.add(root.val);
        backtrace(root, sum - root.val, track);
        return res;
    }

    private void backtrace(TreeNode root, int sum, List<Integer> track) {
        if ( root.left == null && root.right == null) {
            if (sum == 0) res.add(new ArrayList<>(track));
            return;
        }

        if ( root.left != null ) {
            track.add(root.left.val);
            backtrace(root.left,  sum - root.left.val, track);
            track.remove(track.size()-1);

        }

        if ( root.right != null ) {
            track.add(root.right.val);
            backtrace(root.right, sum - root.right.val, track);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(new Solution113().pathSum(root, 22));
    }

    private static void testCase2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(new Solution113().pathSum(root, 1));
    }
}