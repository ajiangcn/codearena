package leetCode;

/**
 * Created by youjiang on 3/24/14.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null) {
            return null;
        }
        for (String str : strs) {
            if(str == null) return null;
        }
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(true) {
            if(index >= strs[0].length()) {
                return sb.toString();
            }
            char c = strs[0].charAt(index);
            for(String str: strs) {
                if(index >= str.length()) {
                    return sb.toString();
                } else {
                    if(c != str.charAt(index)) {
                        return sb.toString();
                    }
                }
            }
            sb.append(c);
            index++;
        }
    }
}
