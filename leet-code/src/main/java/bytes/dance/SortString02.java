package bytes.dance;

/**
 * 这道题的有点在于将字符串的比较变成了 数组的比较
 * 且人为的取消了 s1的排序问题
 * 比较好
 *
 * @author shengouqiang
 * @date 2020/5/7
 */
public class SortString02 {

    public static void main(String[] args) {
        String[][] array = {
                {"ab", "eidbaooo"},
            //    {"ab", "eidboaoo"},
            //    {"hello", "ooolleoooleh"},
           //     {"adc", "dcda"}
        };
        for (int i = 0; i < array.length; i++) {
            String s1 = array[i][0];
            String s2 = array[i][1];
            System.out.println(checkInclusion(s1, s2));
        }
    }

    public static boolean checkInclusion(String s1, String s2){
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1CharArray = new int[26];
        int[] s2CharArray = new int[26];
        for (int i=0;i<s1.length();i++){
            s1CharArray[s1.charAt(i) - 'a']++;
            s2CharArray[s2.charAt(i) - 'a']++;
        }
        for(int i=0;i<s2.length()-s1.length();i++){
            if(checkTwoArrayEqual(s1CharArray,s2CharArray)){
                return true;
            }
            s2CharArray[s2.charAt(i + s1.length()) - 'a']++;
            s2CharArray[s2.charAt(i) - 'a']--;
        }
        return checkTwoArrayEqual(s1CharArray,s2CharArray);
    }

    public static boolean checkTwoArrayEqual(int[] arr1,int[] arr2){
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
