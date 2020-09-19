package mianshi;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 *
 * @author shengouqiang
 * @date 2020/5/12
 */
public class listOfDepth {

    @Data
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Data
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void testOne() {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        root.left = t2;
        root.right= t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t7;
        t4.left = t8;
        printCenter(root);
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        List<TreeNode> list = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        int currentLevel = 0;
        list.add(tree);
        levelList.add(1);
        int index=0;
        while (index != list.size()) {
            TreeNode tmp = list.get(index);
            currentLevel = Math.max(currentLevel,levelList.get(index));
            if (tmp.left != null) {
                levelList.add(levelList.get(index) +1);
                list.add(tmp.left);
            }
            if (tmp.right != null) {
                levelList.add(levelList.get(index) +1);
                list.add(tmp.right);
            }
            index++;
        }
        ListNode[] listNode = new ListNode[currentLevel];
        for (int i=0;i<list.size();i++){
            if(listNode[levelList.get(i)-1] == null){
                listNode[levelList.get(i)-1] = new ListNode(list.get(i).val);
                continue;
            }
            ListNode tmp = listNode[levelList.get(i)-1];
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new ListNode(list.get(i).val);
        }
        return listNode;
    }

    private void printCenter(TreeNode tree) {
        List<TreeNode> list = new ArrayList<>();
        int index=0;

        while (index != list.size()) {
            TreeNode tmp = list.get(index);
            System.out.println(tmp.val);
            if (tmp.left != null) {
                list.add(tmp.left);
            }
            if (tmp.right != null) {
                list.add(tmp.right);
            }
            index++;
        }
    }
}


