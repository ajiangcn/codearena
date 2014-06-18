package algorithm;

import java.util.Arrays;

public class LongestRepeatedString {

    public static String lrs(String s) {

        int N = s.length();

        String[] suffixes = new String[N];
        for(int i=0; i<N; i++) {
            suffixes[i] = s.substring(i, N);
        }

        Arrays.sort(suffixes);

        String lrs = "";
        for(int i=0; i<N-1; i++) {
            int len = lcp(suffixes[i], suffixes[i+1]);
            if(len > lrs.length()) {
                lrs = suffixes[i].substring(0, len);
            }
        }
        return lrs;
    }

    private static int lcp(String a, String b) {
        int result = 0;
        int len = a.length() > b.length() ? b.length() : a.length();

        for(int i=0; i<len; i++) {
            if(a.charAt(i) == b.charAt(i)) {
                result++;
            }
        }
        return result;
    }
}
