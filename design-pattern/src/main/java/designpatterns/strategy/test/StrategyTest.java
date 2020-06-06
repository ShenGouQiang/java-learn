package designpatterns.strategy.test;

import designpatterns.strategy.compare.impl.CatComparatorByAge;
import designpatterns.strategy.compare.impl.CatComparatorByWeight;
import designpatterns.strategy.domain.Cat;
import designpatterns.strategy.domain.Sex;
import designpatterns.strategy.sort.Sort;
import designpatterns.strategy.sort.impl.SelectSort;
import org.junit.Test;

public class StrategyTest {

    @Test
    public void catSort() {
        Cat[] catArray = {
                new Cat("zhao", 18.0D, 10, Sex.MALE),
                new Cat("zhao", 12.0D, 2, Sex.MALE),
                new Cat("zhao", 28.0D, 1, Sex.MALE),
                new Cat("zhao", 8.0D, 8, Sex.MALE),
                new Cat("zhao", 38.0D, 9, Sex.MALE),
                new Cat("zhao", 5.0D, 5, Sex.MALE),
                new Cat("zhao", 2.1D, 3, Sex.MALE),
                new Cat("zhao", 6.6D, 4, Sex.MALE),
                new Cat("zhao", 48.0D, 15, Sex.MALE),
                new Cat("zhao", 0.1D, 7, Sex.MALE)
        };
        Sort<Cat> sort = new SelectSort<>();
        //sort.sort(catArray, new CatComparatorByAge());
        sort.sort(catArray,new CatComparatorByWeight());
        for (Cat cat : catArray) {
            System.out.println(cat);
        }
    }
}
