package datastructure.tree;

import apple.laf.JRSUIUtils;
import org.junit.Test;

import java.util.Stack;
import java.util.Vector;

/**
 * @author shengouqiang
 * @date 2020/5/18
 */
public class CenterPrintWithoutRecursive {

    @Test
    public void testOne() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.setLeft(t2);
        t1.setRight(t3);
        t2.setLeft(t4);
        t2.setRight(t5);
        t3.setLeft(t6);
        t3.setRight(t7);

        printCenter(t1);
        printCenterWithRecursive(t1);
        System.out.println();

        printBefore(t1);
        printBeforeWithResurvise(t1);
        System.out.println();

        printAfter(t1);
        printAfterWithResurvise(t1);
        System.out.println();

    }

    private void printAfter(TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisitNode = null;
        while (!stack.empty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.getLeft();
            }
            if (!stack.empty()) {
                if (stack.peek().getRight() == null || stack.peek().getRight() == lastVisitNode) {
                    TreeNode tmpNode = stack.pop();
                    System.out.print(tmpNode.getVal() + "\t");
                    lastVisitNode = tmpNode;
                } else {
                   p = stack.peek().getRight();
                }
            }
        }
        System.out.println();
    }

    private void printAfterWithResurvise(TreeNode p) {
        if (p == null) {
            return;
        }
        printAfterWithResurvise(p.getLeft());
        printAfterWithResurvise(p.getRight());
        System.out.print(p.getVal() + "\t");
    }

    public void printBefore(TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || p != null) {
            while (p != null) {
                System.out.print(p.getVal() + "\t");
                stack.push(p);
                p = p.getLeft();
            }
            if (!stack.empty()) {
                TreeNode tmp = stack.pop();
                p = tmp.getRight();
            }
        }
        System.out.println();
    }

    private void printBeforeWithResurvise(TreeNode p) {
        if (p == null) {
            return;
        }
        System.out.print(p.getVal() + "\t");
        printBeforeWithResurvise(p.getLeft());
        printBeforeWithResurvise(p.getRight());
    }


    public void printCenter(TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.getLeft();
            }
            if (!stack.empty()) {
                TreeNode tmp = stack.pop();
                System.out.print(tmp.getVal() + "\t");
                p = tmp.getRight();
            }

        }
        System.out.println();
    }

    private void printCenterWithRecursive(TreeNode p) {
        if (p == null) {
            return;
        }
        printCenterWithRecursive(p.getLeft());
        System.out.print(p.getVal() + "\t");
        printCenterWithRecursive(p.getRight());
    }
}
