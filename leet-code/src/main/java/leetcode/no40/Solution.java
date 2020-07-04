package leetcode.no40;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    @Test
    public void testOne() {
        int[] a = new int[]{0,0,1,2,4,2,2,3,1,4};
        int[] finallyArray = version2(a, 8);
        System.out.println(finallyArray);
    }


    public int[] version2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
        for (int i : arr) {
            heap.offer(i);
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[] fin = new int[k];
        int index = 0;
        for (int e : heap) {
            fin[index++] = e;
        }
        return fin;
    }


    private int limit;
    private int[] array;
    private int heapSize;
    private int maxValueIndex;

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length < 2 || k == 0) {
            return arr;
        }
        limit = k;
        array = new int[limit];
        for (int i : arr) {
            push(i);
        }
        return array;
    }

    public void push(int i) {
        heapInsert(i);
    }

    public void heapInsert(int i) {
        int index = 0;
        if (heapSize < limit) {
            array[heapSize] = i;
            maxValueIndex = array[maxValueIndex] < i ? heapSize : maxValueIndex;
            index = heapSize;
            heapSize++;
        } else {
            if (array[maxValueIndex] <= i) {
                return;
            } else {
                array[maxValueIndex] = i;
                index = maxValueIndex;
            }
        }
        int parent = (index - 1) / 2;
        while (array[parent] > array[index]) {
            swap(array, parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
        maxValueIndex = findMaxValueIndex();
    }

    private int findMaxValueIndex() {
        int maxIndex = 0;
        for (int i = 0; i < heapSize; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int pop() {
        int result = array[0];
        swap(array, 0, --heapSize);
        heapify(0);
        return result;
    }

    private void heapify(int index) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int longestValueIndex = left + 1 < heapSize && array[left + 1] > array[left] ? left + 1 : left;
            longestValueIndex = array[longestValueIndex] > array[index] ? longestValueIndex : index;
            if (longestValueIndex == index) {
                break;
            }
            swap(array, longestValueIndex, index);
            index = left;
            left = 2 * left + 1;
        }
    }


}
