package datastructure.sort;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author shengouqiang
 * @date 2020/4/30
 */
public class SelectSort {

    @Test
    public void testOne() {
        int allCount = 5000;
        for (int i=0;i<allCount;i ++){
            int arrayLength = random(100,5000);
            int[] array = new int[arrayLength];
            int[] system = new int[arrayLength];
            for (int j=0;j<arrayLength;j++){
                array[j] = random(0,100000);
                system[j] = array[j];
            }
            sort(array);
            Arrays.sort(system);
            Assert.assertTrue(twoArrayEquals(array,system));
            System.out.println("第 " + (i+1) +" 次的结果为 true");
        }
    }

    private int random(int start,int end){
        return new Random().nextInt(end-start) + start;
    }

    @Test
    public void testTwo(){
        int[] array={45,78,1,76,93,42,63,11,49,0};
        sort(array);
        show(array);
    }

    private void show(int[] array){
//        for (int i=0;i<array.length;i++){
//            if(i > 0 && i%10 == 0){
//                System.out.println();
//            }
//            System.out.print(array[i] + "\t");
//        }
        System.out.println(Arrays.toString(array));
    }

    private boolean twoArrayEquals(int[] array,int[] system){
        if (array.length != system.length){
            return false;
        }
        for (int i=0;i<array.length;i++){
            if(array[i] != system[i]){
                return false;
            }
        }
        return true;
    }


    public void sort(int[] array){
        for (int i=0;i<array.length;i++){
            int minIndex = i;
            for (int j=i+1;j<array.length;j++){
                if(array[minIndex] > array[j]){
                    minIndex=j;
                }
            }
            if(minIndex != i){
                swap(array,i,minIndex);
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
