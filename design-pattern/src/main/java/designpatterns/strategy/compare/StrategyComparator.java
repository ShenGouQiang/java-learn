package designpatterns.strategy.compare;

@FunctionalInterface
public interface StrategyComparator<T> {
    int compare(T t1,T t2);
}
