package offer.no38;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    @Test
    public void testOne() {
        print(permutation("abc"));
        System.out.println();
    }

    @Test
    public void testTwo() {
        print(permutation("aab"));
        System.out.println();
    }

    @Test
    public void testThree(){
        print(permutation("aba"));
        System.out.println();
    }

    private void print(String[] array){
        if(array == null){
            return;
        }
        for (String s : array) {
            System.out.print(s + "\t");
        }
    }

    public String[] permutation(String s) {
        if (s == null) {
            return new String[0];
        }
        char[] array = s.toCharArray();
        quickSort(array, 0, array.length - 1);
        boolean[] usedFlag = new boolean[array.length];
        List<String> result = new ArrayList<>();
        dfs(array, usedFlag, "", 0, result);
        String[] resultArray = result.toArray(new String[result.size()]);
        return resultArray;
    }

    private void quickSort(char[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int med = findMed(array, left, right);
        quickSort(array, left, med - 1);
        quickSort(array, med + 1, right);
    }

    private int findMed(char[] array, int left, int right) {
        char med = array[left];
        boolean reverseScan = true;
        while (left < right) {
            if (reverseScan) {
                if (array[right] < med) {
                    array[left] = array[right];
                    reverseScan = false;
                } else {
                    right--;
                }
            } else {
                if (array[left] > med) {
                    array[right] = array[left];
                    reverseScan = true;
                } else {
                    left++;
                }
            }
        }
        array[left] = med;
        return left;
    }


    public void dfs(char[] array, boolean[] usedFlag, String s, int depth, List<String> result) {
        if (depth == array.length) {
            result.add(s);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (!usedFlag[i]) {
                if (i > 0 && usedFlag[i - 1] && array[i] == array[i - 1]) {
                    continue;
                }
                usedFlag[i] = true;
                dfs(array, usedFlag, s + array[i], depth + 1, result);
                usedFlag[i] = false;
            }
        }
    }

}
