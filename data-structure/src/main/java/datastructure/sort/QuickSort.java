package datastructure.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author shengouqiang
 * @date 2020/6/2
 */
public class QuickSort {

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
        int[] array = {45, 78, 1, 76, 93, 42, 63, 11, 49, 0};
        sort(array);
        show(array);
    }

    @Test
    public void testThree(){
        int[] array = {45, 78, 1, 76, 93, 42, 63, 11, 49, 0};
        int med = findMed(array,0,array.length-1);
        show(array);
        System.out.println(med);
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
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        sort(array, 0, array.length - 1);
    }


    public void sort(int[] array, int let, int right) {
        if(let >= right){
            return;
        }
        int med = findMed(array, let, right);
        sort(array, let, med - 1);
        sort(array, med + 1, right);

    }

    private int findMed(int[] array, int left, int right) {
        int med = array[left];
        boolean reverseScan = true;
        while (left < right) {
            if (reverseScan) {
                if (array[right] < med) {
                    array[left] = array[right];
                    reverseScan = false;
                } else {
                    right--;
                }
            } else {
                if (array[left] > med) {
                    array[right] = array[left];
                    reverseScan = true;
                } else {
                    left++;
                }
            }
        }
        array[left] = med;
        return left;
    }
}
