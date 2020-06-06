package datastructure.tree;

import lombok.Data;

/**
 * @author shengouqiang
 * @date 2020/5/18
 */
@Data
public class TreeNode {

    private int val;

    private TreeNode left;

    private  TreeNode right;

    public TreeNode(int x){
        this.val=x;
    }
}
