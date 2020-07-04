package datastructure.sort;

import org.junit.Before;
import org.junit.Test;

public class MaxTopHeapSort {

    private int heapSize;

    private int limit;

    private int[] result;

    @Before
    public void before() {
        heapSize = 0;
        limit = 5;
        result = new int[limit];
    }


    @Test
    public void testOne() {
        int[] array = new int[]{3, 6, 2, 9, 1, 0, 4, 2, 7, 8, 3};
        array = sort(array);
        print(array);
        for (int i = 0; i < 5; i++) {
            System.out.println(pop(array));
        }

    }

    private void print(int[] array) {
        System.out.println("---------------------------");
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && i % 5 == 0) {
                System.out.println();
            }
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        System.out.println("---------------------------");
    }


    public int[] sort(int[] originArray) {
        int[] result = new int[originArray.length];
        for (int i = 0; i < originArray.length; i++) {
            result[i] = originArray[i];
            heapInsert(result, i);
        }
        return result;
    }

    private void heapInsert(int[] array, int index) {
        while (array[index] > array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
        heapSize++;
    }

    private Integer pop(int[] array) {
        if (array.length < 1) {
            throw new RuntimeException("Oops");
        }
        int result = array[0];
        swap(array, 0, --heapSize);
        heapify(array, 0);
        return result;
    }

    private void heapify(int[] array, int index) {
        int leftChildIndex = index * 2 + 1;
        while (leftChildIndex < heapSize) {
            int longestValueIndex = leftChildIndex + 1 < heapSize && array[leftChildIndex] < array[leftChildIndex + 1] ? leftChildIndex + 1 : leftChildIndex;
            longestValueIndex = array[longestValueIndex] > array[index] ? longestValueIndex : index;
            if (longestValueIndex == index) {
                break;
            }
            swap(array, longestValueIndex, index);
            index = longestValueIndex;
            leftChildIndex = index * 2 + 1;
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
