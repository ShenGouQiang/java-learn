package datastructure.sort;


import org.junit.Test;

/**
 * 归并排序
 */
public class MergeSort {

    @Test
    public void testOne() {
        int[] array = {3, 5, 76, 3, 345, 653, 12, 34, 35, 1, 55, 345, 9};
        int[] array2 = new int[array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        sortWithoutRecursive(array);
        print(array);
        System.out.println("-----------------");
        sortWithRecursive(array2);
        print(array2);
    }

    @Test
    public void testTwo(){
        System.out.println((0-1)/2);
    }

    private void print(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && i % 5 == 0) {
                System.out.println();
            }
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public void sortWithRecursive(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        dfs(array, 0, array.length - 1);
    }

    public void dfs(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >>> 1);
        dfs(array, left, mid);
        dfs(array, mid + 1, right);
        merge(array, left, mid, right);
    }


    public void sortWithoutRecursive(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int end = array.length - 1;
        int mergeSize = 1;
        while (mergeSize <= end && mergeSize >0) {
            int left = 0;
            while (left <= end) {
                int mid = left + mergeSize - 1;
                if (mid >= end) {
                    break;
                }
                int r = Math.min(mid + mergeSize, end);
                merge(array, left, mid, r);
                left = r + 1;
            }
            //为了防止越界，出现的问题
//            if (mergeSize > end / 2) {
//                break;
//            }
            mergeSize <<= 1;
        }
    }

    public void merge(int[] array, int left, int mid, int right) {
        int length = right - left + 1;
        int[] tempArray = new int[length];
        int leftPoint = left;
        int rightPoint = mid + 1;
        int index = 0;
        while (leftPoint <= mid && rightPoint <= right) {
            if (array[leftPoint] > array[rightPoint]) {
                tempArray[index++] = array[rightPoint++];
            } else {
                tempArray[index++] = array[leftPoint++];
            }
        }
        while (leftPoint <= mid) {
            tempArray[index++] = array[leftPoint++];
        }
        while (rightPoint <= right) {
            tempArray[index++] = array[rightPoint++];
        }
        if (tempArray.length >= 0) {
            System.arraycopy(tempArray, 0, array, left + 0, tempArray.length);
        }
    }

}
