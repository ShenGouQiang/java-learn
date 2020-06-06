package designpatterns.strategy.sort.impl;

import designpatterns.strategy.compare.StrategyComparator;
import designpatterns.strategy.sort.Sort;

public class SelectSort<T> implements Sort<T> {
    @Override
    public void sort(T[] arrray, StrategyComparator<T> comparator) {
        for (int i = 0; i < arrray.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arrray.length; j++) {
                minPos = comparator.compare(arrray[j], arrray[minPos]) == -1 ? j : minPos;
            }
            swap(arrray, i, minPos);
        }
    }

    private void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
