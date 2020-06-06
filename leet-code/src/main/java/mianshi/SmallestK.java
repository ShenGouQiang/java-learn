package mianshi;

import org.junit.Test;

/**
 * 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 *
 * @author shengouqiang
 * @date 2020/5/18
 */
public class SmallestK {

    @Test
    public void testOne(){
        int[] arr = {1,3,5,7,2,4,6,8};
        int[] result = smallestK(arr,4);
        for (int i=0;i<result.length;i++){
            System.out.print(result[i] + "\t");
        }
        System.out.println();
    }

    public int[] smallestK(int[] arr, int k) {
        if(arr.length <= k){
            return arr;
        }
        int[] result = new int[k];
        int realContain = 0;
        for (int i=0;i<arr.length;i++){
            if(realContain < k){
                result[realContain++] = arr[i];
                continue;
            }
            int maxIndex = -1;
            for (int j=0;j<k;j++){
                if(result[j] > arr[i]){
                    maxIndex = Math.max(j,maxIndex);
                }
            }
            if(-1!=maxIndex){
                result[maxIndex] = arr[i];
            }

        }
        return result;
    }

}
