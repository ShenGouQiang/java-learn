package offer.no11;

public class Solution {
    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int med = (start + end) / 2;
            if (numbers[med] > numbers[end]) {
                start = med + 1;
            }
            if (numbers[med] < numbers[end]) {
                end = med;
            } else {
                end--;
            }
        }
        return numbers[start];
    }
}
