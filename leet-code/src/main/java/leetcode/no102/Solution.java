package leetcode.no102;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author shengouqiang
 * @date 2020/6/8
 */
public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queueList = new LinkedBlockingQueue<>();
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        queueList.add(root);
        while (!queueList.isEmpty()){
            int number = queueList.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i=0;i<number;i++){
               TreeNode tmpNode =  queueList.poll();
               tmpList.add(tmpNode.val);
               if(null != tmpNode.left){
                   queueList.add(tmpNode.left);
               }
                if(null != tmpNode.right){
                    queueList.add(tmpNode.right);
                }
            }
            resultList.add(tmpList);
        }
        return resultList;
    }
}
