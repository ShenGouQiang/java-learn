package designpatterns.strategy.compare.impl;

import designpatterns.strategy.compare.StrategyComparator;
import designpatterns.strategy.domain.Cat;

public class CatComparatorByWeight implements StrategyComparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        return t1.getWeight() < t2.getWeight() ? -1 :  t1.getWeight()  > t2.getWeight()  ?  1 : 0;
    }
}
