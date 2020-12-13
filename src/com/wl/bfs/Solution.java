package com.wl.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null){
                    sum = sum + node.val;

                    if (node.left !=null) queue.offer(node.left);
                    if (node.right !=null) queue.offer(node.right);
                }
            }
            res.add(sum/size);
        }
        return res;
    }


}