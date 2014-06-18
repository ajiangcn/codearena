package leetCode;

/**
 * Created by youjiang on 3/17/14.
 */
public class ReverseWordInAString {

    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");

        String result = "";
        for(int i=strs.length-1; i>=0; i--) {
            if(!strs[i].equals("")) {
                result += strs[i] + " ";
            }
        }
        return result.trim();
    }
}
