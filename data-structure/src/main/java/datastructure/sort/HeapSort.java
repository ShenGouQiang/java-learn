package datastructure.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author shengouqiang
 * @date 2020/6/2
 */
public class HeapSort {


    @Test
    public void testOne() {
        int allCount = 5000;
        for (int i = 0; i < allCount; i++) {
            int arrayLength = random(100, 5000);
            int[] array = new int[arrayLength];
            int[] system = new int[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                array[j] = random(0, 100000);
                system[j] = array[j];
            }
            sort(array);
            Arrays.sort(system);
            Assert.assertTrue(twoArrayEquals(array, system));
            System.out.println("第 " + (i + 1) + " 次的结果为 true");
        }
    }

    private int random(int start, int end) {
        return new Random().nextInt(end - start) + start;
    }

    @Test
    public void testTwo() {
        int[] array = {50,45,40,20,25,35,30,10,15};
        sort(array);
        show(array);
    }

    private void show(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private boolean twoArrayEquals(int[] array, int[] system) {
        if (array.length != system.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != system[i]) {
                return false;
            }

        }
        return true;
    }

    public void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = (length -i -2)/2; j >=0; j--) {
                heapSwap(array,j,length -i);
            }
            swap(array,length -1-i,0);
        }
    }

    private void heapSwap(int[] array,int index,int length){
        int leftNode = 2*index +1;
         int rightNode = 2*index +2 > length -1 ? length -1 : 2 * index + 2 ;
        if(array[leftNode] > array[rightNode]){
            if(array[index] < array[leftNode]){
                swap(array,index,leftNode);
            }
        }else{
            if(array[index] < array[rightNode]){
                swap(array,index,rightNode);
            }
        }
    }

    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] =array[j];
        array[j] = temp;
    }

}
