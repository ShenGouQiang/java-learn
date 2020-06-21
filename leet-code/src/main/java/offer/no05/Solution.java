package offer.no05;

public class Solution {
    public String replaceSpace(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        StringBuffer buffer = new StringBuffer("");
        for (int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                buffer.append("%20");
                continue;
            }
            buffer.append(s.charAt(i));
        }
        return buffer.toString();
    }
}
