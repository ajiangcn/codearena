package algorithm.stringmatch;

public class KMP {

    public void KMPSearch(String pattern, String input) {
        int[] lps = computeLongestProperPrefix(pattern);

        int input_len = input.length();
        int pattern_len = pattern.length();
        int k = 0; // match start position
        int i = 0; // index to the input string
        int j = 0;  // index to the pattern
        while (i<input_len) {
            while (i< input_len && j < pattern_len) {
                if (input.charAt(i) != pattern.charAt(j)) {
                    break;
                }
                i++;
                j++;
            }
            if (j == pattern_len) {
                System.out.println(String.format("Match happens at index %d", k));
            }
            k = i - lps[j-1];
            j = lps[j-1];
            i++;
            j++;
        }
    }

    public int[] computeLongestProperPrefix(String s) {
        int len = s.length();
        int[] lps = new int[len];
        lps[0] = 0;

        int max = 0;
        int i = 1;
        while (i < len) {
            if (s.charAt(i) == s.charAt(max)) {
                max++;
                lps[i] = max;
                i++;
            } else {
                if (max != 0) {
                    max = lps[max-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * Find the longest suffix of the s[0,i] which is also the prefix of s
     * @param s
     * @return
     */
    public int[] computeLongestProperPrefix1(String s) {
        int len = s.length();
        int[] lps = new int[len];
        lps[0] = 0;

        for(int i=1; i<len; i++) {
            lps[i] = 0;
            for (int j=i; j>=0; j--) {
                if (s.substring(0, j).equals(s.substring(i-j+1, i+1))) {
                    lps[i] = j;
                    break;
                }
            }
        }
        return lps;
    }
}


