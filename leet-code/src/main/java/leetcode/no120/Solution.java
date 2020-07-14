package leetcode.no120;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    @Test
    public void testOne() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(2));
        result.add(Arrays.asList(3, 4));
        result.add(Arrays.asList(6, 5, 7));
        result.add(Arrays.asList(4, 1, 8, 3));
        Assert.assertEquals(11, minimumTotal(result));
        Assert.assertEquals(11, minimumTotal1(result));
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row < 1) {
            return 0;
        }
        int[] array = new int[triangle.get(row - 1).size()];
        int minVal = 0x7fffffff;
        int count = 0;
        for (int i = 0; i < triangle.get(0).size(); i++) {
            array[i] = triangle.get(0).get(i);
            minVal = Math.min(minVal, array[i]);
            count++;
        }
        if (row == 1) {
            return minVal;
        }
        minVal = 0x7fffffff;
        for (int i = 1; i < row; i++) {
            int before = 0x7fffffff;
            int after = array[0];
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                array[j] = temp.get(j) + Math.min(before, after);
                if (i == row - 1) {
                    minVal = Math.min(minVal, array[j]);
                }
                before = after;
                after = j + 1 >= count ? 0x7fffffff : array[j + 1];
            }
            count++;
        }
        return minVal;
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int minVal = 0x7fffffff;
        int row = triangle.size();
        if (row < 1) {
            return 0;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempOne = new ArrayList<>();
        int oneRow = 0x7fffffff;
        for (int i = 0; i < triangle.get(0).size(); i++) {
            tempOne.add(triangle.get(0).get(i));
            oneRow = Math.min(oneRow, triangle.get(0).get(i));
        }
        result.add(tempOne);
        for (int i = 1; i < row; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    temp.add(triangle.get(i).get(j) + result.get(i - 1).get(j));
                } else if (j >= triangle.get(i - 1).size()) {
                    temp.add(triangle.get(i).get(j) + result.get(i - 1).get(j - 1));
                } else {
                    temp.add(triangle.get(i).get(j) + Math.min(result.get(i - 1).get(j - 1), result.get(i - 1).get(j)));
                }
                if (i == row - 1) {
                    minVal = Math.min(minVal, temp.get(j));
                }
            }
            result.add(temp);
        }
        return minVal == 0x7fffffff ? oneRow : minVal;
    }
}
