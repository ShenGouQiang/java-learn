package mianshi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 面试题 08.04. 幂集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author shengouqiang
 * @date 2020/5/27
 */
public class Subsets {

    @Test
    public void testOne(){
      int[] nums={1,2,3};
        System.out.println(subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        long total = 1<< nums.length;
        for (long i=0;i<total;i++){
            long tmpIndex=i;
            int numsIndex=0;
            List<Integer> sub = new ArrayList<>();
            while(tmpIndex !=0D){
                if((tmpIndex & 1) == 1){
                    sub.add(nums[numsIndex]);
                }
                numsIndex++;
                tmpIndex = tmpIndex >>> 1;
            }
            result.add(sub);
        }
        return result;
    }
}
