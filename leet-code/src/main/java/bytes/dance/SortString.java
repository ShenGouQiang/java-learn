package bytes.dance;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 这种做法容易超时
 * 要想想怎么优化
 *
 * @author shengouqiang
 * @date 2020/5/6
 */
public class SortString {

    public static void main(String[] args) {
        String[][] array = {
                {"ab", "eidbaooo"},
                {"ab", "eidboaoo"},
                {"hello", "ooolleoooleh"},
                {"adc", "dcda"}
        };
        for (int i = 0; i < array.length; i++) {
            String s1 = array[i][0];
            String s2 = array[i][1];
            System.out.println(checkInclusion(s1, s2));
        }
    }

    /**
     * 这种题解题的思路是滑动窗口
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        char[] s2Array = s2.toCharArray();
        for (int j = 0; j < s2.length() - s1.length() + 1; j++) {
            Map<Character, Integer> s1Map = strToMap(s1);
            for (int i = j, index = 0; index < s1.length(); i++, index++) {
                if (s1Map.containsKey(s2Array[i])) {
                    char key = s2Array[i];
                    Integer count = s1Map.get(key);
                    s1Map.put(s2Array[i], count - 1);
                }
            }
            List<Integer> list = s1Map.values().stream().distinct().collect(Collectors.toList());
            if (list.size() == 1 && list.get(0) == 0) {
                return true;
            }
        }
        return false;
    }

    private static Map<Character, Integer> strToMap(String str) {
        Map<Character, Integer> map = new HashMap<>(str.length());
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                map.put(c, count + 1);
                continue;
            }
            map.put(c, 1);
        }
        return map;
    }
}
