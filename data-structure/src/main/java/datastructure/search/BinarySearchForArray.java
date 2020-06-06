package datastructure.search;

import java.util.Objects;

/**
 * 这道题目的由来是这样的
 * 有一个数组，先升序，后降序，求数组的最大值
 * <p>
 * 利用的是二分查找，加单调的判断
 */
public class BinarySearchForArray {

    public static void main(String[] args) {
        // Integer[] array = {1,4,7,8,10,20,16,13,12,5};
        Integer[] array = {1, 2, 2, 2, 6, 3, 3,2,2,2,2,2, 3, 3, 1};
        Integer maxValue = getMaxValue(array);
        System.out.println(maxValue);
    }


    /**
     * 利用二分查找法获取数组最大值
     *
     * @param array
     * @return
     */
    public static Integer getMaxValue(Integer[] array) {
        if (Objects.isNull(array) || array.length == 0) {
            return -1;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            return array[0] >= array[1] ? array[0] : array[1];
        }
        int start = 0;
        int end = array.length - 1;
        int mid = (end - start) / 2 + start;
        int index = 0;
        while (end > start) {
            System.out.println("******************* 第 " + (index + 1) + " start *******************");
            System.out.println("start=" + start);
            System.out.println("end=" + end);
            System.out.println("mid=" + mid);
            System.out.println("******************* 第 " + (index + 1) + " end *******************");
            if (array[mid] >= array[mid - 1] && array[mid] <= array[mid + 1]) {
                start = mid;
            }
            if (array[mid] >= array[mid - 1] && array[mid] >= array[mid + 1]) {
                return array[mid];
            }
            if (array[mid] <= array[mid - 1] && array[mid] >= array[mid + 1]) {
                end = mid;
            }
            mid = (end - start) / 2 + start;
            index++;
        }
        return -1;
    }
}
