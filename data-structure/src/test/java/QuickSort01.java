import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.*;

public class QuickSort01 {

    private int random(int start, int end) {
        return new Random().nextInt(end - start) + start;
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

    private void show(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testTwo() {
        int[] array = {45, 78, 1, 76, 93, 42, 63, 11, 49, 0};
        sort(array);
        show(array);
    }

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

    public void sort(int[] array){
        sort(array,0,array.length-1);
    }

    private void sort(int[] array,int left,int right){
        if(left >= right){
            return;
        }
        int midIndex = findMed(array,left,right);
        sort(array,left,midIndex-1);
        sort(array,midIndex+1,right);
    }

    private int findMed(int[] array,int left,int right) {
        int midValue = array[left];
        boolean reverseFlag = false;
        while (left < right) {
            if (!reverseFlag) {
                if (array[right] < midValue) {
                    array[left] = array[right];
                    reverseFlag = true;
                } else {
                    right--;
                }
            } else {
                if (array[left] > midValue) {
                    array[right] = array[left];
                    reverseFlag = false;
                } else {
                    left++;
                }
            }
        }
        array[left] = midValue;
        return left;
    }
}
