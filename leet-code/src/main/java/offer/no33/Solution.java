package offer.no33;

import org.junit.Test;
import org.springframework.objenesis.SpringObjenesis;

/**
 * @author shengouqiang
 * @date 2020/6/22
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null || postorder.length == 0){
            return true;
        }
        int rootVal = postorder[postorder.length -1];
        int index = -1;
        for (int i=0;i<postorder.length -1 ;i++){
            if(postorder[i] > rootVal){
                index = i;
                break;
            }
        }
        if(-1 != index){
            return dfs(postorder,0,index -1) && dfs(postorder,index,postorder.length -1 -1);
        }else{
            return dfs(postorder,0,postorder.length -1- 1);
        }

    }

    public boolean  dfs(int[]postorder,int start,int end){
        if(start >= end){
            return true;
        }
        int rootVal = postorder[end];
        int index = -1;
        for (int i=start;i<end -1 ;i++){
            if(postorder[i] > rootVal){
                index = i;
                break;
            }
        }
        if(-1 != index){
            return dfs(postorder,start,index -1) && dfs(postorder,index,end-1);
        }else{
            return dfs(postorder,start,end- 1);
        }
    }

    @Test
    public void testOne(){
        System.out.println(verifyPostorder(new int[]{1,6,3,2,5}));
    }

    @Test
    public void testTwo(){
        System.out.println(verifyPostorder(new int[]{1,3,2,6,5}));
    }
}
