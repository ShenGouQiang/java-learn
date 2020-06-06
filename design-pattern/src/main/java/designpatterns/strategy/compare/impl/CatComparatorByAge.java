package designpatterns.strategy.compare.impl;

import designpatterns.strategy.compare.StrategyComparator;
import designpatterns.strategy.domain.Cat;

public class CatComparatorByAge implements StrategyComparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        return t1.getAge() < t2.getAge() ? -1 :  t1.getAge()  > t2.getAge()  ?  1 : 0;
    }
}
