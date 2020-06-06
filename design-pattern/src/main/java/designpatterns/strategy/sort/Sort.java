package designpatterns.strategy.sort;

import designpatterns.strategy.compare.StrategyComparator;

@FunctionalInterface
public interface Sort<T> {

    void sort(T[] arrray,StrategyComparator<T> comparator);
}
